package CompanyOrder;

//Factory class is introduced to create different types of membership.
public class MembershipFactory {
    public Membership getMembership(String membershipType)
    {
         if(membershipType.equalsIgnoreCase("platinum"))
        {
            var membership=new Membership("platinum");
            membership.setFees(20000.0);
            membership.setDiscount(20.0);
            return membership;
        }
        else if(membershipType.equalsIgnoreCase("gold"))
        {
            
            var membership=new Membership(
                "gold");
            membership.setFees(10000.0);
            membership.setDiscount(10.0);
            return membership;
        }
        else if(membershipType.equalsIgnoreCase("silver"))
        {
            
            var membership=new Membership("silver");
            membership.setFees(5000.0);
            membership.setDiscount(5.0);
            return membership;
        }

        return null;
    }
    
}
