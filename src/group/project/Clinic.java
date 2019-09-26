/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group.project;
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
/**
 * 
 * @author Gloria Ezzat
 */
//Creation of clinic's class
public class Clinic {
    //attributes
    private final String name;
    private final ArrayList<String> phone= new ArrayList<>();
    private final ArrayList<String> Address= new ArrayList<>();
    private final String workTime;
    private final LinkedList<Doctor> doctors=new LinkedList<>();
    private final LinkedList<Booking> bookings=new LinkedList<>();
    private final LinkedList<Child> children=new LinkedList<>();
    private final LinkedList<Woman> women=new LinkedList<>();
    private final LinkedList<Supply> supplies=new LinkedList<>();
    private final LinkedList<Order> orders=new LinkedList<>();
    private Admin admin;
    private int revenues;
    private double checks;
    //constructor
    public Clinic() throws Exception{
        this.revenues = 0;
        this.checks = 0;
        name="Mother Love";
        phone.add("0229898435");
        phone.add("0228938787");
        phone.add("0127837033");
        Address.add("59 Abbas El 3a2ad");
        Address.add("Madinet Nasr");
        Address.add("Cairo");
        Address.add("Egypt");
        workTime="Everyday from 12pm to 10 pm except Friday and Saturday";
        admin=new Admin("Engy","ICSgroupproject");
        //Creating and implementing first doctor
        doctors.add(new Pediatrician("Lorina","01278979879",200,2000,"Pediatrician"));
        doctors.get(0).setAppointment("Sunday: 5pm-10pm, Tuesday: 1pm-6pm, Thursday: 3pm-8pm");  
        doctors.get(0).setWorkDays("Sunday", "Tuesday", "Thursday");
        doctors.get(0).setWorkTime(5.0, 1.0, 3.0);
        Doctor.setPayments(doctors.get(0).getSalary());
        //Creating and implementing second doctor
        doctors.add(new Pediatrician("Gloria","01276856445",150,3000,"Pediatrician"));
        doctors.get(1).setAppointment("Monday: 12pm-5pm, Wednesday: 4pm-9pm, Thursday: 2pm-7pm");
        doctors.get(1).setWorkDays("Monday", "Wednesday", "Thursday");
        doctors.get(1).setWorkTime(12.0, 4.0, 2.0);
        Doctor.setPayments(doctors.get(1).getSalary());
        //Creating and implementing third doctor
        doctors.add(new Pediatrician("Engy","01286786734",250,2500,"Pediatrician"));
        doctors.get(2).setAppointment("Sunday: 2pm-7pm, Tuesday: 4:30pm-9:30pm , Wednesday: 12pm-5pm");
        doctors.get(2).setWorkDays("Sunday", "Tuesday", "Wednesday");
        doctors.get(2).setWorkTime(2.0, 4.5, 12.0);
        Doctor.setPayments(doctors.get(2).getSalary());
        //Creating and implementing fourth doctor
        doctors.add(new Gynecologist("Anas","01276865764",120,2500,"Gynecologist"));
        doctors.get(3).setAppointment("Tuesday: 2pm-7pm, Wednesday: 5pm-10pm, Thursday: 1pm-6pm");
        doctors.get(3).setWorkDays("Tuesday", "Wednesday", "Thursday");
        doctors.get(3).setWorkTime(2.0, 5.0, 1.0);
        Doctor.setPayments(doctors.get(3).getSalary());
        //Creating and implementing fifth doctor
        doctors.add(new Gynecologist("Wafaa","01257865769",170,2700,"Gynecologist"));
        doctors.get(4).setAppointment("Sunday: 5pm-10pm, Tuesday: 12pm-5pm, Wednesday: 2pm-7pm");
        doctors.get(4).setWorkDays("Sunday", "Tuesday", "Wednesday");
        doctors.get(4).setWorkTime(5.0, 12.0, 2.0);
        Doctor.setPayments(doctors.get(4).getSalary());
        //Creating and implementing sixth doctor
        doctors.add(new Gynecologist("Karim","01289798686",230,1900,"Gynecologist"));
        doctors.get(5).setAppointment("Tuesday: 5pm-10pm, Wednesday: 2pm-7pm, Thursday: 1pm-6pm");
        doctors.get(5).setWorkDays("Tuesday", "Wednesday", "Thursday");
        doctors.get(5).setWorkTime(5.0, 2.0, 1.0);
        Doctor.setPayments(doctors.get(5).getSalary());
        FileOutputStream fo = new FileOutputStream("Doctors.txt"); 
        ObjectOutputStream out = new ObjectOutputStream(fo); 
        out.writeObject(doctors);
        out.close();
        fo.close();
    }

