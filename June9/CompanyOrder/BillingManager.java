package CompanyOrder;

public class BillingManager {
    
    //Method to generate bill from the order information
    //Orchestrator method- doesn't applies logic of its own, but calls other methods
    //  and gets the logic implemented.
    public void generateBill(Order order)
    {
       // 1. Get the order total
       var orderTotal=getOrderTotal(order);
       //2. Check if there is any discount(by getting customer object from getCustomer from order)
       double discount= getOrderDiscount(order);

       double finalOrderAmount=getFinalOrderAmount(orderTotal,discount);
       //3. Get the gst- logic to calculate GST
       double gstAmount=calculateGST(finalOrderAmount);
       //4. get the cess
       double cssAmount=calculateCess(finalOrderAmount);
       //5. Calculate the final bill amount
       double finalBillAmount=calculateFinalBillAmount(finalOrderAmount,discount,gstAmount,cssAmount);
       //6. Display the final bill
       displayFinalBill(order, discount, gstAmount, cssAmount, finalBillAmount);


    }
    protected double getOrderTotal(Order order)
    {
        double orderTotal=0.0;
        orderTotal=order.getTotalOrderValue();
        return orderTotal;
    }
    protected double getOrderDiscount(Order order){
        double discount=0.0;
        if(order.getCustomer() instanceof RegisteredCustomer)
        {
            var registeredCustomer=(RegisteredCustomer) order.getCustomer();
            discount = registeredCustomer.getDiscount();
        }

        
        return discount;
    }
    protected double getFinalOrderAmount(double orderTotal, double discount){
        
        double finalOrderAmount=0.0;
        finalOrderAmount=orderTotal*(1.0-discount/100);

        
        return finalOrderAmount;
    }

    protected double calculateGST(double finalOrderAmount){
        double gstAmount=0.0;
        //ideally we have different slabs for GST but for this cs we will assume 18%
        //
        if(finalOrderAmount>0 && finalOrderAmount<=1000)
            gstAmount=finalOrderAmount*5/100;
        else if(finalOrderAmount>1000 && finalOrderAmount <= 2500)
            gstAmount=finalOrderAmount*12/100;
        else if(finalOrderAmount>2500)
            gstAmount=finalOrderAmount*18/100;
        return gstAmount;
    }
    protected double calculateCess(double finalOrderAmount){
        double cssAmount=0.0;
        //2%
        //
        cssAmount=2/100*finalOrderAmount;
        return cssAmount;
    }
    protected double calculateFinalBillAmount(double finalOrderAmount,double discount,double gstAmount,double cssAmount){
        double finalBillAmount=0.0;

        finalBillAmount=finalOrderAmount*(1-discount/100)+gstAmount+cssAmount;
        return finalBillAmount;
    }
    protected void displayFinalBill(Order order,double discount,double gstAmount,double cssAmount,double finalBillAmount){
        System.out.println("Order id: "+order.getOrderId());
        System.out.println("Customer name: "+order.getCustomer().getName());
        System.out.println("Items: ");
        for(var oi:order.getOrderItems())
        {
            System.out.println("Item No: " + oi.getItem(). getItemNo()) ;
            System.out.println("Title: " + oi.getItem().getTitle());
            System.out.println("Rate: " + oi.getItem().getRate());
        }
        System.out.println("Total: "+order.getTotalOrderValue());
        System.out.println("Discount: "+discount);
        System.out.println("GST "+gstAmount);
        System.out.println("Cess: "+cssAmount);
        System.out.println("Grand Total: "+finalBillAmount);
       

        // return billAmount;
    }
}
