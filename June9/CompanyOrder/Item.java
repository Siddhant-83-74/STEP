package CompanyOrder;


public class Item
{
    private int itemNo;
    private String title;
    private double rate;

    public Item(int itemNo, String title, double rate)
    {
        this.itemNo=itemNo;
        this.title=title;
        this.rate=rate;
    }
    
    public int getItemNo()
    {
        return this.itemNo;
    }

    public void setItemNo(int itemNo)
    {
        this.itemNo=itemNo;
    }
    public String getTitle()
    {
        return this.title;
    }

    public void setTitle(String title)
    {
        this.title=title;
    }
    public double getRate()
    {
        return this.rate;
    }

    public void setRate(double rate)
    {
        this.rate=rate;
    }


}
