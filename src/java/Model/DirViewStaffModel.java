/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import Model.DBConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author SOHIL
 */
public class DirViewStaffModel {
    String name,addr,email,pwd,image,dateOfjoin;
    int status = 0;
    long cont;
     Statement stmt = null;
     Connection con = null; 
     ResultSet rs = null;
    Date d = new Date();
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    
    public DirViewStaffModel()
    {
        DBConnection db = new DBConnection();
       con = db.Connection();
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public long getCont() {
        return cont;
    }

    public void setCont(long cont) {
        this.cont = cont;
    }

    public String getDateOfjoin() {
        return dateOfjoin;
    }

    public void setDateOfjoin(String dateOfjoin) {
        this.dateOfjoin = dateOfjoin;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
   public ResultSet checkEmailExist()
   {
           ResultSet rs1= null;              
           String query = "select stf_emailid from staff where stf_emailid='"+ email +"'";
           Statement  stmt = null;
        try {
            stmt = con.createStatement();
        
              rs1 = stmt.executeQuery(query);
        
          } catch (Exception ex) {
            System.out.println("DirViewStaffModel" +ex);
          }
        
         return rs1;
              
   }
      public int staffInsert()
             {
                 try{
                     
        
                  stmt = con.createStatement();
               String query = "Insert into staff(stf_name,stf_address,stf_contact,stf_emailid,stf_image,stf_password,stf_status,stf_dateofjoin) values('"+name+"','"+addr+"',"+cont+",'"+email+"','"+image+"','"+pwd+"',"+status+",'"+df.format(d)+"')";
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
      
       public ResultSet getStaafData(){
           ResultSet data = null;
       String query = "select s.* from staff s LEFT JOIN panelmembers p ON p.stf_id=s.stf_id  where s.stf_status=0 and p.stf_id IS NULL";
                 
        //   String query = "select * from staff where stf_status="+ 0;
           Statement  stmt = null;
        try {
            stmt = con.createStatement();
        
              data = stmt.executeQuery(query);
        
          } catch (Exception ex) {
            System.out.println("DirViewStaffModel" +ex);
          }
            
         
        
         return data;
       }

       
              public ResultSet getPanelHeadData(){
           ResultSet data = null;
                
           String query = "select * from panelhead";
           Statement  stmt = null;
        try {
            stmt = con.createStatement();
        
              data = stmt.executeQuery(query);
        
          } catch (Exception ex) {
            System.out.println("DirViewStaffModel" +ex);
          }
            
         
        
         return data;
       }
              
              
             public int DeletePanelHead(int panelHeadid)
             {
                 try{
                     
        
                  stmt = con.createStatement();
               String query = "Delete from panelhead where ph_id="+ panelHeadid;
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
             
             
             
             
      public int UpdateStaff(int panelHeadid)
             {
                 try{
                     
        
                  stmt = con.createStatement();
               String query = "Update staff s,panelhead ph set s.stf_status=0,s.stf_dateofjoin='"+df.format(d)+"' where s.stf_id=ph.stf_id and ph.ph_id="+ panelHeadid;
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
             
             
  public int DeleteMembersOfPanelHead(int panelHeadid)
        {
                 try{
             stmt = con.createStatement();
             String query = "Delete from panelmembers where ph_id="+ panelHeadid;
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

  
    public ResultSet getStaffDetailData(int vid)
        {
          ResultSet data = null;
                
           String query = "select * from staff where stf_id="+vid;
           Statement  stmt = null;
        try {
            stmt = con.createStatement();
        
              data = stmt.executeQuery(query);
        
          } catch (Exception ex) {
            System.out.println("DirViewStaffModel" +ex);
          }
            
         
        
         return data;

                 
        }       
             
             
  public int DeleteStaffDetailData(int did)
        {
                 try{
             stmt = con.createStatement();
             String query = "Delete from staff where stf_id="+ did;
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
