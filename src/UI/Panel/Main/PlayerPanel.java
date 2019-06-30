package UI.Panel.Main;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Exception.WinException;
import Inner.Player;
import Inner.Shape;
import UI.Card;
import UI.Frame.MainFrame;
import UI.Panel.MainPanel;

@SuppressWarnings("serial")
public class PlayerPanel extends JPanel {
	
	private int playerID;
	private Player player;
	
	private JLabel inhand[];
	private JLabel quest[];
	private JLabel shape[];

	public PlayerPanel(){
		playerID = -1;
		setBackground(null);
		setUI();
	}
	public void setClearedQuest(int i)throws WinException{
		if (playerID == -1){
			System.out.println("플레이어가 접속되지 않았습니다.");
			return;
		}
		quest[i].setVisible(false);
		player.setQuestCnt();
		if(player.getQuestCnt()==3)
			throw new WinException(playerID);
	}
	public void pushInhandUI(Card card){
		if (playerID == -1){
			System.out.println("플레이어가 접속되지 않았습니다.");
			return;
		}
		int top = player.getInhand().size();
		if(top != 0){
			inhand[top-1].setIcon(player.getInhand().get(top-1).getSmallIcon());
		}
		player.getInhand().add(card);
		inhand[top].setIcon(card.getLargeIcon());
	}
	
	//initMethod
	public void initPlayer(){
		MainPanel mp = MainFrame.getInstance().getMainPanel();
		
		playerID = mp.getPlayerNum();
		player = new Player();
		setUI();
	}
	
	//refrash Method
	public void refrash(){
		if (playerID == -1){
			System.out.println("플레이어가 접속되지 않았습니다.");
			return;
		}
		refrashCoin();
		refrashInhand();
	}
	public void refrashCoin(){
		for(int i=0;i<shape.length;i++){
			shape[i].setText(Shape.getToShape(i) + "  " + player.getCoin(i));
		}
	}
	public void refrashInhand(){
		int nextCardlocation=5;
		int size = player.getInhand().size();
		
		for(int i = 0 ; i < size-1 ; i++){
			inhand[i] = new JLabel(player.getInhand().get(i).getSmallIcon());
			inhand[i].setBounds(nextCardlocation,60,45,180);
			inhand[i].setVisible(true);
			add(inhand[i]);
			nextCardlocation +=45;
		}
		if(size != 0){
			inhand[size-1] = new JLabel(player.getInhand().get(size-1).getLargeIcon());
			inhand[size-1].setBounds(nextCardlocation,60,135,180);
			inhand[size-1].setVisible(true);
			add(inhand[size-1]);
		}		
	}
	
	//getter,setter
	public Player getPlayer() {
		return player;
	}
	
	//private
	private void setUI(){
		setLayout(null);
		setInhandUI();
		setCoinUI();
		setQuestUI();
	}
	private void setCoinUI(){
		if(shape == null)
			shape = new JLabel[4];
		
		int location = 540;
		for(int i=0;i<shape.length;i++){
			shape[i] = new JLabel(Shape.getToShape(i));
			shape[i].setFont(new Font("굴림",Font.BOLD,30));
			shape[i].setBounds(location,10,137,30);
			add(shape[i]);
			location+=140;
		}
	}
	private void setQuestUI(){
		int nextlocation = 10;
		quest = new JLabel[10];
		for(int i =0;i<10;i++){
			quest[i] = new JLabel(""+i);
			quest[i].setFont(new Font("굴림",Font.BOLD,30));
			quest[i].setBounds(nextlocation,10,40,30);
			add(quest[i]);
			nextlocation += 50;
		}
	}
	private void setInhandUI(){		
		inhand = new JLabel[22];		
		for(int i = 0 ; i < 22 ; i++) inhand[i] = new JLabel();
	}
}
