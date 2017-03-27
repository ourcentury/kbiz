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
			System.out.println("�����Դϴ�3");
			return this.dataset_result = xls_xlsx_reader.xls_reader(args1);			
		}else {
			System.out.println("�����Դϴ�4");
			return this.dataset_result = xls_xlsx_reader.xlsx_reader(args1);				
		}		
	}
}

/* Excel File Writer Starts. It contains two types of excel file reader which are xls and xlsx.
 * 
 */

class xls_xlsx_writer {
		
	    //������ VO�� ���ִ� MAP ��ü
		Map<String,Object>map=null;
		//���� DB��ȸ�� ����� ���� LIST��ü
		ArrayList<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
		ArrayList<String> columnList=new ArrayList<String>();
		
		public xls_xlsx_writer(String args) throws IOException {
			common_writer();
			if (args == "xls"){
				xls_writer();
			}else {
				xlsx_writer();				
			}
			
		} // ���θ޼ҵ� ��  �� 
		public void  common_writer(){
			//DB��ȸ�� �����͸� ��Ҵٴ� ������ ������
			for(int i=0;i<10;i++){
			    map=new HashMap<String,Object>();
			    map.put("seq", i+1);
			    map.put("title", "�����̴�"+i);
			    map.put("content", "�����Դϴ�"+i);
			    list.add(map);
			}
			//MAP�� KEY���� ������� 
			if(list !=null &&list.size() >0){
			    //LIST�� ù��° �������� KEY���� �˸� �ǹǷ� 
			    Map<String,Object> m=list.get(0);
			    //MAP�� KEY���� columnList��ü�� ADD 
			    for(String k : m.keySet()){
			        columnList.add(k);
			    }
			}	
		}  // common ��
		
		public void xls_writer() throws IOException {
			
			//1���� workbook�� ���� 
			HSSFWorkbook workbook=new HSSFWorkbook();
			//2���� sheet���� 
			HSSFSheet sheet=workbook.createSheet("��Ʈ��");
			//������ �� 
			HSSFRow row=null;
			//������ �� 
			HSSFCell cell=null;
			//������ DB������ ��ȸ 
			if(list !=null &&list.size() >0){
			    int i=0;
			    for(Map<String,Object> mapobject : list){
			        // ��Ʈ�� �ϳ��� ���� �����Ѵ�(i ���� 0�̸� ù��° �ٿ� �ش�) 
			        row=sheet.createRow((short)i);
			        i++;
			        if(columnList !=null &&columnList.size() >0){
			            for(int j=0;j<columnList.size();j++){
			                //������ row�� �÷��� �����Ѵ� 
			                cell=row.createCell(j);
			                //map�� ��� �����͸� ������ cell�� add�Ѵ� 
			                cell.setCellValue(String.valueOf(mapobject.get(columnList.get(j))));
			            }
			        }
			    }
			}
			FileOutputStream fileoutputstream=new FileOutputStream("c:\\testing.xls");
			//������ ����
			workbook.write(fileoutputstream);
			//�ʼ��� �ݾ��־���� 
			fileoutputstream.close();
			workbook.close();			
			System.out.println("�������ϻ�������");
		}   // xls_reaaer ��
		
		public void xlsx_writer() throws IOException {
			//1���� workbook�� ���� 
			XSSFWorkbook workbook=new XSSFWorkbook();
			//2���� sheet���� 
			XSSFSheet sheet=workbook.createSheet("��Ʈ��");
			//������ �� 
			XSSFRow row=null;
			//������ �� 
			XSSFCell cell=null;
			//������ DB������ ��ȸ 
			if(list !=null &&list.size() >0){
			    int i=0;
			    for(Map<String,Object>mapobject : list){
			        // ��Ʈ�� �ϳ��� ���� �����Ѵ�(i ���� 0�̸� ù��° �ٿ� �ش�) 
			        row=sheet.createRow((short)i);
			        i++;
			        if(columnList !=null &&columnList.size() >0){
			            for(int j=0;j<columnList.size();j++){
			                //������ row�� �÷��� �����Ѵ� 
			                cell=row.createCell(j);
			                //map�� ��� �����͸� ������ cell�� add�Ѵ� 
			                cell.setCellValue(String.valueOf(mapobject.get(columnList.get(j))));
			            }
			        }
			    }
			}
			FileOutputStream fileoutputstream=new FileOutputStream("c:\\testing.xlsx");
			//������ ����
			workbook.write(fileoutputstream);
			//�ʼ��� �ݾ��־���� 
			fileoutputstream.close();
			workbook.close();			
			System.out.println("�������ϻ�������");
		}
		
}  // writer parts ends


/* Excel File Reader Starts. It contains two types of excel file reader which are xls and xlsx.
 * 
 */

class xls_xlsx_reader {
	
	
	
	public xls_xlsx_reader() throws IOException{
		
		
	}
	
	
	
