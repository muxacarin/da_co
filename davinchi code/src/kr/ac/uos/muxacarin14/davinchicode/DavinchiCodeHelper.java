package kr.ac.uos.muxacarin14.davinchicode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * @author marine and MDV
 * 
 */
public class DavinchiCodeHelper {

	private final GameHandler gamehandler; // ������ : ui����
	private ArrayList<DavinchiCodePlayer> pAL = new ArrayList<DavinchiCodePlayer>(); // �÷��̾�
																						// ������
																						// ��̸���Ʈ
	private final int number_of_gamer;// �����ϴ� ��� ��
	private ArrayList<NomalCard> Deck_white = new ArrayList<NomalCard>();
	private ArrayList<NomalCard> Deck_black = new ArrayList<NomalCard>();
	private Random ran = new Random();// ���� �߻� ��ü
	private int turn;// �� ���� [�� 1 �� = 0]
	private Turn turnindex;// �� �� ���� �ܰ�
	private boolean canpass;// �н����ɿ���
	private Damode mode;

	public DavinchiCodeHelper(GameHandler gh, int gamer, Damode mode) { // ������

		this.gamehandler = gh; 			// ui����
		this.number_of_gamer = gamer;	// ������ �� ����
		this.mode = mode;			 	//��� ����
		for (int i = 0; i < number_of_gamer; i++) {// �÷��̾� ��ü ����
			this.pAL.add(new DavinchiCodePlayer());
		}
		this.pAL.trimToSize();//������ ����ȭ
		this.turn = 0;// �� �ʱ�ȭ

		for (int i = 0; i <= 11; i++) {//�� �ʱ�ȭ
			Deck_white.add(new NomalCard(Dacolor.WHITE, i));
			Deck_black.add(new NomalCard(Dacolor.BLACK, i));
		}
		Collections.shuffle(Deck_black, ran);
		Collections.shuffle(Deck_white, ran);

	}

	public void gamestart() { // ���� ���� �޼ҵ�
		if (this.number_of_gamer == 4) { // ���̸Ӽ� 4�� : �ʱ� �� 3��

			for (int i = 0; i < 4; i++) {// �� ���̸� ����
				for (int j = 1; j <= 3; j++) {// �� 3���� �ɵ���
					this.addcard(i, (this.ran.nextBoolean()) ? Dacolor.BLACK
							: Dacolor.WHITE);

				}
			}

		} else {// ���̸Ӽ� 4���� �ƴϸ� : �ʱ� �� 4��
			for (int i = 0; i < number_of_gamer; i++) {// �� ���̸� ����
				for (int j = 1; j <= 4; j++) {// �� 4���� �� ����
					this.addcard(i, (this.ran.nextBoolean()) ? Dacolor.BLACK
							: Dacolor.WHITE);
				}

			}

		}
		this.turnindex = Turn.CARDGET;// ���� �ܰ� : ī�� ��������

		gamehandler.update();// ui ������Ʈ

		// JOptionPane.showMessageDialog(null, "������ �����մϴ�.");
		// JOptionPane.showMessageDialog(null, "�÷��̾�0�� ���Դϴ�.");
	}

	public void takecard(int peopleindex, Dacolor color) {// ī�� �������� �޼ҵ�

		this.addcard(peopleindex % this.number_of_gamer, color);// ī�带 ���´�
		this.turnindex = Turn.SELECT;// ���� �ܰ� : ī�� ���߱�s
		if(this.mode == Damode.MDV) this.canpass = false;
		this.gamehandler.update();// ui ������Ʈ

	}

	public void assertcard(int targetindex, int cardpos, Dacolor color, int number) {// ī��
																				// ���߱�
																				// �޼ҵ�
		int playerindex = (targetindex + this.turn) % this.number_of_gamer;// ������ ī����
																		// ������
																		// �ε���
																		// ����
		if (this.Deck_black.size() != 0 || this.Deck_white.size() != 0) {
			this.turnindex = Turn.CARDGET;// ���� �ܰ� : ī�� �������� �ܰ�
		} else {
			this.turnindex = Turn.SELECT;// ���� ī�尡 ������ ����Ʈ�ܰ�
		}

		this.canpass = true;// ī�� ���߱⸦ �������� ��� ����
		if (!pAL.get(playerindex).assertbyposition(cardpos, color, number)) {// Ʋ�ȴٸ�
			// JOptionPane.showMessageDialog(null, "Ʋ�Ƚ��ϴ�. ���� �Ѿ�ϴ�.");
			// JOptionPane.showMessageDialog(null, "���������� ���� ī�尡 �����˴ϴ�.");
			pAL.get(this.turn % this.number_of_gamer).lastopen();// ���������� ������ ī��
																	// ����
			nextturn();// ���� �Ѿ
			this.gamehandler.update();
		} else {// ���߾��ٸ�
			// JOptionPane.showMessageDialog(null,
			// "���߾����ϴ�. ���� �ѱ�ų� ī�带 ���� �� �ֽ��ϴ�.");
			if (this.mode == Damode.ChocoTea)//��尡 ���ĸ����
				this.turnindex = Turn.SELECT;//�Ȼ̰� ����Ʈ�ؾ���
			pAL.get(playerindex).setlive();// ������ѻ���� ��Ҵ��� �˻�
			if (!pAL.get(playerindex).Islive()) {//Ÿ���� �׾�����
				this.gamehandler.update();
				gamehandler.dead(playerindex);//���� �˸�
				if(this.isEnd()) return;//���� ���� �˻�
			} else {
				this.gamehandler.update();
			}
		}
	}

	public void passturn() {// �� �ѱ�� �޼ҵ�
		this.nextturn();// ���������� �ѱ�
		if (this.mode == Damode.ChocoTea) {//���ĸ����
			if (this.Deck_black.size() != 0 || this.Deck_white.size() != 0) //�а� �����ִٸ�
				this.turnindex = Turn.CARDGET;//�ܰ� ����
		}
		gamehandler.update();// ui ������Ʈ
	}
	
	public int lastcardpos(int playerindex){
		return pAL.get(playerindex).lastcardpos();
	}

	private void addcard(int playerindex, Dacolor color) {// ī�� �������� ����

		int cardnumber;

		switch (color) {// ���� ����
		case BLACK:// �����̶��
			cardnumber = ran.nextInt(Deck_black.size());
			this.pAL.get(playerindex).cardset(this.Deck_black.get(cardnumber));
			this.Deck_black.remove(cardnumber);
			Collections.shuffle(Deck_black, ran);
			break;
		case WHITE:// �Ͼ��̶��
			cardnumber = ran.nextInt(Deck_white.size());
			this.pAL.get(playerindex).cardset(this.Deck_white.get(cardnumber));
			this.Deck_white.remove(cardnumber);
			Collections.shuffle(Deck_white,ran);
			break;
		default:
			break;

		}
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
			this.gamehandler.update();
			for (int i = 0; i < this.getNumberOfGamer(); i++)
				if (this.pAL.get(i).Islive()){
					this.gamehandler.gameEnd(i);
					return true;
				}
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
		return Deck_white.size();
	}

	public int getRemainder_black() {
		return Deck_black.size();
	}

}
