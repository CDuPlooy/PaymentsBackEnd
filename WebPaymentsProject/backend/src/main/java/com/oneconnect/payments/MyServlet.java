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

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet {

    static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        resp.setContentType("application/json");
        TransactionResponseDTO r = new TransactionResponseDTO();
        r.setMessage("PAYGATE testing: server responding with A OK!");
        r.setStatusCode(0);

        resp.getWriter().println(GSON.toJson(r));
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        String name = req.getParameter("name");
        resp.setContentType("text/plain");
        if (name == null) {
            resp.getWriter().println("Please enter a name");
        }
        resp.getWriter().println("Hello " + name);
    }
}
