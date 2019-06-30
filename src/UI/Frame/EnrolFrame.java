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
	private JButton btnCreate;//����
	private JButton btnReset;//�ʱ�ȭ��ư
	private JPasswordField password;//��й�ȣ
	private JTextField id;//���̵�
	private JTextField name;//�̸�
	private ButtonGroup sex;//����(���� ��ư)
	private JTextField age;//����
	
	public static EnrolFrame getInstance(){
		if(instance == null)
			instance = new EnrolFrame();
		return instance;
	}
	
	private EnrolFrame(){
		setTitle("ȸ������ ȭ��");
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
		
		//�̸�
		JLabel nameLabel = new JLabel("�̸�");
		nameLabel.setBounds(10,10,80,25);;
		add(nameLabel);
		name = new JTextField(15);
		name.setBounds(100,10,160,25);
		add(name);
		
		//���̵�
		JLabel idLabel = new JLabel("���̵�");
		idLabel.setBounds(10,40,80,25);;
		add(idLabel);
		id = new JTextField(15);
		id.setBounds(100,40,160,25);
		add(id);
		
		//��й�ȣ
		JLabel pwLabel = new JLabel("��й�ȣ");
		pwLabel.setBounds(10,70,80,25);;
		add(pwLabel);
		password = new JPasswordField(15);
		password.setBounds(100,70,160,25);
		add(password);
		
		//����
		JLabel ageLabel = new JLabel("����");
		ageLabel.setBounds(10,100,80,25);;
		add(ageLabel);
		age = new JTextField(15);
		age.setBounds(100,100,160,25);
		add(age);
		
		//����
		JLabel sexLabel = new JLabel("����");
		sexLabel.setBounds(10,130,80,25);;
		add(sexLabel);
		
		sex = new ButtonGroup();
		JRadioButton male = new JRadioButton("��",true);
		JRadioButton female = new JRadioButton("��");
		sex.add(male);
		sex.add(female);
		male.setBounds(90,130,40,25);
		female.setBounds(130,130,40,25);
		add(male);
		add(female);
		
		//�Է� ���� ����Btn
		btnReset = new JButton("����");
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
		
		//���ο� ȸ�� ����
		btnCreate = new JButton("����");
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
					//ȸ������ ����
					System.out.println("ȸ������ ����");
				}else{
						//ȸ������ ����
					System.out.println("ȸ������ ����");
				}
			}
		});
	}
}