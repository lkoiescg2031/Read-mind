package UI.Frame;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import DataBase.DB;

@SuppressWarnings("serial")
public class LoginFrame extends JFrame{
	
	private static LoginFrame instance;
	private JButton btnLogin;//로그인 버튼
	private JButton btnEnrol;//회원가입 버튼
	private JPasswordField password;//비밀번호 텍스트
	private JTextField id;//아이디 텍스트
	
	public static LoginFrame getInstance(){
		if(instance == null)
			instance = new LoginFrame();
		return instance;
	}
	private LoginFrame(){
		setSize(280,170);
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

		//아이디
		JLabel idLabel = new JLabel("ID");
		idLabel.setBounds(10,10,80,25);;
		add(idLabel);
		id = new JTextField(15);
		id.setBounds(100,10,160,25);
		add(id);
		
		//비밀번호
		JLabel pwLabel = new JLabel("PW");
		pwLabel.setBounds(10,40,80,25);;
		add(pwLabel);
		password = new JPasswordField(15);
		password.setBounds(100,40,160,25);
		add(password);
		
		//회원가입 창으로 이동
		btnEnrol = new JButton("회원가입");
		btnEnrol.setBounds(10,80,100,25);
		add(btnEnrol);
		btnEnrol.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				EnrolFrame.getInstance().setVisible(true);
			}
		});
		
		//로그인 확인
		btnLogin = new JButton("로그인");
		btnLogin.setBounds(160,80,100,25);
		add(btnLogin);
		btnLogin.addActionListener(new ActionListener(){;
			@Override
			public void actionPerformed(ActionEvent e){
				if(DB.getinstance().login(id.getText(), password.getText()))
					System.out.println("Login successfully");
				else
					System.out.println("존재하지 않는 아이디 입니다."); //로그인 실패
			}
		});
	}
}
