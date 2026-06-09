package CompanyOrder;

public class TestMain       
{
    public static void main(String args[])
    {
        var company=new Company("Shopperstop");
        var ghost=new Company("Shopperstop");
        company.setName("Shopperstop");
        ghost.setName("Ghost");
        System.out.println(company.getName());
        System.out.println(ghost.getName());

        


        // var item = new Item()

    }
}
/*
STEPS
Create a console application / java project
Create company class and copy and paste the code given
Create Item class and copy and paste code given
Create Customer Class - No code just create
Create Registered Customer class extending Customer - No code just the class creation
*/

/*


 1. Naming conventions - Should be meaningful names, easily understandable

 2. Casing - Camel Casing - First letter is always small, every word starts with Capital

 if its a combination of more than one word - simpleInterest;

 Class Names - Always Capitals to be begin with 

 Method Names - CamelCasing - Verbs - calculateSimpleInterest()

 Class Variables - camel casing

 Code organisation- Structure and flow of your code

 Code Identation and Formatting - Look neat and clear. There should be
June 9
Company
Customer
RegisteredCustomer
Item
Order

Company Has-A realtionship with Item ->Done
Customer Is-A relationship with Registered Customer ->Done
Customer Has a relationship with Order ~ bidirectional ~ multiplicity ->Done



Classes, Objects Getters and setters
Interfaces
Collections - List and Map
Design Principles and Patterns - SOLID, Structural Design Patterns
Configuration Based Programming
Unit Testable Code
Test Main Code - This is very important for you to know how totest your code

~ when implementing bidirectional relationship, let say there could be multiple B 
object of class A then make a list of B class objects in class A and as it is bidirectional 
we have to make an object of class A in class B too.


*/
