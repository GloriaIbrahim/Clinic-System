/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group.project;
import java.io.Serializable;
import java.util.Arrays;
import java.util.LinkedHashSet;
/**
 *
 * @author Gloria Ezzat
 */
//Creation of doctor's class
public abstract class Doctor implements Serializable {
    //attributes
    private String name;
    private String phone;
    private String[] workDays=new String[3];
    private Double[][] workTime=new Double[3][10];
    private int fees;
    private float salary;
    private String appointment;
    private static LinkedHashSet<String> supplies= new LinkedHashSet<String>();
    private static float totalPayments;
    @Override
    public String toString() {
        return "\nDoctor " + "Name " + name + "\nPhone " + phone + "\nWorkDays " + Arrays.toString(workDays) + "\nFees " + fees + "\nSalary " + salary +"\n"+ appointment;
    }
    //overloaded constructor
    public Doctor (String name,  String phone , int fees , float salary)
    {
        this.name=name;
        this.phone=phone;
        this.fees=fees;
        this.salary=salary;
    }
    //abstract function
    public abstract String getDescription();
    //order new supply method
    public void orderSupply(Clinic MedCare,String name,int num){
        //supplies.add(supply);
        Order or;
        or=new Order(name,this.name,num);
        MedCare.newOrder(or);
    }
    //get all ordered supplies from all doctors
    public static LinkedHashSet<String> getSupplies(){
        return supplies;
    }
    //setting each doctor's times
    public void setWorkTime(Double workTime0,Double workTime1,Double workTime2){
        workTime[0][0]=workTime0;
        workTime[1][0]=workTime1;
        workTime[2][0]=workTime2;
        for(int i=0;i<3;i++){
            for(int j=1;j<10;j++){
                workTime[i][j]=(workTime[i][j-1]+0.5);
                if(workTime[i][j]>=13.0)
                    workTime[i][j]=workTime[i][j]-12.0;
            }
        }
    }
    //setting each doctor's days
    public void setWorkDays(String day0,String day1,String day2){
        workDays[0]=day0;
        workDays[1]=day1;
        workDays[2]=day2;
    }
    //a method that returns each doctor's calendar
    public String browseSchedule(){
        String calendar="";
        for(int i=0;i<3;i++)
        {
            if(workDays[i].length()<8)
                calendar+=workDays[i]+"\t\t";
            else
                calendar+=workDays[i]+"\t";
            for(int j=0;j<10;j++)
            {
                calendar+=workTime[i][j]+"\t";
            }
            calendar+="\n";
        }
        return calendar;
    }
    //a method that modify the time chosen by the doctor
    public void updateSchedule(int day,int time,double newTime){
        workTime[day-1][time-1]= newTime;
    }
    //mutators
    public void setAppointment(String a)
    {
        appointment=a;
    }
    public void setName(String n)
    {
        name=n;
    }
    public void setPhone (String p)
    {
        phone=p;
    }
    public void setFees(int F)
    {
         fees=F;
    }

    public String[] getWorkDays() {
        return workDays;
    }

    public Double[][] getWorkTime() {
        return workTime;
    }
    public void setSalary(float S)
    {
        salary=S;
    } 
    public static void setPayments(float payment){
        Doctor.totalPayments+=payment;
    }
    //accessors
    public String getAppointment()
    {
        return appointment;
    }
    public String getName ()
    {
        return name;
    }
     public String getPhone ()
    {
        return phone;
    }
    public int getFees ()
    {
        return fees;
        
    }
    public float getSalary ()
    {
        return salary;        
    }
    public static float getPayments(){
        return totalPayments;
    }
}
 