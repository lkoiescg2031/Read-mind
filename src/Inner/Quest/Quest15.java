package Inner.Quest;
import java.util.ArrayList;

import Inner.Shape;
import UI.Card;

public class Quest15 extends Quest{
	
	public Quest15(){
		super("15","10ÅÏ Àü,¡ß");
	}
	
	@Override
	public boolean isclear(ArrayList<Card> card , int turn){
		if(card.size() != 3 || turn>10)
			return false;
		
		for(Card temp : card)
			if(temp.getShape() != Shape.DIAMOND)
				return false;
		
		return true;
	}
}