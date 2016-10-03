/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author ds210083
 */
public class stfViewProfile {
  Connection con = null; 
  public stfViewProfile()
  {
      DBConnection db = new DBConnection();
       con = db.Connection();
  }
  public ResultSet getProfileData(int id)
  {
           ResultSet data = null;
           String query = "select * from staff where stf_id="+id;
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
