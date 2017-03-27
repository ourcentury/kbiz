import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;



public class excel_excutor {
	
	public String[][] dataset_result;

	public excel_excutor() throws IOException{
		
	}
	
	public String[][] excel_excutor_result(String args, String args1) throws IOException{
		System.out.println(args);
		if (args.equals("xls")){
			System.out.println("여기입니다3");
			return this.dataset_result = xls_xlsx_reader.xls_reader(args1);			
		}else {
			System.out.println("여기입니다4");
			return this.dataset_result = xls_xlsx_reader.xlsx_reader(args1);				
		}		
	}
}

/* Excel File Writer Starts. It contains two types of excel file reader which are xls and xlsx.
 * 
 */

class xls_xlsx_writer {
		
	    //임의의 VO가 되주는 MAP 객체
		Map<String,Object>map=null;
		//가상 DB조회후 목록을 담을 LIST객체
		ArrayList<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
		ArrayList<String> columnList=new ArrayList<String>();
		
		public xls_xlsx_writer(String args) throws IOException {
			common_writer();
			if (args == "xls"){
				xls_writer();
			}else {
				xlsx_writer();				
			}
			
		} // 메인메소드 끝  끝 
		public void  common_writer(){
			//DB조회후 데이터를 담았다는 가상의 데이터
			for(int i=0;i<10;i++){
			    map=new HashMap<String,Object>();
			    map.put("seq", i+1);
			    map.put("title", "제목이다"+i);
			    map.put("content", "내용입니다"+i);
			    list.add(map);
			}
			//MAP의 KEY값을 담기위함 
			if(list !=null &&list.size() >0){
			    //LIST의 첫번째 데이터의 KEY값만 알면 되므로 
			    Map<String,Object> m=list.get(0);
			    //MAP의 KEY값을 columnList객체에 ADD 
			    for(String k : m.keySet()){
			        columnList.add(k);
			    }
			}	
		}  // common 끝
		
		public void xls_writer() throws IOException {
			
			//1차로 workbook을 생성 
			HSSFWorkbook workbook=new HSSFWorkbook();
			//2차는 sheet생성 
			HSSFSheet sheet=workbook.createSheet("시트명");
			//엑셀의 행 
			HSSFRow row=null;
			//엑셀의 셀 
			HSSFCell cell=null;
			//임의의 DB데이터 조회 
			if(list !=null &&list.size() >0){
			    int i=0;
			    for(Map<String,Object> mapobject : list){
			        // 시트에 하나의 행을 생성한다(i 값이 0이면 첫번째 줄에 해당) 
			        row=sheet.createRow((short)i);
			        i++;
			        if(columnList !=null &&columnList.size() >0){
			            for(int j=0;j<columnList.size();j++){
			                //생성된 row에 컬럼을 생성한다 
			                cell=row.createCell(j);
			                //map에 담긴 데이터를 가져와 cell에 add한다 
			                cell.setCellValue(String.valueOf(mapobject.get(columnList.get(j))));
			            }
			        }
			    }
			}
			FileOutputStream fileoutputstream=new FileOutputStream("c:\\testing.xls");
			//파일을 쓴다
			workbook.write(fileoutputstream);
			//필수로 닫아주어야함 
			fileoutputstream.close();
			workbook.close();			
			System.out.println("엑셀파일생성성공");
		}   // xls_reaaer 끝
		
