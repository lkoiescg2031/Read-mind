package Inner.Quest;
import java.util.ArrayList;

import UI.Card;

public class Quest11 extends Quest{
	
	public Quest11(){
		super("11","+3 or -3, гуюл 0");
	}
	
	@Override
	public boolean isclear(ArrayList<Card> card , int turn){
		int sum = 0;
		int count = 0;
		if(card.size() != 3)
			return false;
		
		for(Card temp : card)
		{
			if(temp.getNum() == 3)
				count++;
			
			sum = sum + temp.getNum()*temp.getSign();
		}
		if(sum != 0 || count == 0)
			return false;
		
		return true;
	}
}