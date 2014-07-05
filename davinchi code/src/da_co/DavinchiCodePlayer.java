package da_co;

import java.util.Arrays;

public class DavinchiCodePlayer {
	
	private boolean hand_white[] = new boolean[12];
	private boolean hand_black[] = new boolean[12];
	
	DavinchiCodePlayer(){
		Arrays.fill(hand_white,false);
		Arrays.fill(hand_black, false);
	}
	
	public void cardset(Dacolor color, int number){
		
		switch (color){
		case WHITE: hand_white[number] = true;
			break;
		case BLACK: hand_black[number] = true;
			break;
		default:
			break;
		
		}
		
	}
	
	public boolean cardget(Dacolor color, int number){
		
		switch (color){
		case BLACK:
			return hand_black[number];
		case WHITE:
			return hand_white[number];
		default:
			return (Boolean) null;
		
		}
	}
	
	

}
