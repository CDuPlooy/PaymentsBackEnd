
package com.oneconnectgroup.payuapp.payu;

public class Sbux
    extends IPaymentMethod
{

    protected String amountInCents;
    protected String sbuxOldReference;
    protected String sbuxReference;
    protected String sbuxVoucherNo;

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
     * Gets the value of the sbuxOldReference property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSbuxOldReference() {
        return sbuxOldReference;
    }

    /**
     * Sets the value of the sbuxOldReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSbuxOldReference(String value) {
        this.sbuxOldReference = value;
    }

    /**
     * Gets the value of the sbuxReference property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSbuxReference() {
        return sbuxReference;
    }

    /**
     * Sets the value of the sbuxReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSbuxReference(String value) {
        this.sbuxReference = value;
    }

    /**
     * Gets the value of the sbuxVoucherNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSbuxVoucherNo() {
        return sbuxVoucherNo;
    }

    /**
     * Sets the value of the sbuxVoucherNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSbuxVoucherNo(String value) {
        this.sbuxVoucherNo = value;
    }

}
