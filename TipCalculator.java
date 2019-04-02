public class TipCalculator
{
    // Data members
    private double billAmount = 0;
    private int tipPercentage = 20;
    private double partySize= 1;

    // Setters and getters
    public void setBillAmount(double billAmount)
    {
        this.billAmount = billAmount;
    }

    public double getBillAmount()
    {
        return this.billAmount;
    }

    public void setTipPercentage(int tipPercentage)
    {
        this.tipPercentage = tipPercentage;
    }

    public int getTipPercentage()
    {
        return this.tipPercentage;
    }

    public void setPartySize(double partySize)
    {
        this.partySize= partySize;
    }

    public double getPartySize()
    {
        return this.partySize;
    }

    // Fancy methods
    public double getTotalBill()
    {
        return this.billAmount * this.tipPercentage + this.billAmount;
    }

    public double getIndividualShare()
    {
        return this.getTotalBill() / this.getPartySize();
    }

}
