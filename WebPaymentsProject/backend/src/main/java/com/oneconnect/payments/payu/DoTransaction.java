
package com.oneconnect.payments.payu;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for doTransaction complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="doTransaction">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Api" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Safekey" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TransactionType" type="{http://soap.api.controller.web.payjar.com/}transactionType" minOccurs="0"/>
 *         &lt;element name="AuthenticationType" type="{http://soap.api.controller.web.payjar.com/}authenticationType" minOccurs="0"/>
 *         &lt;element name="AdditionalInformation" type="{http://soap.api.controller.web.payjar.com/}additionalInfo" minOccurs="0"/>
 *         &lt;element name="Customer" type="{http://soap.api.controller.web.payjar.com/}customer" minOccurs="0"/>
 *         &lt;element name="Basket" type="{http://soap.api.controller.web.payjar.com/}basket" minOccurs="0"/>
 *         &lt;element name="Fraud" type="{http://soap.api.controller.web.payjar.com/}fraud" minOccurs="0"/>
 *         &lt;element name="Creditcard" type="{http://soap.api.controller.web.payjar.com/}creditCard" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Eft" type="{http://soap.api.controller.web.payjar.com/}eft" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="DiscoveryMiles" type="{http://soap.api.controller.web.payjar.com/}discoveryMiles" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="PayPal" type="{http://soap.api.controller.web.payjar.com/}payPal" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Debitcard" type="{http://soap.api.controller.web.payjar.com/}debitCard" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Loyalty" type="{http://soap.api.controller.web.payjar.com/}loyaltyCard" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="BankTransfer" type="{http://soap.api.controller.web.payjar.com/}bankTransfer" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Wallet" type="{http://soap.api.controller.web.payjar.com/}wallet" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ThirdParty" type="{http://soap.api.controller.web.payjar.com/}thirdParty" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Ebucks" type="{http://soap.api.controller.web.payjar.com/}ebucks" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Autopay" type="{http://soap.api.controller.web.payjar.com/}autoPay" minOccurs="0"/>
 *         &lt;element name="Soulstace" type="{http://soap.api.controller.web.payjar.com/}soulstace" minOccurs="0"/>
 *         &lt;element name="Globalpay" type="{http://soap.api.controller.web.payjar.com/}globalpay" minOccurs="0"/>
 *         &lt;element name="Customfield" type="{http://soap.api.controller.web.payjar.com/}customField" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Credit" type="{http://soap.api.controller.web.payjar.com/}credit" minOccurs="0"/>
 *         &lt;element name="TransactionRecord" type="{http://soap.api.controller.web.payjar.com/}transactionRecord" minOccurs="0"/>
 *         &lt;element name="Sbux" type="{http://soap.api.controller.web.payjar.com/}sbux" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="RCS" type="{http://soap.api.controller.web.payjar.com/}rcs" minOccurs="0"/>
 *         &lt;element name="BankAccount" type="{http://soap.api.controller.web.payjar.com/}bankAccount" minOccurs="0"/>
 *         &lt;element name="EWallet" type="{http://soap.api.controller.web.payjar.com/}eWallet" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "doTransaction", propOrder = {
    "api",
    "safekey",
    "transactionType",
    "authenticationType",
    "additionalInformation",
    "customer",
    "basket",
    "fraud",
    "creditcard",
    "eft",
    "discoveryMiles",
    "payPal",
    "debitcard",
    "loyalty",
    "bankTransfer",
    "wallet",
    "thirdParty",
    "ebucks",
    "autopay",
    "soulstace",
    "globalpay",
    "customfield",
    "credit",
    "transactionRecord",
    "sbux",
    "rcs",
    "bankAccount",
    "eWallet"
})
public class DoTransaction {

    @XmlElement(name = "Api")
    protected String api;
    @XmlElement(name = "Safekey")
    protected String safekey;
    @XmlElement(name = "TransactionType")
    protected TransactionType transactionType;
    @XmlElement(name = "AuthenticationType")
    protected AuthenticationType authenticationType;
    @XmlElement(name = "AdditionalInformation")
    protected AdditionalInfo additionalInformation;
    @XmlElement(name = "Customer")
    protected Customer customer;
    @XmlElement(name = "Basket")
    protected Basket basket;
    @XmlElement(name = "Fraud")
    protected Fraud fraud;
    @XmlElement(name = "Creditcard")
    protected List<CreditCard> creditcard;
    @XmlElement(name = "Eft")
    protected List<Eft> eft;
    @XmlElement(name = "DiscoveryMiles")
    protected List<DiscoveryMiles> discoveryMiles;
    @XmlElement(name = "PayPal")
    protected List<PayPal> payPal;
    @XmlElement(name = "Debitcard")
    protected List<DebitCard> debitcard;
    @XmlElement(name = "Loyalty")
    protected List<LoyaltyCard> loyalty;
    @XmlElement(name = "BankTransfer")
    protected List<BankTransfer> bankTransfer;
    @XmlElement(name = "Wallet")
    protected List<Wallet> wallet;
    @XmlElement(name = "ThirdParty")
    protected List<ThirdParty> thirdParty;
    @XmlElement(name = "Ebucks")
    protected List<Ebucks> ebucks;
    @XmlElement(name = "Autopay")
    protected AutoPay autopay;
    @XmlElement(name = "Soulstace")
    protected Soulstace soulstace;
    @XmlElement(name = "Globalpay")
    protected Globalpay globalpay;
    @XmlElement(name = "Customfield")
    protected List<CustomField> customfield;
    @XmlElement(name = "Credit")
    protected Credit credit;
    @XmlElement(name = "TransactionRecord")
    protected TransactionRecord transactionRecord;
    @XmlElement(name = "Sbux")
    protected List<Sbux> sbux;
    @XmlElement(name = "RCS")
    protected Rcs rcs;
    @XmlElement(name = "BankAccount")
    protected BankAccount bankAccount;
    @XmlElement(name = "EWallet")
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
     * Gets the value of the authenticationType property.
     * 
     * @return
     *     possible object is
     *     {@link AuthenticationType }
     *     
     */
    public AuthenticationType getAuthenticationType() {
        return authenticationType;
    }

    /**
     * Sets the value of the authenticationType property.
     * 
     * @param value
     *     allowed object is
     *     {@link AuthenticationType }
     *     
     */
    public void setAuthenticationType(AuthenticationType value) {
        this.authenticationType = value;
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
     * Gets the value of the discoveryMiles property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the discoveryMiles property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDiscoveryMiles().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DiscoveryMiles }
     * 
     * 
     */
    public List<DiscoveryMiles> getDiscoveryMiles() {
        if (discoveryMiles == null) {
            discoveryMiles = new ArrayList<DiscoveryMiles>();
        }
        return this.discoveryMiles;
    }

    /**
     * Gets the value of the payPal property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the payPal property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPayPal().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PayPal }
     * 
     * 
     */
    public List<PayPal> getPayPal() {
        if (payPal == null) {
            payPal = new ArrayList<PayPal>();
        }
        return this.payPal;
    }

    /**
     * Gets the value of the debitcard property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the debitcard property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDebitcard().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DebitCard }
     * 
     * 
     */
    public List<DebitCard> getDebitcard() {
        if (debitcard == null) {
            debitcard = new ArrayList<DebitCard>();
        }
        return this.debitcard;
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
     * Gets the value of the wallet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the wallet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWallet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Wallet }
     * 
     * 
     */
    public List<Wallet> getWallet() {
        if (wallet == null) {
            wallet = new ArrayList<Wallet>();
        }
        return this.wallet;
    }

    /**
     * Gets the value of the thirdParty property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the thirdParty property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getThirdParty().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ThirdParty }
     * 
     * 
     */
    public List<ThirdParty> getThirdParty() {
        if (thirdParty == null) {
            thirdParty = new ArrayList<ThirdParty>();
        }
        return this.thirdParty;
    }

    /**
     * Gets the value of the ebucks property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ebucks property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEbucks().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Ebucks }
     * 
     * 
     */
    public List<Ebucks> getEbucks() {
        if (ebucks == null) {
            ebucks = new ArrayList<Ebucks>();
        }
        return this.ebucks;
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
     * Gets the value of the credit property.
     * 
     * @return
     *     possible object is
     *     {@link Credit }
     *     
     */
    public Credit getCredit() {
        return credit;
    }

    /**
     * Sets the value of the credit property.
     * 
     * @param value
     *     allowed object is
     *     {@link Credit }
     *     
     */
    public void setCredit(Credit value) {
        this.credit = value;
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
     * Gets the value of the sbux property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sbux property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSbux().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Sbux }
     * 
     * 
     */
    public List<Sbux> getSbux() {
        if (sbux == null) {
            sbux = new ArrayList<Sbux>();
        }
        return this.sbux;
    }

    /**
     * Gets the value of the rcs property.
     * 
     * @return
     *     possible object is
     *     {@link Rcs }
     *     
     */
    public Rcs getRCS() {
        return rcs;
    }

    /**
     * Sets the value of the rcs property.
     * 
     * @param value
     *     allowed object is
     *     {@link Rcs }
     *     
     */
    public void setRCS(Rcs value) {
        this.rcs = value;
    }

    /**
     * Gets the value of the bankAccount property.
     * 
     * @return
     *     possible object is
     *     {@link BankAccount }
     *     
     */
    public BankAccount getBankAccount() {
        return bankAccount;
    }

    /**
     * Sets the value of the bankAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BankAccount }
     *     
     */
    public void setBankAccount(BankAccount value) {
        this.bankAccount = value;
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
