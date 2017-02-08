
package com.oneconnectgroup.payuapp.payu;


public class Rcs
    extends IPaymentMethod
{

    protected String amountInCents;
    protected String cardType;
    protected String tenderType;
    protected String vspTrxId;
    protected String wiCode;
    protected String wiTransactionId;

    /**
     * Gets the value of the amountInCents property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAmountInCents() {
        return amountInCents;
    }

    /**
     * Sets the value of the amountInCents property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAmountInCents(String value) {
        this.amountInCents = value;
    }

    /**
     * Gets the value of the cardType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCardType() {
        return cardType;
    }

    /**
     * Sets the value of the cardType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCardType(String value) {
        this.cardType = value;
    }

    /**
     * Gets the value of the tenderType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTenderType() {
        return tenderType;
    }

    /**
     * Sets the value of the tenderType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTenderType(String value) {
        this.tenderType = value;
    }

    /**
     * Gets the value of the vspTrxId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVspTrxId() {
        return vspTrxId;
    }

    /**
     * Sets the value of the vspTrxId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVspTrxId(String value) {
        this.vspTrxId = value;
    }

    /**
     * Gets the value of the wiCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWiCode() {
        return wiCode;
    }

    /**
     * Sets the value of the wiCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWiCode(String value) {
        this.wiCode = value;
    }

    /**
     * Gets the value of the wiTransactionId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWiTransactionId() {
        return wiTransactionId;
    }

    /**
     * Sets the value of the wiTransactionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWiTransactionId(String value) {
        this.wiTransactionId = value;
    }

}
