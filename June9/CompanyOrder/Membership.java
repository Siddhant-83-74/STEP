package CompanyOrder;

public class Membership
 {

    private double discount;
    private double fees;
    private String membershipType;
    public Membership(String membershipType)
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
    
}
