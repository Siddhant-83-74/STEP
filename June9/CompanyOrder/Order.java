package CompanyOrder;
import java.util.List;
import java.util.ArrayList;
/*

*/

public class Order
{
    private int orderId;
    //Has-A order has a customer. Bidirectional relationship
    private Customer customer;

    private List<OrderItem> orderItems;

    public Order()
    {
        orderItems=new ArrayList<>();
    }


    public int getOrderId()
    {
        return this.orderId;
        
    }

    public void setOrderId(int orderId)
    {
        this.orderId=orderId;
    }

    public Customer getCustomer()
    {
        return this.customer;
    }

    public void setCustomer(Customer customer)
    {
        this.customer=customer;
    }

    public List<OrderItem> getOrderItems()
    {
        return this.orderItems;
    }

    public void addOrderItem(OrderItem orderItem)
    {
        this.orderItems.add(orderItem);
    }

    public double getTotalOrderValue(){
        double totalOrderValue = 0.0;
       
        //No if else and any type of customer and still the logic will worl seamlessly without a change in this code
        //Satisfies OCP - Open Closed Principle
        for(OrderItem orderItem: this.getOrderItems()){
            totalOrderValue += orderItem.getTotalOrderValue();
        }
        
        return totalOrderValue;
    }
}