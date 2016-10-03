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
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
/**
 *
 * @author SOHIL
 */
public class StfAddInquiryFormDetailModel {
   String name,addr,email,dateOfinquiry;
   int status,inn_id,con_id,stf_id,inquirystatus;

    public int getInquirystatus() {
        return inquirystatus;
    }

    public void setInquirystatus(int inquirystatus) {
        this.inquirystatus = inquirystatus;
    }
    float perc;
   long cont;
    Statement stmt = null;
    Connection con = null; 
    ResultSet rs = null;
    Date d = new Date();
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    

       public StfAddInquiryFormDetailModel()
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public float getPerc() {
        return perc;
    }

    public void setPerc(float perc) {
        this.perc = perc;
    }

    public long getCont() {
        return cont;
    }

    public void setCont(long cont) {
        this.cont = cont;
    }

    public int getInn_id() {
        return inn_id;
    }

    public void setInn_id(int inn_id) {
        this.inn_id = inn_id;
    }

    public int getCon_id() {
        return con_id;
    }

    public void setCon_id(int con_id) {
        this.con_id = con_id;
    }

    public int getStf_id() {
        return stf_id;
    }

    public void setStf_id(int stf_id) {
        this.stf_id = stf_id;
    }

    
       public ResultSet checkEmailExist()
   {
           ResultSet rs1= null;              
           String query = "select stud_emailid from studentinquiry where stud_emailid='"+ email +"'";
           Statement  stmt = null;
        try {
            stmt = con.createStatement();
        
              rs1 = stmt.executeQuery(query);
        
          } catch (Exception ex) {
            System.out.println("StfAddInquiryFormDetailModel" +ex);
          }
        
         return rs1;
              
   }

             public int studInquiryDetailInsert()
             {
             //    String s = "s";
                 try{
                  stmt = con.createStatement();
               String query = "INSERT INTO studentinquiry(stf_id,inn_id,con_id,stud_name,stud_address,stud_contact,stud_emailid,stud_percentage,stud_status,stud_inquirystatus,stud_updateinquirydate,stud_inquirydate) VALUES("+stf_id+","+inn_id+","+con_id+",'"+name+"','"+addr+"',"+cont+",'"+email+"',"+perc+","+status+","+ inquirystatus +",'"+df.format(d)+"','"+df.format(d)+"')";
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
             
             
             
             public int studUpdateDetail(int studid)
             {
              //   String s="";
                 try{
                  stmt = con.createStatement();
               String query = "Update  studentinquiry set inn_id="+inn_id+",con_id="+con_id+",stud_name='"+name+"',stud_address='"+addr+"',stud_contact="+cont+",stud_emailid='"+email+"',stud_percentage="+perc+",stud_status="+status+",stud_updateinquirydate='"+df.format(d)+"' where stud_id="+ studid;
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
             

             
             
             
              public int studDeleteInfo(int did)
             {
           //      String s="";
                 try{
                  stmt = con.createStatement();
                  String query = "Delete from studentinquiry where stud_id="+ did;
                  return stmt.executeUpdate(query);
               
                   //  return "True";
                }
                 catch(Exception se)
                 {
               //    s = se.toString();
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

             
             
            public ResultSet getStudentData(int stfid){
         
                ResultSet data = null;
          // String stf_id = String.valueOf(sobj.getAttribute("Stf_id_is_logged_in"));
   
           String query = "select * from studentinquiry where stf_id="+ stfid ;
           Statement  stmt = null;
        try {
            stmt = con.createStatement();
        
              data = stmt.executeQuery(query);
        
          } catch (Exception ex) {
            System.out.println("StfAddInquiryFormDetailModel" +ex);
          }
            
         
        
         return data;
       }

            
            
      public ResultSet getStudentDetail(int studid){
         
                ResultSet data = null;
          // String stf_id = String.valueOf(sobj.getAttribute("Stf_id_is_logged_in"));
            String query = "select s.stud_id,s.stud_name,s.inn_id,s.con_id,i.inn_name,c.con_name,s.stud_address,s.stud_contact,s.stud_emailid,s.stud_percentage,s.stud_status from studentinquiry s,institutename i,coursename c where s.inn_id=i.inn_id and s.con_id=c.con_id and s.stud_id="+ studid ;           
    //            String query = "select * from studentinquiry where stud_id="+ studid ;
           Statement  stmt = null;
        try {
            stmt = con.createStatement();
        
              data = stmt.executeQuery(query);
        
          } catch (Exception ex) {
            System.out.println("StfAddInquiryFormDetailModel" +ex);
          }
            
         
        
         return data;
       }

      
      public ResultSet getStaffId(int phid)
      {
                ResultSet data = null;
          // String stf_id = String.valueOf(sobj.getAttribute("Stf_id_is_logged_in"));
            String query = "select stf_id from panelhead where ph_id="+ phid;           
    //            String query = "select * from studentinquiry where stud_id="+ studid ;
           Statement  stmt = null;
        try {
            stmt = con.createStatement();
        
              data = stmt.executeQuery(query);
        
          } catch (Exception ex) {
            System.out.println("phAddInquiryFormDetailModel" +ex);
          }
            
         
        
         return data;
      
      }
  
    }

