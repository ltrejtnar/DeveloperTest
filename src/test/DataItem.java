/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author Ladislav Trejtnar
 */
public class DataItem {
 private String country;
 private int year;
 private Quater quater;
 private String vendor;
 private double units;

    public DataItem(String country, int year, Quater quater, String vendor, double units) {
        this.country = country;
        this.year = year;
        this.quater = quater;
        this.vendor = vendor;
        this.units = units;
    }


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Quater getQuater() {
        return quater;
    }

    public void setQuater(Quater quater) {
        this.quater = quater;
    }


    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public double getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    @Override
    public String toString() {
        return "DataItem{" + "country=" + country + ", date=" + year + ", vendor=" + vendor + ", units=" + units + '}';
    }
    
    
}
