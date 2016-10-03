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
public class DirViewStudentModel {

    Connection con = null;
   public DirViewStudentModel()
    {
        DBConnection db = new DBConnection();
       con = db.Connection();
    }
   
   
    public ResultSet getStudentData(){
           ResultSet data = null;
       String query = "select si.*,st.stf_name from studentinquiry si,staff st where si.stf_id=st.stf_id";
                 
           Statement  stmt = null;
        try {
            stmt = con.createStatement();
        
              data = stmt.executeQuery(query);
        
          } catch (Exception ex) {
            System.out.println("DirViewStudentModel" +ex);
          }
            
         
        
         return data;
       }

      public ResultSet getStudentDetail(int studid){
           ResultSet data = null;
       String query = "select si.*,st.stf_name from studentinquiry si,staff st where si.stf_id=st.stf_id and si.stud_id="+studid;
                 
           Statement  stmt = null;
        try {
            stmt = con.createStatement();
        
              data = stmt.executeQuery(query);
        
          } catch (Exception ex) {
            System.out.println("DirViewStudentModel" +ex);
          }
            
         
        
         return data;
       }
}
