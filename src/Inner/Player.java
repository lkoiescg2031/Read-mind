package Inner;
import java.util.ArrayList;

import UI.Card;

public class Player{
	
	private ArrayList<Card> inhand;
	private Coin coins;
	private int questCnt;
	
	public Player(){
		inhand= new ArrayList<Card>();
		coins = new Coin();
	}
	public int getQuestCnt() {
		return questCnt;
	}
	public void setQuestCnt() {
		this.questCnt++;
	}
	public void addCard(Card card){
		inhand.add(card);
	}
	public ArrayList<Card> getInhand() {
		return inhand;
	}
	public void setbetting(Coin coin){
		coins = Coin.subtract(coins, coin);
	}
	public Coin getCoin(){
		return coins;
	}
	public int getCoin(int shape) {
		return coins.getCoin(shape);
	}
	public void setCoin(int shape,int value){
		coins.setCoin(shape, value);
	}
}