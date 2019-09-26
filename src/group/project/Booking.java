/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group.project;

import java.io.Serializable;

/**
 *
 * @author Gloria Ezzat
 */
//Creation of booking's class
public class Booking implements Serializable {
    //attributes
    private String doctor;
    private Double time;
    private String day;
    private String patientName;
    private int revenue;
    //constructor
    public Booking(String doctor,String day,Double time,String patientName,int revenue) {
        this.day=day;
        this.doctor=doctor;
        this.time=time;
        this.patientName=patientName;
        this.revenue=revenue;
    }

    
    
    @Override
    public String toString() {
        return "Booking: " + "\nDoctor " + doctor + "\nTime " + time + "\nDay " + day + "\nPatient Name " + patientName+"\n";
    }
    //mutators
    public void setRevenues(int revenue){
        this.revenue=revenue;
    }
    public void setDoctor(String doctor){
        this.doctor=doctor;
    }
    public void setDay(String day){
        this.day=day;
    }
    public void setTime(double time){
        this.time=time;
    }
    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    //accessors
    public int getRevenue(){
        return revenue;
    }
    public String getDoctor(){
        return doctor;
    }
    public String getDay(){
        return day;
    }
    public double getTime(){
        return time;
    }
    public String getPatientName() {
        return patientName;
    }

}
