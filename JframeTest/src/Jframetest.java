import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;	
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.*;
import javax.swing.filechooser.*;

public class Jframetest {			
	public static void main(String[] args) throws IOException{
	     Jframe_Test jt = new Jframe_Test();
	     jt.Jframe_initial();
	     
	    //Jframe_Test jt2 = new Jframe_Test();
	    
	   // jt2.Jframe_initial();	    
		
		/*
		System.out.println("실행되나?");
		String[] vari = new String[2];
		vari[0] = "xls";
		vari[1] = "xls1";
		
		excel_excutor ec = new excel_excutor();
		String[][] temp = ec.excel_excutor_result(vari[0]);
		
		System.out.println(temp[2][1]);
		
		Db_operation dbo = new Db_operation(temp);
		*/
		
	}
}
class  Jframe_Test extends JFrame implements ActionListener {

	private JFrame frame = new JFrame();
	private JFrame frame1 = new JFrame();
	private JPanel logoPane = new JPanel(); // 첫화면 logo 패널
	private JPanel menuSelectPane = new JPanel(); //6개의 버튼으로 구성된 첫번재 화면 메뉴 선택 패널	
	private JPanel buttonPane = new JPanel();  // 
	private JFileChooser jfc = new JFileChooser();
	private JLabel jbl = new JLabel();
	/* 버튼 생성 */
	private JButton upload_comp = new JButton("1.Upload Company Info");
	private JButton upload_product = new JButton("2.Upload Product Info");
	private JButton upload_transaction = new JButton("3.Upload Transaction Info");
    private JButton download_info = new JButton("4. Download Info");
    private JButton tbd1 = new JButton("5. TBD1");
    private JButton tbd2 = new JButton("6. TBD2");
    
	private JButton openButton = new JButton("Open");
	private JButton saveButton = new JButton("Save");
	private JButton company_info_upload = new JButton("1.Upload Company Info");
	private JButton product_info_upload = new JButton("2.Upload Product Info");
	private JButton info_download = new JButton("3.Download Information");
	private GridLayout experimetalLayout = new GridLayout(2,0);
	
	
	
	public Jframe_Test() {
	     
        /*		
		buttonPane.setLayout(experimetalLayout);
		
		//buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.X_AXIS));
		buttonPane.add(openButton);
		buttonPane.add(saveButton);
		buttonPane.setBackground(Color.white);
		
		// --buttonPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		//buttonPane.setBorder(BorderFactory.createEmptyBorder(0, 150, 0, 0));
		
		
		jbl.setText("파일선택 전입니다.");
				
		jfc.setFileFilter(new FileNameExtensionFilter("xls", "xls"));
		jfc.setMultiSelectionEnabled(false);
		
		openButton.addActionListener(this);
		saveButton.addActionListener(this);
		
		contentPane.add(jbl, BorderLayout.CENTER);		
		contentPane.add(buttonPane, BorderLayout.SOUTH);
		*/
		
		
	
		//JOptionPane.showMessageDialog(null, "경고경고", "경고입니다", JOptionPane.ERROR_MESSAGE); 
		
	}
	
	/* 초기화면 만들기 */
	public void Jframe_initial(){
		
		Container contentPane = frame.getContentPane();
		contentPane.setBackground(Color.white);
		contentPane.setLayout(experimetalLayout);
		
		menuSelectPane.setLayout(new GridLayout(3,2));
		menuSelectPane.add(upload_comp );
		menuSelectPane.add(upload_product );
		menuSelectPane.add(upload_transaction);
		menuSelectPane.add(download_info);
		menuSelectPane.add(tbd1);
		menuSelectPane.add(tbd2);
		
		contentPane.add(logoPane, BorderLayout.CENTER);
		contentPane.add(menuSelectPane, BorderLayout.SOUTH);
	   	 
		frame.setSize(500, 400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		 //frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		 
	}
	
	public void Jframe_upload(){
		
	};
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		/* 오픈 버튼 선택시 */
		if (e.getSource() == openButton){
			if(jfc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION){
				File file = jfc.getSelectedFile();
				boolean file2 = jfc.accept(file);				
				String file_Name = file.getName();
				String file_addr = file.getPath();
				jbl.setText("선택한 파일: " + file_addr);
				System.out.println(file_Name);
				System.out.println(file2);
			}
		}
	   /* 세이브 버튼 선택시 */	
		if (e.getSource() == saveButton){
			if (jfc.accept(jfc.getSelectedFile()) == true) {
				System.out.println(jfc.accept(jfc.getSelectedFile()));
			}
			System.out.println("파일세이브선택");
		}
		
	}

}