	public static String[][] xls_reader(String file_path) throws IOException{
		//������ �б����� ���������� �����´�
	    FileInputStream fis=new FileInputStream(file_path);
		int rowindex=0;
		int columnindex=0;	
		HSSFWorkbook workbook=new HSSFWorkbook(fis);
		//��Ʈ �� (ù��°���� �����ϹǷ� 0�� �ش�)
		//���� �� ��Ʈ�� �б����ؼ��� FOR���� �ѹ��� �����ش�
		HSSFSheet sheet=workbook.getSheetAt(0);
		//���Ǽ� ã��
		int rows=sheet.getPhysicalNumberOfRows();
		int no_of_col = 0; // ���� ���Ŀ� ���� �÷��� ������ ���� ���� ����
		// Verification for Product excel file or Company Excel File
		HSSFRow row1 = sheet.getRow(0);
		HSSFCell cell1 = row1.getCell(1);
		String veri_value = cell1.getStringCellValue();
		System.out.println(veri_value);
		
		if (veri_value.equals("File Verification:Product")){
			no_of_col = 12; // �÷��� ����
			}else if(veri_value.equals("File Verification:Company")){
			no_of_col = 10; // �÷��� ����
			}else{
			System.out.println("���Ͽ����Դϴ�");
			System.exit(1);
			}
		//���� ��		
		String[][] dataset_temp = new String[rows][no_of_col]; // �������� �����͸� ���� ARRAY
		
		
		for(rowindex=2;rowindex<rows;rowindex++){ // ù��° row ignore 
			HSSFRow row=sheet.getRow(rowindex); // �� �б�
			if(row !=null){
				// int cells=row.getPhysicalNumberOfCells();				
				// System.out.println(cells + "�����óѹ���" + "      "); //�̺κ� �ٲ����
				// for(columnindex=0;columnindex<=cells;columnindex++){
				for(columnindex=0;columnindex<no_of_col;columnindex++){ //�� �� ����
					HSSFCell cell=row.getCell(columnindex);									
					String value=null; // �̰��� ���� value�� ����					
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
						// System.out.println(rowindex + "��" + "��" + columnindex + "�� ���� :"+value);
						if(value.contains("\n")){
							value = value.replace("\n", ";");
						}
						dataset_temp[rowindex][columnindex] = value;  // ���ľ���!!					    
						
						System.out.println("�� ���� :"+ dataset_temp[rowindex][columnindex] + "���� :" + dataset_temp[rowindex][columnindex].length());
					 }  // if-else �� ��					 					
				}
				/*
				if (dataset_temp[rowindex][0] == null||dataset_temp[rowindex][no_of_col-1] == null){					
					System.out.println("������������"); //�����޼��� ���
			    	System.exit(1);					    	
			    } // ������ ���ռ� �׽�Ʈ row�� ���������� �� */ 

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
		
		//��Ʈ �� (ù��°���� �����ϹǷ� 0�� �ش�)
		//���� �� ��Ʈ�� �б����ؼ��� FOR���� �ѹ��� �����ش�
		XSSFSheet sheet=workbook.getSheetAt(0);
		//���� ��
		//���Ǽ� ã��
		int rows=sheet.getPhysicalNumberOfRows();
		int no_of_col = 0; // ���� ���Ŀ� ���� �÷��� ������ ���� ���� ����
	    // Verification for Product excel file or Company Excel File
		XSSFRow row1 = sheet.getRow(0);
		XSSFCell cell1 = row1.getCell(1);
		String veri_value = cell1.getStringCellValue();		
		
		if (veri_value.equals("File Verification:Product")){
			no_of_col = 12; // �÷��� ����
			}else if(veri_value.equals("File Verification:Company")){
			no_of_col = 10; // �÷��� ����
			}else{
			System.out.println("���Ͽ����Դϴ�");
			System.exit(1);
			}
		//���� ��		
		String[][] dataset_temp = new String[rows][no_of_col]; // �������� �����͸� ���� ARRAY
		
		for(rowindex=2;rowindex<rows;rowindex++){ // ù��° row ignore 
			XSSFRow row=sheet.getRow(rowindex); // �� �б�
			if(row !=null){
				// int cells=row.getPhysicalNumberOfCells();				
				// System.out.println(cells + "�����óѹ���" + "      "); //�̺κ� �ٲ����
				// for(columnindex=0;columnindex<=cells;columnindex++){
				for(columnindex=0;columnindex<no_of_col;columnindex++){ //�� �� ����
					XSSFCell cell=row.getCell(columnindex);									
					String value=null; // �̰��� ���� value�� ����					
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
						// System.out.println(rowindex + "��" + "��" + columnindex + "�� ���� :"+value);
						if(value.contains("\n")){
							value = value.replace("\n", ";");
						}
						dataset_temp[rowindex][columnindex] = value;  // ���ľ���!!					    
						
						System.out.println("�� ���� :"+ dataset_temp[rowindex][columnindex] + "���� :" + dataset_temp[rowindex][columnindex].length());
					 }  // if-else �� ��					 					
				}
				/*
				if (dataset_temp[rowindex][0] == null||dataset_temp[rowindex][no_of_col-1] == null){					
					System.out.println("������������"); //�����޼��� ���
			    	System.exit(1);					    	
			    } // ������ ���ռ� �׽�Ʈ row�� ���������� �� */ 

			}
		}
		workbook.close();
		return dataset_temp;
	}
}









