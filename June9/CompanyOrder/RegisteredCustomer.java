package CompanyOrder;


public class RegisteredCustomer extends Customer
{

    private Membership membership;

    public Membership getMembership()
    {
        return this.membership;
    }
    public void setMembership(Membership membership)
    {
        this.membership=membership;
    }
    private double discount;
    private double fees;
    private String membershipType;
    public RegisteredCustomer(String name,int id)
    {
        super(name,id);
    }

    public double getDiscount(){
        return this.discount;
    }

    public void setDiscount(double discount)
    {
        this.discount=discount;
    }

    public double getFees()
    {
        return this.fees;
    }

    public void setFees(double fees)
    {
        this.fees=fees;
    }

    public String getMembershipType()
    {
        return this.membershipType;
    }
    public void setMembershipType(String membershipType)
    {
        this.membershipType=membershipType;
        if(membershipType.equalsIgnoreCase("platinum"))
        {
            this.fees=20000.0;
            this.discount=20.0;
        }
        if(membershipType.equalsIgnoreCase("gold"))
        {
            this.fees=10000.0;
            this.discount=10.0;
        }
        if(membershipType.equalsIgnoreCase("silver"))
        {
            this.fees=5000.0;
            this.discount=5.0;
        }
    }

    @Override
        public double getTotalOrderValueV2(){
        double totalOrderValue = 0.0;
       
        //No if else and any type of customer and still the logic will worl seamlessly without a change in this code
        //Satisfies OCP - Open Closed Principle
        for(Order order: this.getOrder()){
            totalOrderValue += order.getTotalOrderValue()*(1-this.membership.getDiscount()/100);
        }
        
        return totalOrderValue;
    }
}