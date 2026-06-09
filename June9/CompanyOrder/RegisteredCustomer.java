package CompanyOrder;


public class RegisteredCustomer extends Customer
{
    double discountRate;
    public RegisteredCustomer(String name,String id,double discountRate)
    {
        super(name,id);
        this.discountRate=discountRate;
    }

    public double getDiscountRate(){
        return this.discountRate;
    }
    public void setDiscountRate(double discountRate)
    {
        this.discountRate=discountRate;
    }
}