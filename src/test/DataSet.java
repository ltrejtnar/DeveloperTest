/*
 * Class for representation sets of Vendors
 */
package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Ladislav Trejtnar
 */
public class DataSet {

    private ArrayList<DataItem> list;
    private double sumUnits;

    public DataSet() {
        list = new ArrayList<>();
    }

    /*
 * Count sum of units in dataset
     */
    private void sumUnits() {
        double count = 0;
        for (DataItem dataItem : list) {
            count = count + dataItem.getUnits();
        }
        sumUnits = count;
    }

    /*
 * return row number for data on vendor, exclude head of table
     */
    public int getRow(String vendor) {

        int row = 1;
        for (DataItem dataItem : list) {
            if (dataItem.getVendor().toLowerCase().equals(vendor.toLowerCase())) {

                break;
            }
            row++;
        }
        return row;
    }

    /*
 * Sort the rows alphabetically (by vendor)
     */
    public void sortAlpha() {
        Collections.sort(list, new Comparator<DataItem>() {
            @Override
            public int compare(DataItem i2, DataItem i1) {
                return i2.getVendor().toLowerCase().compareTo(i1.getVendor().toLowerCase());

            }
        });

    }

    /*
 * Sort the rows by unit values.
     */
    public void sortByValues() {
        Collections.sort(list, new Comparator<DataItem>() {
            @Override
            public int compare(DataItem i2, DataItem i1) {
                return Double.compare(i2.getUnits(), i1.getUnits());

            }
        });

    }

    /*
 * return array of shade for Vendor, first value is in units, second one gives percentage share
     */
    public double[] getShare(String Vendor) {
        double[] num = new double[2];
        sumUnits();
        for (DataItem dataItem : list) {
            if (dataItem.getVendor().toLowerCase().contains(Vendor.toLowerCase())) {
                num[0] = num[0] + dataItem.getUnits();
            }
        }
        num[1] = num[0] / sumUnits * 100;
        num[1] = num[1] * 100;
        num[1] = Math.round(num[1]);
        num[1] = num[1] / 100;
        return num;
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

    public double getSumUnits() {
        return sumUnits;
    }

    public void setSumUnits(double sumUnits) {
        this.sumUnits = sumUnits;
    }

}
