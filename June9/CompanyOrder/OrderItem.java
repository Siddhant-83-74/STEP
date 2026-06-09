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

    //OrderItem class is taking responsiblity to calculte the total amount for the item
        public double getTotalOrderValue(){
        double totalOrderValue = 0.0;
       
        //No if else and any type of customer and still the logic will worl seamlessly without a change in this code
        //Satisfies OCP - Open Closed Principle
        totalOrderValue=this.item.getRate()*this.quantity;
        
        return totalOrderValue;
    }
}