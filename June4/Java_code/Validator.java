public class Validator
{
    public static void main(String args[])
    {
        double cart_total=0.0;
        int customer_risk_score=0;
        String payment_method="EMI";
        String time="";
        int items=0;
        if(payment_method=="EMI")
        {
            if(customer_risk_score<40)
                System.out.println("Approval needed manually");
            else if(cart_total<8000)
                System.out.println("Rejected");
            else
                System.out.println("Eligible");

        }

        else if(payment_method=="CARD")
        {
            int hour=Integer.parseInt(time.substring(0,2));
            // int min=Integer.parseInt(time.substring(3));
            if(hour<6)
            {
                if(customer_risk_score>40)
                    System.out.println("Rejected");
                else
                    System.out.println("Accepted");
            }
            else
            {
                if(items>2&&cart_total>2000 )
                    System.out.println("Manually review");
                else
                    System.out.println("Approved");
            }

        }


    }
}