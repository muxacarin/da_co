/**
 * 
 */
package da_co;

/**
 * @author muxacarin
 *
 */
public class Card implements Comparable<Card> {
	
	private final Dacolor color;
	private final int number;
	
	private final int comparenumber;
	
	private boolean open;
	
	public Card(Dacolor co, int num){
		this.color = co;
		this.number = num;
		setOpen(false);
		
		
		if(this.color.equals(Dacolor.BLACK)){
			this.comparenumber = this.getNumber() * 4;
		} else {
			this.comparenumber = this.getNumber() * 4 + 2;
		}
	}


	/**
	 * @return the color
	 */
	public Dacolor getColor() {
		return color;
	}


	/**
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}


	/**
	 * @return the comparenumber
	 */
	public int getComparenumber() {
		return comparenumber;
	}


	/**
	 * @return the open
	 */
	public boolean isOpen() {
		return open;
	}


	/**
	 * @param open the open to set
	 */
	public void setOpen(boolean open) {
		this.open = open;
	}


	@Override
	public int compareTo(Card arg0) {
		// TODO Auto-generated method stub
		return this.getComparenumber() - arg0.getComparenumber();
	}


	@Override
	public boolean equals(Object arg0) {
		if(arg0.getClass() == this.getClass()){
			Card compare = (Card) arg0;
			if (this.getColor().equals(compare.getColor()) && this.getNumber() == compare.getNumber()){
				return true;
			} else {
				return false;
			}
		}
		// TODO Auto-generated method stub
		return super.equals(arg0);
	}
	

}
