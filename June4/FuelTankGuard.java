import java.util.Scanner;
public class FuelTankGuard
{
    private int current_fuel;
    
    FuelTankGuard(int n)
    {
        current_fuel=n;
    }
    public int currentFuel()
    {
        return this.current_fuel;
    }

    public void reFuel(int fuelAmt)
    {
        if(this.current_fuel+fuelAmt<100)
            {this.current_fuel+=fuelAmt;
                System.out.println("Refuled "+fuelAmt);
            }
            else
            {System.out.println("Tank is full");}
    }

    public void consumeFuel(int fuelAmt)
    {
        if(this.current_fuel-fuelAmt>0)
        {
            this.current_fuel-=fuelAmt;
        }
    }

    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        FuelTankGuard obj=new FuelTankGuard(50);

        obj.reFuel(30);
        System.out.println(obj.currentFuel());
        obj.consumeFuel(90);
        System.out.println(obj.currentFuel());
        obj.reFuel(25);
        System.out.println(obj.currentFuel());
        obj.consumeFuel(40);
        System.out.println(obj.currentFuel());
        

    }
}