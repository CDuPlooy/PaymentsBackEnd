/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Servlet Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloWorld
*/

package com.oneconnect.payments;

import com.oneconnect.payments.masterpass.DataTest;
import com.oneconnect.payments.masterpass.NotificationPayload;
import com.google.appengine.repackaged.com.google.api.client.util.Base64;
import com.google.appengine.repackaged.org.apache.commons.codec.binary.Hex;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.oneconnect.payments.util.TransactionResponseDTO;

import java.io.IOException;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.oneconnect.payments.util.MasterPassAPI.API_PASSWORD;

public class MasterPassNotificationServlet extends HttpServlet {

    static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    static final Logger log = Logger.getLogger(MasterPassNotificationServlet.class.getSimpleName());
    public static final String NOTIFICATION_PASSWORD = "0A7C7C3838830A556E3918C95B70C1D6";

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
     * Handle notification (encrypted) from MasterPass
     * @param req
     * @param resp
     * @throws IOException
     */
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        log.log(Level.INFO, "################### doPost MasterPassNotificationServlet starting ...");
        printRequestParameters(req);
        String notificationEncrypted = req.getParameter("notificationEncrypted");
        resp.setContentType("application/json");

        try {
            DataTest dt = GSON.fromJson(notificationEncrypted,DataTest.class);
            if (!dt.getResult().equalsIgnoreCase("TEST")) {
                if (notificationEncrypted != null) {
                    NotificationPayload np = decrypt(notificationEncrypted);
                    if (np != null) {
                        //todo send fcm messages + save to database .....................
                        resp.getWriter().println("Request OK");
                    } else {
                        resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                        resp.getWriter().println("Bad Request");
                    }
                } else {
                    resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                    resp.getWriter().println("Bad Request");
                }

            }  else {
                resp.getWriter().println("TEST Request OK");
            }
        } catch (Exception s) {}

        log.log(Level.WARNING, "################### MasterPassNotificationServlet ending ...");
    }

    private void printRequestParameters(HttpServletRequest req) {

        Enumeration<String> parms = req.getParameterNames();
        while (parms.hasMoreElements()) {
            String parm = parms.nextElement();
            log.log(Level.WARNING, parm + " = " + req.getParameter(parm));
        }
    }

    private NotificationPayload decrypt(String notification) {
        NotificationPayload m = null;
        try {
            byte[] data = Base64.decodeBase64(notification.getBytes());
            byte[] rawKey = Hex.decodeHex(API_PASSWORD.toCharArray());
            Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
            c.init(Cipher.DECRYPT_MODE, new SecretKeySpec(rawKey, "AES"), new IvParameterSpec(new byte[16]));
            String json = new String(c.doFinal(data));
            m = GSON.fromJson(json, NotificationPayload.class);
        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed to decrypt data", e);
        }

        return m;
    }

}
