/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.oneconnect.payemts.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.oneconnect.payemts.backend.util.InitiateTransactionDTO;
import com.oneconnect.payemts.backend.util.PayGateAPI;
import com.oneconnect.payemts.backend.util.TransactionResponseDTO;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "paymentApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.payemts.oneconnect.com",
                ownerName = "backend.payemts.oneconnect.com",
                packagePath = ""
        )
)
public class PaymentEndpoint {

    private PayGateAPI api = new PayGateAPI();
    private static final Logger log = Logger.getLogger(PaymentEndpoint.class.getName());
    public static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    /**
     * A simple endpoint method that takes a name and says Hi back
     */
    @ApiMethod(name = "initiatePayGateTransaction")
    public TransactionResponseDTO initiatePayGateTransaction(InitiateTransactionDTO tran) {
        log.log(Level.WARNING, "initiatePayGateTransaction: " + gson.toJson(tran));
        return api.initiateTransaction(tran);
    }

}
