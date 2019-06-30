package UI.Panel;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import Exception.PlayerException;
import UI.Frame.ConnectFrame;
import UI.Frame.LoginFrame;
import UI.Frame.MainFrame;

@SuppressWarnings("serial")
public class Menu extends JMenuBar{

	private static Menu instance=null;
	
	private JMenu gameMenu;
	private JMenuItem startGameBtn;
	private JMenuItem loginBtn;
	private JMenuItem connectBtn;

	private JMenu helpMenu;
	private JMenuItem gmHelp;
	private JMenuItem makers;
	
	static public Menu getInstance(MainFrame frame) {
		if(instance == null)
			new Menu(frame);
		return instance;
	}

	private Menu(MainFrame main) {
		instance = this;
		
		initialMenu();		
		setUI();
	}
	private void initialMenu(){		
		instance.setPreferredSize(new Dimension(0,50));
	}
	private void setUI(){
		gameMenu = generateJMenu("게임(G)",new Dimension(100,50),'G');		
		startGameBtn = generateJMenuItem("새 게임 시작(S)",new Dimension(210,50),'S');
		startGameBtn.addActionListener(new StartGame());		
		loginBtn = generateJMenuItem("로그인(L)",new Dimension(210,50),'L');
		loginBtn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				LoginFrame.getInstance().setVisible(true);
			}
			
		});
		connectBtn = generateJMenuItem("네트워크 연결(C)",new Dimension(210,50),'C');
		connectBtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				ConnectFrame.getInstance().setVisible(true);
			}
			
		});
		
		gameMenu.add(startGameBtn);
		gameMenu.addSeparator();
		gameMenu.add(connectBtn);
		gameMenu.addSeparator();
		gameMenu.add(loginBtn);
		
		helpMenu = generateJMenu("도움말(H)",null,'H');		
		gmHelp = generateJMenuItem("게임 도움말",new Dimension(180,50),'\0');		
		makers = generateJMenuItem("만든이들",new Dimension(180,50),'\0');		
		helpMenu.add(gmHelp);
		helpMenu.addSeparator();
		helpMenu.add(makers);

		instance.add(gameMenu);
		instance.add(helpMenu);
		
	}
	private JMenu generateJMenu(String name,Dimension d,char nemoinic){
		
		JMenu temp = new JMenu(name);
		
		temp.setMnemonic(nemoinic);
		temp.setPreferredSize(d);
		temp.setFont(new Font("굴림",Font.BOLD,25));
		
		return temp;
	}
	private JMenuItem generateJMenuItem(String name,Dimension d,char nemoinic){
		
		JMenuItem temp = new JMenuItem(name);
		
		temp.setMnemonic(nemoinic);
		temp.setPreferredSize(d);
		temp.setFont(new Font("굴림",Font.BOLD,25));
		
		return temp;
	}
	private class StartGame implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			try{
			//forTest
				MainFrame fm = MainFrame.getInstance();
				MainPanel pm = fm.getMainPanel();
				for(int i=0 ; i<4 ; i++) pm.addPlayer();
				if(pm.getPlayerNum() == 0)
					throw new PlayerException();
				//game init
				pm.initGame();
				fm.setUIVisible(true);
				fm.getControlPanel().switchingQuestState();
			}catch(PlayerException arg){
				System.out.println("플레이어가 없습니다.");
			}
		}
		
	}
}
