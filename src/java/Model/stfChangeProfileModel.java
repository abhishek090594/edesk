
package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class stfChangeProfileModel {
    String name,addr,email;
   long cont,id;
   Statement stmt = null;
    Connection con = null; 
    ResultSet rs = null;
public stfChangeProfileModel()
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

    public long getCont() {
        return cont;
    }

    public void setCont(long cont) {
        this.cont = cont;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public ResultSet checkEmailExist()
   {
           ResultSet rs1= null;              
           String query = "select stf_emailid from staff where stf_emailid='"+ email +"'";
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
     public int updateData()
      {
        try
        {
            stmt = con.createStatement();
            String query = "UPDATE staff set stf_name='"+name+"',stf_address='"+addr+"',stf_contact="+cont+",stf_emailid='"+email+"' where stf_id="+id;
            System.out.println(name);
            System.out.println(addr);
            System.out.println(cont);
            System.out.println(email);
            System.out.println(id);
            System.out.println(query);
            return stmt.executeUpdate(query);
           //   return query;
        }
        catch(Exception se)
        {
             System.out.println(se);
            // return se.toString() + "dwuhu";
            return 0;
        }
                 
        finally
        {
            try
            {
                stmt.close();
            }
            catch(Exception e){
               
            
            }
        }
    }
}
