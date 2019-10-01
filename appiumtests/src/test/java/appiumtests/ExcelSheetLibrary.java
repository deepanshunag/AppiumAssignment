package appiumtests;
import java.util.Hashtable;
import java.io.File;
import java.io.IOException;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
public class ExcelSheetLibrary {
	static Sheet wrksheet;
	static Workbook wrkbook = null;
	static Hashtable dict = new Hashtable();
	//create a constructor
	public ExcelSheetLibrary(String ExcelSheetPath) throws BiffException, IOException {
		wrkbook = Workbook.getWorkbook(new File(ExcelSheetPath));
		wrksheet = wrkbook.getSheet("Sheet1");
		ColumnDictionary();
	}
	public static String ReadCell(int column, int row) {
		return wrksheet.getCell(column, row).getContents();
	}
	public static void ColumnDictionary() {
		for (int col=0; col<wrksheet.getColumns();col++) {
			dict.put(ReadCell(col, 0), col);
		}
	}
	public static int GetCell(String colName) {
		try {
			int value;
			value = ((Integer) dict.get(colName)).intValue();
			return value;
		}catch(NullPointerException e) {
			return (0);
		}
	}
}
