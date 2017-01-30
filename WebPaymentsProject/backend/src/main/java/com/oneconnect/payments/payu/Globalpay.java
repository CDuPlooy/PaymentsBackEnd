
package com.oneconnect.payments.payu;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for globalpay complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="globalpay">
 *   &lt;complexContent>
 *     &lt;extension base="{http://soap.api.controller.web.payjar.com/}iPaymentMethod">
 *       &lt;sequence>
 *         &lt;element name="amountInCents" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="basketAmountInCents" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="basketCurrency" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="basketDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="customerContactNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="customerEmail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="customerFirstName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="customerId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="customerLastName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="customerTrxRef" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mcaCustomerCareGetProductsResultCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mcaCustomerCareGetProductsResultMsg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mcaLoggerUpdateResultCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mcaLoggerUpdateResultMsg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mcaRtppPaymentResultCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mcaRtppPaymentResultMsg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="paymentChannel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="payuMerchantId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="transactionDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="transactionReference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="transactionStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="transactionStatusDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="transactionType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "globalpay", propOrder = {
    "amountInCents",
    "basketAmountInCents",
    "basketCurrency",
    "basketDescription",
    "customerContactNumber",
    "customerEmail",
    "customerFirstName",
    "customerId",
    "customerLastName",
    "customerTrxRef",
    "mcaCustomerCareGetProductsResultCode",
    "mcaCustomerCareGetProductsResultMsg",
    "mcaLoggerUpdateResultCode",
    "mcaLoggerUpdateResultMsg",
    "mcaRtppPaymentResultCode",
    "mcaRtppPaymentResultMsg",
    "paymentChannel",
    "payuMerchantId",
    "transactionDate",
    "transactionReference",
    "transactionStatus",
    "transactionStatusDescription",
    "transactionType"
})
public class Globalpay
    extends IPaymentMethod
{

    protected String amountInCents;
    protected String basketAmountInCents;
    protected String basketCurrency;
    protected String basketDescription;
    protected String customerContactNumber;
    protected String customerEmail;
    protected String customerFirstName;
    protected String customerId;
    protected String customerLastName;
    protected String customerTrxRef;
    protected String mcaCustomerCareGetProductsResultCode;
    protected String mcaCustomerCareGetProductsResultMsg;
    protected String mcaLoggerUpdateResultCode;
    protected String mcaLoggerUpdateResultMsg;
    protected String mcaRtppPaymentResultCode;
    protected String mcaRtppPaymentResultMsg;
    protected String paymentChannel;
    protected String payuMerchantId;
    protected String transactionDate;
    protected String transactionReference;
    protected String transactionStatus;
    protected String transactionStatusDescription;
    protected String transactionType;

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
     * Gets the value of the basketAmountInCents property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBasketAmountInCents() {
        return basketAmountInCents;
    }

    /**
     * Sets the value of the basketAmountInCents property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBasketAmountInCents(String value) {
        this.basketAmountInCents = value;
    }

    /**
     * Gets the value of the basketCurrency property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBasketCurrency() {
        return basketCurrency;
    }

    /**
     * Sets the value of the basketCurrency property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBasketCurrency(String value) {
        this.basketCurrency = value;
    }

    /**
     * Gets the value of the basketDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBasketDescription() {
        return basketDescription;
    }

    /**
     * Sets the value of the basketDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBasketDescription(String value) {
        this.basketDescription = value;
    }

    /**
     * Gets the value of the customerContactNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerContactNumber() {
        return customerContactNumber;
    }

    /**
     * Sets the value of the customerContactNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerContactNumber(String value) {
        this.customerContactNumber = value;
    }

    /**
     * Gets the value of the customerEmail property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerEmail() {
        return customerEmail;
    }

    /**
     * Sets the value of the customerEmail property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerEmail(String value) {
        this.customerEmail = value;
    }

    /**
     * Gets the value of the customerFirstName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerFirstName() {
        return customerFirstName;
    }

    /**
     * Sets the value of the customerFirstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerFirstName(String value) {
        this.customerFirstName = value;
    }

    /**
     * Gets the value of the customerId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * Sets the value of the customerId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerId(String value) {
        this.customerId = value;
    }

    /**
     * Gets the value of the customerLastName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerLastName() {
        return customerLastName;
    }

    /**
     * Sets the value of the customerLastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerLastName(String value) {
        this.customerLastName = value;
    }

    /**
     * Gets the value of the customerTrxRef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerTrxRef() {
        return customerTrxRef;
    }

    /**
     * Sets the value of the customerTrxRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerTrxRef(String value) {
        this.customerTrxRef = value;
    }

    /**
     * Gets the value of the mcaCustomerCareGetProductsResultCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMcaCustomerCareGetProductsResultCode() {
        return mcaCustomerCareGetProductsResultCode;
    }

    /**
     * Sets the value of the mcaCustomerCareGetProductsResultCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMcaCustomerCareGetProductsResultCode(String value) {
        this.mcaCustomerCareGetProductsResultCode = value;
    }

    /**
     * Gets the value of the mcaCustomerCareGetProductsResultMsg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMcaCustomerCareGetProductsResultMsg() {
        return mcaCustomerCareGetProductsResultMsg;
    }

    /**
     * Sets the value of the mcaCustomerCareGetProductsResultMsg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMcaCustomerCareGetProductsResultMsg(String value) {
        this.mcaCustomerCareGetProductsResultMsg = value;
    }

    /**
     * Gets the value of the mcaLoggerUpdateResultCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMcaLoggerUpdateResultCode() {
        return mcaLoggerUpdateResultCode;
    }

    /**
     * Sets the value of the mcaLoggerUpdateResultCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMcaLoggerUpdateResultCode(String value) {
        this.mcaLoggerUpdateResultCode = value;
    }

    /**
     * Gets the value of the mcaLoggerUpdateResultMsg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMcaLoggerUpdateResultMsg() {
        return mcaLoggerUpdateResultMsg;
    }

    /**
     * Sets the value of the mcaLoggerUpdateResultMsg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMcaLoggerUpdateResultMsg(String value) {
        this.mcaLoggerUpdateResultMsg = value;
    }

    /**
     * Gets the value of the mcaRtppPaymentResultCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMcaRtppPaymentResultCode() {
        return mcaRtppPaymentResultCode;
    }

    /**
     * Sets the value of the mcaRtppPaymentResultCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMcaRtppPaymentResultCode(String value) {
        this.mcaRtppPaymentResultCode = value;
    }

    /**
     * Gets the value of the mcaRtppPaymentResultMsg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMcaRtppPaymentResultMsg() {
        return mcaRtppPaymentResultMsg;
    }

    /**
     * Sets the value of the mcaRtppPaymentResultMsg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMcaRtppPaymentResultMsg(String value) {
        this.mcaRtppPaymentResultMsg = value;
    }

    /**
     * Gets the value of the paymentChannel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentChannel() {
        return paymentChannel;
    }

    /**
     * Sets the value of the paymentChannel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentChannel(String value) {
        this.paymentChannel = value;
    }

    /**
     * Gets the value of the payuMerchantId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPayuMerchantId() {
        return payuMerchantId;
    }

    /**
     * Sets the value of the payuMerchantId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPayuMerchantId(String value) {
        this.payuMerchantId = value;
    }

    /**
     * Gets the value of the transactionDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransactionDate() {
        return transactionDate;
    }

    /**
     * Sets the value of the transactionDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransactionDate(String value) {
        this.transactionDate = value;
    }

    /**
     * Gets the value of the transactionReference property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransactionReference() {
        return transactionReference;
    }

    /**
     * Sets the value of the transactionReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransactionReference(String value) {
        this.transactionReference = value;
    }

    /**
     * Gets the value of the transactionStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransactionStatus() {
        return transactionStatus;
    }

    /**
     * Sets the value of the transactionStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransactionStatus(String value) {
        this.transactionStatus = value;
    }

    /**
     * Gets the value of the transactionStatusDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransactionStatusDescription() {
        return transactionStatusDescription;
    }

    /**
     * Sets the value of the transactionStatusDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransactionStatusDescription(String value) {
        this.transactionStatusDescription = value;
    }

    /**
     * Gets the value of the transactionType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransactionType() {
        return transactionType;
    }

    /**
     * Sets the value of the transactionType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransactionType(String value) {
        this.transactionType = value;
    }

}
