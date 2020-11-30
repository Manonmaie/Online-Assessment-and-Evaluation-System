package com.iiitb.examAdminBackEnd.sqlDump;

import java.io.*;

import org.springframework.stereotype.Repository;

@Repository
public class SqlDumpGenerateAndExecute {

	public void createSqlDumpFile() throws IOException {
		System.out.println("creating dump");
	      Runtime rt = Runtime.getRuntime();
//	      Process p = rt.exec("/usr/local/Cellar/mysql/8.0.12/bin/mysqldump -u root oaes_assessment_db as_user as_role_master");
	      Process p = rt.exec("mysqldump -u oaes -pOaes_2020 oaes_exam_admin_db out_epack_header epack1 epack2 epack3 epack4");
//	      mysqldump -u [user name] -p[password] [database name] > [dump file]
	      InputStream is=p.getInputStream();
	      FileOutputStream fos=new FileOutputStream("EpackDump.sql");
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
	      String dbUsername="oaes", dbPassword="Oaes_2020", dbName="oaes_exam_admin_db", sourceFile;
	      if(pack == "Qpack") {
	    	  sourceFile = "QpackDump.sql";
	      }
	      else {
	    	  sourceFile = "MpackDump.sql";
	      }
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
