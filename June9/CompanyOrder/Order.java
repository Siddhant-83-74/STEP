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

    public void setOrderItem(OrderItem orderItem)
    {
        this.orderItems.add(orderItem);
    }
}