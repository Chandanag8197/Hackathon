package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	
	
	@DataProvider(name="Data")
	public String [][] getData() throws IOException
	{
		String path=".\\testData\\testData.xlsx";
		
		ExcelUtility xlutil=new ExcelUtility(path);
		
		int totalrows=xlutil.getRowCount("Sheet1");	
		int totalcols=xlutil.getCellCount("Sheet1",1);
				
		String data[][]=new String[1][1];
		
		for(int i=1;i<=totalrows;i++) 
		{		
			for(int j=0;j<totalcols;j++)  
			{
				data[i-1][j]= xlutil.getCellData("Sheet1",i, j);  //1,0
			}
		}
	return data;
				
	}
	

}