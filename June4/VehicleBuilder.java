import java.util.Scanner;
public class VehicleBuilder
{
    String brand;
    int speed;
    static int count=0;;
    VehicleBuilder(String brand,int speed)
    {
        
        this.brand=brand;
        this.speed=speed;

    }
    VehicleBuilder(String brand)
    {
        this.brand=brand;
        this.speed=80;
        count++;
    }
    void printData()
    {
        System.out.println(this.brand+":"+this.speed);
    }

    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String inp[]=new String[3];
        for(int i=0;i<3;i++)
        {
            inp[i]=sc.nextLine();
        }

        VehicleBuilder[] vehicle=new VehicleBuilder[3];
        for(int i=0;i<3;i++)
        {
            String words[]=inp[i].split(" ");
            if(words.length==3)
                vehicle[i]=new VehicleBuilder(words[1],Integer.parseInt(words[2]));
            else
                vehicle[i]=new VehicleBuilder(words[1]);//,Integer.parseInt(words[2]));

        }
        for(VehicleBuilder v:vehicle)
        {
            v.printData();
        }
        System.out.println(count);

    
    }

}