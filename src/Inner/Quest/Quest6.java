package Inner.Quest;
import java.util.ArrayList;

import UI.Card;

public class Quest6 extends Quest{
	
	public Quest6(){
		super("6","+, È¦¼ö");
	}
	
	@Override
	public boolean isclear(ArrayList<Card> card , int turn){
		
		if(card.size() != 3)
			return false;
		
		for(Card temp : card)
			if((temp.getNum() % 2) != 1 || temp.getSign() != 1)
				return false;
		
		return true;
	}
}