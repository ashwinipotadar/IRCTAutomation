package persistent.reusable;

import java.io.File;
import java.io.IOException;

import net.sourceforge.htmlunit.corejs.javascript.tools.debugger.Main;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class FileHandle {
	
	public String readFile (String strFilePath)
	{
		return strFilePath;
		
	}
	public String[][] getExcelData(String xlPath, String shtName) throws BiffException, IOException
	         {
	    Workbook workbk = Workbook.getWorkbook(new File(xlPath));
	    System.out.println(shtName);
	    Sheet sht = workbk.getSheet(shtName);
	    int rowCount = sht.getRows();
	     int colCount = sht.getColumns();
	    String [] [] tabArray = new String[rowCount][colCount];
	    for (int i = 0; i < rowCount; i++) {
	        for (int j = 0; j < colCount; j++) {
	        	System.out.println("i: "+i+"j : "+j);
	        	System.out.println(sht.getCell(j, i).getContents());
	            tabArray[i][j] = sht.getCell(j, i).getContents();
	        }
	    }
	    return (tabArray);
	}
	
	public static void main (String [] args) throws BiffException, IOException
	{
		FileHandle FH = new FileHandle();
		String sheetPath = "./src/test/AddPost.xls";
		   Object[][] retObjArr = FH.getExcelData(sheetPath, "AddPost");
	}

}
