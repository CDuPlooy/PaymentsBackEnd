
package com.oneconnectgroup.payuapp.payu;

public class Wallet
    extends Sva
{

    protected String acquirerReference;
    protected PaymentInstrument paymentInstrument;
    protected PaymentInstrumentType paymentInstrumentType;

    /**
     * Gets the value of the acquirerReference property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAcquirerReference() {
        return acquirerReference;
    }

    /**
     * Sets the value of the acquirerReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAcquirerReference(String value) {
        this.acquirerReference = value;
    }

    /**
     * Gets the value of the paymentInstrument property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentInstrument }
     *     
     */
    public PaymentInstrument getPaymentInstrument() {
        return paymentInstrument;
    }

    /**
     * Sets the value of the paymentInstrument property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentInstrument }
     *     
     */
    public void setPaymentInstrument(PaymentInstrument value) {
        this.paymentInstrument = value;
    }

    /**
     * Gets the value of the paymentInstrumentType property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentInstrumentType }
     *     
     */
    public PaymentInstrumentType getPaymentInstrumentType() {
        return paymentInstrumentType;
    }

    /**
     * Sets the value of the paymentInstrumentType property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentInstrumentType }
     *     
     */
    public void setPaymentInstrumentType(PaymentInstrumentType value) {
        this.paymentInstrumentType = value;
    }

}
