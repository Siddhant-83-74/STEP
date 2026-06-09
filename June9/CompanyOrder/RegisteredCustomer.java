package CompanyOrder;


public class RegisteredCustomer extends Customer
{
    double discount;
    public RegisteredCustomer(String name,int id,double discount)
    {
        super(name,id);
        this.discount=discount;
    }

    public double getDiscount(){
        return this.discount;
    }
    public void setDiscount(double discount)
    {
        this.discount=discount;
    }
}