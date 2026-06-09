package CompanyOrder;

public class OrderItem
{
    //Combination of Item and Quanity
    //Data members
    private Item item;
    private int quantity;

    //Getter and Setter

    public OrderItem(Item item, int quantity)
    {
        this.item=item;
        this.quantity=quantity;
    }
    public Item getItem()
    {
        return this.item;
    }

    public void setItem(Item item)
    {
        this.item=item;
    }

    public int getQuantity()
    {
        return this.quantity;
    }

    public void setQuantity(int quantity)
    {
        this.quantity=quantity;
    }
}