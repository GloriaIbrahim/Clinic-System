/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group.project;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.LinkedList;

/**
 *
 * @author Gloria Ezzat
 */
//Creation of the patient classs
public abstract class Patient {
    //attributes
    private String name;
    private int age;
    private String phone;
    private String address;
    
    //contructor
    public Patient(){
        this.name="";
        this.age=0;
        this.address="";
        this.phone="";
    }
    //abstract methods
    public abstract void createAccount(String pN,String num,String name,String add,int age);
    public abstract LinkedList browseDoctors() throws Exception;
    //mutators
    public void setName(String name){
        this.name=name;
    }
    public void setAge(int age){
        this.age=age;
    }
    public void setPhone(String phone){
        this.phone=phone;
    }
    public void setAddress(String address){
        this.address=address;
    }
    //accessors
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public String getPhone(){
        return phone;
    }
    public String getAddress(){
        return address;
    }
    public int Book (Clinic MedCare1,String docName,String day,double time,int fees) throws Exception {
        
        Booking b=new Booking(docName,day,time,this.name,fees);
        int bookNum=MedCare1.addBooking(b);
        LinkedList<Doctor> doctors;
        try (FileInputStream si = new FileInputStream("Doctors.txt"); 
        ObjectInputStream in = new ObjectInputStream(si)) {
            doctors=(LinkedList<Doctor>) in.readObject();
        }
        for(int i=0;i<doctors.size();i++){
            if(docName.equals(doctors.get(i).getName().toLowerCase())){
                String workDays[]=doctors.get(i).getWorkDays();
                Double workTime[][]=doctors.get(i).getWorkTime();
                for(int k=0;k<3;k++)
                {
                    if(workDays[k].equalsIgnoreCase(day)){
                        for(int j=0;j<10;j++)
                        {
                            if(Double.compare(workTime[k][j],time)==0)
                            {
                                workTime[k][j]=0.0;
                                return bookNum;
                            }
                        }
                    }
                }
            }
        }
        return 0;
    }
    public boolean cancelBooking(Clinic MedCare1,int num){
        return MedCare1.removeBooking(num);
    }
}
