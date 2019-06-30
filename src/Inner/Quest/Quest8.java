package Inner.Quest;
import java.util.ArrayList;

import Inner.Shape;
import UI.Card;

public class Quest8 extends Quest{
	
	public Quest8(){
		super("8","크기가 3이,♥");
	}
	
	@Override
	public boolean isclear(ArrayList<Card> card , int turn){
		
		if(card.size() != 3)
			return false;
		
		for(Card temp : card)
			if(temp.getShape() != Shape.HEART || temp.getNum() > 3)
				return false;
		
		return true;
	}
}