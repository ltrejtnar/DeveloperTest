/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.ArrayList;

/**
 *
 * @author Nudista
 */
public class DataSet {

    private ArrayList<DataItem> list;
    private double sumUnits;
    private double sumUnitsQuater;

    public DataSet() {
        list = new ArrayList<>();
    }

    private void sumUnits() {
        double count = 0;
        for (DataItem dataItem : list) {
            count = count + dataItem.getUnits();
        }
        sumUnits = count;
    }

    private void sumUnitsQuater(Quater q) {
        double count = 0;
        for (DataItem dataItem : list) {
                       if (dataItem.getQuater().equals(q)) {
                count = count + dataItem.getUnits();
            }

        }
        sumUnitsQuater = count;
    }

    public double getShare(String Vendor) {
        double num = 0;
        sumUnits();
        for (DataItem dataItem : list) {
            if (dataItem.getVendor().toLowerCase().contains(Vendor.toLowerCase())) {
                num = num + dataItem.getUnits();
            }
        }
        return num / sumUnits * 100;

    }

    public double getShareQuater(String Vendor, Quater q) {
        sumUnitsQuater(q);

        double num = 0;
        for (DataItem dataItem : list) {
            if ((dataItem.getVendor().toLowerCase().contains(Vendor.toLowerCase())) && dataItem.getQuater().equals(q)) {
                num = num + dataItem.getUnits();
            }
        }
        return num / sumUnitsQuater * 100;

    }

    public void add(DataItem i) {
        list.add(i);
        sumUnits();
    }

    public ArrayList<DataItem> getList() {
        return list;
    }

    public void setList(ArrayList<DataItem> list) {
        this.list = list;
    }

}
