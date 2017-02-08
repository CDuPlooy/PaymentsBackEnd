
package com.oneconnectgroup.payuapp.payu;

import java.util.ArrayList;
import java.util.List;

public class SetTransaction {

    protected String api;
    protected String safekey;
    protected TransactionType transactionType;
    protected Boolean stage;
    protected AdditionalInfo additionalInformation;
    protected Customer customer;
    protected Basket basket;
    protected Fraud fraud;
    protected List<CreditCard> creditcard;
    protected List<Eft> eft;
    protected List<LoyaltyCard> loyalty;
    protected List<BankTransfer> bankTransfer;
    protected Ebucks ebucks;
    protected AutoPay autopay;
    protected Soulstace soulstace;
    protected Globalpay globalpay;
    protected List<CustomField> customfield;
    protected TransactionRecord transactionRecord;
    protected EWallet eWallet;

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
     * Gets the value of the transactionType property.
     * 
     * @return
     *     possible object is
     *     {@link TransactionType }
     *     
     */
    public TransactionType getTransactionType() {
        return transactionType;
    }

    /**
     * Sets the value of the transactionType property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionType }
     *     
     */
    public void setTransactionType(TransactionType value) {
        this.transactionType = value;
    }

    /**
     * Gets the value of the stage property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isStage() {
        return stage;
    }

    /**
     * Sets the value of the stage property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setStage(Boolean value) {
        this.stage = value;
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
     * Gets the value of the basket property.
     * 
     * @return
     *     possible object is
     *     {@link Basket }
     *     
     */
    public Basket getBasket() {
        return basket;
    }

    /**
     * Sets the value of the basket property.
     * 
     * @param value
     *     allowed object is
     *     {@link Basket }
     *     
     */
    public void setBasket(Basket value) {
        this.basket = value;
    }

    /**
     * Gets the value of the fraud property.
     * 
     * @return
     *     possible object is
     *     {@link Fraud }
     *     
     */
    public Fraud getFraud() {
        return fraud;
    }

    /**
     * Sets the value of the fraud property.
     * 
     * @param value
     *     allowed object is
     *     {@link Fraud }
     *     
     */
    public void setFraud(Fraud value) {
        this.fraud = value;
    }

    /**
     * Gets the value of the creditcard property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the creditcard property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCreditcard().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CreditCard }
     * 
     * 
     */
    public List<CreditCard> getCreditcard() {
        if (creditcard == null) {
            creditcard = new ArrayList<CreditCard>();
        }
        return this.creditcard;
    }

    /**
     * Gets the value of the eft property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the eft property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEft().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Eft }
     * 
     * 
     */
    public List<Eft> getEft() {
        if (eft == null) {
            eft = new ArrayList<Eft>();
        }
        return this.eft;
    }

    /**
     * Gets the value of the loyalty property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the loyalty property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLoyalty().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LoyaltyCard }
     * 
     * 
     */
    public List<LoyaltyCard> getLoyalty() {
        if (loyalty == null) {
            loyalty = new ArrayList<LoyaltyCard>();
        }
        return this.loyalty;
    }

    /**
     * Gets the value of the bankTransfer property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bankTransfer property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBankTransfer().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BankTransfer }
     * 
     * 
     */
    public List<BankTransfer> getBankTransfer() {
        if (bankTransfer == null) {
            bankTransfer = new ArrayList<BankTransfer>();
        }
        return this.bankTransfer;
    }

    /**
     * Gets the value of the ebucks property.
     * 
     * @return
     *     possible object is
     *     {@link Ebucks }
     *     
     */
    public Ebucks getEbucks() {
        return ebucks;
    }

    /**
     * Sets the value of the ebucks property.
     * 
     * @param value
     *     allowed object is
     *     {@link Ebucks }
     *     
     */
    public void setEbucks(Ebucks value) {
        this.ebucks = value;
    }

    /**
     * Gets the value of the autopay property.
     * 
     * @return
     *     possible object is
     *     {@link AutoPay }
     *     
     */
    public AutoPay getAutopay() {
        return autopay;
    }

    /**
     * Sets the value of the autopay property.
     * 
     * @param value
     *     allowed object is
     *     {@link AutoPay }
     *     
     */
    public void setAutopay(AutoPay value) {
        this.autopay = value;
    }

    /**
     * Gets the value of the soulstace property.
     * 
     * @return
     *     possible object is
     *     {@link Soulstace }
     *     
     */
    public Soulstace getSoulstace() {
        return soulstace;
    }

    /**
     * Sets the value of the soulstace property.
     * 
     * @param value
     *     allowed object is
     *     {@link Soulstace }
     *     
     */
    public void setSoulstace(Soulstace value) {
        this.soulstace = value;
    }

    /**
     * Gets the value of the globalpay property.
     * 
     * @return
     *     possible object is
     *     {@link Globalpay }
     *     
     */
    public Globalpay getGlobalpay() {
        return globalpay;
    }

    /**
     * Sets the value of the globalpay property.
     * 
     * @param value
     *     allowed object is
     *     {@link Globalpay }
     *     
     */
    public void setGlobalpay(Globalpay value) {
        this.globalpay = value;
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

    /**
     * Gets the value of the transactionRecord property.
     * 
     * @return
     *     possible object is
     *     {@link TransactionRecord }
     *     
     */
    public TransactionRecord getTransactionRecord() {
        return transactionRecord;
    }

    /**
     * Sets the value of the transactionRecord property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionRecord }
     *     
     */
    public void setTransactionRecord(TransactionRecord value) {
        this.transactionRecord = value;
    }

    /**
     * Gets the value of the eWallet property.
     * 
     * @return
     *     possible object is
     *     {@link EWallet }
     *     
     */
    public EWallet getEWallet() {
        return eWallet;
    }

    /**
     * Sets the value of the eWallet property.
     * 
     * @param value
     *     allowed object is
     *     {@link EWallet }
     *     
     */
    public void setEWallet(EWallet value) {
        this.eWallet = value;
    }

}
