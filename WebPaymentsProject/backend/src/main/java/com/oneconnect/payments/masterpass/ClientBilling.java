package com.oneconnect.payments.masterpass;

/**
 * Created by aubreymalabie on 1/23/17.
 */

public class ClientBilling {

    private int clientBillingId;

    public int getClientBillingId() {
        return this.clientBillingId;
    }

    public void setClientBillingId(int clientBillingId) {
        this.clientBillingId = clientBillingId;
    }

    private int clientId;

    public int getClientId() {
        return this.clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    private String alias;

    public String getAlias() {
        return this.alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    private String city;

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    private String country;

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    private String countrySubdivision;

    public String getCountrySubdivision() {
        return this.countrySubdivision;
    }

    public void setCountrySubdivision(String countrySubdivision) {
        this.countrySubdivision = countrySubdivision;
    }

    private String line1;

    public String getLine1() {
        return this.line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    private String line2;

    public String getLine2() {
        return this.line2;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    private int postalCode;

    public int getPostalCode() {
        return this.postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

}
