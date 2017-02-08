
package com.oneconnectgroup.payuapp.payu;

import java.util.ArrayList;
import java.util.List;

public class ManagePaymentMethod {

    protected String api;
    protected String safekey;
    protected ManagePaymentMethodType managePaymentMethodType;
    protected AdditionalInfo additionalInformation;
    protected Customer customer;
    protected List<CustomField> customfield;

    /**
     * Gets the value of the api property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApi() {
        return api;
    }

    /**
     * Sets the value of the api property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApi(String value) {
        this.api = value;
    }

    /**
     * Gets the value of the safekey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSafekey() {
        return safekey;
    }

    /**
     * Sets the value of the safekey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSafekey(String value) {
        this.safekey = value;
    }

    /**
     * Gets the value of the managePaymentMethodType property.
     * 
     * @return
     *     possible object is
     *     {@link ManagePaymentMethodType }
     *     
     */
    public ManagePaymentMethodType getManagePaymentMethodType() {
        return managePaymentMethodType;
    }

    /**
     * Sets the value of the managePaymentMethodType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagePaymentMethodType }
     *     
     */
    public void setManagePaymentMethodType(ManagePaymentMethodType value) {
        this.managePaymentMethodType = value;
    }

    /**
     * Gets the value of the additionalInformation property.
     * 
     * @return
     *     possible object is
     *     {@link AdditionalInfo }
     *     
     */
    public AdditionalInfo getAdditionalInformation() {
        return additionalInformation;
    }

    /**
     * Sets the value of the additionalInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdditionalInfo }
     *     
     */
    public void setAdditionalInformation(AdditionalInfo value) {
        this.additionalInformation = value;
    }

    /**
     * Gets the value of the customer property.
     * 
     * @return
     *     possible object is
     *     {@link Customer }
     *     
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Sets the value of the customer property.
     * 
     * @param value
     *     allowed object is
     *     {@link Customer }
     *     
     */
    public void setCustomer(Customer value) {
        this.customer = value;
    }

    /**
     * Gets the value of the customfield property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the customfield property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCustomfield().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CustomField }
     * 
     * 
     */
    public List<CustomField> getCustomfield() {
        if (customfield == null) {
            customfield = new ArrayList<CustomField>();
        }
        return this.customfield;
    }

}
