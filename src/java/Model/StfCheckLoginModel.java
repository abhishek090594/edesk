/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import Model.DBConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author SOHIL
 */
public class StfCheckLoginModel {
   Connection con = null; 
   ResultSet rs = null;
   String email,password;
     public StfCheckLoginModel()
    {
        DBConnection db = new DBConnection();
       con = db.Connection();
    }

    

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
     
     public ResultSet checkForLogin()
     {
         try{
            String query = "select * from staff where stf_emailid='"+ email +"' and stf_password='" + password +"' and stf_status=0 limit 1";
            Statement stmt = con.createStatement();
             rs = stmt.executeQuery(query);
            }   
            catch(SQLException e){
                 System.out.println("StfCheckLoginModel" +e);           
            }
            return rs;
    
     }
     
     
     
}
