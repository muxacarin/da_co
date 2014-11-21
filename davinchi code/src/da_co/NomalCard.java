/**
 * 
 */
package da_co;

/**
 * @author muxacarin
 *
 */
public class NomalCard implements Card {
	
	private final Dacolor color;
	private final int number;
	
	private boolean open;
	
	public NomalCard(Dacolor co, int num){
		this.color = co;
		this.number = num;
		setOpen(false);
		
		
		
	}


	/* (non-Javadoc)
	 * @see da_co.Card#getColor()
	 */
	@Override
	public Dacolor getColor() {
		return color;
	}


	/* (non-Javadoc)
	 * @see da_co.Card#getNumber()
	 */
	@Override
	public int getNumber() {
		return number;
	}



	/* (non-Javadoc)
	 * @see da_co.Card#isOpen()
	 */
	@Override
	public boolean isOpen() {
		return open;
	}


	/* (non-Javadoc)
	 * @see da_co.Card#setOpen(boolean)
	 */
	@Override
	public void setOpen(boolean open) {
		this.open = open;
	}


	/* (non-Javadoc)
	 * @see da_co.Card#compareTo(da_co.Card)
	 */
	@Override
	public int compareTo(Card arg0) {
		// TODO Auto-generated method stub
		if(this.getNumber() > arg0.getNumber()) return 1;
		else if (this.getNumber() < arg0.getNumber()) return -1;
		else {
			if (this.getColor().equals(arg0.getColor())) return 0;
			else if (this.getColor().equals(Dacolor.BLACK)) return -1;
			else return 1;
		} 
		
	}


	/* (non-Javadoc)
	 * @see da_co.Card#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj.getClass() == this.getClass()){
			Card compare = (Card) obj;
			if (this.getColor().equals(compare.getColor()) && this.getNumber() == compare.getNumber()){
				return true;
			} else {
				return false;
			}
		}
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	

}
