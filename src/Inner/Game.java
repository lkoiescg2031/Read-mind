package Inner;
import java.util.Random;
import java.util.Vector;

import Inner.Quest.Quest;
import Inner.Quest.Quest1;
import Inner.Quest.Quest10;
import Inner.Quest.Quest11;
import Inner.Quest.Quest12;
import Inner.Quest.Quest13;
import Inner.Quest.Quest14;
import Inner.Quest.Quest15;
import Inner.Quest.Quest16;
import Inner.Quest.Quest17;
import Inner.Quest.Quest18;
import Inner.Quest.Quest19;
import Inner.Quest.Quest2;
import Inner.Quest.Quest20;
import Inner.Quest.Quest3;
import Inner.Quest.Quest4;
import Inner.Quest.Quest5;
import Inner.Quest.Quest6;
import Inner.Quest.Quest7;
import Inner.Quest.Quest8;
import Inner.Quest.Quest9;
import Inner.Random.RandomGenerate;
import UI.Card;

public class Game {

	private int turn=1;

	private int maxCard=40;
	private int nextCard=0;
	
	private int firstPlayer=0;
	private int playerNum;
	
	private Vector<Card> deck = null;
	private String decklist =null;
	private Card drawCard = null;
	
	private Vector<Quest> quest = null;	
	private String questlist = null;
	
	private Random random = new Random();
	
	//Deck Method
	public int getRemainCard() {
		return maxCard - nextCard;
	}
	public void draw(){
		 drawCard = deck.get(nextCard++);
	}
	public Card getdrawCard(){
		return drawCard;
	}
	private void generateDeck(){
		
		Card card;
		int sign[] = {-1,1};
		int shape[] = {0,1,2,3};
		int number[] = {1,2,3,4,5};
		int signCount[] = {20,20};
		int shapeCount[] = {10,10,10,10};
		int numberCount[] = {8,8,8,8,8};
		int i,randomSign, randomShape, randomNumber;
		
		if(deck != null)
			deck = null;
		deck = new Vector<Card>();
		
		for(i=0;i<maxCard;i++)
		{
			//부호 결정
			randomSign = random.nextInt(2);
			if(signCount[randomSign]==0){
				randomSign = (randomSign + 1) % 2;
			}
			signCount[randomSign]--;
			//모양 결정
			randomShape = random.nextInt(4);
			if(shapeCount[randomShape] == 0)
			{
				while(shapeCount[randomShape] != 0){
					randomShape = (randomShape+1)%4;
				}
			}
			shapeCount[randomShape]--;
			//숫자 결정
			randomNumber = random.nextInt(5);
			if(numberCount[randomNumber] == 0)
			{
				while(numberCount[randomNumber] != 0){
					randomNumber = (randomNumber)%5;
				}
			}
			numberCount[randomNumber]--;
			card = new Card(sign[randomSign],shape[randomShape],number[randomNumber]);
			decklist = decklist + card.getName() +"-";
			deck.add(card);
		}
		nextCard = 0;
	}
	public String getDecklist(){
		return decklist;
	}
	
	//Quest Method
	public Vector<Quest> getQuest() {
		return quest;
	}
	private void generateQuest(){
		
		int temp;
		boolean flag[] = new boolean[20];
		Quest temp2;
		
		RandomGenerate rangeRandom = new RandomGenerate(new int[]{1,1,1,1,1,1,1,1,1,1,
																1,1,1,1,1,1,1,1,1,1});
		if(quest != null)
			quest.removeAllElements();
		quest = new Vector<Quest>();
		
		while(quest.size()<10){
			temp = rangeRandom.generateRandom(this.random.nextInt(rangeRandom.getRange()));
			if(!flag[temp]){
				switch(temp){
				case 0:temp2 = new Quest1();break;
				case 1:temp2 = new Quest2();break;
				case 2:temp2 = new Quest3();break;
				case 3:temp2 = new Quest4();break;
				case 4:temp2 = new Quest5();break;
				case 5:temp2 = new Quest6();break;
				case 6:temp2 = new Quest7();break;
				case 7:temp2 = new Quest8();break;
				case 8:temp2 = new Quest9();break;
				case 9:temp2 = new Quest10();break;
				case 10:temp2 = new Quest11();break;
				case 11:temp2 = new Quest12();break;
				case 12:temp2 = new Quest13();break;
				case 13:temp2 = new Quest14();break;
				case 14:temp2 = new Quest15();break;
				case 15:temp2 = new Quest16();break;
				case 16:temp2 = new Quest17();break;
				case 17:temp2 = new Quest18();break;
				case 18:temp2 = new Quest19();break;
				default:temp2 = new Quest20();break;
				}
				quest.add(temp2);
				questlist = questlist + temp2.getQID() +"-";
				flag[temp]=true;
				
			}
		}
	}
	public String getQuestList(){
		return questlist;
	}

	//Turn Method
	public int getTurn(){
		return this.turn;
	}
	public void nextTurn(){
		turn++;
	}
	
	//PlayerNum Method
	public void incFirstPlayer(){
		firstPlayer++;
		firstPlayer %=playerNum;
	}
	public int getFirstPlayer(){
		return firstPlayer;
	}
	private void generateFirstPlayer(){
		firstPlayer = random.nextInt(playerNum);
	}
	
	//GameMethod
	public Game(int playerNum){
		this.playerNum = playerNum;		
		System.out.println("새 게임을 위한 덱 생성!!");
		generateDeck();
		System.out.println("새 게임을 위한 퀘스트 생성!!");
		generateQuest();
		System.out.println("첫번째 차례를 고르는 중");
		generateFirstPlayer();
		System.out.println("새 게임 시작");
	}
}
