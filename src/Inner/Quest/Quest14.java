package Inner.Quest;
import java.util.ArrayList;

import Inner.Shape;
import UI.Card;

public class Quest14 extends Quest{
	
	public Quest14(){
		super("14","10�� ��,��");
	}
	
	@Override
	public boolean isclear(ArrayList<Card> card , int turn){
		if(card.size() != 3 || turn>10)
			return false;
		
		for(Card temp : card)
			if(temp.getShape() != Shape.HEART)
				return false;
		
		return true;
	}
}