/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import Model.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 *
 * @author SOHIL
 */
public class StfViewInquiryDetailsModel {

     Connection con = null; 
 
     public StfViewInquiryDetailsModel()
    {
        DBConnection db = new DBConnection();
       con = db.Connection();
    }
     
   public ResultSet getInstituteName(){
           ResultSet data = null;
                
           String query = "select * from institutename";
           Statement  stmt = null;
        try {
            stmt = con.createStatement();
        
              data = stmt.executeQuery(query);
        
          } catch (Exception ex) {
            System.out.println("StfViewInquiryDetailsModel" +ex);
          }
    
           
         return data;
       }
   
   
         public ResultSet getCourseName(){
           ResultSet data = null;
                
           String query = "select * from coursename";
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