		public void xlsx_writer() throws IOException {
			//1차로 workbook을 생성 
			XSSFWorkbook workbook=new XSSFWorkbook();
			//2차는 sheet생성 
			XSSFSheet sheet=workbook.createSheet("시트명");
			//엑셀의 행 
			XSSFRow row=null;
			//엑셀의 셀 
			XSSFCell cell=null;
			//임의의 DB데이터 조회 
			if(list !=null &&list.size() >0){
			    int i=0;
			    for(Map<String,Object>mapobject : list){
			        // 시트에 하나의 행을 생성한다(i 값이 0이면 첫번째 줄에 해당) 
			        row=sheet.createRow((short)i);
			        i++;
			        if(columnList !=null &&columnList.size() >0){
			            for(int j=0;j<columnList.size();j++){
			                //생성된 row에 컬럼을 생성한다 
			                cell=row.createCell(j);
			                //map에 담긴 데이터를 가져와 cell에 add한다 
			                cell.setCellValue(String.valueOf(mapobject.get(columnList.get(j))));
			            }
			        }
			    }
			}
			FileOutputStream fileoutputstream=new FileOutputStream("c:\\testing.xlsx");
			//파일을 쓴다
			workbook.write(fileoutputstream);
			//필수로 닫아주어야함 
			fileoutputstream.close();
			workbook.close();			
			System.out.println("엑셀파일생성성공");
		}
		
}  // writer parts ends


/* Excel File Reader Starts. It contains two types of excel file reader which are xls and xlsx.
 * 
 */

class xls_xlsx_reader {
	
	
	
	public xls_xlsx_reader() throws IOException{
		
		
	}
	
	
	
	public static String[][] xls_reader(String file_path) throws IOException{
		//파일을 읽기위해 엑셀파일을 가져온다
	    FileInputStream fis=new FileInputStream(file_path);
		int rowindex=0;
		int columnindex=0;	
		HSSFWorkbook workbook=new HSSFWorkbook(fis);
		//시트 수 (첫번째에만 존재하므로 0을 준다)
		//만약 각 시트를 읽기위해서는 FOR문을 한번더 돌려준다
		HSSFSheet sheet=workbook.getSheetAt(0);
		//행의수 찾기
		int rows=sheet.getPhysicalNumberOfRows();
		int no_of_col = 0; // 파일 형식에 따라 컬럼수 지정을 위한 변수 선언
		// Verification for Product excel file or Company Excel File
		HSSFRow row1 = sheet.getRow(0);
		HSSFCell cell1 = row1.getCell(1);
		String veri_value = cell1.getStringCellValue();
		System.out.println(veri_value);
		
		if (veri_value.equals("File Verification:Product")){
			no_of_col = 12; // 컬럼수 지정
			}else if(veri_value.equals("File Verification:Company")){
			no_of_col = 10; // 컬럼수 지정
			}else{
			System.out.println("파일에러입니다");
			System.exit(1);
			}
		//행의 수		
		String[][] dataset_temp = new String[rows][no_of_col]; // 엑셀에서 데이터를 담을 ARRAY
		
		
		for(rowindex=2;rowindex<rows;rowindex++){ // 첫번째 row ignore 
			HSSFRow row=sheet.getRow(rowindex); // 행 읽기
			if(row !=null){
				// int cells=row.getPhysicalNumberOfCells();				
				// System.out.println(cells + "피지컬넘버셀" + "      "); //이부분 바꿔야함
				// for(columnindex=0;columnindex<=cells;columnindex++){
				for(columnindex=0;columnindex<no_of_col;columnindex++){ //셀 수 고정
					HSSFCell cell=row.getCell(columnindex);									
					String value=null; // 이곳에 엑셀 value가 쌓임					
					  if(cell==null){
						continue;
				      }else{
						switch (cell.getCellType()){
						case HSSFCell.CELL_TYPE_FORMULA:
							value=cell.getCellFormula();
							break;
						case HSSFCell.CELL_TYPE_NUMERIC:
							value=cell.getNumericCellValue()+"";
							break;
						case HSSFCell.CELL_TYPE_STRING:
							value=cell.getStringCellValue()+"";
							break;
						case HSSFCell.CELL_TYPE_BLANK:
							value=cell.getBooleanCellValue()+"";
							break;
						case HSSFCell.CELL_TYPE_ERROR:
							value=cell.getErrorCellValue()+"";
							break;
					     }
						// System.out.println(rowindex + "행" + "열" + columnindex + "셀 내용 :"+value);
						if(value.contains("\n")){
							value = value.replace("\n", ";");
						}
						dataset_temp[rowindex][columnindex] = value;  // 고쳐야함!!					    
						
						System.out.println("셀 내용 :"+ dataset_temp[rowindex][columnindex] + "길이 :" + dataset_temp[rowindex][columnindex].length());
					 }  // if-else 문 끝					 					
				}
				/*
				if (dataset_temp[rowindex][0] == null||dataset_temp[rowindex][no_of_col-1] == null){					
					System.out.println("오류오류오루"); //오류메세지 출력
			    	System.exit(1);					    	
			    } // 데이터 적합성 테스트 row가 끝날때마다 함 */ 

			}
		}
		workbook.close();
		return dataset_temp;
	}
	
