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
	private JButton btnJoin;//���� ��ư
	private JButton btnClose;//��� ��ư
	private JTextField ip;//ip�ּ�
	private JTextField port;//port��ȣ
	private ButtonGroup human;//ȣ��Ʈ, Ŭ���̾�Ʈ(���� ��ư)
	
	public static ConnectFrame getInstance(){
		if(instance == null)
			instance = new ConnectFrame();
		return instance;
	}
	private ConnectFrame(){
		
		setTitle("���� ȭ��");
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
		JLabel ipLabel = new JLabel("ip �ּ� : ");
		ipLabel.setBounds(10,10,50,25);
		add(ipLabel);
				
		//port
		JLabel portLabel = new JLabel("��Ʈ ��ȣ :");
		portLabel.setBounds(180,10,70,25);
		add(portLabel);
		
		//ȣ��Ʈ Ŭ���̾�Ʈ ����
		JLabel humanLabel = new JLabel("���� : ");
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
		
		//ȣ��Ʈ Ŭ���̾�Ʈ
		human = new ButtonGroup();
		JRadioButton host = new JRadioButton("ȣ��Ʈ");
		JRadioButton client = new JRadioButton("Ŭ���̾�Ʈ",true);
		human.add(host);
		human.add(client);
		host.setBounds(100,40,80,25);
		client.setBounds(190,40,100,25);
		add(host);
		add(client);
		
		//��ҹ�ư
		btnClose = new JButton("���");
		btnClose.setBounds(10,70,100,25);
		add(btnClose);
		btnClose.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				//����ȭ������ �̵�
			}
		});
		
		//����
		btnJoin = new JButton("����");
		btnJoin.setBounds(160,70,100,25);
		add(btnJoin);
		btnJoin.addActionListener(new ActionListener(){;
			@Override
			public void actionPerformed(ActionEvent e){
			}
		});
	}
}