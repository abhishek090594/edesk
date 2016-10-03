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
public class stfChangePwdModel {
  String pwd,email;
     Statement stmt = null;
    Connection con = null; 
    ResultSet rs = null;
public stfChangePwdModel()
{
    DBConnection db = new DBConnection();
        con = db.Connection();
}

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public ResultSet chkOldPwd()
    {
        ResultSet rs1= null;              
        String query = "select stf_password from staff where stf_emailid='"+ email +"' and stf_password='"+pwd+"' ";
        Statement  stmt = null;
        try 
        {
            stmt = con.createStatement();
            rs1 = stmt.executeQuery(query);

        }
        catch (Exception ex) 
        {
            System.out.println("StfAddInquiryFormDetailModel" +ex);
        }
        
        return rs1;
    }
    public int updatePwd()
    {
        try
        {
            stmt = con.createStatement();
            String qry2 = "UPDATE staff set stf_password='"+pwd+"' where stf_emailid='"+ email +"'";
            return  stmt.executeUpdate(qry2);
        }
        catch(Exception se)
        {
            return 0;
        }
                 
        finally
        {
            try
            {
                stmt.close();
            }
            catch(Exception e){}
        }
    }
    
    
    
}
