/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group.project;

/**
 *
 * @author Gloria Ezzat
 */
public class Gynecologist extends Doctor {
    //overladed constructor that calls the constructor of the base class
    private String description;
    public Gynecologist(String name, String phone, int fees, float salary,String description) {
        super(name, phone, fees, salary);   
        this.description=description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getDescription() {
        return this.description;
    }
}
