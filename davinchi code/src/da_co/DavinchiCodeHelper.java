package da_co;

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
	private ArrayList<Card> d_w = new ArrayList<Card>();
	private ArrayList<Card> d_b = new ArrayList<Card>();
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
			d_w.add(new Card(Dacolor.WHITE, i));
			d_b.add(new Card(Dacolor.BLACK, i));
		}
		Collections.shuffle(d_b, ran);
		Collections.shuffle(d_w, ran);

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
		this.turnindex = Turn.SELECT;// ���� �ܰ� : ī�� ���߱�
		this.gamehandler.update();// ui ������Ʈ

	}

	public void assertcard(int targetindex, int cardpos, Dacolor color, int number) {// ī��
																				// ���߱�
																				// �޼ҵ�
		int playerindex = (targetindex + this.turn) % this.number_of_gamer;// ������ ī����
																		// ������
																		// �ε���
																		// ����
		if (this.d_b.size() != 0 || this.d_w.size() != 0) {
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
		} else {// ���߾��ٸ�
			// JOptionPane.showMessageDialog(null,
			// "���߾����ϴ�. ���� �ѱ�ų� ī�带 ���� �� �ֽ��ϴ�.");
			if (this.mode == Damode.ChocoTea)//��尡 ���ĸ����
				this.turnindex = Turn.SELECT;//�Ȼ̰� ����Ʈ�ؾ���
			pAL.get(playerindex).setlive();// ������ѻ���� ��Ҵ��� �˻�
			if (!pAL.get(playerindex).Islive()) {//Ÿ���� �׾�����
				gamehandler.dead(playerindex);//���� �˸�
				this.isEnd();//���� ���� �˻�
			}
		}
		this.gamehandler.update();// ui ������Ʈ
	}

	public void passturn() {// �� �ѱ�� �޼ҵ�
		this.nextturn();// ���������� �ѱ�
		if (this.mode == Damode.ChocoTea) {//���ĸ����
			if (this.d_b.size() != 0 || this.d_w.size() != 0) //�а� �����ִٸ�
				this.turnindex = Turn.CARDGET;//�ܰ� ����
		}
		gamehandler.update();// ui ������Ʈ
	}

	private void addcard(int playerindex, Dacolor color) {// ī�� �������� ����

		int cardnumber;

		switch (color) {// ���� ����
		case BLACK:// �����̶��
			cardnumber = ran.nextInt(d_b.size());
			this.pAL.get(playerindex).cardset(this.d_b.get(cardnumber));
			this.d_b.remove(cardnumber);
			Collections.shuffle(d_b, ran);

			break;
		case WHITE:// �Ͼ��̶��
			cardnumber = ran.nextInt(d_w.size());
			this.pAL.get(playerindex).cardset(this.d_w.get(cardnumber));
			this.d_w.remove(cardnumber);
			Collections.shuffle(d_w,ran);

			break;
		default:
			break;

		}// ī�带 ���� ���ߴٸ� �����޴ٰ� ��ȯ
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

	private void isEnd() {// ���ӳ� �˻� �޼ҵ�
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
		return d_w.size();
	}

	public int getRemainder_black() {
		return d_b.size();
	}

}
