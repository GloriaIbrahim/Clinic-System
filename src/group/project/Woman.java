/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group.project;
import java.io.*;
import java.util.LinkedList;
/**
 *
 * @author Gloria Ezzat
 */
public class Woman extends Patient implements Serializable{
    //attribute
    private String status; 
    //constructor
    public void Woman()
    {
        this.status="";
    }

    @Override
    public String toString() {
        return "Woman "+"Name " + this.getName() + "\nAge " + this.getAge() + "\nPhone " + this.getPhone() + "\nAddress " + this.getAddress() + "\nStatus " + status;
    }
    //mutator
    public void setStatus(String status){
        this.status=status;
    }
    //accessor
    public String getStatus(){
        return status;
    }

    @Override
    public void createAccount(String status,String num,String name,String add,int age) {
            this.setName(name);
            this.setAddress(add);
            this.setPhone(num);
            this.status=status;
            this.setAge(age);
    }

    @Override
    public LinkedList browseDoctors()  throws Exception{
        LinkedList<Doctor> doctors;
        LinkedList<Doctor> womenDoctors=new LinkedList<Doctor>();
        try (FileInputStream si = new FileInputStream("Doctors.txt"); 
        ObjectInputStream in = new ObjectInputStream(si)) {
            doctors=(LinkedList<Doctor>) in.readObject();
        }
        for(int i=0;i<doctors.size();i++){
            if("Gynecologist".equals(doctors.get(i).getDescription())){
                womenDoctors.add(doctors.get(i));
            }
        }
        return womenDoctors;
    }
    
}
