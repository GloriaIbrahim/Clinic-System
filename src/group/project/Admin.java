/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group.project;

import java.util.LinkedList;

/**
 *
 * @author Gloria Ezzat
 */
//Creation admin's class
public class Admin {
    //attributes
    private String username;
    private String password;
    //default constructor
    public Admin(){
        this.password="";
        this.username="";
    }
    //overloaded constructor
    public Admin(String username,String password){
        this.password=password;
        this.username=username;
    }
    //mutators
    public void setUsername(String username){
        this.username=username;
    }
    public void setPassword(String password){
        this.password=password;
    }
    //accessors
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    public boolean accountValidation(String username,String password) throws Exception{
        if(this.username.equals(username)&&this.password.equals(password))
            return true;
        else
        {
            Exception exception = null;
            throw exception;
        }
        
    }
    //add a new supply object
    public void addSupply (Clinic MedCare,String name,double price,int q)
    {
        Supply s = new Supply();
        s.setName(name);
        s.setPrice(price); 
        s.setQuantity(q);
        MedCare.addSupply(s);
    }
    public void orderSupply(Clinic MedCare,String name,int num){
        //supplies.add(supply);
        Order or;
        or=new Order(name,"Admin",num);
        MedCare.newOrder(or);
    }
    public LinkedList checkOrders(Clinic MedCare){
        return MedCare.getOrders();
    }
    public float checkDoctorsPayments(){
        
        return Doctor.getPayments();
    }
    //displaying the existed supplies
    public LinkedList getSupplies(Clinic Medcare)
    {
        return Medcare.getSupplies();
    }
    public int checkRevenues(Clinic Medcare){
        return Medcare.getRevenues();
    }
    public double checkChecks(Clinic Medcare)
    {
        return Medcare.getChecks();
    }
}
