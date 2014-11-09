package da_co;

import java.util.Arrays;

/**
 * @author marine and MDV
 *
 */
public class DavinchiCodePlayer {
	
	private boolean hand_white[] = new boolean[12];
	private boolean hand_black[] = new boolean[12];//���� �迭
	private boolean open_white[] = new boolean[12];
	private boolean open_black[] = new boolean[12];//����ī�� �迭
	private boolean islive = true;//���� ����
	private Dacolor lastcolor;//���������� ���� ī���� 
	private int lastnumber;//���������� ���� ī���� ����
	
	DavinchiCodePlayer(){ //����
		Arrays.fill(hand_white, false);
		Arrays.fill(hand_black, false);
		Arrays.fill(open_black, false);
		Arrays.fill(open_white, false);//���� ����ī�� �迭 false�� ä���.
	}
	
	
	public void cardset(Dacolor color, int number){//ī�� ���� �޼ҵ�
		
		switch (color){
		case WHITE: hand_white[number] = true;//�����̶��
			lastcolor = Dacolor.WHITE;
			lastnumber = number;
			break;
		case BLACK: hand_black[number] = true;//�������̶��
			lastcolor = Dacolor.BLACK;
			lastnumber = number;
			break;
		default:
			break;
		
		}
		
	}
	
	public void lastopen(){//������ ���� ī�� ���� �޼ҵ�
		if (this.lastcolor.equals(Dacolor.BLACK)){
			this.open_black[this.lastnumber] = true;
		} else {
			this.open_white[this.lastnumber] = true;
		}
	}
	

	public boolean cardget(Dacolor color, int number){//ī�� ����ִ��� �˻� �޼ҵ�
		
		return (color.equals(Dacolor.BLACK)) ? this.hand_black[number] : this.hand_white[number];
	}
	
	public boolean opencardget(Dacolor color, int number){//ī�尡 ���µǾ��ִ��� �˻� �޼ҵ�
		
		return (color.equals(Dacolor.BLACK)) ? this.open_black[number] : this.open_white[number];
	}
	
	public boolean cardposition(int cardpos, Dacolor color, int number){//ī�� ��ġ�� �˻� �޼ҵ� 
		boolean[] hand = (color.equals(Dacolor.BLACK)) ? this.hand_black : this.hand_white;
		boolean[] open = (color.equals(Dacolor.BLACK)) ? this.open_black : this.open_white;//���򺰷� �迭 ����
		
		if (open[number]) return false; //���µǾ� �ִ� ����� false
		
		if (hand[number]) {//���µǾ����� �ʰ� ������ �ִٸ�
			if(cardcount(color, number) == cardpos + 1) open[number] = true;//ī�� ������ �´ٸ� ����
		}
		return open[number];//���¿��� ��ȯ
	}
	
	private int cardcount(Dacolor color, int number){//ī�� ���� ��ȯ �޼ҵ� -> ���
		boolean[] hand = (color.equals(Dacolor.BLACK)) ? this.hand_black : this.hand_white; //�Ű����� �÷��� �迭 ����
		int pos = (hand[number]) ? 1 : 0; //�÷��� �ѹ��� ��� ������ 1 �ƴϸ� 0 
		if (color == Dacolor.BLACK )
			if ( number == 0) return pos; //������ 0�� isthis��ȯ
			else return pos + cardcount(Dacolor.WHITE, number-1);//�����ε� 0�� �ƴ϶�� �Ͼ��� 1�� �� ������ ���� ���ؼ� ��ȯ
		else return pos + cardcount(Dacolor.BLACK, number);//�Ͼ��̶�� ������ �������� ���� ���ؼ� ��ȯ
		
	}

	public boolean Islive() {//�������� ��ȯ
		return islive;
	}

	public void setlive() {//�������� �˻�
		int white = 0;
		int black = 0;
		int white_open = 0;
		int black_open = 0;//�� ���� �ڵ�� ����ī�� �� ����
		
		for(int n = 0; n < hand_white.length;n++){
			if(this.hand_black[n]) black++;
			if(this.hand_white[n]) white++;
			if(this.open_black[n]) black_open++;
			if(this.open_white[n]) white_open++;//ī��� ����
		}
		
		if(black == black_open && white == white_open){//�ڵ�� = ����ī��� ���
			this.islive = false;//�״´�
		}
		
	}
}
