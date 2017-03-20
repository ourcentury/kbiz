import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
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
	private JButton initButton = new JButton("Home");
	private JButton company_info_upload = new JButton("1.Upload Company Info");
	private JButton product_info_upload = new JButton("2.Upload Product Info");
	private JButton info_download = new JButton("3.Download Information");
	private GridLayout experimetalLayout = new GridLayout(2,1);
	private Container contentPane = frame.getContentPane();
	
	
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
		
		contentPane.setBackground(Color.gray);
		contentPane.setLayout(experimetalLayout);
		
		menuSelectPane.setLayout(new GridLayout(3,2));
		menuSelectPane.add(upload_comp );
		menuSelectPane.add(upload_product );
		menuSelectPane.add(upload_transaction);
		menuSelectPane.add(download_info);
		menuSelectPane.add(tbd1);
		menuSelectPane.add(tbd2);
		
		upload_comp.addActionListener(this);
		upload_product.addActionListener(this);
		upload_transaction.addActionListener(this);
		download_info.addActionListener(this);
		tbd1.addActionListener(this);
		tbd2.addActionListener(this);
		
		contentPane.add(logoPane, BorderLayout.CENTER);
		contentPane.add(menuSelectPane, BorderLayout.SOUTH);
	   	 
		frame.setSize(500, 400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		 //frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		 
	}
	
	public void Jframe_empty(String pane_recog){	   	
	   if (pane_recog=="initial"){		   
		   contentPane.removeAll();
		   //frame.getContentPane().removeAll();
		   frame.invalidate();
		   frame.validate();
		   frame.repaint();		
		   
		   //frame.getContentPane().repaint();
		   
		  //contentPane.remove(logoPane);
		  //contentPane.remove(menuSelectPane);
		  
		  System.out.println("remove");
	   }
	   System.out.println("revalidate");
	   //frame.invalidate();
	   //frame.validate();
	   //frame.repaint();
	   
	}
	public void Jframe_upload(){
		
		JPanel label_panel = new JPanel();
		JPanel blank_panel = new JPanel();
		JPanel init_btn_Panel = new JPanel();
		
		contentPane.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		//GridBagConstraints c1 = new GridBagConstraints();
		//GridBagConstraints c2 = new GridBagConstraints();
		
		
	    //c.ipadx = 0;
		c.fill = GridBagConstraints.FIRST_LINE_START;
		c.anchor = GridBagConstraints.BASELINE_LEADING;		
		c.gridx=0;
		c.gridy=1;
		c.gridwidth = 3;	
		//c.gridheight = 3;
		c.weightx = 0.7;
	    c.weighty = 0.5;
		//c.gridheight = 2;		
		//c.gridwidth = 100;
		
		jbl.setText("파일선택 전입니다.");
		label_panel.add(jbl);		
		contentPane.add(label_panel,c);
		/*
		c.gridx=1;
		c.gridy=0;
		c.gridwidth = 1;
		contentPane.add(blank_panel,c);
		*/
		buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.X_AXIS));
		buttonPane.add(openButton);
		buttonPane.add(saveButton);
		buttonPane.setBackground(Color.white);
		
		openButton.addActionListener(this);
		saveButton.addActionListener(this);
		//buttonPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		//buttonPane.setBorder(BorderFactory.createEmptyBorder(0, 150, 0, 0));
		
		/* init으로 돌아가는 버튼 */
		init_btn_Panel.add(initButton);
		//c.anchor = GridBagConstraints.EAST;
				
		c.gridx=0;
		c.gridy=2;
		//c.ipadx = 3;
		c.gridwidth = 1;	
		c.weightx = 0.15;
		c.weighty = 0.3;
		//c.gridwidth = 0;
				
		//c.insets = new Insets(20,0,0,0);
		contentPane.add(init_btn_Panel, c);
		
		//c.anchor = GridBagConstraints.LAST_LINE_END;		
		c.gridx=2;
		c.gridy=2;
		c.gridwidth = 1;
		//c.weightx = 0;
		//c.gridwidth = 0;
		//c.insets = new Insets(20,50,0,0);
		
		contentPane.add(buttonPane, c);
		
		jfc.setFileFilter(new FileNameExtensionFilter("xls", "xls"));
		jfc.setMultiSelectionEnabled(false);
		
		frame.invalidate();
		frame.validate();
		frame.repaint();

	};
	public void Jframe_download(){
		//JPanel textfield_panel = new JPanel();
		
		JFrame frame1 = new JFrame();
		
		JTextArea txtfield = new JTextArea("바보야바보야바보야바보야바보야바보야바보야바보야바보야바보야바보야바보야바보야바보야바보야바보야바보야바보야바보야바보야바보야바보야바보야바보야바보야");
		JScrollPane textfield_panel = new JScrollPane(txtfield);
		
		//JTextField txtfield = new JTextField(1);
		//textfield_panel.add(txtfield);
		
		
		//textfield_panel.setPreferredSize(new Dimension(500,400));
	    //contentPane = frame.getContentPane();
		
		
		contentPane.setLayout(new BorderLayout());
		contentPane.add(textfield_panel);
		
		
		frame.invalidate();
		frame.validate();
		frame.repaint();
		
		
		//frame1.setVisible(true);
		//frame1.setSize(500, 500);
      	//	frame1.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		/* 메뉴에서 업로드하는 메뉴를 선택 했을 때 */		
		if (e.getSource() == upload_comp){			
			String recog = "initial";
			Jframe_empty(recog);
			System.out.println("1");
			Jframe_upload();
			System.out.println("@");
		}
		/* 메뉴에서 서치하는 메뉴를 선택 했을 때 */
		if (e.getSource() == download_info){
			String recog = "initial";
			Jframe_empty(recog);
			Jframe_download();
			System.out.println("$$");
			
		}
		
		/* 오픈 버튼 선택시 */
		if (e.getSource() == openButton){
			if(jfc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION){
				File file = jfc.getSelectedFile();
				boolean file2 = jfc.accept(file);				
				String file_Name = file.getName();
				String file_addr = file.getPath();
				jbl.setText("선택한 파일: " + file_addr);
				file_Name.lastIndexOf(".") ;
				String file_name_new = file_Name.substring(file_Name.lastIndexOf(".")+1);
				
				System.out.println(file_Name);
				System.out.println(file_name_new);
			}
		}
	   /* 세이브 버튼 선택시 */	
		if (e.getSource() == saveButton){
			if (jfc.accept(jfc.getSelectedFile()) == true) {
				System.out.println(jfc.accept(jfc.getSelectedFile()));
				File file = jfc.getSelectedFile();
				String file_Name = file.getName();
				System.out.println(file_Name);
			}
			System.out.println("파일세이브선택");
		}
		
	}

}
