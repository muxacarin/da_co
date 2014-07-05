package da_co;

import java.util.Arrays;
import da_co.Color;

public class DavinchiCodePlayer {
	
	private boolean hand_white[] = new boolean[12];
	private boolean hand_black[] = new boolean[12];
	
	DavinchiCodePlayer(){
		Arrays.fill(hand_white,false);
		Arrays.fill(hand_black, false);
	}
	
	public void cardset(Color color, int number){
		
		switch (color){
		case WHITE: hand_white[number] = true;
			break;
		case BLACK: hand_black[number] = true;
			break;
		default:
			break;
		
		}
		
	}
	
	

}
