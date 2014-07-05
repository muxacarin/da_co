package da_co;

import java.util.ArrayList;


public class DavinchiCodeHelper {
	
	private GameWindows gamewindows;	//게임판 : ui제어
	private DavinchiCodePlayer p1,p2,p3,p4;
	private DavinchiCodePlayer[] pa = {p1,p2,p3,p4};
	private ArrayList<DavinchiCodePlayer> pAL = new ArrayList<DavinchiCodePlayer>();
	private int people;
	private boolean deck_white[] = new boolean[12];
	private boolean deck_black[] = new boolean[12];
	
	
	
	
	DavinchiCodeHelper(GameWindows gw){
		this(gw,4);
	}
	
	DavinchiCodeHelper(GameWindows gw, int n){
		
		this.gamewindows = gw;
		this.people = n;
		for(int i=0;i<people;i++){
			pa[i] = new DavinchiCodePlayer();
			pAL.add(pa[i]);
		}
		pAL.trimToSize();
		
	}
	
	public void gamestart(){
		if (people == 4){
			
		}
	}
	
	
	
	

}
