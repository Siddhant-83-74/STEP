class LoyaltyEngine
{
    public static void main(String args[])
    {
        double total_cart_value=10000;
        int membership_years=20;
        int items_count=0;
        boolean has_coupon=true;
        boolean is_weekend=false;
        String purchase_history="High";
        double dis=0.0;
        boolean is_freeShip=false;
        if(total_cart_value>10000 && membership_years>5)
            {dis=0.2;
            System.out.println("VIP ELite");
            }
       else{
        
        if(has_coupon&&purchase_history=="High")
            System.out.println("Coupon 12%");
        else if(items_count>8 || is_weekend)
           System.out.println("Free Ship + 10%");
        if(total_cart_value>5000 && membership_years>=2)
            System.out.println("Premium Bundle");
        }
    }
}