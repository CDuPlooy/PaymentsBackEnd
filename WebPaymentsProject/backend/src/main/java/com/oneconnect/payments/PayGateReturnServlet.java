/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Servlet Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloWorld
*/

package com.oneconnect.payments;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.oneconnect.payments.util.TransactionResponseDTO;

import java.io.IOException;
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
        log.log(Level.WARNING, "################### doGet PayGateReturnServlet starting ...");
        printRequestParameters(req);
        resp.setContentType("text/html");
        String r = processRequest(req);
        resp.getWriter().println(r);

        log.log(Level.WARNING, "################### PayGateReturnServlet ending ... sent data to app");
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

        log.log(Level.WARNING, "## doPost PayGateReturnServlet receiving ...");
        printRequestParameters(req);
        String r = processRequest(req);
        resp.setContentType("text/html");
        resp.getWriter().println(r);

        log.log(Level.WARNING, "################### PayGateReturnServlet ending ... sent data to app");
    }

    private String processRequest(HttpServletRequest req) {
        TransactionResponseDTO tr = new TransactionResponseDTO();
        try {
            tr.setPayRequestID(req.getParameter("PAY_REQUEST_ID"));
            int tranStatus = Integer.parseInt(req.getParameter("TRANSACTION_STATUS"));
            tr.setTransactionStatus(tranStatus);
            switch (tranStatus) {
                case 0:
                    tr.setMessage("Not Done");
                    break;
                case 1:
                    tr.setMessage("Approved");
                    break;
                case 2:
                    tr.setMessage("Declined");
                    break;
                case 3:
                    tr.setMessage("Cancelled");
                    break;
                case 4:
                    tr.setMessage("User Cancelled");
                    break;

            }

        } catch (Exception e) {
            tr.setStatusCode(8);
            tr.setMessage("Unable to process the transaction");

        }

        log.log(Level.WARNING, "sending to app: " + GSON.toJson(tr));
        return getHTML(tr);
    }

    private String getHTML(TransactionResponseDTO tr) {
        StringBuilder sb = new StringBuilder();
        sb.append("<br><h1>").append("Payment Result</h1><br>");
        sb.append("<h2>").append(tr.getMessage()).append("</h2><br>");
        sb.append("<h3>Thank You!</h3>");
        sb.append("<p>OneConnect Payment Gateway appreciates your business.</p>");
        sb.append("<p>").append(tr.getPayRequestID()).append("</p>");



        return sb.toString();
    }
    private void printRequestParameters(HttpServletRequest req) {
        StringBuilder sb = new StringBuilder();

        Enumeration<String> parms = req.getParameterNames();
        while (parms.hasMoreElements()) {
            String parm = parms.nextElement();
           sb.append(parm).append( " = ").append(req.getParameter(parm)).append("\n");
        }
        Enumeration<String> attr = req.getAttributeNames();
        while (parms.hasMoreElements()) {
            String parm = attr.nextElement();
            sb.append(parm).append( " = ").append(req.getAttribute(parm)).append("\n");
        }

        log.log(Level.WARNING,"Request parameters and attributes:\n" + sb.toString());
    }



}
