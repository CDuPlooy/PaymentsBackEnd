
package com.oneconnectgroup.payuapp.payu;

public class Sva
    extends IPaymentMethod
{

    protected String amountInCents;
    protected String availableBalance;
    protected String loayltyBalance;
    protected String loyaltyAmountInCents;
    protected String reservedBalance;
    protected String sufficientFunds;
    protected String type;
    protected WalletBalance walletBalance;

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
     * Gets the value of the availableBalance property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAvailableBalance() {
        return availableBalance;
    }

    /**
     * Sets the value of the availableBalance property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAvailableBalance(String value) {
        this.availableBalance = value;
    }

    /**
     * Gets the value of the loayltyBalance property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLoayltyBalance() {
        return loayltyBalance;
    }

    /**
     * Sets the value of the loayltyBalance property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLoayltyBalance(String value) {
        this.loayltyBalance = value;
    }

    /**
     * Gets the value of the loyaltyAmountInCents property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLoyaltyAmountInCents() {
        return loyaltyAmountInCents;
    }

    /**
     * Sets the value of the loyaltyAmountInCents property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLoyaltyAmountInCents(String value) {
        this.loyaltyAmountInCents = value;
    }

    /**
     * Gets the value of the reservedBalance property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReservedBalance() {
        return reservedBalance;
    }

    /**
     * Sets the value of the reservedBalance property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReservedBalance(String value) {
        this.reservedBalance = value;
    }

    /**
     * Gets the value of the sufficientFunds property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSufficientFunds() {
        return sufficientFunds;
    }

    /**
     * Sets the value of the sufficientFunds property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSufficientFunds(String value) {
        this.sufficientFunds = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the walletBalance property.
     * 
     * @return
     *     possible object is
     *     {@link WalletBalance }
     *     
     */
    public WalletBalance getWalletBalance() {
        return walletBalance;
    }

    /**
     * Sets the value of the walletBalance property.
     * 
     * @param value
     *     allowed object is
     *     {@link WalletBalance }
     *     
     */
    public void setWalletBalance(WalletBalance value) {
        this.walletBalance = value;
    }

}
