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
 * @author SOHIL
 */
public class phPanelHeadMembers {

   Connection con = null; 
   ResultSet rs = null;
   String email,password;
     public phPanelHeadMembers()
    {
        DBConnection db = new DBConnection();
       con = db.Connection();
    }
     
      public ResultSet getListForPanelHeadMembers(int pmid)
    {
        
          ResultSet data = null;
         String query = "select st.stf_name,st.stf_emailid,st.stf_contact from staff st,panelmembers pm where pm.stf_id=st.stf_id and pm.ph_id=" + pmid;
         Statement  stmt = null;
        try {
            stmt = con.createStatement();
        
              data = stmt.executeQuery(query);
        
          } catch (Exception ex) {
            System.out.println("StfAddInquiryFormDetailModel" +ex);
      
            }
        return data;
    }




 public ResultSet getListOfStudentListUnderPanelHead(int pmid)
    {
        
          ResultSet data = null;
 //        String query = "select si.* from studentinquiry as si,staff as stf where stf.stf_id=si.stf_id and stf.stf_id IN(select stf_id from panelmembers where ph_id="+ pmid +") and stf.stf_id IN(select stf_id from panelhead where ph_id="+ pmid +")";
       String query = "select * from studentinquiry as si,staff as stf where stf.stf_id=si.stf_id and stf.stf_id IN(select stf_id from panelhead where ph_id="+ pmid +")";          
         Statement  stmt = null;
        try {
            stmt = con.createStatement();
        
              data = stmt.executeQuery(query);
        
          } catch (Exception ex) {
            System.out.println("getListOfStudentListUnderPanelHead" +ex);
      
            }
        return data;
    }





}
