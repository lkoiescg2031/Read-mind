package Inner;

public class Shape {
	
	static final public int SPADE = 0;
	static final public int HEART = 1;
	static final public int DIAMOND = 2;
	static final public int CLOVER = 3;
	
	public static String getToShape(int shape){
		switch(shape){
		case SPADE:return "¢¼";
		case HEART:return "¢¾";
		case DIAMOND:return "¡ß";
		case CLOVER:return "¢À";
		}
		return "Shape_ERROR_INPUT_SEGMENT_IS_NOT_SHAPE :"+shape;
	}
	public static String getToString(int shape){
		switch(shape){
		case SPADE:return "S";
		case HEART:return "H";
		case DIAMOND:return "D";
		case CLOVER:return "C";
		}
		return "Shape_ERROR_INPUT_SEGMENT_IS_NOT_SHAPE :"+shape;
	}
	public static boolean isShape(int shape){
		if(shape>=0&&shape<4)
			return true;
		return false;
	}
}
