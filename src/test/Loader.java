/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.opencsv.CSVReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ladislav Trejtnar
 */
public class Loader {

    private String path;
    private CSVReader reader;
    private final char CSVSPLIT = ',';

    public Loader(String path) {

        this.path = path;

    }

   
    public void load(DataSet s, int year, Quater q, String country) {
        DataItem i;
        String[] lineArray;

        String quater = "";
        try {
            reader = new CSVReader(new FileReader(path), CSVSPLIT);

            while ((lineArray = reader.readNext()) != null) {
                if (lineArray[1].length() == 7) {
                    quater = lineArray[1].substring(5);
                    lineArray[1] = lineArray[1].substring(0, 4);
                }
                if (this.isNumeric(lineArray[1]) && this.isNumeric(lineArray[3])) {
                    if ((lineArray[0].toLowerCase().equals(country.toLowerCase())) && (year == Integer.parseInt(lineArray[1])) && (Quater.valueOf(quater).equals(q))) {
                        i = new DataItem(lineArray[0], Integer.parseInt(lineArray[1]), Quater.valueOf(quater), lineArray[2], Double.parseDouble(lineArray[3]));
                        s.add(i);
                    }
                }
            }

        } catch (FileNotFoundException ex) {
            System.err.println("File not found");
        } catch (IOException ex) {
            Logger.getLogger(Loader.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private boolean isNumeric(String s) {
        boolean ret = true;
        try {
            Double.parseDouble(s);

        } catch (NumberFormatException e) {
            ret = false;
        }
        return ret;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

}
