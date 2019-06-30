package Inner.Quest;
import java.util.ArrayList;

import UI.Card;

public class Quest7 extends Quest{
	
	public Quest7(){
		super("7","-,Â¦¼ö");
	}
	
	@Override
	public boolean isclear(ArrayList<Card> card , int turn){
		
		if(card.size() != 3)
			return false;
		
		for(Card temp : card)
			if((temp.getNum() % 2) != 0 || temp.getSign() != -1)
				return false;
		
		return true;
	}
}