package Inner.Quest;
import java.util.ArrayList;

import UI.Card;

public class Quest3 extends Quest{
	
	public Quest3(){
		super("3","гу 0");
	}
	
	@Override
	public boolean isclear(ArrayList<Card> card , int turn){
		int sum = 0;
		if(card.size() != 3)
			return false;
		
		for(Card temp : card)
			sum = temp.getSign() * temp.getNum() + sum;
		
		if(sum != 0)
			return false;
		
		return true;
	}
}