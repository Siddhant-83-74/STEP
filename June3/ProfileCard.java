public class ProfileCard
{
    public static void main(String args[])
    {
        String name="Siddhant Jain";
        int age=22;
        float height=165.0f;
        char bloodGroup='O';
        boolean isStudent=true;

        System.out.println("My name is "+name);
        System.out.println("Age: "+age);
        System.out.println("Height: "+height);
        System.out.println("Blood Group: "+bloodGroup+"\nStudent: "+isStudent);

        int currentYear=2026;
        int birthYear=currentYear-age;
        System.out.println("Birth year: "+birthYear);
    }
}