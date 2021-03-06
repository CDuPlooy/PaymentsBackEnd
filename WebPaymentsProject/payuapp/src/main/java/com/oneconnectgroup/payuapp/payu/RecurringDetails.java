
package com.oneconnectgroup.payuapp.payu;

public class RecurringDetails
    extends PayUMapLoader
{

    protected String deductionDay;
    protected String frequency;
    protected String recurrences;
    protected String recurringPaymentToken;
    protected String statementDescription;

    /**
     * Gets the value of the deductionDay property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeductionDay() {
        return deductionDay;
    }

    /**
     * Sets the value of the deductionDay property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeductionDay(String value) {
        this.deductionDay = value;
    }

    /**
     * Gets the value of the frequency property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFrequency() {
        return frequency;
    }

    /**
     * Sets the value of the frequency property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFrequency(String value) {
        this.frequency = value;
    }

    /**
     * Gets the value of the recurrences property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecurrences() {
        return recurrences;
    }

    /**
     * Sets the value of the recurrences property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecurrences(String value) {
        this.recurrences = value;
    }

    /**
     * Gets the value of the recurringPaymentToken property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecurringPaymentToken() {
        return recurringPaymentToken;
    }

    /**
     * Sets the value of the recurringPaymentToken property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecurringPaymentToken(String value) {
        this.recurringPaymentToken = value;
    }

    /**
     * Gets the value of the statementDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatementDescription() {
        return statementDescription;
    }

    /**
     * Sets the value of the statementDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatementDescription(String value) {
        this.statementDescription = value;
    }

}
