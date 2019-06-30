package Exception;

@SuppressWarnings("serial")
public class WinException extends Exception{
	
	private int winPlayerNum;

	public WinException(int winPlayerNum) {
		super();
		this.winPlayerNum = winPlayerNum;
	}

	public int getWinPlayerNum() {
		return winPlayerNum;
	}

}
