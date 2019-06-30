package UI.Panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import Inner.Coin;
import Inner.Shape;
import UI.Frame.MainFrame;
import UI.Frame.QuestFrame;
import UI.Panel.Control.BettingConsol;
import UI.Panel.Main.PlayerPanel;

@SuppressWarnings("serial")
public class ControlPanel extends JPanel {
	
	private BettingConsol shape[];
	private JButton changingBtn;
	private JButton nextTurn;
		
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
	public void switchingQuestState(){
		changingBtn.setText("퀘스트 깨기");
		changingBtn.removeActionListener(betting);
		changingBtn.addActionListener(clearing);
		changingBtn.setVisible(true);
		nextTurn.setVisible(true);
		for(int i=0;i<Coin.coinNum;i++){
			shape[i].setVisible(false);
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
	public ControlPanel() {
		
		setBackground(null);
		setPreferredSize(new Dimension(400,1600));//버튼 패널의 크기
		setUI();
		
	}
	//private Method
	private void setUI(){
		setLayout(new GridLayout(6,1,0,2));
		
		shape = new BettingConsol[4];
		
		shape[Shape.SPADE] = new BettingConsol("SPADE");
		shape[Shape.DIAMOND] = new BettingConsol("DIAMOND");
		shape[Shape.HEART] = new BettingConsol("HEART");
		shape[Shape.CLOVER] = new BettingConsol("CLOVER");
		
		changingBtn = generateJButton("배팅 하기");
		nextTurn = generateJButton("넘기기");
		nextTurn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				switchingNullState();
			}
			
		});
		
		add(shape[Shape.SPADE]);
		add(shape[Shape.HEART]);
		add(shape[Shape.DIAMOND]);
		add(shape[Shape.CLOVER]);
		add(nextTurn);
		add(changingBtn);
		
		switchingNullState();
	}
  	private JButton generateJButton(String name){
		
		JButton temp = new JButton(name);
		
		temp.setPreferredSize(new Dimension(400,214));
		temp.setBackground(new Color(0,100,0));
		temp.setFont(new Font("굴림",Font.BOLD,60));
		
		return temp;
	}
	private ActionListener clearing =new ActionListener(){
		private QuestFrame frame=null;
		@Override
		public void actionPerformed(ActionEvent arg0) {
			frame = new QuestFrame();
		}
	};
	private ActionListener betting = new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent arg0) {
			PlayerPanel me = MainFrame.getInstance().getMainPanel().getPlayerPanel()[MainPanel.Me];
			Coin temp= new Coin();
			
			for(int i=0;i<Coin.coinNum;i++)
				if(shape[i].getData()<me.getPlayer().getCoin(i))
					temp.setCoin(i, shape[i].getData());
			
			me.getPlayer().setbetting(temp);
			me.refrashCoin();
			
			switchingNullState();
		}
	};
}
