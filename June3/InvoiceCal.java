public class InvoiceCal
{
    public static void main(String args[])
    {
        String productName="Samsung galaxy S24";
        int quantity=50;
        int unitPrice=55000;

        double taxRate=0.18;
        double disRate=0.10;


        double subtotal=quantity*unitPrice;
        double discountAmt=subtotal*disRate;
        double afterDis=subtotal-discountAmt;
        double taxAmt=afterDis*taxRate;
        double totalAmount=afterDis+taxAmt;

        System.out.println("Product: "+productName+"\nUnit Price: "+unitPrice+"\nTotal Amount after tax: "+totalAmount);
    }
}