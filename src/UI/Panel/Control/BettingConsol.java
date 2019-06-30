package UI.Panel.Control;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class BettingConsol extends JPanel {
	
	private Font font;
	private String name;
	private JLabel value;
	private JTextField data;
	
	//refrash
	public void refrash(){
		data.setText("");
	}
	
	//getter,setter
	public int getData(){
		try{
			return Integer.parseInt(data.getText());
		}catch(NumberFormatException e){
			return 0;
		}
	}
	
	//Constructor
	public BettingConsol(String name){
		
		setBackground(null);
		setPreferredSize(new Dimension(400,214));//버튼 패널의 크기
		
		this.name = name;
		font = new Font("굴림",Font.BOLD,50);
		
		setUI();
	}
	
	//private Method
	private void setUI(){
		
		value = new JLabel(name);
		data = new JTextField();
		value.setFont(font);
		data.addKeyListener(new KeyListener(){

			@Override
			public void keyPressed(KeyEvent e) {
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				char c = e.getKeyChar();
				  
				if (!Character.isDigit(c)) {
					e.consume();
					return;
				}
			}
			
		});
		data.setFont(font);
		
		setLayout(new GridLayout(2,1,0,2));
		
		add(this.value);
		add(data);
	}
}
