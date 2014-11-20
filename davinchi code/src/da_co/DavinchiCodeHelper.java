package da_co;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * @author marine and MDV
 * 
 */
public class DavinchiCodeHelper {

	private final GameHandler gamehandler; // ������ : ui����
	// private DavinchiCodePlayer[] pa = new DavinchiCodePlayer[4];
	private ArrayList<DavinchiCodePlayer> pAL = new ArrayList<DavinchiCodePlayer>(); // �÷��̾�
																						// ������
																						// ��̸���Ʈ
	private final int number_of_gamer;// �����ϴ� ��� ��
	private boolean deck_white[] = new boolean[12];
	private int remainder_white;
	private boolean deck_black[] = new boolean[12];
	private int remainder_black;// �� �迭�� ���� ī�� ��
	private Random ran = new Random();// ���� �߻� ��ü
	private int turn;// �� ���� [�� 1 �� = 0]
	private Turn turnindex;// �� �� ���� �ܰ�
	private boolean canpass;// �н����ɿ���
	private Damode mode;

	public DavinchiCodeHelper(GameHandler gh, int gamer, Damode mode) { // ������

		this.gamehandler = gh; // ui����
		this.number_of_gamer = gamer;// ������ �� ����

		this.mode = mode;
		Arrays.fill(deck_white, true);
		Arrays.fill(deck_black, true);// �� �ʱ�ȭ
		for (int i = 0; i < number_of_gamer; i++) {// �÷��̾� ��ü ����
			this.pAL.add(new DavinchiCodePlayer());
		}
		this.pAL.trimToSize();
		this.turn = 0;// �� �ʱ�ȭ
		this.setRemainder_black(12);
		this.setRemainder_white(12);// ���� ī�� �� �ʱ�ȭ

	}

	public void gamestart() { // ���� ���� �޼ҵ�
		if (this.number_of_gamer == 4) { // ���̸Ӽ� 4�� : �ʱ� �� 3��

			for (int i = 0; i < 4; i++) {// �� ���̸� ����
				for (int j = 1; j <= 3;) {// �� 3���� �ɵ���
					if (this.addcard(i,
							(this.ran.nextBoolean()) ? Dacolor.BLACK
									: Dacolor.WHITE))
						j++;// ī�带 �̾��ش�
				}
			}

		} else {// ���̸Ӽ� 4���� �ƴϸ� : �ʱ� �� 4��
			for (int i = 0; i < number_of_gamer; i++) {// �� ���̸� ����
				for (int j = 1; j <= 4;) {// �� 4���� �� ����
					if (this.addcard(i,
							(this.ran.nextBoolean()) ? Dacolor.BLACK
									: Dacolor.WHITE))
						j++;// ī�带 �̾��ش�
				}

			}

		}
		this.turnindex = Turn.CARDGET;// ���� �ܰ� : ī�� ��������

		gamehandler.update();// �� ������Ʈ

		// JOptionPane.showMessageDialog(null, "������ �����մϴ�.");
		// JOptionPane.showMessageDialog(null, "�÷��̾�0�� ���Դϴ�.");
	}

	public void takecard(int peopleindex, Dacolor color) {// ī�� �������� �޼ҵ�

		while (!this.addcard(peopleindex % this.number_of_gamer, color))
			;// ī�带 ���´�
		this.turnindex = Turn.SELECT;// ���� �ܰ� : ī�� ���߱�
		this.gamehandler.update();// ui ������Ʈ

	}

