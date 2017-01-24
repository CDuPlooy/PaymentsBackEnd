
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
 *           &lt;element name="CardVaultResponse" type="{http://www.paygate.co.za/PayHOST}CardVaultResponseType"/>
 *           &lt;element name="WalletVaultResponse" type="{http://www.paygate.co.za/PayHOST}WalletVaultResponseType"/>
 *           &lt;element name="LookUpVaultResponse" type="{http://www.paygate.co.za/PayHOST}LookUpVaultResponseType"/>
 *           &lt;element name="DeleteVaultResponse" type="{http://www.paygate.co.za/PayHOST}DeleteVaultResponseType"/>
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
    "cardVaultResponse",
    "walletVaultResponse",
    "lookUpVaultResponse",
    "deleteVaultResponse"
})
@XmlRootElement(name = "SingleVaultResponse")
public class SingleVaultResponse {

    @XmlElement(name = "CardVaultResponse")
    protected CardVaultResponseType cardVaultResponse;
    @XmlElement(name = "WalletVaultResponse")
    protected WalletVaultResponseType walletVaultResponse;
    @XmlElement(name = "LookUpVaultResponse")
    protected LookUpVaultResponseType lookUpVaultResponse;
    @XmlElement(name = "DeleteVaultResponse")
    protected DeleteVaultResponseType deleteVaultResponse;

    /**
     * Gets the value of the cardVaultResponse property.
     * 
     * @return
     *     possible object is
     *     {@link CardVaultResponseType }
     *     
     */
    public CardVaultResponseType getCardVaultResponse() {
        return cardVaultResponse;
    }

    /**
     * Sets the value of the cardVaultResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link CardVaultResponseType }
     *     
     */
    public void setCardVaultResponse(CardVaultResponseType value) {
        this.cardVaultResponse = value;
    }

    /**
     * Gets the value of the walletVaultResponse property.
     * 
     * @return
     *     possible object is
     *     {@link WalletVaultResponseType }
     *     
     */
    public WalletVaultResponseType getWalletVaultResponse() {
        return walletVaultResponse;
    }

    /**
     * Sets the value of the walletVaultResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link WalletVaultResponseType }
     *     
     */
    public void setWalletVaultResponse(WalletVaultResponseType value) {
        this.walletVaultResponse = value;
    }

    /**
     * Gets the value of the lookUpVaultResponse property.
     * 
     * @return
     *     possible object is
     *     {@link LookUpVaultResponseType }
     *     
     */
    public LookUpVaultResponseType getLookUpVaultResponse() {
        return lookUpVaultResponse;
    }

    /**
     * Sets the value of the lookUpVaultResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link LookUpVaultResponseType }
     *     
     */
    public void setLookUpVaultResponse(LookUpVaultResponseType value) {
        this.lookUpVaultResponse = value;
    }

    /**
     * Gets the value of the deleteVaultResponse property.
     * 
     * @return
     *     possible object is
     *     {@link DeleteVaultResponseType }
     *     
     */
    public DeleteVaultResponseType getDeleteVaultResponse() {
        return deleteVaultResponse;
    }

    /**
     * Sets the value of the deleteVaultResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link DeleteVaultResponseType }
     *     
     */
    public void setDeleteVaultResponse(DeleteVaultResponseType value) {
        this.deleteVaultResponse = value;
    }

}
