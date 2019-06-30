package Inner.Quest;
import java.util.ArrayList;

import Inner.Shape;
import UI.Card;

public class Quest16 extends Quest{
	
	public Quest16(){
		super("16","15ÅÏ Àü,¡ß, -2 ~ +2");
	}
	
	@Override
	public boolean isclear(ArrayList<Card> card , int turn){
		if(card.size() != 3 || turn>15)
			return false;
		
		for(Card temp : card)
			if(temp.getShape() != Shape.DIAMOND || temp.getNum()>2)
				return false;
		
		return true;
	}
}