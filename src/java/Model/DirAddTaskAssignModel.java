/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import Model.DBConnection;
import java.sql.Connection;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author SOHIL
 */
public class DirAddTaskAssignModel {
     Connection con = null; 
     Statement stmt = null;
     String stdate,enddate;
     String desc;
     int panel_id;
     Date d = new Date();
     SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
  public DirAddTaskAssignModel()
    {
        DBConnection db = new DBConnection();
       con = db.Connection();
    }

    public int getPanel_id() {
        return panel_id;
    }

    public void setPanel_id(int panel_id) {
        this.panel_id = panel_id;
    }

  
    public String getStdate() {
        return stdate;
    }

    public void setStdate(String stdate) {
        this.stdate = stdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    
    
       public int assignTaskInsert()
             {
             //    String s = "s";
                 try{
                  stmt = con.createStatement();
                
               String query = "insert into taskassign(ph_id,taskAssign_startdate,taskAssign_enddate,taskAssign_description,taskAssign_date) values("+ panel_id +",'"+ stdate +"','"+ enddate +"','"+ desc +"','"+df.format(d)+"')";
            return  stmt.executeUpdate(query);
               // return query;
                    //  return "True";
         //      s += " no";
                }
                 catch(Exception se)
                 {
                     return 0;
               //       s += se.toString();
                 }
                 
                 finally{
                     try{
                  stmt.close();
                     }
                     catch(Exception e){
                         
                     }
                 }
                
             }
             
             
}
