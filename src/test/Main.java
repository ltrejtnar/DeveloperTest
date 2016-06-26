/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author Nudista
 */
public class Main {
   static Loader l = new Loader("data.csv");
   static DataSet ds = new DataSet();
    
    public static void main(String[] args) {
l.load(ds);
ds.sortByValues();
        for (DataItem arg : ds.getList()) {
            System.out.println(arg);
        }
        System.out.println(ds.getRows("asus"));
    }
 
}
