package CompanyOrder;

import java.util.ArrayList;
import java.util.List;
public class Company
{
    //Has-A relationship ~unidirectional
    private List<Item> items;
    //Has-A ~ Unidirectional
    private List<Customer> customers;
    private String name;

    public Company(String name)
    {
        this.name=name;
        this.items= new ArrayList<>();
        this.customers=new ArrayList<>();

    }

    public void setName(String name)
    {
        this.name=name;
    }

    public String getName()
    {
        return this.name;
    }

    public List<Item> getItems()
    {
        return this.items;
    }

    public void addItem(Item item)
    {
        this.items.add(item);
    }

    public List<Customer> getCustomers()
    {
        return this.customers;
    }
    public void addCustomer(Customer customer)
    {
        this.customers.add(customer);
    }

    //Functional Methods
    public double getTotalOrderValue()
    {
        double totalOrderValue=0.0;

        for(Customer customer:this.customers){
            for(Order order:customer.getOrder()){
                for(OrderItem orderItem:order.getOrderItems()){
                if(customer instanceof RegisteredCustomer){
                    RegisteredCustomer rc= (RegisteredCustomer)customer;
                    totalOrderValue+= orderItem.getQuantity()*(orderItem.getItem().getRate()*(1.0-rc.getDiscount()/100.0));
                }
                else
                    totalOrderValue+= orderItem.getQuantity()*orderItem.getItem().getRate();
                }

            }
        }
        return totalOrderValue;
    }


}