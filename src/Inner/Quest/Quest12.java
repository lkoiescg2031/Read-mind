package Inner.Quest;
import java.util.ArrayList;

import Inner.Shape;
import UI.Card;

public class Quest12 extends Quest{
	
	public Quest12(){
		super("12","10ÅÏ Àü, ¢À");
	}
	
	@Override
	public boolean isclear(ArrayList<Card> card , int turn){
		if(card.size() != 3 || turn>10)
			return false;
		
		for(Card temp : card)
			if(temp.getShape() != Shape.CLOVER)
				return false;
		
		return true;
	}
}