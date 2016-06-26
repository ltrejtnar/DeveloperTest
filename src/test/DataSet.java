/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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

    public String getRows(String vendor) {
        String s = "";
        int row = 1;
        for (DataItem dataItem : list) {
            if (dataItem.getVendor().toLowerCase().equals(vendor.toLowerCase())) {

                s = s + row + ",";
            }
            row++;
        }
        return s;
    }

    public void sortAlpha() {
        Collections.sort(list, new Comparator<DataItem>() {
            @Override
            public int compare(DataItem i2, DataItem i1) {
                return i2.getVendor().toLowerCase().compareTo(i1.getVendor().toLowerCase());

            }
        });

    }
    
    public void sortByValues() {
        Collections.sort(list, new Comparator<DataItem>() {
            @Override
            public int compare(DataItem i2, DataItem i1) {
                return Double.compare(i2.getUnits(), i1.getUnits());

            }
        });

    }

    public void sortAlpha(ArrayList<DataItem> i) {
        Collections.sort(i, new Comparator<DataItem>() {
            @Override
            public int compare(DataItem i2, DataItem i1) {
                return i2.getVendor().toLowerCase().compareTo(i1.getVendor().toLowerCase());

            }
        });
    }

    public ArrayList<DataItem> tableOfQuater(Quater q) {
        ArrayList<DataItem> listOfQuater = new ArrayList<>();
        for (DataItem dataItem : list) {
            if (dataItem.getQuater().equals(q)) {
                listOfQuater.add(dataItem);
            }
        }
        return listOfQuater;
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
