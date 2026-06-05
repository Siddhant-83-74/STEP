import java.util.Scanner;
interface Fleet
{
    public int Fare(int dis);
}

class Car implements Fleet
{
   final int fareRate=10;
   
  public int Fare(int dis)
   {
    return dis*fareRate;
   }
}

class Bike implements Fleet
{
    final int fareRate=5;

    public int Fare(int dis)
    {
        return dis*fareRate;
    }
}

class Truck implements Fleet
{
    final int fareRate=15;

    public int Fare(int dis)
    {
        return (dis*fareRate+100);
    }
}

public class FleetDashboard
{
    public static void main(String args[])
    {
        Fleet vehicle[]=new Fleet[4];
        Scanner sc=new Scanner(System.in);
        String inp[]=new String[4];
        for(int i=0;i<4;i++)
        {
            inp[i]=sc.nextLine();
        }

        int i=0;
        int totalFare=0;
        int maxFare=0;
        char max='\0';
        int fare=0;
        
        for(String input:inp)
        {
            String words[]=input.split(" ");
            if(words[0].equalsIgnoreCase("car")) 
                {vehicle[i]=new Car();
                    fare=vehicle[i].Fare(20);
                 if(fare>maxFare)
                {    maxFare=fare;
                    max=words[1].charAt(0);
                }
                totalFare+=fare;
                i++;
                }
            else if(words[0].equalsIgnoreCase("bike"))
                {vehicle[i]=new Bike();
                    fare=vehicle[i].Fare(20);
                     if(fare>maxFare)
                {    maxFare=fare;
                    max=words[1].charAt(0);
                }
                totalFare+=fare;
                i++;
                }
            else if(words[0].equalsIgnoreCase("truck"))
                {vehicle[i]=new Truck();
                    fare=vehicle[i].Fare(20);
                     if(fare>maxFare)
                {    maxFare=fare;
                    max=words[1].charAt(0);
                }
                totalFare+=fare;
                i++;

                }
        }
        int car=0,bike=0,truck=0;
        for(Fleet v:vehicle)
        {
            if(v instanceof Car)
                car++;
            else if(v instanceof Bike)
                bike++;
            else if(v instanceof Truck)
                truck++;
        }

        System.out.println("Total Fare: "+totalFare+"\nHighest Fare: "+max+" ("+maxFare+")");
        System.out.println("Cars: "+car+"\nBikes: "+bike+"\nTruck: "+truck);





    }
}