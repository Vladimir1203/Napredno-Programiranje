/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fon.ai.maventransportappcommon.domain;

import java.io.Serializable;

/**
 *
 * @author stackOverflow
 */
public class Costs implements Serializable{
    private double driverSallary;
    private double fuel;
    private double toll;
    private double other;
    private double inTotal;

    public Costs() {
    }

    public Costs(double driverSallary, double fuel, double toll, double other, double inTotal) {
        this.driverSallary = driverSallary;
        this.fuel = fuel;
        this.toll = toll;
        this.other = other;
        this.inTotal = inTotal;
    }

    public double getInTotal() {
        return inTotal;
    }

    public void setInTotal(double inTotal) {
        this.inTotal = inTotal;
    }

    public double getDriverSallary() {
        return driverSallary;
    }

    public void setDriverSallary(double driverSallary) {
        this.driverSallary = driverSallary;
    }

    public double getFuel() {
        return fuel;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public double getToll() {
        return toll;
    }

    public void setToll(double toll) {
        this.toll = toll;
    }

    public double getOther() {
        return other;
    }

    public void setOther(double other) {
        this.other = other;
    }
    
    
}
