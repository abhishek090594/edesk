/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import Model.DBConnection;
import java.io.IOException;
import static java.lang.Math.log;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.omg.SendingContext.RunTime;

/**
 *
 * @author SOHIL
 */
public class DirDatabaseBakUpModel {
      Connection con = null; 
     public DirDatabaseBakUpModel()
    {
        DBConnection db = new DBConnection();
       con = db.Connection();
    }
    public boolean backupDataWithDatabase(String dumpExePath, String host, String port, String user, String password, String database, String backupPath) {
        boolean status = false;
        try {
            Process p = null;

            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            Date date = new Date();
            String filepath = "Backup of " + database + " on " + dateFormat.format(date) + ".sql";

            String batchCommand = "";
            if (password != "") {
                //Backup with database
                batchCommand = dumpExePath + " -h " + host + " --port " + port + " -u " + user + " --password=" + password + " --add-drop-database -B " + database + " -r \"" + backupPath + "" + filepath + "\"";
            } else {
                batchCommand = dumpExePath + " -h " + host + " --port " + port + " -u " + user + " --add-drop-database -B " + database + " -r \"" + backupPath + "" + filepath + "\"";
            }

            Runtime runtime = Runtime.getRuntime();
            p = runtime.exec(batchCommand);
            int processComplete = p.waitFor();

            if (processComplete == 0) {
                status = true;
                System.out.println("Backup created successfully for with DB " + database + " in " + host + ":" + port);
            } else {
                status = false;
                System.out.println("Could not create the backup for with DB " + database + " in " + host + ":" + port);
            }

        } catch (IOException ioe) {
       //     log.error(ioe, ioe.getCause());
        } catch (Exception e) {
      //      log.error(e, e.getCause());
        }
        return status;
    }

     
}
