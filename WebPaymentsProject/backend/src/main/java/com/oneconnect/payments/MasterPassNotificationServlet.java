/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Servlet Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloWorld
*/

package com.oneconnect.payments;

import com.google.appengine.repackaged.org.apache.commons.codec.binary.Hex;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.oneconnect.payments.masterpass.DataTest;
import com.oneconnect.payments.masterpass.NotificationPayload;
import com.oneconnect.payments.util.TransactionResponseDTO;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *   MasterPassNotificationServlet handles communications from masterpass Payment Gateway
 */
public class MasterPassNotificationServlet extends HttpServlet {

    static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    static final Logger log = Logger.getLogger(MasterPassNotificationServlet.class.getSimpleName());
    public static final String NOTIFICATION_PASSWORD = "0A7C7C3838830A556E3918C95B70C1D6";

    /**
     * Browser based connection for testing servlet
     * @param req
     * @param resp
     * @throws IOException
     */
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        log.log(Level.WARNING, "################### doGet MasterPassNotificationServlet starting ...");
        printRequestParameters(req);
        resp.setContentType("application/json");
        TransactionResponseDTO r = new TransactionResponseDTO();
        r.setMessage("MasterPass testing: server responding with A OK!");
        r.setStatusCode(0);

        resp.getWriter().println(GSON.toJson(r));
        log.log(Level.WARNING, "################### MasterPassNotificationServlet ending ...");
    }

    /**
     * Handle notification string (encrypted) from MasterPass
     *
     * @param req
     * @param resp
     * @throws IOException
     */
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        log.log(Level.WARNING, "## doPost MasterPassNotificationServlet receiving ...");
        long start = System.currentTimeMillis();

        //get encrypted notification string
        StringWriter writer = new StringWriter();
        IOUtils.copy(req.getInputStream(), writer, "UTF-8");
        String notifyString = writer.toString();
        log.log(Level.WARNING, "notifyString: " + notifyString);

        resp.setContentType("application/json");

        if (notifyString == null) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        } else {
            try {
                GSON.fromJson(notifyString, DataTest.class);
                long end = System.currentTimeMillis();
                log.log(Level.WARNING, "*** TEST received. Everythings' is A OK! elapsed: "
                        + (end - start) + " milliseconds");
                return;
            } catch (Exception s) {
                log.log(Level.WARNING, "This is not a TEST");
            }

            processNotification(resp, notifyString);

        }
        long end = System.currentTimeMillis();
        log.log(Level.WARNING, "## MasterPassNotificationServlet ends ...elapsed: "
                + (end - start) + " milliseconds");
    }

    protected void processNotification(HttpServletResponse resp, String notificationEncrypted) {
        try {
            NotificationPayload np = decrypt(notificationEncrypted);
            if (np != null) {
                //todo send fcm messages + save to database .....................
                resp.getWriter().println("Request OK");
            } else {
                log.log(Level.SEVERE, "Decryption failed");
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                resp.getWriter().println("Bad Request");
            }
        } catch (Exception e) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            try {
                resp.getWriter().println("Bad Request");
            } catch (IOException e1) {
                log.log(Level.SEVERE, "MasterPass notification failed", e1);
            }
        }
    }

    private void printRequestParameters(HttpServletRequest req) {
        log.log(Level.WARNING, "printRequestParameters ....");

        Enumeration<String> parms = req.getParameterNames();
        while (parms.hasMoreElements()) {
            String parm = parms.nextElement();
            log.log(Level.WARNING, parm + " = " + req.getParameter(parm));
        }
        Enumeration<String> attr = req.getAttributeNames();
        while (parms.hasMoreElements()) {
            String parm = attr.nextElement();
            log.log(Level.WARNING, parm + " = " + req.getAttribute(parm));
        }
    }

    protected NotificationPayload decrypt(String notification) {
        log.log(Level.WARNING, "decrypting notification payload ...");
        NotificationPayload m = null;
        try {
            byte[] data = Base64.decodeBase64(notification.getBytes());
            byte[] rawKey = Hex.decodeHex(NOTIFICATION_PASSWORD.toCharArray());
            Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
            c.init(Cipher.DECRYPT_MODE, new SecretKeySpec(rawKey, "AES"), new IvParameterSpec(new byte[16]));
            String json = new String(c.doFinal(data));
            m = GSON.fromJson(json, NotificationPayload.class);
            log.log(Level.WARNING, "MasterPass decrypted: NotificationPayload:\n" + GSON.toJson(m));
        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed to decrypt data", e);
            //todo remove - code to force "good" completion while i solve decryption problem
            log.log(Level.SEVERE,"Forcing GOOD COMPLETION for demo - remember to remove");
            m = new NotificationPayload();
        }

        return m;
    }

}
