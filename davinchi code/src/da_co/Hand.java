package da_co;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Hand implements Iterable<Card>  {
	
	private ArrayList<Card> handlist = new ArrayList<Card>();
	
	public void add(Card card){
		this.handlist.add(card);
		Collections.sort(this.handlist);
	}
	
	public Card get(int arg0){
		return this.handlist.get(arg0);
	}
	
	public int size(){
		return this.handlist.size();
	}

	@Override
	public Iterator<Card> iterator() {
		// TODO Auto-generated method stub
		return this.handlist.iterator();
	}
}
