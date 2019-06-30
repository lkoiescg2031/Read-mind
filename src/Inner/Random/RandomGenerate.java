package Inner.Random;
public class RandomGenerate {
	
	private int rate[];
	
	public RandomGenerate(int[] list){
		int temp =0;
		rate= new int[list.length];
		for(int i=0;i<list.length;i++){
			temp+=list[i];
			rate[i]=temp;
		}
	}
	public int getRange() {
		return rate[rate.length-1];
	}
	public void setRange(int range) {
		this.rate[rate.length-1] = range;
	}

	public int[] getRate() {
		return rate;
	}
	public void setRate(int[] list) {
		int temp = 0;
		rate= new int[list.length];
		for(int i=0;i<list.length;i++){
			temp+=list[i];
			rate[i]=temp;
		}
	}
	public int generateRandom(int random){
		if(random<0 || random>=rate[rate.length-1])
			return -1;
		for(int i = rate.length - 2;i>=0;i--)
			if(rate[i]<=random)
				return i+1;
		return 0;
	}
}
