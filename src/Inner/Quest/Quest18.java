package Inner.Quest;
import java.util.ArrayList;

import Inner.Shape;
import UI.Card;

public class Quest18 extends Quest{
	
	public Quest18(){
		super("18","15ÅÏ Àü, '-', ¢¼");
	}
	
	@Override
	public boolean isclear(ArrayList<Card> card , int turn){
		if(card.size() != 3 || turn>15)
			return false;
		
		for(Card temp : card)
			if(temp.getShape() != Shape.SPADE || temp.getSign() != -1)
				return false;
		
		return true;
	}
}