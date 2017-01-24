
package com.oneconnect.payments.paygate;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element name="CardPayoutRequest" type="{http://www.paygate.co.za/PayHOST}CardPayoutRequestType"/>
 *           &lt;element name="BankPayoutRequest" type="{http://www.paygate.co.za/PayHOST}BankPayoutRequestType"/>
 *           &lt;element name="WalletPayoutRequest" type="{http://www.paygate.co.za/PayHOST}WalletPayoutRequestType"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "cardPayoutRequest",
    "bankPayoutRequest",
    "walletPayoutRequest"
})
@XmlRootElement(name = "SinglePayoutRequest")
public class SinglePayoutRequest {

    @XmlElement(name = "CardPayoutRequest")
    protected CardPayoutRequestType cardPayoutRequest;
    @XmlElement(name = "BankPayoutRequest")
    protected BankPayoutRequestType bankPayoutRequest;
    @XmlElement(name = "WalletPayoutRequest")
    protected WalletPayoutRequestType walletPayoutRequest;

    /**
     * Gets the value of the cardPayoutRequest property.
     * 
     * @return
     *     possible object is
     *     {@link CardPayoutRequestType }
     *     
     */
    public CardPayoutRequestType getCardPayoutRequest() {
        return cardPayoutRequest;
    }

    /**
     * Sets the value of the cardPayoutRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link CardPayoutRequestType }
     *     
     */
    public void setCardPayoutRequest(CardPayoutRequestType value) {
        this.cardPayoutRequest = value;
    }

    /**
     * Gets the value of the bankPayoutRequest property.
     * 
     * @return
     *     possible object is
     *     {@link BankPayoutRequestType }
     *     
     */
    public BankPayoutRequestType getBankPayoutRequest() {
        return bankPayoutRequest;
    }

    /**
     * Sets the value of the bankPayoutRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link BankPayoutRequestType }
     *     
     */
    public void setBankPayoutRequest(BankPayoutRequestType value) {
        this.bankPayoutRequest = value;
    }

    /**
     * Gets the value of the walletPayoutRequest property.
     * 
     * @return
     *     possible object is
     *     {@link WalletPayoutRequestType }
     *     
     */
    public WalletPayoutRequestType getWalletPayoutRequest() {
        return walletPayoutRequest;
    }

    /**
     * Sets the value of the walletPayoutRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link WalletPayoutRequestType }
     *     
     */
    public void setWalletPayoutRequest(WalletPayoutRequestType value) {
        this.walletPayoutRequest = value;
    }

}
