package com.iiitb.examAdminBackEnd.sqlDump;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SqlDumpController {

	@Autowired
	private SqlDumpService sqlDumpService;
	
	@RequestMapping("/RpackDump")
	public void getRpackDump() throws IOException, InterruptedException {
		sqlDumpService.getEpackDump();
	}
	
//	@RequestMapping("/RpackDump")
//	public void getRpackDump() throws IOException {
////		sqlDumpService.getRpackDump();
//		Runtime rt = Runtime.getRuntime();
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
//	}
	
//	@RequestMapping("/RpackDump2")
//	public static boolean backup() throws IOException, InterruptedException {
//		String dbUsername="root", dbPassword="akshara", dbName="oaes_assessment_db", outputFile="mydb_abackup.sql";
//        String command = String.format("mysqldump -u%s -p%s --add-drop-table --databases %s -r %s", dbUsername, dbPassword, dbName, outputFile);
//        Process process = Runtime.getRuntime().exec(command);
//        int processComplete = process.waitFor();
//        return processComplete == 0;
//    }
}
