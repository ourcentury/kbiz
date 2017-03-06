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
	   //  Jframe_Test jt = new Jframe_Test();
		System.out.println("실행되나?");
		String[] vari = new String[2];
		vari[0] = "xls";
		vari[1] = "xls1";
				
		excel_excutor ec = new excel_excutor(vari[0]);
		String[][] temp = ec.excel_excutor_result();
		
		System.out.println(temp[1][2]);
		
		Db_operation dbo = new Db_operation(temp);
		
		
	}
}
class  Jframe_Test extends JFrame implements ActionListener {

	private JFrame frame = new JFrame();
	private JPanel buttonPane = new JPanel();
	private JFileChooser jfc = new JFileChooser();
	private JLabel jbl = new JLabel();
	private JButton openButton = new JButton("Open");
	private JButton saveButton = new JButton("Save");
	
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
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == openButton){
			if(jfc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION){
				File file = jfc.getSelectedFile();
				boolean file2 = jfc.accept(file);				
				String file_Name = file.getName();
				jbl.setText("선택한 파일: " + file_Name);
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
