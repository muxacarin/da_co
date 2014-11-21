package da_co;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * @author marine and MDV
 * 
 */
public class DavinchiCodeHelper {

	private final GameHandler gamehandler; // 게임판 : ui제어
	private ArrayList<DavinchiCodePlayer> pAL = new ArrayList<DavinchiCodePlayer>(); // 플레이어
																						// 지정용
																						// 어레이리스트
	private final int number_of_gamer;// 게임하는 사람 수
	private ArrayList<NomalCard> Deck_white = new ArrayList<NomalCard>();
	private ArrayList<NomalCard> Deck_black = new ArrayList<NomalCard>();
	private Random ran = new Random();// 난수 발생 객체
	private int turn;// 턴 세기 [제 1 턴 = 0]
	private Turn turnindex;// 한 턴 안의 단계
	private boolean canpass;// 패스가능여부
	private Damode mode;

	public DavinchiCodeHelper(GameHandler gh, int gamer, Damode mode) { // 생성자

		this.gamehandler = gh; 			// ui연결
		this.number_of_gamer = gamer;	// 게임자 수 설정
		this.mode = mode;			 	//모드 설정
		for (int i = 0; i < number_of_gamer; i++) {// 플레이어 객체 생성
			this.pAL.add(new DavinchiCodePlayer());
		}
		this.pAL.trimToSize();//사이즈 최적화
		this.turn = 0;// 턴 초기화

		for (int i = 0; i <= 11; i++) {//덱 초기화
			Deck_white.add(new NomalCard(Dacolor.WHITE, i));
			Deck_black.add(new NomalCard(Dacolor.BLACK, i));
		}
		Collections.shuffle(Deck_black, ran);
		Collections.shuffle(Deck_white, ran);

	}

	public void gamestart() { // 게임 시작 메소드
		if (this.number_of_gamer == 4) { // 게이머수 4명 : 초기 패 3장

			for (int i = 0; i < 4; i++) {// 각 게이머 마다
				for (int j = 1; j <= 3; j++) {// 패 3장이 될동안
					this.addcard(i, (this.ran.nextBoolean()) ? Dacolor.BLACK
							: Dacolor.WHITE);

				}
			}

		} else {// 게이머수 4명이 아니면 : 초기 패 4장
			for (int i = 0; i < number_of_gamer; i++) {// 각 게이머 마다
				for (int j = 1; j <= 4; j++) {// 패 4장이 될 동안
					this.addcard(i, (this.ran.nextBoolean()) ? Dacolor.BLACK
							: Dacolor.WHITE);
				}

			}

		}
		this.turnindex = Turn.CARDGET;// 턴의 단계 : 카드 가져오기

		gamehandler.update();// ui 업데이트

		// JOptionPane.showMessageDialog(null, "게임을 시작합니다.");
		// JOptionPane.showMessageDialog(null, "플레이어0의 턴입니다.");
	}

	public void takecard(int peopleindex, Dacolor color) {// 카드 가져오기 메소드

		this.addcard(peopleindex % this.number_of_gamer, color);// 카드를 얻어온다
		this.turnindex = Turn.SELECT;// 턴의 단계 : 카드 맞추기
		this.gamehandler.update();// ui 업데이트

	}

