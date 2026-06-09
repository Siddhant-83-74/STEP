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
}