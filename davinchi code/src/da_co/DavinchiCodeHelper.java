package da_co;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import da_co.Color;


public class DavinchiCodeHelper {
	
	private GameWindows gamewindows;	//게임판 : ui제어
	private DavinchiCodePlayer[] pa = new DavinchiCodePlayer[4];
	private ArrayList<DavinchiCodePlayer> pAL = new ArrayList<DavinchiCodePlayer>();
	private int people;
	private boolean deck_white[] = new boolean[12];
	private boolean deck_black[] = new boolean[12];
	private Random ran = new Random();
	
	
	
	DavinchiCodeHelper(GameWindows gw){
		this(gw,4);
	}
	
	DavinchiCodeHelper(GameWindows gw, int n){
		
		this.gamewindows = gw;
		this.people = n;
		Arrays.fill(deck_white,true);
		Arrays.fill(deck_black, true);
		for(int i=0;i<people;i++){
			pa[i] = new DavinchiCodePlayer();
			pAL.add(pa[i]);
		}
		pAL.trimToSize();
		
	}
	
	public void gamestart(){
		if (people == 4){
			
			for (int i = 0; i < 4; i++){
				for (int j = 1; j <= 3; j++){
					lable1:
					while(true){
						
						Color col = (ran.nextBoolean()) ? Color.WHITE : Color.BLACK;
						int cardnumber = ran.nextInt(12);
						
						switch (col){
						case WHITE :
							if (deck_white[cardnumber]){
								pAL.get(i).cardset(Color.WHITE, cardnumber);
								deck_white[cardnumber] = false;
								break lable1;
							}
							break;
						case BLACK:
							if (deck_black[cardnumber]){
								pAL.get(i).cardset(Color.BLACK, cardnumber);
								deck_black[cardnumber] = false;
								break lable1;
							}
							break;
						default:
							break;
							
						
						}
						
						
					}
					
					
					
				}
			}
			
		}else{
			for (int i = 0; i<people; i++){
				for (int j = 1; j <= 4; j++){
					lable1:
					while(true){
						
						Color col = (ran.nextBoolean()) ? Color.WHITE : Color.BLACK;
						int cardnumber = ran.nextInt(12);
						
						switch (col){
						case WHITE :
							if (deck_white[cardnumber]){
								pAL.get(i).cardset(Color.WHITE, cardnumber);
								deck_white[cardnumber] = false;
								break lable1;
							}
							break;
						case BLACK:
							if (deck_black[cardnumber]){
								pAL.get(i).cardset(Color.BLACK, cardnumber);
								deck_black[cardnumber] = false;
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
	
	
	
	

}
