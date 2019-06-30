package UI.Frame;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class ConnectFrame extends JFrame{
	
	private static ConnectFrame instance;
	private JButton btnJoin;//접속 버튼
	private JButton btnClose;//취소 버튼
	private JTextField ip;//ip주소
	private JTextField port;//port번호
	private ButtonGroup human;//호스트, 클라이언트(라디오 버튼)
	
	public static ConnectFrame getInstance(){
		if(instance == null)
			instance = new ConnectFrame();
		return instance;
	}
	private ConnectFrame(){
		
		setTitle("참가 화면");
		setSize(320,160);
		setResizable(false);
		setLocation();
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
		setLayout(null);
				
		//ip
		JLabel ipLabel = new JLabel("ip 주소 : ");
		ipLabel.setBounds(10,10,50,25);
		add(ipLabel);
				
		//port
		JLabel portLabel = new JLabel("포트 번호 :");
		portLabel.setBounds(180,10,70,25);
		add(portLabel);
		
		//호스트 클라이언트 구분
		JLabel humanLabel = new JLabel("구분 : ");
		humanLabel.setBounds(10,40,80,25);
		add(humanLabel);
		
		//ip
		ip = new JTextField(15);
		ip.setBounds(70,10,100,25);
		add(ip);
				
		//port
		port= new JTextField(5);
		port.setBounds(250,10,50,25);
		add(port);
		
		//호스트 클라이언트
		human = new ButtonGroup();
		JRadioButton host = new JRadioButton("호스트");
		JRadioButton client = new JRadioButton("클라이언트",true);
		human.add(host);
		human.add(client);
		host.setBounds(100,40,80,25);
		client.setBounds(190,40,100,25);
		add(host);
		add(client);
		
		//취소버튼
		btnClose = new JButton("취소");
		btnClose.setBounds(10,70,100,25);
		add(btnClose);
		btnClose.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				//이전화면으로 이동
			}
		});
		
		//참가
		btnJoin = new JButton("참가");
		btnJoin.setBounds(160,70,100,25);
		add(btnJoin);
		btnJoin.addActionListener(new ActionListener(){;
			@Override
			public void actionPerformed(ActionEvent e){
			}
		});
	}
}