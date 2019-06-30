package UI.Panel;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import Inner.Game;
import UI.Panel.Main.CenterPanel;
import UI.Panel.Main.PlayerPanel;

@SuppressWarnings("serial")
public class MainPanel extends JPanel {

	public static final int Me =0;
	
	private Game gm = null;
	private CenterPanel center = null;
	private int playerNum=0;
	private PlayerPanel player[];
	
	public MainPanel() {
		playerNum=0;
		setBackground(null);
		setPreferredSize(new Dimension(1600,1600));
		setUI();
	}
	//getter,setter
	public Game getGameInfor(){
		return gm;
	}
	public CenterPanel getCenterPanel() {
		return center;
	}
	public PlayerPanel[] getPlayerPanel() {
		return player;
	}
	public int getPlayerNum(){
		return playerNum;
	}
	//playerMethod
	public void addPlayer(){
		try{
			if(playerNum==4)
				throw new Exception();
			player[playerNum].initPlayer();
			player[playerNum].setVisible(true);
			playerNum++;
		}catch(Exception e){
			System.out.println("플레이어를 생성할 수 없습니다.");
		}
	}
	//initMethod
	public void initGame(){
		gm = new Game(playerNum);
		for(int i=0;i<gm.getQuest().size();i++){
			center.setQuest(i, i + ". " + gm.getQuest().get(i).getQuest());
		}
		for(int i=0;i<playerNum;i++){
			player[i].initPlayer();
		}
		center.setNotification("");
		for(int i = 0; i < 2; i++){
			for(int j = 0; j < playerNum; j++){
				int cur = (j+gm.getFirstPlayer())%playerNum;
				gm.draw();
				player[cur].pushInhandUI(gm.getdrawCard());
				player[cur].refrashInhand();
			}
		}
		for(int i=0;i<playerNum;i++){
			player[i].refrash();
		}
		center.setcurrentCard(gm.getdrawCard().getLargeIcon());
		center.setremainCardString(gm.getRemainCard());
		center.setNotification(gm.getTurn()+"턴 째,"+gm.getFirstPlayer()+"의 차례");
	}
	
	private void setUI(){
		setLayout(null);
		setCenterUI();
		setPlayerUI();
	}
	private void setCenterUI(){
		//Center
		center = new CenterPanel();
		center.setBounds(250,250,1100,1100);
		add(center);
	}
	private void setPlayerUI(){
		player = new PlayerPanel[4];
		
		//SOUTH
		player[0] =new PlayerPanel();
		player[0].setBounds(250, 1350, 1100, 250);
		player[0].setVisible(false);
		add(player[0]);
		//WEST
		player[1] = new PlayerPanel(){
			private Graphics2D g2d;
			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);                
				g2d = (Graphics2D) g;
              
				float x = this.getWidth() / 2.0f;
				float y = this.getHeight() / 2.0f;
              
				g2d.rotate(Math.PI/2, x, y);
			}
			@Override
			public void paintChildren(Graphics g) {
				super.paintChildren(g2d);
			}
		};
        player[1].setBounds(-850,250,1100,1100);
		player[1].setVisible(false);
        add(player[1]);
        //NORTH
		player[2] = new PlayerPanel(){
			private Graphics2D g2d;
			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);                
				g2d = (Graphics2D) g;
				
				float x = this.getWidth() / 2.0f;
				float y = this.getHeight() / 2.0f;
               
				g2d.rotate(Math.PI, x, y);
			}
 				@Override
			public void paintChildren(Graphics g) {
				super.paintChildren(g2d);
			}
		};
		player[2].setBounds(250,0,1100,250);
		player[2].setVisible(false);
       	add(player[2]);
       	//EAST
		player[3] = new PlayerPanel(){
			private Graphics2D g2d;
			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);                
				g2d = (Graphics2D) g;
               
				float x = this.getWidth() / 2.0f;
				float y = this.getHeight() / 2.0f;
               
				g2d.rotate(Math.PI/2*3, x, y);
			}
			@Override
			public void paintChildren(Graphics g) {
				super.paintChildren(g2d);
			}
		};
		player[3].setBounds(1350,250,1100,1100);
		player[3].setVisible(false);
		add(player[3]);
	}
}

