package UI.Frame;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;

import UI.Panel.ControlPanel;
import UI.Panel.MainPanel;
import UI.Panel.Menu;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	
	private static MainFrame instance=null;
	private MainPanel mainPanel = null;
	private ControlPanel btnPanel = null;
	
	public static MainFrame getInstance(){
		if(instance == null)
			instance = new MainFrame();
		return instance;
	}
	public void setUIVisible(boolean arg){
		mainPanel.setVisible(arg);
		btnPanel.setVisible(arg);
	}
	public MainPanel getMainPanel() {
		return mainPanel;
	}
	public ControlPanel getControlPanel() {
		return btnPanel;
	}
	
	private MainFrame() {		
		Container contantpane = this.getContentPane();
		
		setSize(2016,1702);//매인 프레임의 킈기
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Card Game!");	
		setLocation();
		setJMenuBar(Menu.getInstance(this));
		contantpane.setBackground(new Color(0,147,0));
		setUI();
		setVisible(true);
	}
	private void setLocation(){		
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dms = tk.getScreenSize();
		Dimension dms_frame = this.getSize();
		int x = (int)(dms.getWidth() / 2 - dms_frame.getWidth() / 2);
		int y = (int)(dms.getHeight() / 2 - dms_frame.getHeight() / 2);
		this.setLocation(x, y);		
	}
	private void setUI(){
		mainPanel = new MainPanel();
		btnPanel = new ControlPanel();
		
		setLayout(new FlowLayout(FlowLayout.LEFT,5,0));
		add(mainPanel);
		add(btnPanel);
		setUIVisible(false);
	}
	
	public static void main(String[] args) {
		MainFrame.getInstance();
	}
}
