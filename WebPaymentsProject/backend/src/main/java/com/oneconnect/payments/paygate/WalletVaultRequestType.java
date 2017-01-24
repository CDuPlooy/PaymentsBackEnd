
package com.oneconnect.payments.paygate;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for WalletVaultRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WalletVaultRequestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Account" type="{http://www.paygate.co.za/PayHOST}PayGateAccountType"/>
 *         &lt;element name="WalletAccount" type="{http://www.w3.org/2001/XMLSchema}token"/>
 *         &lt;element name="WalletPassword" type="{http://www.w3.org/2001/XMLSchema}token" minOccurs="0"/>
 *         &lt;element name="UserDefinedFields" type="{http://www.paygate.co.za/PayHOST}KeyValueType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WalletVaultRequestType", propOrder = {
    "account",
    "walletAccount",
    "walletPassword",
    "userDefinedFields"
})
public class WalletVaultRequestType {

    @XmlElement(name = "Account", required = true)
    protected PayGateAccountType account;
    @XmlElement(name = "WalletAccount", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String walletAccount;
    @XmlElement(name = "WalletPassword")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String walletPassword;
    @XmlElement(name = "UserDefinedFields")
    protected List<KeyValueType> userDefinedFields;

    /**
     * Gets the value of the account property.
     * 
     * @return
     *     possible object is
     *     {@link PayGateAccountType }
     *     
     */
    public PayGateAccountType getAccount() {
        return account;
    }

    /**
     * Sets the value of the account property.
     * 
     * @param value
     *     allowed object is
     *     {@link PayGateAccountType }
     *     
     */
    public void setAccount(PayGateAccountType value) {
        this.account = value;
    }

    /**
     * Gets the value of the walletAccount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWalletAccount() {
        return walletAccount;
    }

    /**
     * Sets the value of the walletAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWalletAccount(String value) {
        this.walletAccount = value;
    }

    /**
     * Gets the value of the walletPassword property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWalletPassword() {
        return walletPassword;
    }

    /**
     * Sets the value of the walletPassword property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWalletPassword(String value) {
        this.walletPassword = value;
    }

    /**
     * Gets the value of the userDefinedFields property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the userDefinedFields property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUserDefinedFields().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link KeyValueType }
     * 
     * 
     */
    public List<KeyValueType> getUserDefinedFields() {
        if (userDefinedFields == null) {
            userDefinedFields = new ArrayList<KeyValueType>();
        }
        return this.userDefinedFields;
    }

}
