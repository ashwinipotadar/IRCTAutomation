package persistent.MavenFirstPrj;

import java.io.File;
import java.io.IOException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.testng.annotations.Test;

import bsh.org.objectweb.asm.Label;

@Test
public class DatadrivenClass {
	public void excelDriven() throws BiffException, IOException, RowsExceededException, WriteException
	{
		Workbook book =Workbook.getWorkbook(new File ("./src/test/Master.xls"));
		Sheet S1=book.getSheet(0);
		String value= S1.getCell(0,0).getContents();
		System.out.println(value);
		book.close();
		WritableWorkbook newbook = Workbook.createWorkbook(new File("./src/test/MasterNew.xls") );
		WritableSheet sheet = newbook.createSheet("Master", 0);
		jxl.write.Label l1= new jxl.write.Label(0,0, "one");
		sheet.addCell(l1);
		newbook.write();
		newbook.close();
				
		Workbook oldcopy= Workbook.getWorkbook(new File("./src/test/Master.xls"));
		WritableWorkbook newcopy= Workbook.createWorkbook(new File("./src/test/MasterCopy.xls"), oldcopy);
		WritableSheet sheet1= newcopy.getSheet(0);
		jxl.write.Label L2 = new jxl.write.Label(2, 2, "Copy Content");
		sheet1.addCell(L2);
		newcopy.write();
		newcopy.close();
		oldcopy.close();
		
	}
	}

	

