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
//Creation of supply's class
public class Supply implements Serializable {
    //attributes
    private String name;
    private double price;
    private int quantity;
    private static int count;
    //default constructor
    public Supply (){
        this.name="";
        this.price=0;
        this.quantity=0;
        count+=quantity;
    }
    //overloaded contructor
    public Supply (String name,double price,int quantity){
        this.name=name;
        this.price=price;
        this.quantity=quantity;
        count+=quantity;
    }

    @Override
    public String toString() {
        return "Supply " + "Name " + name + "\nPrice " + price + "\nQuantity " + quantity+"\n";
    }
    //mutators
    public void setName(String name)
    {
        this.name=name;
    }
    public void setPrice(double price)
    {
        this.price=price;
    }
    public void setQuantity(int quantity)
    {
        this.quantity=quantity;
    }
    //accessors
    public String getName()
    {
        return name;
    }
    public double getPrice()
    {
        return price;
    }
    public int getQuantity()
    {
        return quantity;
    }
    //accessing counter
    public static int suppliesCount()
    {
        return count;
    }
}
