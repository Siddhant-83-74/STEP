import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;


class Patient
{
    String patientId;
    String name;
    int age;
    boolean hasEmergency=false;

    public Patient(String patientId,String name,int age,boolean hasEmergency)
    {
        this.patientId=patientId;
        this.name=name;
        this.age=age;
        this.hasEmergency=hasEmergency;
    }
}

class PatientRegistry
{
    static ArrayList <Patient> patients = new ArrayList<>();

   static void registerPatient(Patient p1)
    {
        for(Patient p: patients)
        {
            if(p.patientId==p1.patientId)
            {
                System.out.println("Patient id already exist.");
                return;
            }
        }
        patients.add(p1);

    }

    static void findPatient(Patient p1)
    {
        for(Patient p: patients)
        {
            if(p.patientId==p1.patientId)
            {
                System.out.println("Patient id: "+p.patientId+"\nPatient's Name: "+p.name+"\nAge: "+p.age);
                return;
            }
            System.out.println("No matching id exists");
        }
    }

    static void getPatientByReg()
    {

        for(int i=patients.size()-1;i>=0;i++)
           { System.out.println("Patient id: "+patients.get(i).patientId+"\nPatient's Name: "+patients.get(i).name+"\nAge: "+patients.get(i).age);
                System.out.println();       
    }

    }

    static void dischargePatient(Patient p)
    {
        for(Patient p1: patients)
        {
            if(p.patientId==p1.patientId)
            {
                    
                    patients.remove(p) ;
            }
        }
        System.out.println("No matching id exists");
    }

    
    static LinkedList <Patient> ePatients=new LinkedList<>();

    static void displayData(Patient p)
    {
        System.out.println("Patient id:"+p.patientId+"\nName: "+p.name+"\nAge: "+p.age);
    }

    static void addEmergencyPatient(Patient p)
    {
        for(Patient p1: ePatients)
        {
            if(p.patientId==p1.patientId)
            {
                System.out.println("Patient id already exist in emergency queue.");
                return;
            }
        }
        ePatients.add(p);
    }

    static void getNextPatient()
    {
        if(!ePatients.isEmpty())
        {
            displayData(ePatients.getFirst());
            ePatients.removeFirst();
        }
        else
        System.out.println("Emergency queue is empty");
    }

    static int getWaitingCount()
    {
        return ePatients.size();
    }

    static void peekNextPatient()
    {
        if(!ePatients.isEmpty())
             displayData(ePatients.getFirst());
        else
             System.out.println("Emergency queue is empty");

    }

}

public class lvl1
{
    public static void main(String args[])
    {
        Patient p1=new Patient("01","Arun",45,false);
        Patient p2=new Patient("02","Varun",40,false);
        Patient p3=new Patient("03","Aarun",35,false);
        Patient p4=new Patient("01","Arun",45,false);
        Patient p5=new Patient("06","Arun singh",35,true);
        Patient p6=new Patient("05","Arun gupta",25,true);

        PatientRegistry.registerPatient(p1);
        PatientRegistry.registerPatient(p2);
        PatientRegistry.registerPatient(p3);
        PatientRegistry.registerPatient(p4);

        PatientRegistry.addEmergencyPatient(p5);
        PatientRegistry.addEmergencyPatient(p6);


    }
}


