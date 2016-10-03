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
public class DirAddPanelHeadModel {
 
     Connection con = null; 
     Statement stmt = null;
     String stfName;
     int stfId,phid;

         public DirAddPanelHeadModel()
    {
        DBConnection db = new DBConnection();
       con = db.Connection();
    }

    public int getPhid() {
        return phid;
    }

    public void setPhid(int phid) {
        this.phid = phid;
    }

    public String getStfName() {
        return stfName;
    }

    public void setStfName(String stfName) {
        this.stfName = stfName;
    }

    public int getStfId() {
        return stfId;
    }

    public void setStfId(int stfId) {
        this.stfId = stfId;
    }
    
    
       public int panelHeadInsert()
             {
             //    String s = "s";
                 try{
                  stmt = con.createStatement();
               String query = "INSERT INTO panelhead(ph_name,stf_id) VALUES('"+stfName+"',"+ stfId +")";
                return  stmt.executeUpdate(query);
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
    
    

       
              public int assignStaffInsert()
             {
             //    String s = "s";
                 try{
                  stmt = con.createStatement();
               String query = "INSERT INTO panelmembers(ph_id,stf_id) VALUES('"+ phid +"',"+ stfId +")";
                return  stmt.executeUpdate(query);
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
    

       
       
    public ResultSet getDataForPanelHeadCreation(int stfid)
    {
        
          ResultSet data = null;
         String query = "select stf_id,stf_name from staff where stf_id="+ stfid ;
         Statement  stmt = null;
        try {
            stmt = con.createStatement();
        
              data = stmt.executeQuery(query);
        
          } catch (Exception ex) {
            System.out.println("StfAddInquiryFormDetailModel" +ex);
      
            }
        return data;
    }






     public int updateStaffStatus()
             {
              //   String s="";
                 try{
                  stmt = con.createStatement();
               String query = "Update  staff set stf_status="+1+" where stf_id="+ stfId ;
              return stmt.executeUpdate(query);
               
                   //  return "True";
                }
                 catch(Exception se)
                 {
               //      s = se.toString();
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
             
     
       public ResultSet getPanelHeadDataOfStaff(){
           ResultSet data = null;
                
           String query = "select ph_id,ph_name from panelHead";
           Statement  stmt = null;
        try {
            stmt = con.createStatement();
        
              data = stmt.executeQuery(query);
        
          } catch (Exception ex) {
            System.out.println("DirViewStaffModel" +ex);
          }
            
         
        
         return data;
       }
     
      public ResultSet getMemberDataOfStaff(){
           ResultSet data = null;
                
           String query = "select s.* from staff s LEFT JOIN panelmembers p ON p.stf_id=s.stf_id  where s.stf_status=0 and p.stf_id IS NULL";
           Statement  stmt = null;
        try {
            stmt = con.createStatement();
        
              data = stmt.executeQuery(query);
        
          } catch (Exception ex) {
            System.out.println("DirViewStaffModel" +ex);
          }
            
         
        
         return data;
       }

      
 


}