package Inner.Quest;
import java.util.ArrayList;

import Inner.Shape;
import UI.Card;

public class Quest20 extends Quest{
	
	public Quest20(){
		super("20","not(-2 and +2),Ёп,Че 0");
	}
	
	@Override
	public boolean isclear(ArrayList<Card> card , int turn){
		int sum = 0;
		
		if(card.size() != 3)
			return false;
		
		for(Card temp : card)
		{
			if(temp.getShape() != Shape.DIAMOND || temp.getNum() == 2)
				return false;
			sum = sum + temp.getSign() * temp.getNum();
		}
		if(sum != 0)
			return false;
		
		return true;
	}
}