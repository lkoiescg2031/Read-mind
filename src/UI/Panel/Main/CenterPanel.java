package UI.Panel.Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class CenterPanel extends Panel {
	
	//�˸�â
	private JLabel notification;
	
	//���� ����ī��
	private JLabel currentCard;
	private JLabel remainCardString;
	
	//����Ʈ
	private JLabel questList[];
	//�÷��̾� ����	
	private JLabel player[];

	public CenterPanel() {
		setBackground(new Color(0,170,0));
		setUI();
	}
	public void setNotification(String alert){
		notification.setText(alert);
	}
	public void setcurrentCard(ImageIcon cur){
		currentCard.setIcon(cur);
	}
	public void setremainCardString(int value){
		remainCardString.setText("���� ī�� : " + value + "��");
	}
	public void setQuest(int i,String name){
		questList[i].setText(name);
	}
	public void initBettingUI(){
		for(int i=0;i<player.length;i++)
			player[i].setText("");
	}
	public void setBetting(int i,int value){
		player[i].setText(String.valueOf(value));
	}
	
	private void setUI(){
		setLayout(null);
		setQuestUI();
		setDeckUI();		
		setBettingUI();
		setNotificationUI();
	}
	private void setQuestUI(){
		int Lheight =800;
		int Rheight =800;
		
		JLabel questName = new JLabel("Quest List");
		questName.setFont(new Font("����",Font.BOLD,50));
		questName.setBounds(410,720,266,40);
		add(questName);
		
		questList =new JLabel[10];
		for(int i=0;i<10;i++){
			questList[i]= new JLabel(i+". 10�� ��,��,not(-1 and 1)");
			questList[i].setFont(new Font("����",Font.BOLD,33));
			if(i%2 == 0){
				questList[i].setBounds(68,Lheight,500,33);
				Lheight+=40;
			}else{
				questList[i].setBounds(568,Rheight,500,33);
				Rheight+=40;
			}
			add(questList[i]);
		}
	}
	private void setDeckUI(){

		JLabel currentCardString = new JLabel("���� ī��");
		currentCardString.setFont(new Font("����",Font.BOLD,50));
		currentCardString.setBounds(140,280,232,40);
		add(currentCardString);
		
		currentCard = new JLabel(new ImageIcon("./Image/sample.jpg"));
		currentCard.setBounds(187,380,134,180);
		add(currentCard);
		
		remainCardString = new JLabel("���� ī�� : " + 40 + "��");
		remainCardString.setFont(new Font("����",Font.BOLD,30));
		remainCardString.setBounds(135,610,246,40);
		add(remainCardString);
	}
	private void setBettingUI(){
		
		JLabel betting = new JLabel("�÷��̾� ����");
		betting.setFont(new Font("����",Font.BOLD,50));
		betting.setBounds(540,250,500,50);
		add(betting);
		
		player = new JLabel[4];
		
		JLabel south = new JLabel("South :");
		south.setFont(new Font("����",Font.BOLD,40));
		south.setBounds(450,340,600,40);
		add(south);
		player[0] = new JLabel("");
		player[0].setFont(new Font("����",Font.BOLD,40));
		player[0].setBounds(750,340,600,40);
		add(player[0]);

		
		JLabel west = new JLabel("West :");
		west.setFont(new Font("����",Font.BOLD,35));
		west.setBounds(450,440,600,35);
		add(west);
		player[1] = new JLabel("");
		player[1].setFont(new Font("����",Font.BOLD,40));
		player[1].setBounds(750,440,600,40);
		add(player[1]);
		
		JLabel north = new JLabel("North :");
		north.setFont(new Font("����",Font.BOLD,35));
		north.setBounds(450,540,600,35);
		add(north);
		player[2] = new JLabel("");
		player[2].setFont(new Font("����",Font.BOLD,40));
		player[2].setBounds(750,540,600,40);
		add(player[2]);
		
		JLabel east = new JLabel("East :");
		east.setFont(new Font("����",Font.BOLD,35));
		east.setBounds(450,640,600,35);
		add(east);
		player[3] = new JLabel("");
		player[3].setFont(new Font("����",Font.BOLD,40));
		player[3].setBounds(750,640,600,40);
		add(player[3]);
		
	}
	private void setNotificationUI(){
		//int maxstringsize =15;
		
		notification = new JLabel("�˸�â�� �����մϴ�. ���̴�");
		notification.setFont(new Font("����",Font.BOLD,60));
		notification.setBackground(Color.WHITE);
		notification.setBounds(135, 130, 1000, 60);
		add(notification);
	}}
