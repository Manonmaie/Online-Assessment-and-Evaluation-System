package com.urest.v1.authoring_module.sqlDump;

import java.io.*;

import org.springframework.stereotype.Repository;

@Repository
public class SqlDumpGenerateAndExecute {

	public void createSqlDumpFile(String pack) throws IOException {
		System.out.println("creating dump");
	      Runtime rt = Runtime.getRuntime();
//	      Process p = rt.exec("/usr/local/Cellar/mysql/8.0.12/bin/mysqldump -u root oaes_assessment_db as_user as_role_master");
	      String command = "mysqldump -u newuser -ppassword question_bank";
	      String file;
	      if(pack == "Qpack") {
	    	  command = command + " out_qpack_header qpack1 qpack2 qpack3";
	    	  file = "QpackDump.sql";
	      }
	      else {
	    	  command  = command + " out_apack_header apack1 apack2";
	    	  file = "ApackDump.sql";
	      }
	      Process p = rt.exec(command);
//	      mysqldump -u [user name] -p[password] [database name] > [dump file]
	      InputStream is=p.getInputStream();
	      FileOutputStream fos=new FileOutputStream(file);
	      int ch;
	      while((ch=is.read())!=-1) {
	             fos.write(ch);
	      }
	      fos.close();
	      is.close();
	      System.out.println("----SQL backup file generated: mydb_abackup.sql----");
	    }

	    public boolean runSqlDumpFile(String pack) throws IOException, InterruptedException {
	      Runtime rt = Runtime.getRuntime();
//	      String dbUsername="root", dbPassword="akshara", dbName="dummy", sourceFile="dump.sql";
	      String dbUsername="newuser", dbPassword="password", dbName="question_bank", sourceFile="dump.sql";
//	      Process pr = rt.exec("mysql -p -h ServerName dummy < mydb_abackup.sql");
	      String[] command = new String[]{
//	                "/usr/local/Cellar/mysql/8.0.12/bin/mysql",
	    		  	"mysql",
	                "-u" + dbUsername,
	                "-p" + dbPassword,
	                "-e",
	                " source " + sourceFile,
	                dbName
	        };
	        Process runtimeProcess = Runtime.getRuntime().exec(command);
	        int processComplete = runtimeProcess.waitFor();
	        return processComplete == 0;
	    }
}

