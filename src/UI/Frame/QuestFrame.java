package UI.Frame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Inner.Coin;
import UI.Panel.Control.BettingConsol;

@SuppressWarnings("serial")
public class QuestFrame extends JFrame {
	
	private JPanel cardPanel;
	private JPanel questPanel;
	
	private JButton selectBtn;
		
	//PannelState Method
	public void switchingBettingState(){
		changingBtn.setText("배팅하기");
		changingBtn.removeActionListener(clearing);
		changingBtn.addActionListener(betting);
		changingBtn.setVisible(true);
		nextTurn.setVisible(false);
		
		for(int i=0;i<Coin.coinNum;i++){
			shape[i].refrash();
			shape[i].setVisible(true);
		}
	}
	public void switchingNullState(){
		changingBtn.setVisible(false);
		nextTurn.setVisible(false);
		for(int i=0;i<Coin.coinNum;i++){
			shape[i].setVisible(false);
		}
		
	}
	
	//Constructor
	public QuestFrame() {		
		setBackground(new Color(0,170,0));
		setLocation();
		setSize(1020,400);
		setUI();
		setVisible(true);
	}
	//private Method
	private void setLocation(){		
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dms = tk.getScreenSize();
		Dimension dms_frame = this.getSize();
		int x = (int)(dms.getWidth() / 2 - dms_frame.getWidth() / 2);
		int y = (int)(dms.getHeight() / 2 - dms_frame.getHeight() / 2);
		this.setLocation(x, y);		
	}
	private void setUI(){
		setLayout(null);
		switchingBettingState();
	}
	private void setQuestUI(){
		questPanel = new JPanel();
		questPanel.setBackground(null);
		questPanel.setBounds(0, 0, 1020, 300);
		questPanel.setLayout(null);
		
		JLabel questLabel = new JLabel("Quset List");
		add(questPanel);
	}
	private void setCardUI(){
		cardPanel = new JPanel();
	}
	private ActionListener betting = new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent arg0) {
			switchingNullState();
		}
	};
}