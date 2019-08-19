import com.sterlingcommerce.woodstock.workflow.Document;    
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
File file = null;
String  workFlowId =  (String)wfc.getWFContent("workFlowId");
BufferedReader br = null;
try{
 br = new BufferedReader(new FileReader("/ISILON/SIIBC/GEHOP/WORK/rejCUR_B"+workFlowId+".xml"));
 String line = null;
 while(( line = br.readLine())!=null){
   line = line.replace("<REJEITADOS>", "");
   line = line.replace("</REJEITADOS>", "");
   line = line.replace("<REJEITADO>", "");
   line = line.replace("</REJEITADO>", "");
   line=line.trim();
   file = new  File("/ISILON/SIIBC/GEHOP/"+line);
   file.delete();
 }
 br.close();
}catch(Exception ex){
 log.log("File Not Exist!"+ ex.getMessage());
}
return "000";
