package da_co;

public class JokerCard implements Card {
	
	private final Dacolor color;
	
	private boolean open;
	
	private Card beforecard;
	private Card aftercard;
	
	
	public JokerCard(Dacolor co){
		this.color = co;
	}

	@Override
	public Dacolor getColor() {
		// TODO Auto-generated method stub
		return this.color;
	}

	@Override
	public int getNumber() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isOpen() {
		// TODO Auto-generated method stub
		return this.open;
	}

	@Override
	public void setOpen(boolean open) {
		// TODO Auto-generated method stub\
		this.open = open;
		
	}

	public Card getBeforecard() {
		return beforecard;
	}

	public void setBeforecard(Card beforecard) {
		this.beforecard = beforecard;
	}

	public Card getAftercard() {
		return aftercard;
	}

	public void setAftercard(Card aftercard) {
		this.aftercard = aftercard;
	}

	@Override
	public int compareTo(Card arg0) {
		if (arg0.equals(this)) return 0;
		if(this.beforecard.compareTo(arg0) >= 0) return 1;
		else if (this.aftercard.compareTo(arg0)<=0) return -1;
		else return 0;
	}

}