	public static String[][] xlsx_reader(String file_path) throws IOException{
		 	
		FileInputStream fis=new FileInputStream(file_path);
		int rowindex=0;
		int columnindex=0;
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		
		//시트 수 (첫번째에만 존재하므로 0을 준다)
		//만약 각 시트를 읽기위해서는 FOR문을 한번더 돌려준다
		XSSFSheet sheet=workbook.getSheetAt(0);
		//행의 수
		//행의수 찾기
		int rows=sheet.getPhysicalNumberOfRows();
		int no_of_col = 0; // 파일 형식에 따라 컬럼수 지정을 위한 변수 선언
	    // Verification for Product excel file or Company Excel File
		XSSFRow row1 = sheet.getRow(0);
		XSSFCell cell1 = row1.getCell(1);
		String veri_value = cell1.getStringCellValue();		
		
		if (veri_value.equals("File Verification:Product")){
			no_of_col = 12; // 컬럼수 지정
			}else if(veri_value.equals("File Verification:Company")){
			no_of_col = 10; // 컬럼수 지정
			}else{
			System.out.println("파일에러입니다");
			System.exit(1);
			}
		//행의 수		
		String[][] dataset_temp = new String[rows][no_of_col]; // 엑셀에서 데이터를 담을 ARRAY
		
		for(rowindex=2;rowindex<rows;rowindex++){ // 첫번째 row ignore 
			XSSFRow row=sheet.getRow(rowindex); // 행 읽기
			if(row !=null){
				// int cells=row.getPhysicalNumberOfCells();				
				// System.out.println(cells + "피지컬넘버셀" + "      "); //이부분 바꿔야함
				// for(columnindex=0;columnindex<=cells;columnindex++){
				for(columnindex=0;columnindex<no_of_col;columnindex++){ //셀 수 고정
					XSSFCell cell=row.getCell(columnindex);									
					String value=null; // 이곳에 엑셀 value가 쌓임					
					  if(cell==null){
						continue;
				      }else{
						switch (cell.getCellType()){
						case HSSFCell.CELL_TYPE_FORMULA:
							value=cell.getCellFormula();
							break;
						case HSSFCell.CELL_TYPE_NUMERIC:
							value=cell.getNumericCellValue()+"";
							break;
						case HSSFCell.CELL_TYPE_STRING:
							value=cell.getStringCellValue()+"";
							break;
						case HSSFCell.CELL_TYPE_BLANK:
							value=cell.getBooleanCellValue()+"";
							break;
						case HSSFCell.CELL_TYPE_ERROR:
							value=cell.getErrorCellValue()+"";
							break;
					     }
						// System.out.println(rowindex + "행" + "열" + columnindex + "셀 내용 :"+value);
						if(value.contains("\n")){
							value = value.replace("\n", ";");
						}
						dataset_temp[rowindex][columnindex] = value;  // 고쳐야함!!					    
						
						System.out.println("셀 내용 :"+ dataset_temp[rowindex][columnindex] + "길이 :" + dataset_temp[rowindex][columnindex].length());
					 }  // if-else 문 끝					 					
				}
				/*
				if (dataset_temp[rowindex][0] == null||dataset_temp[rowindex][no_of_col-1] == null){					
					System.out.println("오류오류오루"); //오류메세지 출력
			    	System.exit(1);					    	
			    } // 데이터 적합성 테스트 row가 끝날때마다 함 */ 

			}
		}
		workbook.close();
		return dataset_temp;
	}
}









