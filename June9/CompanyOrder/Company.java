package CompanyOrder;

import java.util.ArrayList;
import java.util.List;
public class Company
{
    //Has-A relationship
    private List<Item> items;
    private String name;

    public Company(String name)
    {
        this.name=name;
        this.items= new ArrayList<>();

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


}