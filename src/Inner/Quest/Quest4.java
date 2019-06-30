package Inner.Quest;
import java.util.ArrayList;

import UI.Card;

public class Quest4 extends Quest{
	
	public Quest4(){
		super("4","크기가 3이상");
	}
	
	@Override
	public boolean isclear(ArrayList<Card> card , int turn){

		if(card.size() != 3)
			return false;
		
		for(Card temp : card)
			if(temp.getNum() < 3)
				return false;
		
		return true;
	}
}