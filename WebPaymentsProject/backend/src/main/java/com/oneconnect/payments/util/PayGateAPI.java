package com.oneconnect.payments.util;

import com.oneconnect.payments.paygate.PayHOSTService;
import com.oneconnect.payments.paygate.PingRequest;
import com.oneconnect.payments.paygate.PingResponse;
import com.oneconnect.payments.paygate.SinglePaymentRequest;
import com.oneconnect.payments.paygate.SinglePaymentResponse;

import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.soap.DetailEntry;

/**
 * Created by aubreymalabie on 1/19/17.
 */

public class PayGateAPI {

    private static final Logger log = Logger.getLogger(PayGateAPI.class.getName());
//    public static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    public static final PayHOSTService service = new PayHOSTService();

    public SinglePaymentResponse singlePaymentRequest(SinglePaymentRequest request) {
        log.log(Level.WARNING, "starting singlePaymentRequest ...." + request.getCardPaymentRequest().getCardNumber());
        SinglePaymentResponse resp = new SinglePaymentResponse();
        try {
            resp = service.getPayHOSTSoap11().singlePayment(request);
            log.log(Level.WARNING, "what the fuck happened - did not crash!");
        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed singlePaymentRequest", e);
            if (e instanceof javax.xml.ws.soap.SOAPFaultException) {
                javax.xml.ws.soap.SOAPFaultException x = (javax.xml.ws.soap.SOAPFaultException) e;
                javax.xml.soap.Detail detail = x.getFault().getDetail(); // <detail> node
                Iterator detailEntries = detail.getDetailEntries(); //nodes under <detail>

                while (detailEntries.hasNext()) {
                    DetailEntry de = (DetailEntry) detailEntries.next();
                    log.log(Level.WARNING, de.toString());
                }

            }
        }
        return resp;
    }
     public PingResponse ping(PingRequest request) {
         PingResponse resp = service.getPayHOSTSoap11().ping(request);
         return resp;
     }
}
