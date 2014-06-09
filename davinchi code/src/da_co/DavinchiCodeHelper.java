package da_co;

import java.util.ArrayList;


public class DavinchiCodeHelper {
		//archi1test
	private GameWindows gamewindows;	//게임판 : ui제어
	private DavinchiCodePlayer p1;
	private DavinchiCodePlayer p2;
	private DavinchiCodePlayer p3;
	private DavinchiCodePlayer p4;
	private DavinchiCodePlayer[] pa = {p1,p2,p3,p4};
	private ArrayList<DavinchiCodePlayer> pAL = new ArrayList<DavinchiCodePlayer>();
	private int people;
	
	
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
	
	

}
