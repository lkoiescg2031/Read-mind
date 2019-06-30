package Inner.Quest;
import java.util.ArrayList;

import UI.Card;

public class Quest17 extends Quest{
	
	public Quest17(){
		super("17","20ÅÏ Àü, '+', È¦¼ö");
	}
	
	@Override
	public boolean isclear(ArrayList<Card> card , int turn){
		if(card.size() != 3 || turn>20)
			return false;
		
		for(Card temp : card)
			if(temp.getSign() != 1 || (temp.getNum() % 2) != 1)
				return false;
		
		return true;
	}
}