package da_co;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author marine and MDV
 * 
 */
public class DavinchiCodePlayer {

	private ArrayList<Card> hand = new ArrayList<Card>();
	private boolean islive = true;// 생존 여부
	private Card last;

	public void cardset(NomalCard arg0) {
		this.hand.add(arg0);
		this.last = arg0;
		Collections.sort(this.hand);
	}

	public void lastopen() {// 마지막 득템 카드 오픈 메소드

		for (Card car : this.hand) {
			if (car.equals(this.last)) {
				car.setOpen(true);
			}
		}
	}

	public boolean cardget(Dacolor color, int number) {// 카드 들고있는지 검사 메소드

		for (Card car : this.hand) {
			if (car.equals(new NomalCard(color, number)))
				return true;
		}
		return false;
	}

	public boolean opencardget(Dacolor color, int number) {// 카드가 오픈되어있는지 검사 메소드

		for (Card car : this.hand) {
			if (car.equals(new NomalCard(color, number)))
				return car.isOpen();
		}
		return false;

	}

	public boolean assertbyposition(int cardpos, Dacolor color, int number) {// 카드
																			// 위치로
																			// 검사
																			// 메소드
		if (this.hand.get(cardpos).equals(new NomalCard(color, number))) {
			this.hand.get(cardpos).setOpen(true);
			return true;
		} else
			return false;

	}

	public boolean Islive() {// 생존여부 반환
		return islive;
	}

	public void setlive() {// 생존여부 검사

		for (Card car : this.hand) {
			if (!car.isOpen())
				return;
		}
		this.islive = false;
	}
}
