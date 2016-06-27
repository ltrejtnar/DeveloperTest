/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ladislav Trejtnar
 */
public class Saver {

    private String path;
    private FileWriter fWriter;
    private BufferedWriter writer;

    public Saver(String path) {
        this.path = path;
    }

    private String writeHead(String charset,String title) {
        return "<html>\n"
                + "    <head>\n"
                + "        <title>"+title+"</title>\n"
                + "        <meta charset=\"" + charset + "\">\n"
                + "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                + "    </head>\n";
    }

    public void writeHTML(DataSet ds, String table) {

        try {
            fWriter = new FileWriter(path);
            writer = new BufferedWriter(fWriter);
            writer.write(writeHead("UTF-8","DeveloperTest table"));
            writer.write("<body>");
            writer.newLine();
            writer.write("<table border=\"1\">");
            writer.write("<caption>"+table+"</caption>");
            writer.write("<tr><td><b>Vendor</b></td><td><b>Units</b></td><td><b>Share</b></td></tr>");
            for (DataItem di : ds.getList()) {
                writer.write("<tr><td>"+di.getVendor()+"</td><td>"+di.getUnits()+"</td><td>"+ds.getShare(di.getVendor())[1]+"%</td></tr>");
            }
             writer.write("<tr><td><b>Total</b></td><td><b>"+ds.getSumUnits()+"</b></td><td><b>100%</b></td></tr>");
            writer.write("</table>");
            writer.newLine();
            writer.write("</body></html>");

            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(Saver.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void witeToSCV(){
        /*
        *To do code. To write each DataItem in DataSet, just change path to .csv, declare csv separator, toString in DataItem could be also used to define format of each DataItem
        *
        */
    }
    
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

}
