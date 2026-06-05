import java.util.Scanner;
public class FleetCoreRegistry
{
    String id;
    String brand;
    int speed;

    FleetCoreRegistry(String id,String brand,int speed)
    {
        this.id=id;
        this.brand=brand;
        this.speed=speed;
    }

    void summariseData()
    {
        System.out.println("Vehicle "+this.id+"("+this.brand+")");
        System.out.println("Top Speed: "+this.speed+" km/h");
        System.out.println("Category:  "+(speed>=100?"Fast":"Standard"));
    }

    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);

        String inp=sc.nextLine();
        String[] words = inp.split(" ");
        int i=0; 
        String id="";
        String brand="";
        int speed=0;
        for(String word:words)
        {

            if(i==0)
            {
                id=word;
            }
            else if(i==1)
            {
                brand=word;
            }
            else
            {
                speed=Integer.parseInt(word);
            }
            i++;
        }
        FleetCoreRegistry obj= new FleetCoreRegistry(id,brand,speed);
        obj.summariseData();
    }
}