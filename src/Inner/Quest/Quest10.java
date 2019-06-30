package Inner.Quest;
import java.util.ArrayList;

import Inner.Shape;
import UI.Card;

public class Quest10 extends Quest{
	
	public Quest10(){
		super("10","'+',¢¾ or ¡ß,Â¦¼ö");
	}
	
	@Override
	public boolean isclear(ArrayList<Card> card , int turn){
		
		if(card.size() != 3)
			return false;
		
		for(Card temp : card)
			if((temp.getShape() != Shape.DIAMOND && temp.getShape() != Shape.HEART) || temp.getSign() != 1 || (temp.getNum() % 2 != 0))
				return false;
		
		return true;
	}
}