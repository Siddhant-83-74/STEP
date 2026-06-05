import java.util.Scanner;
 class Vehicle
{
    String brand;
    int speed;
    Vehicle(String brand,int speed)
    {
        this.brand=brand;
        this.speed=speed;
    }


}

class Car extends Vehicle
{
    int seats;
    Car(String brand,int speed,int seats)
    {
        super(brand,speed);
        this.seats=seats;
    }

    void printData()
    {
        System.out.println("Car "+this.brand+": "+this.speed+", "+this.seats+" seats");
    }

}

class Truck extends Vehicle
{
    int capacity;
    Truck(String brand,int speed,int capacity)
    {
        super(brand,speed);
        this.capacity=capacity;
    }
    void printData()
    {
        System.out.println("Truck "+this.brand+": "+this.speed+" km/h, "+this.capacity+" kg cargo");
    }
}



public class Main{
public static void main(String args[])
{
    Scanner sc=new Scanner(System.in);
    String inp=sc.nextLine();
    Car obj=null;
    Truck objt=null;
    String words[]=inp.split(" ");
    if(words[0].equals("CAR"))
        {obj=new Car(words[1],Integer.parseInt(words[2]),Integer.parseInt(words[3]));
        obj.printData();
        }
    else if(words[0].equals("TRUCK")){
        objt=new Truck(words[1],Integer.parseInt(words[2]),Integer.parseInt(words[3]));
        objt.printData();
    }

}
}