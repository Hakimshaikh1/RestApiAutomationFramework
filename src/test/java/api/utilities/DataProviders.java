package api.utilities;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name="AllData")
	public String [][] AllDataProvider(){

		String fFilename = System.getProperty("user.dir")+ "//TestData//TestData.xlsx";
		
		int ttlRows=ReadExcelFile.getRowCount(fFilename, "Sheet1");
		int ttlCol=ReadExcelFile.getColCount(fFilename, "Sheet1");

		String userData[][]=new String [ttlRows-1][ttlCol];

		for(int rowNo=1; rowNo<ttlRows; rowNo++) {

			for(int col=0; col<ttlCol; col++) {

				userData[rowNo-1][col]= ReadExcelFile.getCellValue(fFilename, "Sheet1", rowNo, col);

			}
		}

		return userData;


	}

	@DataProvider(name="UserNameData")
	public String [] UserNameDataProvider(){

		String fFilename = System.getProperty("user.dir")+ "//TestData//TestData.xlsx";
		int ttlRows=ReadExcelFile.getRowCount(fFilename, "Sheet1");


		String userNameData[]=new String [ttlRows-1];

		for(int rowNo=1; rowNo<ttlRows; rowNo++) {

			userNameData[rowNo-1]= ReadExcelFile.getCellValue(fFilename, "Sheet1", rowNo, 1);


		}

		return userNameData;


	}

}
