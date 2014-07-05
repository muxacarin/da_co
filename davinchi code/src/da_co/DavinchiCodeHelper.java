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
	private boolean deck_black[] = new boolean[12];
	private Random ran = new Random();
	private int turn;
	
	
	
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
		
	}
	
	public int getTurn() {
		return this.turn;
	}
	
	public int getPeople(){
		return this.people;
	}


	public void gamestart(){
		if (this.people == 4){
			
			for (int i = 0; i < 4; i++){
				for (int j = 1; j <= 3; j++){
					lable1:
					while(true){
						
						Dacolor col = (ran.nextBoolean()) ? Dacolor.WHITE : Dacolor.BLACK;
						int cardnumber = ran.nextInt(12);
						
						switch (col){
						case WHITE :
							if (this.deck_white[cardnumber]){
								this.pAL.get(i).cardset(Dacolor.WHITE, cardnumber);
								this.deck_white[cardnumber] = false;
								break lable1;
							}
							break;
						case BLACK:
							if (this.deck_black[cardnumber]){
								this.pAL.get(i).cardset(Dacolor.BLACK, cardnumber);
								this.deck_black[cardnumber] = false;
								break lable1;
							}
							break;
						default:
							break;
						}
					}
				}
			}
			
		} else {
			for (int i = 0; i<people; i++){
				for (int j = 1; j <= 4; j++){
					lable1:
					while(true){
						
						Dacolor col = (ran.nextBoolean()) ? Dacolor.WHITE : Dacolor.BLACK;
						int cardnumber = ran.nextInt(12);
						
						switch (col){
						case WHITE :
							if (this.deck_white[cardnumber]){
								this.pAL.get(i).cardset(Dacolor.WHITE, cardnumber);
								this.deck_white[cardnumber] = false;
								break lable1;
							}
							break;
						case BLACK:
							if (this.deck_black[cardnumber]){
								this.pAL.get(i).cardset(Dacolor.BLACK, cardnumber);
								this.deck_black[cardnumber] = false;
								break lable1;
							}
							break;
						default:
							break;
						}
					}
				}
				
			}
			
		}
		
		gamewindows.update();
	}
	
	public boolean getcardinhand(int n, Dacolor color, int number){
		return pAL.get(n).cardget(color, number);
	}
	
	
	
	

}
