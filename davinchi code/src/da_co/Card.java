package da_co;

public interface Card extends Comparable<Card>{
	

	/**
	 * @return the color
	 */
	public abstract Dacolor getColor();

	/**
	 * @return the number
	 */
	public abstract int getNumber();

	/**
	 * @return the open
	 */
	public abstract boolean isOpen();

	/**
	 * @param open the open to set
	 */
	public abstract void setOpen(boolean open);

	public abstract int compareTo(Card arg0);

	public abstract boolean equals(Object obj);

}