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
public class Main {

    static Loader l = new Loader("data.csv");
    static Saver s = new Saver("table.html");
    static DataSet ds = new DataSet();

    public static void main(String[] args) {
        String country = "Czech Republic";
        Quater q = Quater.Q3;
        int year = 2010;
        String vendor = "acer";

        //l.loadAll(ds);
        
        
               
        l.load(ds, year, q, country);
         System.out.println("Data about " + vendor + " units are on the line " + ds.getRow(vendor));



        // ds.sortAlpha();
        // ds.sortByValues();
        
        System.out.println(ds.getShare(vendor)[0] + " units, " + ds.getShare(vendor)[1] + " percent for " + vendor);

        s.writeHTML(ds, country + " " + q.toString());
    }

}
