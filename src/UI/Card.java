package UI;

import javax.swing.ImageIcon;

import Inner.Shape;

public class Card {
	
	private String name;
	
	private int sign;
	private int num;
	private int shape;
	
	public Card(int sign,int shape,int num){
		this.sign= sign;
		this.num = num;
		this.shape = shape;
		
		if(sign<0)
			name="R";
		else
			name="B";
		name = name + Shape.getToString(shape) + num;
	}
	public String getName(){
		return name;
	}
	public ImageIcon getLargeIcon(){
		return new ImageIcon("./Image/"+name+".jpg");
	}
	public ImageIcon getSmallIcon(){
		return new ImageIcon("./Image/"+name+"S.jpg");
	}
	public int getSign() {
		return sign;
	}
	public int getNum() {
		return num;
	}
	public int getShape() {
		return shape;
	}
}
