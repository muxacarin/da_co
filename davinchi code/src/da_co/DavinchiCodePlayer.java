package da_co;

import java.util.Arrays;

public class DavinchiCodePlayer {
	
	private boolean hand_white[] = new boolean[12];
	private boolean hand_black[] = new boolean[12];
	private boolean open_white[] = new boolean[12];
	private boolean open_black[] = new boolean[12];
	
	DavinchiCodePlayer(){
		Arrays.fill(hand_white,false);
		Arrays.fill(hand_black, false);
		Arrays.fill(open_black, false);
		Arrays.fill(open_white, false);
	}
	
	private int cardcount(Dacolor color, int number){
		boolean[] hand = (color.equals(Dacolor.BLACK)) ? this.hand_black : this.hand_white;
		int isthis = (hand[number]) ? 1 : 0;
		if (color == Dacolor.BLACK )
			if ( number == 0) return isthis;
			else return isthis + cardcount(Dacolor.WHITE, number-1);
		else return isthis + cardcount(Dacolor.BLACK, number);
		
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
		
		return (color.equals(Dacolor.BLACK)) ? this.hand_black[number] : this.hand_white[number];
	}
	
	public boolean opencardget(Dacolor color, int number){
		
		return (color.equals(Dacolor.BLACK)) ? this.open_black[number] : this.open_white[number];
	}
	
	public boolean cardposition(int cardpos, Dacolor color, int number){
		boolean[] hand = (color.equals(Dacolor.BLACK)) ? this.hand_black : this.hand_white;
		boolean[] open = (color.equals(Dacolor.BLACK)) ? this.open_black : this.open_white;
		
		if (open[number]) return false;
		
		if (hand[number]) {
			if(cardcount(color, number) == cardpos + 1) open[number] = true;
		}
		return open[number];
	}
	
	
	

}
