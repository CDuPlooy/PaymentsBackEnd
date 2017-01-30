
package com.oneconnect.payments.payu;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PayUMapLoader complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PayUMapLoader">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PayUMapLoader", namespace = "https://www.payu.co.za/PayUMapLoader")
@XmlSeeAlso({
    ManagePaymentMethodResponseMessage.class,
    DeleteTransactionResponseMessage.class,
    Basket.class,
    WalletBalance.class,
    Balance.class,
    AdditionalInfo.class,
    Credit.class,
    CustomField.class,
    TransactionRecord.class,
    Redirect.class,
    RecurringDetails.class,
    IPaymentMethod.class,
    Customer.class,
    LookupTransactionResponseMessage.class,
    GetTransactionResponseMessage.class,
    DoTransactionResponseMessage.class,
    SetTransactionResponseMessage.class
})
public abstract class PayUMapLoader {


}
