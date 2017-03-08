import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.event.ActionEvent;	
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.*;
import javax.swing.filechooser.*;

public class Jframetest {			
	public static void main(String[] args) throws IOException{
	    Jframe_Test jt = new Jframe_Test();
	    Jframe_Test jt2 = new Jframe_Test();
	    
	    jt2.Jframe_initial();	    
		System.out.println("실행되나?");
		String[] vari = new String[2];
		vari[0] = "xls";
		vari[1] = "xls1";
		/*		
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
	private JPanel buttonPane = new JPanel();
	private JFileChooser jfc = new JFileChooser();
	private JLabel jbl = new JLabel();
	private JButton openButton = new JButton("Open");
	private JButton saveButton = new JButton("Save");
	private JButton company_info_upload = new JButton("1.Upload Company Info");
	private JButton product_info_upload = new JButton("2.Upload Product Info");
	private JButton info_download = new JButton("3.Download Information");
	
	public Jframe_Test() {
		
        Container contentPane = frame.getContentPane();
		contentPane.setBackground(Color.white);
		
		
		buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.X_AXIS));
		buttonPane.add(openButton);
		buttonPane.add(saveButton);
		buttonPane.setBackground(Color.white);
		
		// --buttonPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		buttonPane.setBorder(BorderFactory.createEmptyBorder(0, 150, 0, 0));
		
		
		jbl.setText("파일선택 전입니다.");
				
		jfc.setFileFilter(new FileNameExtensionFilter("xls", "xls"));
		jfc.setMultiSelectionEnabled(false);
		
		openButton.addActionListener(this);
		saveButton.addActionListener(this);
		
		contentPane.add(jbl, BorderLayout.LINE_END);		
		contentPane.add(buttonPane, BorderLayout.PAGE_END);
		
		frame.setSize(300, 200);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// JOptionPane.showMessageDialog(null, "경고경고", "경고입니다", JOptionPane.ERROR_MESSAGE); 
		
	}
	
	public void Jframe_initial(){
		 
		Container contentPane = frame1.getContentPane();
		 contentPane.setBackground(Color.white);
		 
		 frame1.setSize(400,500);
		 frame1.setVisible(true);
		 frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		 
	}
	@Override
	public void actionPerformed(ActionEvent e) {
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
		
		if (e.getSource() == saveButton){
			if (jfc.accept(jfc.getSelectedFile()) == true) {
				System.out.println(jfc.accept(jfc.getSelectedFile()));
			}
			System.out.println("파일세이브선택");
		}
		
	}

}
