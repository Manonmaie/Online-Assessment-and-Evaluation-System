package com.iiitb.assessmentBackEnd.sqlDump;

import java.io.*;

import org.springframework.stereotype.Repository;

@Repository
public class SqlDumpGenerateAndExecute {

	public void createSqlDumpFile() throws IOException {
		System.out.println("creating dump");
	      Runtime rt = Runtime.getRuntime();
	      Process p = rt.exec("/usr/local/Cellar/mysql/8.0.12/bin/mysqldump -u root oaes_assessment_db out_rpack_header rpack1 rpack2 rpack3 rpack4");
//	      Process p = rt.exec("mysqldump -u root -ppassword oaes_assessment_db as_user as_role_master");
//	      mysqldump -u [user name] -p[password] [database name] > [dump file]
	      InputStream is=p.getInputStream();
	      FileOutputStream fos=new FileOutputStream("RpackDump.sql");
	      int ch;
	      while((ch=is.read())!=-1) {
	             fos.write(ch);
	      }
	      fos.close();
	      is.close();
	      System.out.println("----SQL backup file generated: mydb_abackup.sql----");
	    }

	    public boolean runSqlDumpFile() throws IOException, InterruptedException {
	      Runtime rt = Runtime.getRuntime();
	      String dbUsername="root", dbPassword="akshara", dbName="oaes_assessment_db", sourceFile="EpackDump.sql";
//	      String dbUsername="root", dbPassword="password", dbName="test", sourceFile="dump.sql";
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
