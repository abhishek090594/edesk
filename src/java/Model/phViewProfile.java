/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class phViewProfile 
{
       Connection con = null; 
 
     public phViewProfile()
    {
        DBConnection db = new DBConnection();
       con = db.Connection();
    }
     
   public ResultSet getProfileData(int id){
           ResultSet data = null;
           String query = "select s.stf_id,s.stf_name,s.stf_contact,s.stf_emailid,s.stf_address,ph.ph_id from staff s,panelhead ph where  ph.stf_id=s.stf_id and ph.ph_id="+id;
           Statement  stmt = null;
        try {
            stmt = con.createStatement();
        
              data = stmt.executeQuery(query);
        
          } catch (Exception ex) {
            System.out.println("StfViewInquiryDetailsModel" +ex);
          }
    
           
         return data;
       }
   
   
     
}
