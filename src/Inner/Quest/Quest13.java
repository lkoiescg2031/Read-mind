package Inner.Quest;
import java.util.ArrayList;

import UI.Card;

public class Quest13 extends Quest{
	
	public Quest13(){
		super("13","10턴 전 ,3이하");
	}
	
	@Override
	public boolean isclear(ArrayList<Card> card , int turn){
		if(card.size() != 3 || turn>10)
			return false;
		
		for(Card temp : card)
			if(temp.getNum() > 3)
				return false;
		
		return true;
	}
}