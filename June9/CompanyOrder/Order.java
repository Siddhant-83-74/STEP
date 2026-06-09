package CompanyOrder;
/*

*/

public class Order
{
    private int orderId;
    private Customer customer;
    //Has-A order has a customer. Bidirectional relationship
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
}