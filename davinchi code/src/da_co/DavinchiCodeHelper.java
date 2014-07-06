package da_co;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


public class DavinchiCodeHelper {
	
	private GameWindows gamewindows;	//게임판 : ui제어
	private DavinchiCodePlayer[] pa = new DavinchiCodePlayer[4];
	private ArrayList<DavinchiCodePlayer> pAL = new ArrayList<DavinchiCodePlayer>();
	private int people;
	private boolean deck_white[] = new boolean[12];
	private int remainder_white;
	private boolean deck_black[] = new boolean[12];
	private int remainder_black;
	private Random ran = new Random();
	private int turn;
	private Turn turnindex;
	private boolean canpass;
	
	
	DavinchiCodeHelper(GameWindows gw){
		this(gw,4);
	}
	
	DavinchiCodeHelper(GameWindows gw, int n){
		
		this.gamewindows = gw;
		this.people = n;
		Arrays.fill(deck_white,true);
		Arrays.fill(deck_black,true);
		for(int i=0;i<people;i++){
			this.pa[i] = new DavinchiCodePlayer();
			this.pAL.add(this.pa[i]);
		}
		this.pAL.trimToSize();
		this.turn = 0;
		this.setRemainder_black(12);
		this.setRemainder_white(12);
		
	}
	
	public int getTurn() {
		return this.turn;
	}
	
	public int getPeople(){
		return this.people;
	} 
	
	public boolean getcardinhand(int n, Dacolor color, int number){
		return pAL.get(n%this.people).cardget(color, number);
	}
	
	public boolean getopencardinhand(int n, Dacolor color, int number){
		return pAL.get(n%this.people).opencardget(color, number);
	}

	public Turn getTurnindex() {
		return turnindex;
	}

	public boolean isCanpass() {
		return canpass;
	}
	
	public int getRemainder_white() {
		return remainder_white;
	}

	private void setRemainder_white(int remainder_white) {
		this.remainder_white = remainder_white;
	}

	public int getRemainder_black() {
		return remainder_black;
	}

	private void setRemainder_black(int remainder_black) {
		this.remainder_black = remainder_black;
	}

	private boolean addcard (int playerindex, Dacolor color){
		
		int cardnumber = ran.nextInt(12);
		
		switch (color) {
		case BLACK:
			if (this.deck_black[cardnumber]){
				this.pAL.get(playerindex).cardset(Dacolor.BLACK, cardnumber);
				this.deck_black[cardnumber] = false;
				this.setRemainder_black(this.getRemainder_black() - 1);
				return true;
			}
			break;
		case WHITE:
			if (this.deck_white[cardnumber]){
				this.pAL.get(playerindex).cardset(Dacolor.WHITE, cardnumber);
				this.deck_white[cardnumber] = false;
				this.setRemainder_white(this.getRemainder_white() - 1);
				return true;
			}
			break;
		default:
			break;
		
		}
		return false;
	}


	public void gamestart(){
		if (this.people == 4){
			
			for (int i = 0; i < 4; i++){
				for (int j = 1; j<=3;){
					if(this.addcard(i, (this.ran.nextBoolean()) ? Dacolor.BLACK : Dacolor.WHITE)) j++;
				}
			}
			
		} else {
			for (int i = 0; i<people; i++){
				for (int j = 1; j <= 4;){
					if(this.addcard(i, (this.ran.nextBoolean()) ? Dacolor.BLACK : Dacolor.WHITE)) j++;
				}
				
			}
			
		}
		
		this.turnindex = Turn.CARDGET;
		
		gamewindows.update();
	}
	
	public void takecard(int peopleindex, Dacolor color){
		
		while(!this.addcard(peopleindex%this.people, color));
		this.canpass = true;
		this.turnindex = Turn.SELECT;
		this.gamewindows.update();
		
	}
	
	public void assertcard(int player, int cardpos, Dacolor color, int number){
		int playerindex = (player + this.turn)%this.people;
		this.turnindex = Turn.CARDGET;
		if(!pAL.get(playerindex).cardposition(cardpos, color, number)) {
			nextturn();
		}
		this.gamewindows.update();
		
		
		
		
		
	}

	private void nextturn() {
		this.turn++;
		this.canpass = false;
	}
	
	public void passturn(){
		this.nextturn();
		gamewindows.update();
	}
	


	
	
	
}
