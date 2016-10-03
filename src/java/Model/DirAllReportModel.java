/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.sql.*;
import Model.DBConnection;
/**
 *
 * @author admin
 */
public class DirAllReportModel {
    String sdate,edate;
    ResultSet rs1,rs2,rs3,stfRs1,stfRs2,stfRs3,phRs1,phRs2,phRs3,clgRs1,clgRs2,clgRs3;

    public ResultSet getClgRs2() {
        return clgRs2;
    }

    public void setClgRs2(ResultSet clgRs2) {
        this.clgRs2 = clgRs2;
    }

    public ResultSet getClgRs3() {
        return clgRs3;
    }

    public void setClgRs3(ResultSet clgRs3) {
        this.clgRs3 = clgRs3;
    }

    

    public ResultSet getClgRs1() {
        return clgRs1;
    }

    public void setClgRs1(ResultSet clgRs1) {
        this.clgRs1 = clgRs1;
    }


    public ResultSet getStfRs1() {
        return stfRs1;
    }

    public void setStfRs1(ResultSet stfRs1) {
        this.stfRs1 = stfRs1;
    }

    public ResultSet getStfRs2() {
        return stfRs2;
    }

    public void setStfRs2(ResultSet stfRs2) {
        this.stfRs2 = stfRs2;
    }

    public ResultSet getStfRs3() {
        return stfRs3;
    }

    public void setStfRs3(ResultSet stfRs3) {
        this.stfRs3 = stfRs3;
    }

    public ResultSet getPhRs1() {
        return phRs1;
    }

    public void setPhRs1(ResultSet phRs1) {
        this.phRs1 = phRs1;
    }

    public ResultSet getPhRs2() {
        return phRs2;
    }

    public void setPhRs2(ResultSet phRs2) {
        this.phRs2 = phRs2;
    }

    public ResultSet getPhRs3() {
        return phRs3;
    }

    public void setPhRs3(ResultSet phRs3) {
        this.phRs3 = phRs3;
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }
    int pid,sid,clgid;
 Connection con = null; 
 ResultSet rs = null;
    public DirAllReportModel()
    {
        DBConnection db = new DBConnection();
       con = db.Connection();
    }

    
    public int getClgid() {
        return clgid;
    }

    public void setClgid(int clgid) {
        this.clgid = clgid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }
    public ResultSet getRs3() {
        return rs3;
    }

    public void setRs3(ResultSet rs3) {
        this.rs3 = rs3;
    }
    
    public String getSdate() {
        return sdate;
    }

    public void setSdate(String sdate) {
        this.sdate = sdate;
    }

    public String getEdate() {
        return edate;
    }

    public void setEdate(String edate) {
        this.edate = edate;
    }

    public ResultSet getRs1() {
        return rs1;
    }

    public void setRs1(ResultSet rs1) {
        this.rs1 = rs1;
    }

    public ResultSet getRs2() {
        return rs2;
    }

