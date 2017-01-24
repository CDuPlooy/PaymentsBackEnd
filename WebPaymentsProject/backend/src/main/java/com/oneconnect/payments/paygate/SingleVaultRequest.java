
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
 *           &lt;element name="CardVaultRequest" type="{http://www.paygate.co.za/PayHOST}CardVaultRequestType"/>
 *           &lt;element name="WalletVaultRequest" type="{http://www.paygate.co.za/PayHOST}WalletVaultRequestType"/>
 *           &lt;element name="LookUpVaultRequest" type="{http://www.paygate.co.za/PayHOST}LookUpVaultRequestType"/>
 *           &lt;element name="DeleteVaultRequest" type="{http://www.paygate.co.za/PayHOST}DeleteVaultRequestType"/>
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
    "cardVaultRequest",
    "walletVaultRequest",
    "lookUpVaultRequest",
    "deleteVaultRequest"
})
@XmlRootElement(name = "SingleVaultRequest")
public class SingleVaultRequest {

    @XmlElement(name = "CardVaultRequest")
    protected CardVaultRequestType cardVaultRequest;
    @XmlElement(name = "WalletVaultRequest")
    protected WalletVaultRequestType walletVaultRequest;
    @XmlElement(name = "LookUpVaultRequest")
    protected LookUpVaultRequestType lookUpVaultRequest;
    @XmlElement(name = "DeleteVaultRequest")
    protected DeleteVaultRequestType deleteVaultRequest;

    /**
     * Gets the value of the cardVaultRequest property.
     * 
     * @return
     *     possible object is
     *     {@link CardVaultRequestType }
     *     
     */
    public CardVaultRequestType getCardVaultRequest() {
        return cardVaultRequest;
    }

    /**
     * Sets the value of the cardVaultRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link CardVaultRequestType }
     *     
     */
    public void setCardVaultRequest(CardVaultRequestType value) {
        this.cardVaultRequest = value;
    }

    /**
     * Gets the value of the walletVaultRequest property.
     * 
     * @return
     *     possible object is
     *     {@link WalletVaultRequestType }
     *     
     */
    public WalletVaultRequestType getWalletVaultRequest() {
        return walletVaultRequest;
    }

    /**
     * Sets the value of the walletVaultRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link WalletVaultRequestType }
     *     
     */
    public void setWalletVaultRequest(WalletVaultRequestType value) {
        this.walletVaultRequest = value;
    }

    /**
     * Gets the value of the lookUpVaultRequest property.
     * 
     * @return
     *     possible object is
     *     {@link LookUpVaultRequestType }
     *     
     */
    public LookUpVaultRequestType getLookUpVaultRequest() {
        return lookUpVaultRequest;
    }

    /**
     * Sets the value of the lookUpVaultRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link LookUpVaultRequestType }
     *     
     */
    public void setLookUpVaultRequest(LookUpVaultRequestType value) {
        this.lookUpVaultRequest = value;
    }

    /**
     * Gets the value of the deleteVaultRequest property.
     * 
     * @return
     *     possible object is
     *     {@link DeleteVaultRequestType }
     *     
     */
    public DeleteVaultRequestType getDeleteVaultRequest() {
        return deleteVaultRequest;
    }

    /**
     * Sets the value of the deleteVaultRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link DeleteVaultRequestType }
     *     
     */
    public void setDeleteVaultRequest(DeleteVaultRequestType value) {
        this.deleteVaultRequest = value;
    }

}
