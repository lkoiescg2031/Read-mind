package Inner.Quest;
import java.util.ArrayList;

import Inner.Shape;
import UI.Card;

public class Quest9 extends Quest{
	
	public Quest9(){
		super("9","+,¢À");
	}
	
	@Override
	public boolean isclear(ArrayList<Card> card , int turn){
		
		if(card.size() != 3)
			return false;
		
		for(Card temp : card)
			if(temp.getShape() != Shape.CLOVER || temp.getSign() != 1)
				return false;
		
		return true;
	}
}