package kr.ac.uos.muxacarin14.davinchicode;

public interface Card extends Comparable<Card>{
	
	static final int JOKER = 79;

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