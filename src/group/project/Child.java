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
public class Child extends Patient  implements Serializable{
    //attribute
    private String parentName; 

    @Override
    public String toString() {
        return "Child " + "Parent Name " + parentName + "\nPhone "+ this.getPhone()+"\nChild Name "+ this.getName()+"\nAddress "+this.getAddress()+"\nAge "+this.getAge();
    }
    //constructor
    public void Child(){
       this.parentName="";
    }
    //mutator
    public void setParentName(String parentName){
       this.parentName=parentName;
    }
    //accessor
    public String getParentName(){
       return parentName;
    }
    @Override
    public void createAccount(String pN,String num,String name,String add,int age) {
            this.parentName=pN;
            this.setPhone(num);
            this.setName(name);
            this.setAddress(add);
            this.setAge(age);
    }

    @Override
    public LinkedList browseDoctors()  throws Exception{
        LinkedList<Doctor> doctors;
        LinkedList<Doctor> childrenDoctors=new LinkedList<Doctor>();
        try (FileInputStream si = new FileInputStream("Doctors.txt"); 
        ObjectInputStream in = new ObjectInputStream(si)) {
            doctors=(LinkedList<Doctor>) in.readObject();
        }
        for(int i=0;i<doctors.size();i++){
            if("Pediatrician".equals(doctors.get(i).getDescription())){
                childrenDoctors.add(doctors.get(i));
            }
        }
        return childrenDoctors;
    }

}
