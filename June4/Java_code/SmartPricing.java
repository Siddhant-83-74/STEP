public class SmartPricing
{
    String productCat;
    double basePrice;
    int quantity;
    String customerType;
    double totalFinalPrice;
    SmartPricing(String productCat, int basePrice,int quantity,String customerType)
    {
        this.productCat=productCat;
        this.basePrice=basePrice;
        this.quantity=quantity;
        this.customerType=customerType;
    }

    double priceAfterDiscount()
    {
        double disRate=0;
        
        disRate=(this.customerType=="Premium")?0.08:
                (this.customerType=="VIP")?0.15:0.0;

        if(this.quantity>10)
            disRate+=0.05;

        disRate=(disRate>0.4)?0.4:disRate;
        double priceAfterDis=this.basePrice*(1.0-disRate);
        
        return priceAfterDis;

    }

    double priceAfterTax()
    {
        double priceAfterDis=this.priceAfterDiscount();

    
        double taxRate=(this.productCat=="Electronics")?0.18:
                       (this.productCat=="Apparel")?0.12:
                       (this.productCat=="Grocery")?0.05:
                       (this.productCat=="Beauty")?0.15:0.0;
        
        double priceAfterT=priceAfterDis*(1.0-taxRate);
        return priceAfterT;

    }

    void totalPrice()
    {
        double priceAfterT=this.priceAfterTax();
        this.totalFinalPrice=priceAfterT*this.quantity;
        
    }

    void printData()
    {
        System.out.println("Total Final Price: "+this.totalFinalPrice);
    }


    public static void main(String args[])
    {
        SmartPricing obj=new SmartPricing("Electronics",15000,15,"VIP");
        obj.totalPrice();
        obj.printData();
    }
}