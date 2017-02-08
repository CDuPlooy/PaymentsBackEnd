
package com.oneconnectgroup.payuapp.payu;

public abstract class IPaymentMethod
    extends PayUMapLoader
{

    protected String defaultPM;
    protected String pmId;

    /**
     * Gets the value of the defaultPM property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDefaultPM() {
        return defaultPM;
    }

    /**
     * Sets the value of the defaultPM property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDefaultPM(String value) {
        this.defaultPM = value;
    }

    /**
     * Gets the value of the pmId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPmId() {
        return pmId;
    }

    /**
     * Sets the value of the pmId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPmId(String value) {
        this.pmId = value;
    }

}
