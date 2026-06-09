package CompanyOrder;
import java.util.List;
import java.util.ArrayList;

public class Customer
{
    private String name;
    private int customerId;
    // if we use discount data here then for all the regular customers it will be 0
    //MIC-Mixed Instance Cohesion
    //Mixing some other instance data with this instance

    //Has-A a Customer has many customer ~ bidirectional
    private List<Order> orders;
    public Customer(String name, int customerId)
    {
        this.name=name;
        this.customerId=customerId;
        this.orders=new ArrayList<>();
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name=name;
    }

    public int getCustomerId()
    {
        return this.customerId;
    }

    public void setCustomerId(int customerId)
    {
        this.customerId=customerId;
    }

    public List<Order> getOrder()
    {
        return this.orders;
    }

    public void addOrder(Order order)
    {
        this.orders.add(order);
    }
    //functional
    // public double getTotalOrderValueV1()
    // {
    //     double totalOrderValue=0.0;

        
    //         for(Order order:this.getOrder()){
    //             for(OrderItem orderItem:order.getOrderItems()){
    //             if(this instanceof RegisteredCustomer){
    //                 RegisteredCustomer rc= (RegisteredCustomer)this;
    //                 totalOrderValue+= orderItem.getQuantity()*(orderItem.getItem().getRate()*(1.0-rc.getDiscount()/100.0));
    //             }
    //             else
    //                 totalOrderValue+= orderItem.getQuantity()*orderItem.getItem().getRate();
    //             }
    //             //OCP: Open closed Principle
    //             //class  should be open for extension but closed for modification
    //             //and it can be solved from run-time polymorphism - Method Overloading
                
            
    //     }
    //     return totalOrderValue;
    // }

    public double getTotalOrderValueV2(){
        double totalOrderValue = 0.0;
       
        //No if else and any type of customer and still the logic will worl seamlessly without a change in this code
        //Satisfies OCP - Open Closed Principle
        for(Order order: this.getOrder()){
            totalOrderValue += order.getTotalOrderValue();
        }
        
        return totalOrderValue;
    }
}