	public void assertcard(int targetindex, int cardpos, Dacolor color, int number) {// 카드
																				// 맞추기
																				// 메소드
		int playerindex = (targetindex + this.turn) % this.number_of_gamer;// 지목한 카드의
																		// 주인의
																		// 인덱스
																		// 설정
		if (this.Deck_black.size() != 0 || this.Deck_white.size() != 0) {
			this.turnindex = Turn.CARDGET;// 턴의 단계 : 카드 가져오기 단계
		} else {
			this.turnindex = Turn.SELECT;// 남은 카드가 없으면 셀렉트단계
		}

		this.canpass = true;// 카드 맞추기를 했음으로 통과 가능
		if (!pAL.get(playerindex).assertbyposition(cardpos, color, number)) {// 틀렸다면
			// JOptionPane.showMessageDialog(null, "틀렸습니다. 턴이 넘어갑니다.");
			// JOptionPane.showMessageDialog(null, "마지막으로 뽑은 카드가 공개됩니다.");
			pAL.get(this.turn % this.number_of_gamer).lastopen();// 마지막으로 가져온 카드
																	// 오픈
			nextturn();// 턴이 넘어감
		} else {// 맞추었다면
			// JOptionPane.showMessageDialog(null,
			// "맞추었습니다. 턴을 넘기거나 카드를 뽑을 수 있습니다.");
			if (this.mode == Damode.ChocoTea)//모드가 공식모드라면
				this.turnindex = Turn.SELECT;//안뽑고 셀렉트해야함
			pAL.get(playerindex).setlive();// 맞춤당한사람이 살았는지 검사
			if (!pAL.get(playerindex).Islive()) {//타겟이 죽었으면
				gamehandler.dead(playerindex);//죽음 알림
				this.isEnd();//게임 종료 검사
			}
		}
		this.gamehandler.update();// ui 업데이트
	}

	public void passturn() {// 턴 넘기기 메소드
		this.nextturn();// 다음턴으로 넘김
		if (this.mode == Damode.ChocoTea) {//공식모드라면
			if (this.Deck_black.size() != 0 || this.Deck_white.size() != 0) //패가 남아있다면
				this.turnindex = Turn.CARDGET;//단계 변경
		}
		gamehandler.update();// ui 업데이트
	}

	private void addcard(int playerindex, Dacolor color) {// 카드 가져오기 구현

		int cardnumber;

		switch (color) {// 색깔에 따라서
		case BLACK:// 검정이라면
			cardnumber = ran.nextInt(Deck_black.size());
			this.pAL.get(playerindex).cardset(this.Deck_black.get(cardnumber));
			this.Deck_black.remove(cardnumber);
			Collections.shuffle(Deck_black, ran);

			break;
		case WHITE:// 하양이라면
			cardnumber = ran.nextInt(Deck_white.size());
			this.pAL.get(playerindex).cardset(this.Deck_white.get(cardnumber));
			this.Deck_white.remove(cardnumber);
			Collections.shuffle(Deck_white,ran);

			break;
		default:
			break;

		}// 카드를 주지 못했다면 실패햇다고 반환
	}

	private void nextturn() {// 턴 넘기기 구현
		do {
			this.turn++;// 턴을 증가시킨다
		} while (!pAL.get(this.turn % this.number_of_gamer).Islive());// 다음사람이
																		// 죽었다면
																		// 계속 반복

		this.canpass = false;// 턴시작이므로 패스불가

		// JOptionPane.showMessageDialog(null, "플레이어"+ (this.turn %
		// this.number_of_gamer + 1)+ "의 턴입니다.");
	}

	private void isEnd() {// 게임끝 검사 메소드
		int liver = 0;// 생존자수
		for (DavinchiCodePlayer DCP : this.pAL) {// 생존자 수 세기
			if (DCP.Islive())
				liver++;
		}
		if (liver == 1) {// 생존자가 1명이라면
			// JOptionPane.showMessageDialog(null, "플레이어"+ (this.turn %
			// this.number_of_gamer + 1) +"께서 승리하셨습니다.");
			this.gamehandler.update();
			for (int i = 0; i < this.getNumberOfGamer(); i++)
				if (this.pAL.get(i).Islive())
					this.gamehandler.gameEnd(i);
		}
	}

	public int getTurn() {
		return this.turn;
	}

	public int getNumberOfGamer() {
		return this.number_of_gamer;
	}

	public boolean getcardinhand(int n, Dacolor color, int number) {
		return pAL.get(n % this.number_of_gamer).cardget(color, number);
	}

	public boolean getopencardinhand(int n, Dacolor color, int number) {
		return pAL.get(n % this.number_of_gamer).opencardget(color, number);
	}

	public Turn getTurnindex() {
		return turnindex;
	}

	public boolean isCanpass() {
		return canpass;
	}

	public int getRemainder_white() {
		return Deck_white.size();
	}

	public int getRemainder_black() {
		return Deck_black.size();
	}

}
