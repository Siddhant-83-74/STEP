public class InvoiceCalExt
{
    String productName;
    int qty;
    int unitPrice;
    float taxRate;
    float disRate;
    float totalAmt;
    static final char currencySym='₹';

    InvoiceCalExt(String productName,int qty,int unitPrice,float taxRate,float disRate)
    {
        this.productName=productName;
        this.qty=qty;
        this.unitPrice=unitPrice;
        this.taxRate=taxRate;
        this.disRate=disRate;
    }
    void calAmt()
    {
        
        float afterDisAmount=(this.qty*this.unitPrice)-(this.qty*this.unitPrice*this.disRate);
        afterDisAmount=Math.round(afterDisAmount);
        this.totalAmt=afterDisAmount+afterDisAmount*this.taxRate;
    }

    void printData()
    {
        System.out.println("Product: "+this.productName+"\nUnit Price: "+this.unitPrice+"\nTotal Amount after tax: "+this.totalAmt);
        System.out.println();
    }
    public static void main(String args[])
    {
        InvoiceCalExt S24=new InvoiceCalExt("Samsung Galaxy S24",50,55000,0.18f,0.256f);
        InvoiceCalExt S25=new InvoiceCalExt("Samsung Galaxy S25",50,80000,0.18f,0.1f);

        S24.calAmt();
        S25.calAmt();

        S24.printData();
        S25.printData();
    }
}