
package com.oneconnect.payments.paygate;

import java.util.ArrayList;
import java.util.List;
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
 *           &lt;element name="QueryResponse" type="{http://www.paygate.co.za/PayHOST}QueryResponseType" maxOccurs="unbounded"/>
 *           &lt;element name="SettlementResponse" type="{http://www.paygate.co.za/PayHOST}SettleResponseType"/>
 *           &lt;element name="RefundResponse" type="{http://www.paygate.co.za/PayHOST}RefundResponseType"/>
 *           &lt;element name="VoidResponse" type="{http://www.paygate.co.za/PayHOST}VoidResponseType"/>
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
    "queryResponse",
    "settlementResponse",
    "refundResponse",
    "voidResponse"
})
@XmlRootElement(name = "SingleFollowUpResponse")
public class SingleFollowUpResponse {

    @XmlElement(name = "QueryResponse")
    protected List<QueryResponseType> queryResponse;
    @XmlElement(name = "SettlementResponse")
    protected SettleResponseType settlementResponse;
    @XmlElement(name = "RefundResponse")
    protected RefundResponseType refundResponse;
    @XmlElement(name = "VoidResponse")
    protected VoidResponseType voidResponse;

    /**
     * Gets the value of the queryResponse property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the queryResponse property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getQueryResponse().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link QueryResponseType }
     * 
     * 
     */
    public List<QueryResponseType> getQueryResponse() {
        if (queryResponse == null) {
            queryResponse = new ArrayList<QueryResponseType>();
        }
        return this.queryResponse;
    }

    /**
     * Gets the value of the settlementResponse property.
     * 
     * @return
     *     possible object is
     *     {@link SettleResponseType }
     *     
     */
    public SettleResponseType getSettlementResponse() {
        return settlementResponse;
    }

    /**
     * Sets the value of the settlementResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link SettleResponseType }
     *     
     */
    public void setSettlementResponse(SettleResponseType value) {
        this.settlementResponse = value;
    }

    /**
     * Gets the value of the refundResponse property.
     * 
     * @return
     *     possible object is
     *     {@link RefundResponseType }
     *     
     */
    public RefundResponseType getRefundResponse() {
        return refundResponse;
    }

    /**
     * Sets the value of the refundResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link RefundResponseType }
     *     
     */
    public void setRefundResponse(RefundResponseType value) {
        this.refundResponse = value;
    }

    /**
     * Gets the value of the voidResponse property.
     * 
     * @return
     *     possible object is
     *     {@link VoidResponseType }
     *     
     */
    public VoidResponseType getVoidResponse() {
        return voidResponse;
    }

    /**
     * Sets the value of the voidResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link VoidResponseType }
     *     
     */
    public void setVoidResponse(VoidResponseType value) {
        this.voidResponse = value;
    }

}
