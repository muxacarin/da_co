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
	
	
	public void cardset(Dacolor color, int number){//카드 득템 메소드
		
		switch (color){
		case WHITE: hand_white[number] = true;//햐얀색이라면
			lastcolor = Dacolor.WHITE;
			lastnumber = number;
			break;
		case BLACK: hand_black[number] = true;//검정색이라면
			lastcolor = Dacolor.BLACK;
			lastnumber = number;
			break;
		default:
			break;
		
		}
		
	}
	
	public void lastopen(){//마지막 득템 카드 오픈 메소드
		if (this.lastcolor.equals(Dacolor.BLACK)){
			this.open_black[this.lastnumber] = true;
		} else {
			this.open_white[this.lastnumber] = true;
		}
	}
	

	public boolean cardget(Dacolor color, int number){//카드 들고있는지 검사 메소드
		
		return (color.equals(Dacolor.BLACK)) ? this.hand_black[number] : this.hand_white[number];
	}
	
	public boolean opencardget(Dacolor color, int number){//카드가 오픈되어있는지 검사 메소드
		
		return (color.equals(Dacolor.BLACK)) ? this.open_black[number] : this.open_white[number];
	}
	
	public boolean cardposition(int cardpos, Dacolor color, int number){//카드 위치로 검사 메소드 
		boolean[] hand = (color.equals(Dacolor.BLACK)) ? this.hand_black : this.hand_white;
		boolean[] open = (color.equals(Dacolor.BLACK)) ? this.open_black : this.open_white;//색깔별로 배열 선택
		
		if (open[number]) return false; //오픈되어 있는 수라면 false
		
		if (hand[number]) {//오픈되어있지 않고 가지고 있다면
			if(cardcount(color, number) == cardpos + 1) open[number] = true;//카드 순서가 맞다면 오픈
		}
		return open[number];//오픈여부 반환
	}
	
	private int cardcount(Dacolor color, int number){//카드 순서 반환 메소드 -> 재귀
		boolean[] hand = (color.equals(Dacolor.BLACK)) ? this.hand_black : this.hand_white; //매개변수 컬러로 배열 선택
		int pos = (hand[number]) ? 1 : 0; //컬러의 넘버를 들고 있으면 1 아니면 0 
		if (color == Dacolor.BLACK )
			if ( number == 0) return pos; //검정의 0면 isthis반환
			else return pos + cardcount(Dacolor.WHITE, number-1);//검정인데 0이 아니라면 하양의 1을 뺀 숫자의 값을 더해서 반환
		else return pos + cardcount(Dacolor.BLACK, number);//하양이라면 검정의 같은수의 값을 더해서 반환
		
	}

	public boolean Islive() {//생존여부 반환
		return islive;
	}

	public void setlive() {//생존여부 검사
		int white = 0;
		int black = 0;
		int white_open = 0;
		int black_open = 0;//각 색깔별 핸드와 오픈카드 수 변수
		
		for(int n = 0; n < hand_white.length;n++){
			if(this.hand_black[n]) black++;
			if(this.hand_white[n]) white++;
			if(this.open_black[n]) black_open++;
			if(this.open_white[n]) white_open++;//카드수 세기
		}
		
		if(black == black_open && white == white_open){//핸드수 = 오픈카드수 라면
			this.islive = false;//죽는다
		}
		
	}
}
