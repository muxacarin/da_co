package da_co;

/**
 * @author marine and MDV
 * 
 */
public class DavinchiCodePlayer {

	private Hand hand = new Hand();
	private boolean islive = true;// ���� ����
	private Card last;

	public void cardset(Card card) {
		this.hand.add(card);
		this.last = card;
	}

	public void lastopen() {// ������ ���� ī�� ���� �޼ҵ�

		for (Card car : this.hand) {
			if (car.equals(this.last)) {
				car.setOpen(true);
			}
		}
	}

	public boolean cardget(Dacolor color, int number) {// ī�� ����ִ��� �˻� �޼ҵ�

		for (Card car : this.hand) {
			if (car.equals(new NomalCard(color, number)))
				return true;
		}
		return false;
	}

	public boolean opencardget(Dacolor color, int number) {// ī�尡 ���µǾ��ִ��� �˻� �޼ҵ�

		for (Card car : this.hand) {
			if (car.equals(new NomalCard(color, number)))
				return car.isOpen();
		}
		return false;
	}

	public boolean assertbyposition(int cardpos, Dacolor color, int number) {// ī��
																			// ��ġ��
																			// �˻�
																			// �޼ҵ�
		if (this.hand.get(cardpos).equals(new NomalCard(color, number))) {
			this.hand.get(cardpos).setOpen(true);
			return true;
		} else
			return false;
	}

	public boolean Islive() {// �������� ��ȯ
		return islive;
	}

	public void setlive() {// �������� �˻�

		for (Card car : this.hand) {
			if (!car.isOpen())
				return;
		}
		this.islive = false;
	}

	public int lastcardpos() {
		for(int i = 0; i < hand.size(); i++){
			if(last.equals(hand.get(i))) return i;
		}
		return -1;
	}
}
