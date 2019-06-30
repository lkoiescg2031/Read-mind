package UI.Frame;

import java.sql.*;
import java.util.Enumeration;

import javax.swing.*;

import DataBase.LoginDB;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.*;

@SuppressWarnings("serial")
public class EnrolFrame extends JFrame{
	
	private static EnrolFrame instance;
	private JButton btnCreate;//생성
	private JButton btnReset;//초기화버튼
	private JPasswordField password;//비밀번호
	private JTextField id;//아이디
	private JTextField name;//이름
	private ButtonGroup sex;//성별(라디오 버튼)
	private JTextField age;//나이
	
	public static EnrolFrame getInstance(){
		if(instance == null)
			instance = new EnrolFrame();
		return instance;
	}
	
	private EnrolFrame(){
		setTitle("회원가입 화면");
		setSize(270,250);
		setUI();
		setLocation();
		setResizable(false);
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
		
		//이름
		JLabel nameLabel = new JLabel("이름");
		nameLabel.setBounds(10,10,80,25);;
		add(nameLabel);
		name = new JTextField(15);
		name.setBounds(100,10,160,25);
		add(name);
		
		//아이디
		JLabel idLabel = new JLabel("아이디");
		idLabel.setBounds(10,40,80,25);;
		add(idLabel);
		id = new JTextField(15);
		id.setBounds(100,40,160,25);
		add(id);
		
		//비밀번호
		JLabel pwLabel = new JLabel("비밀번호");
		pwLabel.setBounds(10,70,80,25);;
		add(pwLabel);
		password = new JPasswordField(15);
		password.setBounds(100,70,160,25);
		add(password);
		
		//나이
		JLabel ageLabel = new JLabel("나이");
		ageLabel.setBounds(10,100,80,25);;
		add(ageLabel);
		age = new JTextField(15);
		age.setBounds(100,100,160,25);
		add(age);
		
		//성별
		JLabel sexLabel = new JLabel("성별");
		sexLabel.setBounds(10,130,80,25);;
		add(sexLabel);
		
		sex = new ButtonGroup();
		JRadioButton male = new JRadioButton("남",true);
		JRadioButton female = new JRadioButton("여");
		sex.add(male);
		sex.add(female);
		male.setBounds(90,130,40,25);
		female.setBounds(130,130,40,25);
		add(male);
		add(female);
		
		//입력 내용 리셋Btn
		btnReset = new JButton("리셋");
		btnReset.setBounds(10,170,100,25);
		add(btnReset);
		btnReset.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				name.setText("");
				id.setText("");
				password.setText("");
				age.setText("");
				male.setSelected(true);
			}
		});
		
		//새로운 회원 생성
		btnCreate = new JButton("생성");
		btnCreate.setBounds(160,170,100,25);
		add(btnCreate);
		btnCreate.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				Enumeration<AbstractButton> enums = sex.getElements();
				String sex = new String();
				while(enums.hasMoreElements()) {
				    AbstractButton ab = enums.nextElement();
				    JRadioButton jb = (JRadioButton)ab;
				 
				    if(jb.isSelected())
				        sex = jb.getText().trim();
				}
				if(CreateMember(name.getText(),id.getText(),password.getText(),age.getText(),sex)){
					//회원가입 성공
					System.out.println("회원가입 성공");
				}else{
						//회원가입 실패
					System.out.println("회원가입 실패");
				}
			}
		});
	}
}