    public void setRs2(ResultSet rs2) {
        this.rs2 = rs2;
    }
    public void ConfirmedRS()
    {
        try{
      //  Class.forName("com.mysql.jdbc.Driver");
       //         Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/erd","root","");
                Statement statement = con.createStatement( );
                rs1 = statement.executeQuery("SELECT count( * ) FROM studentinquiry WHERE stud_status =1 and date(stud_inquirydate)>='"+sdate+"' and date(stud_inquirydate)<='"+edate+"'" );
        }
        catch(Exception e)
        {
            System.err.println(e);
        }
    }
    public void NotConfirmedRS()
    {
        try{
    //    Class.forName("com.mysql.jdbc.Driver");
     //           Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/erd","root","");
                Statement statement = con.createStatement( );
                rs2 = statement.executeQuery("SELECT count( * ) FROM studentinquiry WHERE stud_status =0 and date(stud_inquirydate)>='"+sdate+"' and date(stud_inquirydate)<='"+edate+"'" );
                }
        catch(Exception e)
        {
            System.err.println(e);
        }
    }
    public void AllStudentRs()
    {
        try{
       // Class.forName("com.mysql.jdbc.Driver");
       //         Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/erd","root","");
                Statement statement = con.createStatement( );
                rs3 = statement.executeQuery("SELECT count( * ) FROM studentinquiry WHERE date(stud_inquirydate)>='"+sdate+"' and date(stud_inquirydate)<='"+edate+"'" );
                }
        catch(Exception e)
        {
            System.err.println(e);
        }
    }
    public void LineConfirmedRS()
    {
        try{
  //      Class.forName("com.mysql.jdbc.Driver");
  //              Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/erd","root","");
                Statement statement = con.createStatement( );
                rs1 = statement.executeQuery("SELECT *,date(stud_inquirydate),count(*) FROM studentinquiry where stud_status=1 group by date(stud_inquirydate) having date(stud_inquirydate)>='"+sdate+"' and date(stud_inquirydate)<='"+edate+"'" );
        }
        catch(Exception e)
        {
            System.err.println(e);
        }
    }
    public void LineNotConfirmedRS()
    {
        try{
 //       Class.forName("com.mysql.jdbc.Driver");
   //             Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/erd","root","");
                Statement statement = con.createStatement( );
                rs2 = statement.executeQuery("SELECT *,date(stud_inquirydate),count(*) FROM studentinquiry where stud_status=0 group by date(stud_inquirydate) having date(stud_inquirydate)>='"+sdate+"' and date(stud_inquirydate)<='"+edate+"'" );
                }
        catch(Exception e)
        {
            System.err.println(e);
        }
    }
    public void LineAllStudentRs()
    {
        try{
     //   Class.forName("com.mysql.jdbc.Driver");
       //         Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/erd","root","");
                Statement statement = con.createStatement( );
                rs3 = statement.executeQuery("SELECT *,date(stud_inquirydate),count(*) FROM studentinquiry where group by date(stud_inquirydate) having date(stud_inquirydate)>='"+sdate+"' and date(stud_inquirydate)<='"+edate+"'" );
                }
        catch(Exception e)
        {
            System.err.println(e);
        }
    }
    public void PanelHeadConfirmedRS()
    {
        try{
    //    Class.forName("com.mysql.jdbc.Driver");
    //            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/erd","root","");
                Statement statement = con.createStatement( );
                phRs1 = statement.executeQuery("SELECT count( * ) FROM staff AS s, panelhead AS ph, panelmembers AS pm, studentinquiry AS si WHERE ph.ph_id = pm.ph_id AND s.stf_id = pm.stf_id AND ph.ph_id ="+pid+" AND pm.stf_id = si.stf_id AND si.stud_status =1 AND date( si.stud_inquirydate ) >= '"+sdate+"' AND date( si.stud_inquirydate ) <= '"+edate+"'" );
        }
        catch(Exception e)
        {
            System.err.println(e);
        }
    }
    public void PanelHeadNotConfirmedRS()
    {
        try{
    //    Class.forName("com.mysql.jdbc.Driver");
    //            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/erd","root","");
                Statement statement = con.createStatement( );
                phRs2 = statement.executeQuery("SELECT count( * ) FROM staff AS s, panelhead AS ph, panelmembers AS pm, studentinquiry AS si WHERE ph.ph_id = pm.ph_id AND s.stf_id = pm.stf_id AND ph.ph_id ="+pid+" AND pm.stf_id = si.stf_id AND si.stud_status =0 AND date( si.stud_inquirydate ) >= '"+sdate+"' AND date( si.stud_inquirydate ) <= '"+edate+"'" );
        }
        catch(Exception e)
        {
            System.err.println(e);
        }
    }
    public void PanelHeadAllStudentRs()
    {
        try{
     //           Class.forName("com.mysql.jdbc.Driver");
      //          Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/erd","root","");
                Statement statement = con.createStatement( );
                phRs3 = statement.executeQuery("SELECT count( * ) FROM staff AS s, panelhead AS ph, panelmembers AS pm, studentinquiry AS si WHERE ph.ph_id = pm.ph_id AND s.stf_id = pm.stf_id AND ph.ph_id ="+pid+" AND pm.stf_id = si.stf_id AND date( si.stud_inquirydate ) >= '"+sdate+"' AND date( si.stud_inquirydate ) <= '"+edate+"'" );
                }
        catch(Exception e)
        {
            System.err.println(e);
        }
    }
    public void StaffConfirmedRS()
    {
        try{
   //     Class.forName("com.mysql.jdbc.Driver");
     //           Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/erd","root","");
                Statement statement = con.createStatement( );
                stfRs1 = statement.executeQuery("select count(*) from staff as s,studentinquiry as si where s.stf_id=si.stf_id and si.stf_id="+sid+" and si.stud_status=1 and date(si.stud_inquirydate)>='"+sdate+"' and date(si.stud_inquirydate)<='"+edate+"'" );
                
        }
        catch(Exception e)
        {
            System.err.println(e);
        }
    }
    public void StaffNotConfirmedRS()
    {
        try{
     //   Class.forName("com.mysql.jdbc.Driver");
      //          Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/erd","root","");
                Statement statement = con.createStatement( );
                stfRs2 = statement.executeQuery("select count(*) from staff as s,studentinquiry as si where s.stf_id=si.stf_id and si.stf_id="+sid+" and si.stud_status=0 and date(si.stud_inquirydate)>='"+sdate+"' and date(si.stud_inquirydate)<='"+edate+"'" );
        }
        catch(Exception e)
        {
            System.err.println(e);
        }
    }
    public void StaffAllStudentRs()
    {
        try{
         //       Class.forName("com.mysql.jdbc.Driver");
         //       Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/erd","root","");
                Statement statement = con.createStatement( );
                stfRs3 = statement.executeQuery("select count(*) from staff as s,studentinquiry as si where s.stf_id=si.stf_id and si.stf_id="+sid+" and date(si.stud_inquirydate)>='"+sdate+"' and date(si.stud_inquirydate)<='"+edate+"'" );
                }
        catch(Exception e)
        {
            System.err.println(e);
        }
    }
    public void InstituteConfirmedRS()
    {
        try{
  //      Class.forName("com.mysql.jdbc.Driver");
  //              Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/erd","root","");
                Statement statement = con.createStatement( );
                clgRs1 = statement.executeQuery("SELECT count(*) FROM studentinquiry WHERE inn_id="+clgid+" and date(stud_inquirydate)>='"+sdate+"' and date(stud_inquirydate)<='"+edate+"' and stud_status=1" );
        }
        catch(Exception e)
        {
            System.err.println(e);
        }
    }
    public void InstituteNotConfirmedRS()
    {
        try{
  //      Class.forName("com.mysql.jdbc.Driver");
  //              Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/erd","root","");
                Statement statement = con.createStatement( );
                clgRs2 = statement.executeQuery("SELECT count(*) FROM studentinquiry WHERE inn_id="+clgid+" and date(stud_inquirydate)>='"+sdate+"' and date(stud_inquirydate)<='"+edate+"' and stud_status=0" );
        }
        catch(Exception e)
        {
            System.err.println(e);
        }
    }
    public void InstituteAllStudentRs()
    {
        try{
    //            Class.forName("com.mysql.jdbc.Driver");
    //            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/erd","root","");
                Statement statement = con.createStatement( );
                clgRs3 = statement.executeQuery("SELECT count(*) FROM studentinquiry WHERE inn_id="+clgid+" and date(stud_inquirydate)>='"+sdate+"' and date(stud_inquirydate)<='"+edate+"'" );
                }
        catch(Exception e)
        {
            System.err.println(e);
        }
    }
}
