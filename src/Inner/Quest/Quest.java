package Inner.Quest;
import java.util.ArrayList;

import UI.Card;

public abstract class Quest {
	
	private String QID;
	private String quest;
	
	public Quest(String QID,String quest){
		this.QID = QID;
		this.quest = quest; 
	}
	public String getQID(){
		return QID;
	}
	public String getQuest(){
		return quest;
	}
	public abstract boolean isclear(ArrayList<Card> card,int turn);

}
