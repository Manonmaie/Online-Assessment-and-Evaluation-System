package com.iiitb.assessmentBackEnd.sqlDump;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SqlDumpService {
	
//	@Autowired
//	private SqlDumpRepository sqlDumpRepository;
	
	@Autowired
	private SqlDumpGenerateAndExecute sqlDump;
	
//	public void getRpackDump1() {
//		sqlDumpRepository.getAllRpackTablesDump();
//	}
	
	public void getRpackDump() throws IOException {
		sqlDump.createSqlDumpFile();
	}
	
	public void importEpackDump() throws IOException, InterruptedException {
		if(sqlDump.runSqlDumpFile()) {
			System.out.println("Dump execute Success");
		}
		else {
			System.out.println("Dump execute Failed");
		}
	}
	
//	public void getRpackDump() throws IOException {
//        Runtime rt = Runtime.getRuntime();
//        Process p = rt.exec("mysqldump -u root -p oaes_assessment_db as_user as_role_master");
//        InputStream is=p.getInputStream();
//        FileOutputStream fos=new FileOutputStream("mydb_abackup.sql");
//        int ch;
//        while((ch=is.read())!=-1) {
//               fos.write(ch);
//        }
//        fos.close();
//        is.close();
//        System.out.println("----SQL backup file generated: mydb_abackup.sql----");
//    }
	
//	 public void getRpackDump() throws IOException {
//	   Runtime rt = Runtime.getRuntime();
//       Process p = rt.exec("mysqldump -u root -p akshara --database oaes_assessment_db");
//       InputStream is = p.getInputStream();     
//       FileOutputStream fos = new FileOutputStream("dump.sql");        
//       int ch;
//       while((ch=is.read())!=-1) {            
//    	   fos.write(ch);
//       }    
//       fos.close();
//       is.close();   
//       System.out.println("----SQL backup file generated: dump.sql----");
//    }

}
