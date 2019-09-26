/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group.project;
import java.util.Scanner;
/**
 *
 * @author Gloria Ezzat
 */
public class MedCare {
    /**
     * @param args
     * @throws java.lang.Exception
     */
    
    public static void main (String[] args) throws Exception{
        
        Scanner input=new Scanner(System.in);
        String space=new String();
//Creating Medcare object of clinic class
        //Creating an object of a clinic
        Clinic MedCare1=new Clinic();
        //welcome interface
        String welcome=MedCare1.display();
        System.out.println(welcome);
//Patients use
        
        //the patient is a child
        int num;
        do{
            //patient choosing the specialization
            
            System.out.println("1-Reserve a doctor");
            System.out.println("2-Cancel reservation");
            System.out.println("3-Exit");
            num=input.nextInt();
            if(num==3)
                break;
            space=input.nextLine();
            System.out.print("Please choose a Child or a Woman: ");
            String choice=input.nextLine();
            if("Child".equals(choice)||"child".equals(choice))
            {
                Child ch=new Child();
                if(num==1){
                    System.out.println(ch.browseDoctors());
                    
                    System.out.println("Please enter your infomation ");
                    System.out.print("Parent Name: ");
                    String parentName=input.nextLine();
                    System.out.print("Phone Number: ");
                    String number=input.nextLine();
                    System.out.print("Child Name: ");
                    String chName=input.nextLine();
                    System.out.print("Child Address: ");
                    String add=input.nextLine();
                    System.out.print("Child Age: ");
                    int age=input.nextInt();
                    space=input.nextLine();
                    ch.createAccount(parentName,number,chName,add,age);
                    MedCare1.addChild(ch);
                    System.out.println("Please choose the doctor's name ");
                    String docName=input.nextLine();
                    Doctor d=MedCare1.presence(docName);
                    System.out.println(d.browseSchedule());
                    System.out.println("Please choose the day you want ");
                    String day=input.nextLine();
                    System.out.println("Please choose the time you want ");
                    Double time=input.nextDouble();
                    System.out.println("Pay doctor fees ");
                    int fees=input.nextInt();
                    int bookNum=ch.Book(MedCare1,docName,day,time,fees);
                    space=input.nextLine();
                    if(bookNum!=0)
                    {
                        System.out.println("Day is booked");
                        System.out.println(bookNum);
                        System.out.println("Press enter to continue");
                        space=input.nextLine();
                    }
                }      
                else if(num==2){
                    System.out.print("Enter the number of your booking ");
                    int index=input.nextInt();
                    index--;
                    if(ch.cancelBooking(MedCare1,index)){
                        System.out.println("Booking is cancelled");
                        System.out.println("Press enter to continue");
                        space=input.nextLine();
                    }
                }
            }
            else if("Woman".equals(choice)||"woman".equals(choice))
            {
                Woman w=new Woman();
                if(num==1){
                    
                    System.out.println(w.browseDoctors());
                    System.out.println("Please enter your infomation ");
                    System.out.print("Name: ");
                    String wName=input.nextLine();
                    System.out.print("Address: ");
                    String add=input.nextLine();
                    System.out.print("Phone Number: ");
                    String number=input.nextLine();
                    System.out.print("Married or Single: ");
                    String status=input.nextLine();
                    System.out.print("Age: ");
                    int age=input.nextInt();
                    space=input.nextLine();
                    w.createAccount(status,number,wName,add,age);
                    MedCare1.addWoman(w);
                    System.out.println("Please choose the doctor's name ");
                    String docName=input.nextLine();
                    Doctor d=MedCare1.presence(docName);
                    System.out.println(d.browseSchedule());
                    System.out.println("Please choose the day you want ");
                    String day=input.nextLine();
                    System.out.println("Please choose the time you want ");
                    Double time=input.nextDouble();
                    System.out.println("Pay doctor fees ");
                    int fees=input.nextInt();
                    int bookNum=w.Book(MedCare1,docName,day,time,fees);
                    space=input.nextLine();
                    if(bookNum!=0)
                    {
                        System.out.println("Day is booked");
                        System.out.println(bookNum);
                        System.out.println("Press enter to continue");
                        space=input.nextLine();
                    }
                }
                else if(num==2){
                    System.out.println("Enter the number of your booking ");
                    int index=input.nextInt();
                    index--;
                    if(w.cancelBooking(MedCare1,index))
                    {
                        System.out.println("Booking is cancelled");
                        System.out.println("Press enter to continue");
                        space=input.nextLine();
                    }
                }
            }
            space=input.nextLine();
        }while(num!=3);
        MedCare1.saveData();
//Doctors use
        System.out.println("Press enter to continue");
        space=input.nextLine();space=input.nextLine();
        //the doctor enters its name
        System.out.println("Please Enter Your Name");
        Doctor d=MedCare1.presence(input.nextLine());
        do{
        System.out.println("1-Order new supply");
        System.out.println("2-Modify calendar");
        System.out.println("3-Check calendar");
        System.out.println("4-Modify fees");
        System.out.println("5-Exit");
        num= input.nextInt();
        space=input.nextLine();
            switch(num){
                // Doctor Ordering Supplies
                case 1:
                    System.out.print("Enter supply name: ");
                    String name=input.nextLine();
                    System.out.print("Enter supply quantity: ");
                    int q=input.nextInt();
                    space=input.nextLine();
                    d.orderSupply(MedCare1,name,q);
                    break;
                //Doctor modifies its calendar
                case 2:
                    System.out.println("Enter the day number, the time number and the new timing: ");
                    int day=input.nextInt();
                    int time=input.nextInt();
                    double newTime=input.nextFloat();
                    d.updateSchedule(day,time,newTime);
                    space=input.nextLine();
                    break;
                case 3:
                    System.out.println(d.browseSchedule());
                    break;
                case 4:
                    System.out.print("Enter the new fees: ");
                    d.setFees(input.nextInt());
                }
            
        System.out.println("Press enter to continue");
        space=input.nextLine();
        }while(num!=5);
        MedCare1.saveData();
//Admin use
        Admin admin=MedCare1.getAdmin();
        //Admin sign in
        try{
            System.out.println("Enter username");
            String username=input.nextLine();
            System.out.println("Enter password");
            String pass=input.nextLine();
            if(admin.accountValidation(username, pass)){
                int choix;
                do{
                System.out.println("Select what you are going to do");
                System.out.println("1-Check orders");
                System.out.println("2-Check doctors' monthly payments");
                System.out.println("3-Add a new supply");
                System.out.println("4-Check the existed supplies");
                System.out.println("5-Check the checks of the recent ordered supplies");
                System.out.println("6-Check the total clinic revenues");
                System.out.println("7-Order new supply");
                System.out.println("8-Exit");
                choix=input.nextInt();
                switch (choix){
                    case 1:
                        System.out.println(admin.checkOrders(MedCare1));
                        break;
                    case 2:
                        System.out.print("Doctors' total payments= ");
                        System.out.println(admin.checkDoctorsPayments());
                        break;
                    case 3:
                        space=input.nextLine();
                        System.out.println("Enter Medicine name");
                        String name=input.nextLine();
                        System.out.println("Enter Medicine price");
                        double price=input.nextDouble(); 
                        System.out.println("Enter Medicine Quantity");
                        int q=input.nextInt();
                        admin.addSupply(MedCare1,name,price,q);
                        break;
                    case 4:
                        System.out.println(admin.getSupplies(MedCare1));
                        break;
                    case 5:
                        System.out.println("The revenues of the clinic= ");
                        System.out.println(admin.checkChecks(MedCare1));
                        break;    
                    case 6:
                        System.out.println("The revenues of the clinic= ");
                        System.out.println(admin.checkRevenues(MedCare1));
                        break;
                    case 7:
                        space=input.nextLine();
                        System.out.print("Enter supply name: ");
                        name=input.nextLine();
                        System.out.print("Enter supply quantity: ");
                        num=input.nextInt();
                        admin.orderSupply(MedCare1, name, num);
                    }
                System.out.println("Press enter to continue");
                space=input.nextLine();space=input.nextLine();
                }while(choix!=8);
                MedCare1.saveData();
            }
        }
        catch(Exception exception)
        {
            System.out.println("Wrong password");
        }      
    MedCare1.saveData();
    }
}






