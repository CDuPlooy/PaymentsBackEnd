/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.oneconnect.payments.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.oneconnect.payments.backend.util.InitiateTransactionDTO;
import com.oneconnect.payments.backend.util.PayGateAPI;
import com.oneconnect.payments.backend.util.TransactionResponseDTO;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "paymentsApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.payments.oneconnect.com",
                ownerName = "backend.payments.oneconnect.com",
                packagePath = ""
        )
)


public class PaymentsEndpoint {
    private PayGateAPI api = new PayGateAPI();

    /**
     * A simple endpoint method that takes a name and says Hi back
     */
    @ApiMethod(name = "initiateTransaction")
    public TransactionResponseDTO sayHi(InitiateTransactionDTO initiateTransaction) {
        return api.initiateTransaction(initiateTransaction);

    }

}