    //add new booking
    public int addBooking(Booking b){
        this.bookings.add(b);
        this.revenues+=b.getRevenue();
        int bookNum=bookings.indexOf(b)+1;
        return bookNum;
    }
    public boolean removeBooking(int num){
        this.revenues-=bookings.get(num).getRevenue();
        bookings.remove(num);
        return true;
    }

    public int getRevenues() {
        return revenues;
    }
    public Doctor presence(String name){
        for(int i=0;i<doctors.size();i++){
            if(name.equalsIgnoreCase(doctors.get(i).getName()))
                return doctors.get(i);
        }
        return null;
    }
    public void newOrder(Order or){
        this.orders.add(or);
    }
    public void addSupply(Supply s){
        this.supplies.add(s);
        this.checks+=s.getPrice();
    }

    public double getChecks() {
        return checks;
    }
    //add new patient
    public void addChild(Child c) {
        this.children.add(c);
    }
    public void addWoman(Woman w) {
        this.women.add(w);
    }
    public LinkedList<Supply> getSupplies() {
        LinkedList<Supply> supplies=null;
        try (FileInputStream si = new FileInputStream("Supplies.txt"); 
        ObjectInputStream in = new ObjectInputStream(si)) {
            supplies=(LinkedList<Supply>) in.readObject();
        }
        catch(Exception e){   
        }
        return supplies;
    }

    public LinkedList<Order> getOrders() {
        LinkedList<Order> orders=null;
        try (FileInputStream si = new FileInputStream("Orders.txt"); 
        ObjectInputStream in = new ObjectInputStream(si)) {
            orders=(LinkedList<Order>) in.readObject();
        }
        catch(Exception e){   
        }
        return orders;
    }
    public void saveData() throws Exception{
        FileOutputStream fo6 = new FileOutputStream("Doctors.txt"); 
        ObjectOutputStream out6 = new ObjectOutputStream(fo6); 
        out6.writeObject(doctors);
        out6.close();
        fo6.close();
        FileOutputStream fo = new FileOutputStream("Women.txt"); 
        ObjectOutputStream out = new ObjectOutputStream(fo);
        out.writeObject(women);
        out.close();
        fo.close();
        FileOutputStream fo1 = new FileOutputStream("Children.txt"); 
        ObjectOutputStream out1 = new ObjectOutputStream(fo1);
        out1.writeObject(children);
        out1.close();
        fo1.close();
        FileOutputStream fo2 = new FileOutputStream("Bookings.txt"); 
        ObjectOutputStream out2 = new ObjectOutputStream(fo2);
        out2.writeObject(bookings);
        out2.close();
        fo2.close();
        FileOutputStream fo3 = new FileOutputStream("Supplies.txt"); 
        ObjectOutputStream out3 = new ObjectOutputStream(fo3);
        out3.writeObject(supplies);
        out3.close();
        fo3.close();
        FileOutputStream fo4 = new FileOutputStream("Orders.txt"); 
        ObjectOutputStream out4 = new ObjectOutputStream(fo4);
        out4.writeObject(orders);
        out4.close();
        fo4.close();
    }
    //accessors
    public String getName()
    {
        return name;
    }
    public ArrayList<String> getaddress()
    {
        return Address;
    }
    public ArrayList<String> getphone()
    {
        return phone;
    }
    public String getWorkTime(){
        return workTime;
    }
    
    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
    //display method
    public String display(){
        return "Clinic Name: "+getName()+"\nClinic Address: "+getaddress()+"\nClinic Phone: "+getphone()+"\nClinic Work Time: "+getWorkTime();
    }
}
