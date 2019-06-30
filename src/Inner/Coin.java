package Inner;

public class Coin {
	
	public final static int coinNum = 4;
	private static int init = 100;
	private int[] coin;

	
	public Coin(){
		coin= new int[]{init,init,init,init};
	}
	public static Coin subtract(Coin x,Coin y){//return x-y
		Coin temp = new Coin();
		for(int i=0 ; i < coinNum ; i++){
			int midresult =x.getCoin(i)-y.getCoin(i);
			if(midresult<0)
				midresult=0;
			temp.setCoin(i,midresult);
		}
		return temp;
	}
	public void setCoin(int shape,int value){
		coin[shape] = value;
	}
	public int getCoin(int shape){
		return coin[shape];
	}
	public boolean isEmpty(int shape){
		return coin[shape] == 0;
	}
}
