
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
 *           &lt;element name="CardPaymentRequest" type="{http://www.paygate.co.za/PayHOST}CardPaymentRequestType"/>
 *           &lt;element name="WebPaymentRequest" type="{http://www.paygate.co.za/PayHOST}WebPaymentRequestType"/>
 *           &lt;element name="TokenPaymentRequest" type="{http://www.paygate.co.za/PayHOST}TokenPaymentRequestType"/>
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
    "cardPaymentRequest",
    "webPaymentRequest",
    "tokenPaymentRequest"
})
@XmlRootElement(name = "SinglePaymentRequest")
public class SinglePaymentRequest {

    @XmlElement(name = "CardPaymentRequest")
    protected CardPaymentRequestType cardPaymentRequest;
    @XmlElement(name = "WebPaymentRequest")
    protected WebPaymentRequestType webPaymentRequest;
    @XmlElement(name = "TokenPaymentRequest")
    protected TokenPaymentRequestType tokenPaymentRequest;

    /**
     * Gets the value of the cardPaymentRequest property.
     * 
     * @return
     *     possible object is
     *     {@link CardPaymentRequestType }
     *     
     */
    public CardPaymentRequestType getCardPaymentRequest() {
        return cardPaymentRequest;
    }

    /**
     * Sets the value of the cardPaymentRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link CardPaymentRequestType }
     *     
     */
    public void setCardPaymentRequest(CardPaymentRequestType value) {
        this.cardPaymentRequest = value;
    }

    /**
     * Gets the value of the webPaymentRequest property.
     * 
     * @return
     *     possible object is
     *     {@link WebPaymentRequestType }
     *     
     */
    public WebPaymentRequestType getWebPaymentRequest() {
        return webPaymentRequest;
    }

    /**
     * Sets the value of the webPaymentRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link WebPaymentRequestType }
     *     
     */
    public void setWebPaymentRequest(WebPaymentRequestType value) {
        this.webPaymentRequest = value;
    }

    /**
     * Gets the value of the tokenPaymentRequest property.
     * 
     * @return
     *     possible object is
     *     {@link TokenPaymentRequestType }
     *     
     */
    public TokenPaymentRequestType getTokenPaymentRequest() {
        return tokenPaymentRequest;
    }

    /**
     * Sets the value of the tokenPaymentRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link TokenPaymentRequestType }
     *     
     */
    public void setTokenPaymentRequest(TokenPaymentRequestType value) {
        this.tokenPaymentRequest = value;
    }

}
