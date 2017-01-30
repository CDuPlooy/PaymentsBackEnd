/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Servlet Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloWorld
*/

package com.oneconnect.payments;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.oneconnect.payments.masterpass.DataTest;
import com.oneconnect.payments.util.TransactionResponseDTO;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *   MasterPassNotificationServlet handles communications from masterpass Payment Gateway
 */
public class PayGateReturnServlet extends HttpServlet {

    static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    static final Logger log = Logger.getLogger(PayGateReturnServlet.class.getSimpleName());

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

        log.log(Level.WARNING, "## doPost PayGateNotificationServlet receiving ...");
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
        log.log(Level.WARNING, "## PayGateNotificationServlet ends ...elapsed: "
                + (end - start) + " milliseconds");
    }

    protected void processNotification(HttpServletResponse resp, String notificationEncrypted) {
//        try {
//            NotificationPayload np = decrypt(notificationEncrypted);
//            if (np != null) {
//                //todo send fcm messages + save to database .....................
//                resp.getWriter().println("Request OK");
//            } else {
//                log.log(Level.SEVERE, "Decryption failed");
//                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
//                resp.getWriter().println("Bad Request");
//            }
//        } catch (Exception e) {
//            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
//            try {
//                resp.getWriter().println("Bad Request");
//            } catch (IOException e1) {
//                log.log(Level.SEVERE, "PayGate notification failed", e1);
//            }
//        }
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



}
