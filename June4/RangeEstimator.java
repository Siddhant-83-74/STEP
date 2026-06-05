import java.util.Scanner;
abstract class Vehicle
{
    String brand;
    Vehicle(String brand)
    {
        this.brand=brand;
    }

    abstract void Range();
}

class Petrol extends Vehicle
{
     int fuel;
     int mileage;

     Petrol(String brand, int fuel, int mileage)
     {
        super(brand);
        this.fuel=fuel;
        this.mileage=mileage;
     }

     void Range()
     {
        System.out.println(this.brand+" (Petrol) Range: "+(this.fuel*this.mileage)+"km");
     }
}

class Electric extends Vehicle
{
     int battery;
     int efficiency;

     Electric(String brand, int battery, int efficiency)
     {
        super(brand);
        this.battery=battery;
        this.efficiency=efficiency;
     }

     void Range()
     {
        System.out.println(this.brand+" (Petrol) Range: "+(this.battery*this.efficiency)+"km");
     }
}

public class RangeEstimator
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String inp=sc.nextLine();
        String words[]=inp.split(" ");
        Vehicle v=null;
        if(words[0].equalsIgnoreCase("electric"))
        {
            v=new Electric(words[1],Integer.parseInt(words[2]),Integer.parseInt(words[3]));
            v.Range();
        }
        else if(words[0].equalsIgnoreCase("petrol"))
        {
            v=new Petrol(words[1],Integer.parseInt(words[2]),Integer.parseInt(words[3]));
            v.Range();
        }
    }
}