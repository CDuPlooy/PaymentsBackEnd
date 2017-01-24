package com.oneconnect.payments.masterpass;

/**
 * Created by aubreymalabie on 1/23/17.
 */

public class ClientContact {

    private int clientContactId;

    public int getClientContactId() {
        return this.clientContactId;
    }

    public void setClientContactId(int clientContactId) {
        this.clientContactId = clientContactId;
    }

    private int clientId;

    public int getClientId() {
        return this.clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    private String firstName;

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    private String lastName;

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    private String country;

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    private String emailAddress;

    public String getEmailAddress() {
        return this.emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

}
