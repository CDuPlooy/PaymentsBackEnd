/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Servlet Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloWorld
*/

package com.oneconnect.payments;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.oneconnect.payments.paygate.PayGateNotifyResponseDTO;
import com.oneconnect.payments.paygate.PayGateResponseDTO;
import com.oneconnect.payments.util.TransactionResponseDTO;

import java.io.IOException;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * MasterPassNotificationServlet handles communications from masterpass Payment Gateway
 */
public class PayGateNotificationServlet extends HttpServlet {

    static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    static final Logger log = Logger.getLogger(PayGateNotificationServlet.class.getSimpleName());

    /**
     * Browser based connection for testing servlet
     *
     * @param req
     * @param resp
     * @throws IOException
     */
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        log.log(Level.WARNING, "################### doGet PayGateNotificationServlet starting ...");
        printRequestParameters(req);
        resp.setContentType("text/html");
        PayGateResponseDTO payGateResponse = new PayGateResponseDTO();
        try {
            PayGateNotifyResponseDTO m = processNotification(req);
            payGateResponse.setPayGateNotifyResponse(m);
            payGateResponse.setMessage("PayGate notification response OK");
        } catch (Exception e) {
            payGateResponse.setStatusCode(9);
            payGateResponse.setMessage("Unable to process PayGate notofication");
        }
        resp.getWriter().println("OK");
        log.log(Level.WARNING, "################### PayGateNotificationServlet ended: sent OK ...");
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
        printRequestParameters(req);
        TransactionResponseDTO r = new TransactionResponseDTO();
        r.setMessage("PayGateNotificationServlet: server notification responding with OK!");
        r.setStatusCode(0);
        resp.setContentType("application/json");
        PayGateResponseDTO payGateResponse = new PayGateResponseDTO();
        try {
            PayGateNotifyResponseDTO m = processNotification(req);
            payGateResponse.setPayGateNotifyResponse(m);
            payGateResponse.setMessage("PayGate notification response OK");
        } catch (Exception e) {
            payGateResponse.setStatusCode(9);
            payGateResponse.setMessage("Unable to process PayGate notofication");
        }
        resp.getWriter().println(GSON.toJson("OK"));
        log.log(Level.WARNING, "################### PayGateNotificationServlet ended: sent OK ...");
    }

    protected PayGateNotifyResponseDTO processNotification(HttpServletRequest req) throws Exception{

        PayGateNotifyResponseDTO notifyResponse = new PayGateNotifyResponseDTO();
        try {
            notifyResponse.setTransactionID(req.getParameter("TRANSACTION_ID"));
            notifyResponse.setTransactionStatus(Integer.parseInt(req.getParameter("TRANSACTION_STATUS")));
            notifyResponse.setResultCode(Integer.parseInt(req.getParameter("RESULT_CODE")));
            notifyResponse.setResultDesc(req.getParameter("RESULT_DESC"));
            notifyResponse.setPayGateID(req.getParameter("PAYGATE_ID"));
            notifyResponse.setPayMethodDetail(req.getParameter("PAY_METHOD_DETAIL"));
            notifyResponse.setAmount(Integer.parseInt(req.getParameter("AMOUNT")));
            notifyResponse.setReference(req.getParameter("REFERENCE"));
            notifyResponse.setCurrency(req.getParameter("CURRENCY"));
            notifyResponse.setRiskIndicator(req.getParameter("RISK_INDICATOR"));
            notifyResponse.setAuthCode(req.getParameter("AUTH_CODE"));
            notifyResponse.setChecksum(req.getParameter("CHECKSUM"));
            notifyResponse.setPayMethod(req.getParameter("PAY_METHOD"));
            notifyResponse.setUser1(req.getParameter("USER1"));
            notifyResponse.setPayRequestID(req.getParameter("PAY_REQUEST_ID"));

            log.log(Level.WARNING, "PayGateNotifyResponse:\n" + GSON.toJson(notifyResponse));
        } catch (Exception e) {
            log.log(Level.SEVERE,"Failed to parse PayGate notify", e);
            throw e;
        }

        return notifyResponse;
    }

    private void printRequestParameters(HttpServletRequest req) {
        StringBuilder sb = new StringBuilder();

        Enumeration<String> parms = req.getParameterNames();
        while (parms.hasMoreElements()) {
            String parm = parms.nextElement();
            sb.append(parm).append(" = ").append(req.getParameter(parm)).append("\n");
        }
        Enumeration<String> attr = req.getAttributeNames();
        while (parms.hasMoreElements()) {
            String parm = attr.nextElement();
            sb.append(parm).append(" = ").append(req.getAttribute(parm)).append("\n");
        }

        log.log(Level.WARNING, "Request parameters and attributes:\n" + sb.toString());
    }

}
