package Inner.Quest;

import java.util.ArrayList;

import Inner.Shape;
import UI.Card;

public class Quest1 extends Quest{
	
	public Quest1(){
		super("1","¢¼");
	}
	
	@Override
	public boolean isclear(ArrayList<Card> card,int turn){//cardNum
		
		if(card.size() != 3)
			return false;
		
		for(Card temp : card)
			if(temp.getShape() != Shape.SPADE)
				return false;
		
		return true;	
	}
}
