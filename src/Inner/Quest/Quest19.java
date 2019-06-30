package Inner.Quest;
import java.util.ArrayList;

import Inner.Shape;
import UI.Card;

public class Quest19 extends Quest{
	
	public Quest19(){
		super("19","10�� ��,��,not(-1 and 1)");
	}
	
	@Override
	public boolean isclear(ArrayList<Card> card , int turn){
		if(card.size() != 3 || turn>10)
			return false;
		
		for(Card temp : card)
			if(temp.getShape() != Shape.HEART || temp.getNum()<2)
				return false;
		
		return true;
	}
}