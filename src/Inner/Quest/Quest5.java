package Inner.Quest;
import java.util.ArrayList;

import Inner.Shape;
import UI.Card;

public class Quest5 extends Quest{
	
	public Quest5(){
		super("5","'+',¡ß");
	}
	
	@Override
	public boolean isclear(ArrayList<Card> card , int turn){
		
		if(card.size() != 3)
			return false;
		
		for(Card temp : card)
			if(temp.getShape() != Shape.DIAMOND || temp.getSign() != 1)
				return false;
		
		return true;
	}
}