	public void assertcard(int player, int cardpos, Dacolor color, int number) {// ī��
																				// ���߱�
																				// �޼ҵ�
		int playerindex = (player + this.turn) % this.number_of_gamer;// ������ ī����
																		// ������
																		// �ε���
																		// ����
		if (this.remainder_black != 0 || this.remainder_white != 0) {
			this.turnindex = Turn.CARDGET;// ���� �ܰ� : ī�� �������� �ܰ�
		} else {
			this.turnindex = Turn.SELECT;// ���� ī�尡 ������ ����Ʈ�ܰ�
		}

		this.canpass = true;// ī�� ���߱⸦ �������� ��� ����
		if (!pAL.get(playerindex).cardposition(cardpos, color, number)) {// Ʋ�ȴٸ�
			// JOptionPane.showMessageDialog(null, "Ʋ�Ƚ��ϴ�. ���� �Ѿ�ϴ�.");
			// JOptionPane.showMessageDialog(null, "���������� ���� ī�尡 �����˴ϴ�.");
			pAL.get(this.turn % this.number_of_gamer).lastopen();// ���������� ������ ī��
																	// ����
			nextturn();// ���� �Ѿ
		} else {// ���߾��ٸ�
			// JOptionPane.showMessageDialog(null,
			// "���߾����ϴ�. ���� �ѱ�ų� ī�带 ���� �� �ֽ��ϴ�.");
			if (this.mode == Damode.ChocoTea)
				this.turnindex = Turn.SELECT;
			pAL.get(playerindex).setlive();// ������ѻ���� ��Ҵ��� �˻�
			if (!pAL.get(playerindex).Islive()) {
				gamehandler.dead(playerindex);
			}
			if (this.isEnd()) {// ������ �������� �˻�
				return;
			}
			;
		}

		this.gamehandler.update();// ui ������Ʈ

	}

	public void passturn() {// �� �ѱ�� �޼ҵ�
		this.nextturn();// ���������� �ѱ�
		if (this.mode == Damode.ChocoTea) {
			if (this.remainder_black != 0 || this.remainder_white != 0)
				this.turnindex = Turn.CARDGET;
		}
		gamehandler.update();// ui ������Ʈ
	}

	private boolean addcard(int playerindex, Dacolor color) {// ī�� �������� ����

		int cardnumber = ran.nextInt(12);// 0 - 11 ������ ����

		switch (color) {// ���� ����
		case BLACK:// �����̶��
			if (this.deck_black[cardnumber]) {// ���� ����ī�带 �� ���ִٸ�
				this.pAL.get(playerindex).cardset(Dacolor.BLACK, cardnumber);// ī��
																				// �߰�
				this.deck_black[cardnumber] = false;// ������ ����
				this.setRemainder_black(this.getRemainder_black() - 1);// ī�� �� 1
																		// ����
				return true;// �����ߴٰ� ��ȯ
			}
			break;
		case WHITE:// �Ͼ��̶��
			if (this.deck_white[cardnumber]) {
				this.pAL.get(playerindex).cardset(Dacolor.WHITE, cardnumber);
				this.deck_white[cardnumber] = false;
				this.setRemainder_white(this.getRemainder_white() - 1);
				return true;
			}
			break;
		default:
			break;

		}
		return false;// ī�带 ���� ���ߴٸ� �����޴ٰ� ��ȯ
	}

	private void nextturn() {// �� �ѱ�� ����
		do {
			this.turn++;// ���� ������Ų��
		} while (!pAL.get(this.turn % this.number_of_gamer).Islive());// ���������
																		// �׾��ٸ�
																		// ��� �ݺ�

		this.canpass = false;// �Ͻ����̹Ƿ� �н��Ұ�

		// JOptionPane.showMessageDialog(null, "�÷��̾�"+ (this.turn %
		// this.number_of_gamer + 1)+ "�� ���Դϴ�.");
	}

	private boolean isEnd() {// ���ӳ� �˻� �޼ҵ�
		int liver = 0;// �����ڼ�
		for (DavinchiCodePlayer DCP : this.pAL) {// ������ �� ����
			if (DCP.Islive())
				liver++;
		}
		if (liver == 1) {// �����ڰ� 1���̶��
			// JOptionPane.showMessageDialog(null, "�÷��̾�"+ (this.turn %
			// this.number_of_gamer + 1) +"���� �¸��ϼ̽��ϴ�.");
			for (int i = 0; i < this.getNumberOfGamer(); i++)
				if (this.pAL.get(i).Islive())
					this.gamehandler.gameEnd(i);
			return true;
		}
		return false;
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
		return remainder_white;
	}

	private void setRemainder_white(int remainder_white) {
		this.remainder_white = remainder_white;
	}

	public int getRemainder_black() {
		return remainder_black;
	}

	private void setRemainder_black(int remainder_black) {
		this.remainder_black = remainder_black;
	}

}
