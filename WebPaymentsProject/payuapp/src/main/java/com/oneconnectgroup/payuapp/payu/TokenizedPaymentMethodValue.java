
package com.oneconnectgroup.payuapp.payu;

public class TokenizedPaymentMethodValue {

    protected int hashOrder;
    protected boolean hashParticipant;
    protected boolean sensitiveData;
    protected String value;

    /**
     * Gets the value of the hashOrder property.
     * 
     */
    public int getHashOrder() {
        return hashOrder;
    }

    /**
     * Sets the value of the hashOrder property.
     * 
     */
    public void setHashOrder(int value) {
        this.hashOrder = value;
    }

    /**
     * Gets the value of the hashParticipant property.
     * 
     */
    public boolean isHashParticipant() {
        return hashParticipant;
    }

    /**
     * Sets the value of the hashParticipant property.
     * 
     */
    public void setHashParticipant(boolean value) {
        this.hashParticipant = value;
    }

    /**
     * Gets the value of the sensitiveData property.
     * 
     */
    public boolean isSensitiveData() {
        return sensitiveData;
    }

    /**
     * Sets the value of the sensitiveData property.
     * 
     */
    public void setSensitiveData(boolean value) {
        this.sensitiveData = value;
    }

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
    }

}
