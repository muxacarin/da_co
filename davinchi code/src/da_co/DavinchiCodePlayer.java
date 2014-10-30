package da_co;

import java.util.Arrays;

/**
 * @author marine and MDV
 *
 */
public class DavinchiCodePlayer {
	
	private boolean hand_white[] = new boolean[12];
	private boolean hand_black[] = new boolean[12];//손패 배열
	private boolean open_white[] = new boolean[12];
	private boolean open_black[] = new boolean[12];//오픈카드 배열
	private boolean islive = true;//생존 여부
	private Dacolor lastcolor;//마지막으로 뽑은 카드의 
	private int lastnumber;//마지막으로 뽑은 카드의 숫자
	
	DavinchiCodePlayer(){ //생성
		Arrays.fill(hand_white, false);
		Arrays.fill(hand_black, false);
		Arrays.fill(open_black, false);
		Arrays.fill(open_white, false);//손패 오픈카드 배열 false로 채우기.
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
			lastcolor = Dacolor.WHITE;
			lastnumber = number;
			break;
		case BLACK: hand_black[number] = true;
			lastcolor = Dacolor.BLACK;
			lastnumber = number;
			break;
		default:
			break;
		
		}
		
	}
	
	public void lastopen(){
		if (this.lastcolor.equals(Dacolor.BLACK)){
			this.open_black[this.lastnumber] = true;
		} else {
			this.open_white[this.lastnumber] = true;
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

	public boolean Islive() {
		return islive;
	}

	public void setlive() {
		int white = 0;
		int black = 0;
		int white_open = 0;
		int black_open = 0;
		
		for(int n = 0; n < hand_white.length;n++){
			if(this.hand_black[n]) black++;
			if(this.hand_white[n]) white++;
			if(this.open_black[n]) black_open++;
			if(this.open_white[n]) white_open++;
		}
		
		if(black == black_open && white == white_open){
			this.islive = false;
		}
		
	}
	
	
	

}
