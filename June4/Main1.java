import java.util.Scanner;
abstract class Vehicle
{
    String brand;
    int dis;

    Vehicle(String brand, int dis)
    {
        // this.fare=fare;
        this.brand=brand;
        this.dis=dis;
    }
    abstract void printData();
    
}

class Car extends Vehicle{

    Car(String brand,int dis)
    {
        super(brand,dis);
    }
    @Override
    void printData()
    {
        System.out.println(this.brand+" (Car) Fare: "+this.dis*10);
    }

}
class Bike extends Vehicle{

    Bike(String brand,int dis)
    {
        super(brand,dis);
    }
    @Override
    void printData()
    {
        System.out.println(this.brand+" (Bike) Fare: "+this.dis*5);
    }

}
class Truck extends Vehicle{

    Truck(String brand,int dis)
    {
        super(brand,dis);
    }
    @Override
    void printData()
    {
        System.out.println(this.brand+" (Truck) Fare: "+this.dis*20);
    }

}

public class Main1
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String inp=sc.nextLine();

        String words[]=inp.split(" ");
        Vehicle v=null;
        if(words[0].equals("CAR"))
        {
            v=new Car(words[1],10);
            v.printData();
        }
        else if(words[0].equals("BIKE"))
        {
            v=new Bike(words[1],10);
            v.printData();
        }
        else if(words[0].equals("TRUCK"))
        {
            v=new Truck(words[1],10);
            v.printData();
        }
    }
}