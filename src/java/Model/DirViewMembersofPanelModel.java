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
public class DirViewMembersofPanelModel {
    Connection con = null; 
    Statement stmt = null;
     public DirViewMembersofPanelModel()
    {
        DBConnection db = new DBConnection();
       con = db.Connection();
    }

      public ResultSet getMembersListofPanel(int pid){
           ResultSet data = null;
                
           String query = "select s.*,p.* from staff s,panelmembers p where p.stf_id=s.stf_id and p.ph_id="+ pid;
           Statement  stmt = null;
        try {
            stmt = con.createStatement();
        
              data = stmt.executeQuery(query);
        
          } catch (Exception ex) {
            System.out.println("DirViewStaffModel" +ex);
          }
            
         
        
         return data;
       }
      
      
      
        public int DeleteMemberFromPanelHead(int Staffid)
             {
                 try{
                     
        
                  stmt = con.createStatement();
               String query = "Delete from panelmembers where stf_id="+ Staffid;
              return  stmt.executeUpdate(query);
             //  return "True";
             }
                 catch(Exception se)
                 {
                     return 0;
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
