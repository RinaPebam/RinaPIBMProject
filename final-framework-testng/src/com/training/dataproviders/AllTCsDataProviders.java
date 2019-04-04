package com.training.dataproviders;

import java.util.List;

import org.testng.annotations.DataProvider;

import com.training.bean.LoginBean;
import com.training.dao.ELearningDAO;
import com.training.readexcel.ApachePOIExcelRead;
import com.training.readexcel.ReadExcel;
import com.training.readexcel.ReadExcel_old;

public class AllTCsDataProviders {

	@DataProvider(name = "db-inputs")
	public Object [][] getDBData() {

		List<LoginBean> list = new ELearningDAO().getLogins(); 
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(LoginBean temp : list){
			Object[]  obj = new Object[2]; 
			obj[0] = temp.getUserName(); 
			obj[1] = temp.getPassword(); 
			
			result[count ++] = obj; 
		}
		
		
		return result;
	}
	
	@DataProvider(name = "excel-inputs")
	public Object[][] getExcelData(){
		String fileName =System.getProperty("user.dir")+"/resources/RinaExcel.xlsx";
		//String fileName ="C:/Users/RINAPEBAM/git/RinaPIBMProject/final-framework-testng/resources/RinaExcel.xlsx";
		return new ApachePOIExcelRead().getExcelContent(fileName); 
	}
	
	@DataProvider(name = "xls-inputs")
	public Object[][] getXLSData(){
		// ensure you will have the title as first line in the file 
		//return new ReadExcel().getExcelData("C:/Users/Naveen/Desktop/Testing.xls", "Sheet1"); 
		return new ReadExcel().getExcelData(System.getProperty("user.dir")+"/resources/RinaExcel.xlsx", "Sheet1"); 

	}


	@DataProvider(name = "excel-inputsTC77")
	public Object[][] getExcelDataTC77(){
		String fileName =System.getProperty("user.dir")+"/resources/TC77_Rina.xlsx";
		return new ApachePOIExcelRead().getExcelContent(fileName); 
	}
	

	@DataProvider(name = "xls-inputsTC77")
	public Object[][] getXLSDataTC77(){
	// ensure you will have the title as first line in the file 
	return new ReadExcel().getExcelData(System.getProperty("user.dir")+"/resources/TC77_Rina.xlsx", "Sheet1"); 

	}
	
	@DataProvider(name = "excel-inputsTC78")
	public Object[][] getExcelDataTC78(){
		String fileName =System.getProperty("user.dir")+"/resources/TC78_Rina.xlsx";
		return new ApachePOIExcelRead().getExcelContent(fileName); 
	}
	

	@DataProvider(name = "xls-inputsTC78")
	public Object[][] getXLSDataTC78(){
	// ensure you will have the title as first line in the file 
	return new ReadExcel().getExcelData(System.getProperty("user.dir")+"/resources/TC78_Rina.xlsx", "Sheet1"); 

	}
	
	@DataProvider(name = "excel-inputsTC79")
	public Object[][] getExcelDataTC79(){
		String fileName =System.getProperty("user.dir")+"/resources/TC79_Rina.xlsx";
		return new ApachePOIExcelRead().getExcelContent(fileName); 
	}
	

	@DataProvider(name = "xls-inputsTC79")
	public Object[][] getXLSDataTC79(){
	// ensure you will have the title as first line in the file 
	return new ReadExcel().getExcelData(System.getProperty("user.dir")+"/resources/TC79_Rina.xlsx", "Sheet1"); 

	}
	
	
	}
