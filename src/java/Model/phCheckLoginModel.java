/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author SOHIL
 */
public class phCheckLoginModel {
    
        String email,password;
 Connection con = null; 
 ResultSet rs = null;
    public phCheckLoginModel()
    {
        DBConnection db = new DBConnection();
       con = db.Connection();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
     public ResultSet phcheckForLogin()
     {
         try{
            String query = "select s.stf_emailid,ph.ph_id from staff s,panelhead ph where s.stf_emailid='"+ email +"' and s.stf_password='" + password +"' and s.stf_status=1 and ph.stf_id=s.stf_id limit 1";
            Statement stmt = con.createStatement();
             rs = stmt.executeQuery(query);
            }   
            catch(SQLException e){
                 System.out.println("StfCheckLoginModel" +e);           
            }
            return rs;
    
     }
}
