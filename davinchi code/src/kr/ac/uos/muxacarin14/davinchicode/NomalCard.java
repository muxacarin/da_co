package kr.ac.uos.muxacarin14.davinchicode;

public class NomalCard implements Card {

	private final Dacolor color;
	private final int number;

	private boolean open;

	public NomalCard(Dacolor co, int num) {
		this.color = co;
		this.number = num;
		setOpen(false);
	}


	@Override
	public Dacolor getColor() {
		return color;
	}


	@Override
	public int getNumber() {
		return number;
	}


	@Override
	public boolean isOpen() {
		return open;
	}


	@Override
	public void setOpen(boolean open) {
		this.open = open;
	}

	@Override
	public int compareTo(Card arg0) {
		// TODO Auto-generated method stub
		if (this.getNumber() > arg0.getNumber())
			return 1;
		else if (this.getNumber() < arg0.getNumber())
			return -1;
		else {
			return this.getColor().ordinal() - arg0.getColor().ordinal();
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj.getClass() == this.getClass()) {
			Card compare = (Card) obj;
			if (this.getColor().equals(compare.getColor())
					&& this.getNumber() == compare.getNumber()) {
				return true;
			} else {
				return false;
			}
		}
		return super.equals(obj);
	}
}
