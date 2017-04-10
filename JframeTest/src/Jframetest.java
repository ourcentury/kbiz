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
import java.awt.TextField;
import java.awt.event.ActionEvent;	
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;
import javax.swing.filechooser.*;
import javax.swing.table.TableModel;

public class Jframetest {			
	public static void main(String[] args) throws IOException{
	     Jframe_Test jt = new Jframe_Test();
	     jt.Jframe_initial(0);
	    
	     
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
class  Jframe_Test extends JFrame implements ActionListener, ItemListener {
    
	private JFrame frame = new JFrame();
	private JFrame frame1 = new JFrame();
	private JPanel logoPane = new JPanel(); // 첫화면 logo 패널
	private JPanel menuSelectPane = new JPanel(); //6개의 버튼으로 구성된 첫번재 화면 메뉴 선택 패널	
	private JPanel buttonPane = new JPanel();  //
	private JPanel init_btn_Panel = new JPanel();
	private JFileChooser jfc = new JFileChooser();
	private JLabel jbl = new JLabel();
	private JTextArea jtxt_area = new JTextArea();
	/* 버튼 생성 */
	private JButton upload_comp = new JButton("1.Upload Company Info");
	private JButton upload_product = new JButton("2.Upload Product Info");
	private JButton upload_transaction = new JButton("3.Upload Transaction Info");
    private JButton download_info = new JButton("4. Download Info");
    private JButton tbd1 = new JButton("5. TBD1");
    private JButton tbd2 = new JButton("6. TBD2");
//    private JButton excel_dload_btn = new JButton("Excel Download");
    private JButton srch_btn = new JButton("Search");
    private JButton excel_export = new JButton("Excel");
    
	private JButton openButton = new JButton("Open");
	private JButton saveButton = new JButton("Save");
	private JButton initButton = new JButton("Home");
	private JButton company_info_upload = new JButton("1.Upload Company Info");
	private JButton product_info_upload = new JButton("2.Upload Product Info");
	private JButton info_download = new JButton("3.Download Information");
	private GridLayout experimetalLayout = new GridLayout(2,1);
	private Container contentPane = frame.getContentPane();
	
	private JCheckBox select_All = new JCheckBox("전체");
	private JCheckBox comp_info = new JCheckBox("회사정보");
	private JCheckBox product_info = new JCheckBox("상품정보");
	private JCheckBox pro_trans_history = new JCheckBox("상품거래내역");
	private JTextField comp_name_srch  = new JTextField("");
	private JScrollPane textfield_panel = new JScrollPane();
	private JTable jt = new JTable();
	public String[][] temp;
	String file_extender;	
	
	
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
	public void Jframe_initial(int init_type){
		/*
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
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
		
		/* INITIATING ONLY */
		if(init_type == 0){
			//frame.setSize(500, 400);
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			upload_comp.addActionListener(this);
			upload_product.addActionListener(this);
			upload_transaction.addActionListener(this);
			download_info.addActionListener(this);
			tbd1.addActionListener(this);
			tbd2.addActionListener(this);
			openButton.addActionListener(this);
			saveButton.addActionListener(this);
			initButton.addActionListener(this);
			srch_btn.addActionListener(this);
			excel_export.addActionListener(this);
			
			/* 아이템리스너 넣기 */
		    select_All.addItemListener(this);
		    comp_info.addItemListener(this);
		    product_info.addItemListener(this);
		    pro_trans_history.addItemListener(this);
			}		
		 //frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		 
	}
	
	public void Jframe_empty(String pane_recog){	   	
	   if (pane_recog=="initial"){		   
		   contentPane.removeAll();
		   frame.invalidate();
		   frame.validate();
		   frame.repaint();		
		   System.out.println("remove");
	   }
	   System.out.println("revalidate");
	   //frame.invalidate();
	   //frame.validate();
	   //frame.repaint();
	   
	}
	public void Jframe_upload(int upload_type){
		
		
		System.out.println("upload type : " + upload_type);
		JPanel label_panel = new JPanel();
		
		GroupLayout g_layout = new GroupLayout(contentPane);
		contentPane.setLayout(g_layout);
		g_layout.setAutoCreateGaps(true) ;
		g_layout.setAutoCreateContainerGaps(true);
		
		g_layout.setHorizontalGroup(
				g_layout.createParallelGroup()				    
				    .addComponent(logoPane)
				    .addGroup(g_layout.createSequentialGroup()				    		
				    	     .addComponent(jtxt_area))				    		
                    .addGroup(g_layout.createSequentialGroup()				    				
				    		.addComponent(initButton)
				    		.addGap(250)
				    		.addComponent(openButton)
				    		.addComponent(saveButton))				    		
				        );
		g_layout.setVerticalGroup(
				   g_layout.createSequentialGroup()
				      .addComponent(logoPane)
				      .addGroup(g_layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				           .addComponent(jtxt_area))
				      .addGroup(g_layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				    	   .addComponent(initButton)  
				           .addComponent(openButton)
				           .addComponent(saveButton))
				);
		
		
		
	    jtxt_area.setText("파일선택 전입니다.");
	    jtxt_area.setEditable(false);
		label_panel.add(jtxt_area);		
		
		//openButton.addActionListener(this);
		//saveButton.addActionListener(this);
		//initButton.addActionListener(this);
				
		jfc.setFileFilter(new FileNameExtensionFilter("xls & xlsx", "xls", "xlsx"));
		jfc.setMultiSelectionEnabled(false);
		
		frame.invalidate();
		frame.validate();
		frame.repaint();		

	};
	public void Jframe_download() {
		JLabel comp = new JLabel(); //회사정보 검색 레이블
		
		JTextArea txtfield = new JTextArea("");
		
		
		GroupLayout g_layout = new GroupLayout(contentPane);
		contentPane.setLayout(g_layout);
		g_layout.setAutoCreateGaps(true) ;
		g_layout.setAutoCreateContainerGaps(true);
		
		g_layout.setHorizontalGroup(
				g_layout.createParallelGroup()				    
				    .addComponent(textfield_panel)
				    .addGroup(g_layout.createSequentialGroup()
				    		.addComponent(comp)
				    		.addComponent(comp_name_srch,50,150,150)				    		
				    		.addComponent(select_All)
				    		.addGap(417)
				    		.addComponent(excel_export, 50, 75, 75))				            
				    .addGroup(g_layout.createSequentialGroup()				    				
				    		.addComponent(comp_info)
				    		.addComponent(product_info)
				    		.addComponent(pro_trans_history)
				    		.addGap(350)
				    		.addComponent(initButton)
				   			.addComponent(srch_btn))						    		 
				    );
		g_layout.setVerticalGroup(
				   g_layout.createSequentialGroup()
				      .addComponent(textfield_panel)
				      .addGroup(g_layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				           .addComponent(comp)
				           .addComponent(comp_name_srch)
				           .addComponent(select_All)
				           .addComponent(excel_export))				           
				      .addGroup(g_layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				           .addComponent(product_info)
				           .addComponent(comp_info)
				           .addComponent(pro_trans_history)
				           .addComponent(initButton)
				           .addComponent(srch_btn))
				           
				);
		
		comp.setText("회사명 : ");
		
		ItemListener listner = new ItemListener(){
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		};
		
		if (textfield_panel.getColumnHeader() == null){
			excel_export.setEnabled(false);
			System.out.println("1번입니다");
		} else {
			excel_export.setEnabled(true);
			System.out.println("2번입니다");
		}
		//JPanel textfield_panel = new JPanel();		
		//contentPane.setLayout(new BorderLayout());
        //buttonPane.setLayout(new GridLayout());		
		
		
		//JTextField txtfield = new JTextField(1);
		//textfield_panel.add(txtfield);
		
	
		//contentPane.setPreferredSize(new Dimension(100,200));
		//textfield_panel.setPreferredSize(new Dimension(100,200));
	    //contentPane = frame.getContentPane();
		
		//contentPane.add(textfield_panel);
		frame.setSize(800,600);
		frame.invalidate();
		frame.validate();
		frame.repaint();
		
		
		//frame1.setVisible(true);
		//frame1.setSize(500, 500);
      	//	frame1.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	}
	
	@Override
	public void itemStateChanged(ItemEvent e){
		// when select select_all company
		if(e.getSource() == select_All){
			System.out.println(e.getStateChange());
			if(e.getStateChange() == 1){
				comp_name_srch.setText("");
				comp_name_srch.setEditable(false);
			} else{
				comp_name_srch.setEditable(true);
			}
		}
		if(e.getSource() == comp_info){
			System.out.println(e.getStateChange());
		}
		if(e.getSource() == product_info){
			System.out.println(e.getStateChange());
		}
		if(e.getSource() == pro_trans_history){
			System.out.println(e.getStateChange());
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		/* 메뉴에서 회사정보 업로드하는 메뉴를 선택 했을 때 */		
		if (e.getSource() == upload_comp){			
			String recog = "initial";
			Jframe_empty(recog);
			System.out.println("1");			
			Jframe_upload(1);			
		}
		/* 메뉴에서 상품정보 업로드하는 메뉴를 선택 했을 때 */		
		if (e.getSource() == upload_product){			
			String recog = "initial";
			Jframe_empty(recog);
			System.out.println("2");			
			Jframe_upload(2);			
		}
		/* 메뉴에서 트랜잭션 업로드하는 메뉴를 선택 했을 때 */
		if (e.getSource() == upload_transaction){			
			String recog = "initial";
			Jframe_empty(recog);
			System.out.println("3");			
			Jframe_upload(3);			
		}
		
		/* 메뉴에서 서치하는 메뉴를 선택 했을 때 */
		if (e.getSource() == download_info){
			String recog = "initial";
			Jframe_empty(recog);
			Jframe_download();
			System.out.println("$$");			
		}
		/* 메뉴에서 서치하는 메뉴를 선택 했을 때 */
		if (e.getSource() == tbd1){
			String recog = "initial";
			Db_operation dbo = new Db_operation();
			dbo.Db_operate1();			
			System.out.println("$$");			
		}
		/* 홈버튼 메뉴 선택 */		
		if (e.getSource() == initButton){
			String recog = "initial";
			Jframe_empty(recog);
			System.out.println("@@");			
			Jframe_initial(1);
			System.out.println("!!");
			
		}
		/* Search button 메뉴 선택 */		
		if (e.getSource() == srch_btn){
			// parameter setting for stored procedure. 
			String srch_recog;			
			if(select_All.isSelected()){
				srch_recog = "1";
			} else {
				srch_recog = "2";
			}
			if(comp_info.isSelected()){
				srch_recog = srch_recog + "1";
			} else {
				srch_recog = srch_recog + "2";
			}
			if(product_info.isSelected()){
				srch_recog = srch_recog + "1";
			} else {
				srch_recog = srch_recog + "2";
			}
			if(pro_trans_history.isSelected()){
				srch_recog = srch_recog + "1";
			} else {
				srch_recog = srch_recog + "2";
			}
			String comp_name = comp_name_srch.getText();
			if(srch_recog.substring(0,1).equals("2") && comp_name_srch.equals("")){
				JOptionPane.showMessageDialog(null, "회사명을 입력하거나 전체 선택을 해주세요.", "회사명 입력오류.", JOptionPane.ERROR_MESSAGE);
			}
			Db_operation dbo = new Db_operation();
			// select 문 실행
			System.out.println(srch_recog + "회사명 : " +comp_name);
			Object[][] sel_result = dbo.Db_select("search_info", srch_recog, comp_name);
			
			//ArrayList<Map<String, Object>> data = (ArrayList<Map<String, Object>>) sel_result[0];			
			//ArrayList<String> column_name =  (ArrayList<String>) sel_result[1];
			//String[][] data = (String[][]) sel_result[0];
			//Object[] res_ret = data.toArray();
			//Object[] col_lists = column_name.toArray();
			int row_cnt = sel_result.length;
			int column_cnt = sel_result[0].length;
			
			String[] column_list = new String[column_cnt];
			Object[][] data = new Object[row_cnt-1][column_cnt];
			//System.out.println(data[0][0]);
			//System.out.println(sel_result);
			//System.out.println(col_lists[0]);
			for(int i=0;i<column_cnt;i++){
				column_list[i] = (String) sel_result[0][i];
			}
				
			System.arraycopy(sel_result, 1, data, 0, row_cnt-1);
			
			jt = new JTable(data, column_list);		
			jt.doLayout();
			textfield_panel = new JScrollPane(jt);
			textfield_panel.createHorizontalScrollBar();
			
			textfield_panel.setPreferredSize(getPreferredSize());
			Jframe_empty("initial");
			Jframe_download();
			
			
		}
		/* excel 선택시 */
		if (e.getSource() == excel_export){
			TableModel temp_model = jt.getModel();
			
			HashMap<String, Object> map = null;
			ArrayList<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
			ArrayList<String> columnList=new ArrayList<String>();
			
			int col_cnt = temp_model.getColumnCount();
			int row_cnt = temp_model.getRowCount();
			for (int i=0;i<col_cnt;i++){
				columnList.add(temp_model.getColumnName(i));
			};
			
			for(int i=0;i<row_cnt;i++){
				map = new HashMap<String, Object>();
				for(int j=0;j<col_cnt;j++){
					map.put(temp_model.getColumnName(j), temp_model.getValueAt(i, j));
				}
				list.add(map);
			}
			try {
				excel_excutor et = new excel_excutor();
				et.excel_writer(list, columnList);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
		/* 오픈 버튼 선택시 */
		if (e.getSource() == openButton){
			if(jfc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION){
				File file = jfc.getSelectedFile();
				boolean file2 = jfc.accept(file);				
				String file_Name = file.getName();
				String file_addr = file.getPath();
				jtxt_area.setText("선택한 파일: " + file_addr);				
				file_extender = file_Name.substring(file_Name.lastIndexOf(".")+1);
				
				System.out.println(file_addr);
				System.out.println(file_extender);
				
			}
		}
	   /* 세이브 버튼 선택시 */	
		if (e.getSource() == saveButton){
			if (jfc.accept(jfc.getSelectedFile()) == true) {
				System.out.println(jfc.accept(jfc.getSelectedFile()));
				File file = jfc.getSelectedFile();
				String file_Name = file.getName();
				String file_addr = file.getPath();
				
				System.out.println(file_addr + "2");
				System.out.println(file_extender + "2");
				
				try {
					excel_excutor ec = new excel_excutor();
					temp = ec.excel_excutor_result(file_extender,file_addr);
					
					Db_operation dbo = new Db_operation();
					dbo.Db_operate(temp);
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
								
			}
			System.out.println("파일세이브선택");
		}
		
	}

}
