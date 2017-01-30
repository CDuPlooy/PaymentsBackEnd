/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.oneconnect.payments;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.config.Named;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.oneconnect.payments.masterpass.MasterPassRequestDTO;
import com.oneconnect.payments.masterpass.MasterPassResponseDTO;
import com.oneconnect.payments.paygate.PayGateInitiateRequestDTO;
import com.oneconnect.payments.paygate.PayGateInitiateTranResponseDTO;
import com.oneconnect.payments.paygate.PayGateNotifyResponseDTO;
import com.oneconnect.payments.paygate.PayGateResponseDTO;
import com.oneconnect.payments.paygate.PayGateQueryTransactionRequestDTO;
import com.oneconnect.payments.payu.PayUResponseDTO;
import com.oneconnect.payments.util.MasterPassAPI;
import com.oneconnect.payments.util.PayGateAPI;
import com.oneconnect.payments.util.PayUAPI;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "paymentApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "payments.oneconnect.com",
                ownerName = "payments.oneconnect.com"
        )
)
public class PaymentEndpoint {

    private PayUAPI payUAPI = new PayUAPI();
    private PayGateAPI payGateAPI = new PayGateAPI();
    private static final Logger log = Logger.getLogger(PaymentEndpoint.class.getName());
    public static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private MasterPassAPI masterPassAPI = new MasterPassAPI();


    @ApiMethod(name = "initiatePayGate")
    public PayGateResponseDTO initiatePayGate(PayGateInitiateRequestDTO payGateRequest) {
        PayGateResponseDTO mResponse = new PayGateResponseDTO();
        try {
            PayGateInitiateTranResponseDTO resp = payGateAPI.initiateTransaction(payGateRequest);
            mResponse.setPayGateInitiateTranResponse(resp);
        } catch (Exception e) {
            mResponse.setStatusCode(9);
            mResponse.setMessage("Unable to initiate PayGate transaction");
        }

        return mResponse;
    }
    @ApiMethod(name = "queryPayGate")
    public PayGateResponseDTO queryPayGate(PayGateQueryTransactionRequestDTO payGateRequest) {
        PayGateResponseDTO mResponse = new PayGateResponseDTO();
        try {
            PayGateNotifyResponseDTO resp = payGateAPI.getTransactionResponse(payGateRequest);
            mResponse.setPayGateNotifyResponse(resp);
        } catch (Exception e) {
            mResponse.setStatusCode(9);
            mResponse.setMessage("Unable to query PayGate transaction");
        }

        return mResponse;
    }
    @ApiMethod(name = "obtainMasterPassCode")
    public MasterPassResponseDTO obtainMasterPassCode(
            final MasterPassRequestDTO masterPassRequest) {

        log.log(Level.WARNING, "############### obtainMasterPassCode starting ...");
        MasterPassResponseDTO resp = masterPassAPI.getCode(masterPassRequest);


        return resp;
    }

    @ApiMethod(name = "getMasterPassTransactionCode")
    public MasterPassResponseDTO getMasterPassTransactionCode(final MasterPassRequestDTO masterPassRequest) {
        log.log(Level.WARNING, "getMasterPassCode starting ...");
        MasterPassResponseDTO resp = masterPassAPI.getCode(masterPassRequest);


        return resp;
    }

    @ApiMethod(name = "queryMasterPassCode")
    public MasterPassResponseDTO queryMasterPassCode(@Named("code") String code) {
        log.log(Level.WARNING, "queryMasterPassCode starting ...");
        MasterPassResponseDTO resp = masterPassAPI.queryCode(code);

        return resp;
    }

    @ApiMethod(name = "pingPayU")
    public PayUResponseDTO pingPayU() {
        PayUResponseDTO response = new PayUResponseDTO();
        String ping = payUAPI.ping();
        response.setMessage("Ping response: " + ping);
        return response;
    }

}
