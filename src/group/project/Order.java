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
public class Order implements Serializable{
    private String supplyName;
    private String doctorName;
    private int quantity;

    @Override
    public String toString() {
        return "Order: " + "\nSupply Name " + supplyName + "\nOrdered By " + doctorName + "\nQuantity=" + quantity+"\n";
    }

    public Order(String supplyName, String doctorName, int quantity) {
        this.supplyName = supplyName;
        this.doctorName = doctorName;
        this.quantity = quantity;
    }

    public Order() {
    }
    
    public String getSupplyName() {
        return supplyName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setSupplyName(String supplyName) {
        this.supplyName = supplyName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
}
