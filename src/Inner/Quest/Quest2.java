package Inner.Quest;
import java.util.ArrayList;

import UI.Card;

public class Quest2 extends Quest{
	
	public Quest2(){
		super("2","«’ 13¿ÃªÛ");
	}
	
	@Override
	public boolean isclear(ArrayList<Card> card , int turn){
		int sum = 0;
		if(card.size() != 3)
			return false;
		
		for(Card temp : card)
			sum = temp.getSign() * temp.getNum() + sum;
		
		if(sum<13)
			return false;
		
		return true;
	}
}