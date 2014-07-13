package da_co;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class GameWindows extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7954384317661319220L; //직렬화 uid
	
	private DavinchiCodeHelper davinchicodehelper;	//게임담당클래스 선언
	
	private JPanel contentPane;	//판때기
	
	
	private final Action exitaction = new ExitAction();	//종료액션
	private final Action TakeBlack = new Takeblack();
	private final Action TakeWhite = new Takewhite();
	private final Action passturn = new PassTurn();
	
	
	private final Insets zeroinests = new Insets(0,0,0,0);	//여백 0
	
	private final MouseAdapter mouse = new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			JButton button = (JButton) arg0.getSource();
			if(button.isEnabled()) GameWindows.this.assertcard(button);;
		}
	};
	
	private JButton mycard_1;
	private JButton mycard_2;
	private JButton mycard_3;
	private JButton mycard_4;
	private JButton mycard_5;
	private JButton mycard_6;
	private JButton mycard_7;	//자기카드버튼
	private JButton[] mycard_list/* = {mycard_1,mycard_2,mycard_3,mycard_4,mycard_5,mycard_6,mycard_7}*/;	//자기카드버튼배열
	
	private JButton p1card_1;
	private JButton p1card_2;
	private JButton p1card_3;
	private JButton p1card_4;
	private JButton p1card_5;
	private JButton p1card_6;
	private JButton p1card_7;	//p1카드버튼
	private JButton[] p1card_list/* = new JButton[]{p1card_1,p1card_2,p1card_3,p1card_4,p1card_5,p1card_6,p1card_7}*/;	//p1카드버튼배열
			
	private JButton p2card_1;
	private JButton p2card_2;
	private JButton p2card_3;
	private JButton p2card_4;
	private JButton p2card_5;
	private JButton p2card_6;
	private JButton p2card_7;	//p2카드버튼
	private JButton[] p2card_list/* = new JButton[]{p2card_1,p2card_2,p2card_3,p2card_4,p2card_5,p2card_6,p2card_7}*/;	//p2카드버튼배열
	
	private JButton p3card_1;
	private JButton p3card_2;
	private JButton p3card_3;
	private JButton p3card_4;
	private JButton p3card_5;
	private JButton p3card_6;
	private JButton p3card_7;	//p3카드버튼
	private JButton[] p3card_list/* = new JButton[]{p3card_1,p3card_2,p3card_3,p3card_4,p3card_5,p3card_6,p3card_7}*/;	//p3카드버튼배열
	
	private JButton[][] listarray /*={mycard_list, p1card_list, p2card_list, p3card_list}*/;
	
	
	private JButton getblackcard;
	private JButton getwhitecard;
	private JButton passbutton;
	private JButton p2card_8;
	private JButton p2card_9;
	private JButton p2card_10;
	private JButton p2card_11;
	private JButton p2card_12;
	private JButton p2card_13;
	private JButton p2card_14;
	private JButton p1card_8;
	private JButton p1card_9;
	private JButton p1card_10;
	private JButton p1card_11;
	private JButton p1card_12;
	private JButton p1card_13;
	private JButton p1card_14;
	private JButton p3card_8;
	private JButton p3card_9;
	private JButton p3card_10;
	private JButton p3card_11;
	private JButton p3card_12;
	private JButton p3card_13;
	private JButton p3card_14;
	private JButton mycard_8;
	private JButton mycard_9;
	private JButton mycard_10;
	private JButton mycard_11;
	private JButton mycard_12;
	private JButton mycard_13;
	private JButton mycard_14;
	private JButton exitbutton;
	private JComboBox numberBox;
	


	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 **/
	public GameWindows(int people)  {
		
		davinchicodehelper = new DavinchiCodeHelper(this, people);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 880, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		gbl_contentPane.columnWidths = new int[]{40,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,40};
		gbl_contentPane.rowHeights = new int[]{30,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,30};
		contentPane.setLayout(gbl_contentPane);
		
		p2card_14 = new JButton("");
		GridBagConstraints gbc_p2card_14 = new GridBagConstraints();
		gbc_p2card_14.fill = GridBagConstraints.BOTH;
		gbc_p2card_14.insets = zeroinests;
		gbc_p2card_14.gridx = 2;
		gbc_p2card_14.gridy = 1;
		contentPane.add(p2card_14, gbc_p2card_14);
		
		p2card_13 = new JButton("");
		GridBagConstraints gbc_p2card_13 = new GridBagConstraints();
		gbc_p2card_13.fill = GridBagConstraints.BOTH;
		gbc_p2card_13.insets = zeroinests;
		gbc_p2card_13.gridx = 3;
		gbc_p2card_13.gridy = 1;
		contentPane.add(p2card_13, gbc_p2card_13);
		
		p2card_12 = new JButton("");
		GridBagConstraints gbc_p2card_12 = new GridBagConstraints();
		gbc_p2card_12.fill = GridBagConstraints.BOTH;
		gbc_p2card_12.insets = zeroinests;
		gbc_p2card_12.gridx = 4;
		gbc_p2card_12.gridy = 1;
		contentPane.add(p2card_12, gbc_p2card_12);
		
		p2card_11 = new JButton("");
		GridBagConstraints gbc_p2card_11 = new GridBagConstraints();
		gbc_p2card_11.fill = GridBagConstraints.BOTH;
		gbc_p2card_11.insets = zeroinests;
		gbc_p2card_11.gridx = 5;
		gbc_p2card_11.gridy = 1;
		contentPane.add(p2card_11, gbc_p2card_11);
		
		p2card_10 = new JButton("");
		GridBagConstraints gbc_p2card_10 = new GridBagConstraints();
		gbc_p2card_10.fill = GridBagConstraints.BOTH;
		gbc_p2card_10.insets = zeroinests;
		gbc_p2card_10.gridx = 6;
		gbc_p2card_10.gridy = 1;
		contentPane.add(p2card_10, gbc_p2card_10);
		
		p2card_9 = new JButton("");
		GridBagConstraints gbc_p2card_9 = new GridBagConstraints();
		gbc_p2card_9.fill = GridBagConstraints.BOTH;
		gbc_p2card_9.insets = zeroinests;
		gbc_p2card_9.gridx = 7;
		gbc_p2card_9.gridy = 1;
		contentPane.add(p2card_9, gbc_p2card_9);
		
		p2card_8 = new JButton("");
		GridBagConstraints gbc_p2card_8 = new GridBagConstraints();
		gbc_p2card_8.fill = GridBagConstraints.BOTH;
		gbc_p2card_8.insets = zeroinests;
		gbc_p2card_8.gridx = 8;
		gbc_p2card_8.gridy = 1;
		contentPane.add(p2card_8, gbc_p2card_8);
		p2card_7 = new JButton("");
		GridBagConstraints gbc_p2card_7 = new GridBagConstraints();
		gbc_p2card_7.fill = GridBagConstraints.BOTH;
		gbc_p2card_7.insets = zeroinests;
		gbc_p2card_7.gridx = 9;
		gbc_p2card_7.gridy = 1;
		contentPane.add(p2card_7, gbc_p2card_7);
		
		p2card_6 = new JButton("");
		GridBagConstraints gbc_p2card_6 = new GridBagConstraints();
		gbc_p2card_6.fill = GridBagConstraints.BOTH;
		gbc_p2card_6.insets = zeroinests;
		gbc_p2card_6.gridx = 10;
		gbc_p2card_6.gridy = 1;
		contentPane.add(p2card_6, gbc_p2card_6);
		
		p2card_5 = new JButton("");
		GridBagConstraints gbc_p2card_5 = new GridBagConstraints();
		gbc_p2card_5.fill = GridBagConstraints.BOTH;
		gbc_p2card_5.insets = zeroinests;
		gbc_p2card_5.gridx = 11;
		gbc_p2card_5.gridy = 1;
		contentPane.add(p2card_5, gbc_p2card_5);
		
		p2card_4 = new JButton("");
		GridBagConstraints gbc_p2card_4 = new GridBagConstraints();
		gbc_p2card_4.fill = GridBagConstraints.BOTH;
		gbc_p2card_4.insets = zeroinests;
		gbc_p2card_4.gridx = 12;
		gbc_p2card_4.gridy = 1;
		contentPane.add(p2card_4, gbc_p2card_4);
		
		p2card_3 = new JButton("");
		GridBagConstraints gbc_p2card_3 = new GridBagConstraints();
		gbc_p2card_3.fill = GridBagConstraints.BOTH;
		gbc_p2card_3.insets = zeroinests;
		gbc_p2card_3.gridx = 13;
		gbc_p2card_3.gridy = 1;
		contentPane.add(p2card_3, gbc_p2card_3);
		
		p2card_2 = new JButton("");
		GridBagConstraints gbc_p2card_2 = new GridBagConstraints();
		gbc_p2card_2.fill = GridBagConstraints.BOTH;
		gbc_p2card_2.insets = zeroinests;
		gbc_p2card_2.gridx = 14;
		gbc_p2card_2.gridy = 1;
		contentPane.add(p2card_2, gbc_p2card_2);
		
		p2card_1 = new JButton("");
		//p2card_1.addMouseListener(mouse);
		GridBagConstraints gbc_p2card_1 = new GridBagConstraints();
		gbc_p2card_1.fill = GridBagConstraints.BOTH;
		gbc_p2card_1.insets = zeroinests;
		gbc_p2card_1.gridx = 15;
		gbc_p2card_1.gridy = 1;
		contentPane.add(p2card_1, gbc_p2card_1);
		
		p3card_1 = new JButton("");
		GridBagConstraints gbc_p3card_1 = new GridBagConstraints();
		gbc_p3card_1.fill = GridBagConstraints.BOTH;
		gbc_p3card_1.insets = zeroinests;
		gbc_p3card_1.gridx = 1;
		gbc_p3card_1.gridy = 2;
		contentPane.add(p3card_1, gbc_p3card_1);
		
		p1card_14 = new JButton("");
		GridBagConstraints gbc_p1card_14 = new GridBagConstraints();
		gbc_p1card_14.fill = GridBagConstraints.BOTH;
		gbc_p1card_14.insets = zeroinests;
		gbc_p1card_14.gridx = 16;
		gbc_p1card_14.gridy = 2;
		contentPane.add(p1card_14, gbc_p1card_14);
		
		p3card_2 = new JButton("");
		GridBagConstraints gbc_p3card_2 = new GridBagConstraints();
		gbc_p3card_2.fill = GridBagConstraints.BOTH;
		gbc_p3card_2.insets = zeroinests;
		gbc_p3card_2.gridx = 1;
		gbc_p3card_2.gridy = 3;
		contentPane.add(p3card_2, gbc_p3card_2);
		
		p1card_13 = new JButton("");
		GridBagConstraints gbc_p1card_13 = new GridBagConstraints();
		gbc_p1card_13.fill = GridBagConstraints.BOTH;
		gbc_p1card_13.insets = zeroinests;
		gbc_p1card_13.gridx = 16;
		gbc_p1card_13.gridy = 3;
		contentPane.add(p1card_13, gbc_p1card_13);
		
		p3card_3 = new JButton("");
		GridBagConstraints gbc_p3card_3 = new GridBagConstraints();
		gbc_p3card_3.fill = GridBagConstraints.BOTH;
		gbc_p3card_3.insets = zeroinests;
		gbc_p3card_3.gridx = 1;
		gbc_p3card_3.gridy = 4;
		contentPane.add(p3card_3, gbc_p3card_3);
		
		numberBox = new JComboBox();
		numberBox.setFont(new Font("Dialog", Font.BOLD, 20));
		numberBox.setModel(new DefaultComboBoxModel(new String[] {"    0", "    1", "    2", "    3", "    4", "    5", "    6", "    7", "    8", "    9", "   10", "   11"}));
		GridBagConstraints gbc_numberBox = new GridBagConstraints();
		gbc_numberBox.gridheight = 2;
		gbc_numberBox.gridwidth = 2;
		gbc_numberBox.insets = zeroinests;
		gbc_numberBox.fill = GridBagConstraints.BOTH;
		gbc_numberBox.gridx = 8;
		gbc_numberBox.gridy = 4;
		contentPane.add(numberBox, gbc_numberBox);
		
		p1card_12 = new JButton("");
		GridBagConstraints gbc_p1card_12 = new GridBagConstraints();
		gbc_p1card_12.fill = GridBagConstraints.BOTH;
		gbc_p1card_12.insets = zeroinests;
		gbc_p1card_12.gridx = 16;
		gbc_p1card_12.gridy = 4;
		contentPane.add(p1card_12, gbc_p1card_12);
		
		p3card_4 = new JButton("");
		GridBagConstraints gbc_p3card_4 = new GridBagConstraints();
		gbc_p3card_4.fill = GridBagConstraints.BOTH;
		gbc_p3card_4.insets = zeroinests;
		gbc_p3card_4.gridx = 1;
		gbc_p3card_4.gridy = 5;
		contentPane.add(p3card_4, gbc_p3card_4);
		
		p1card_11 = new JButton("");
		GridBagConstraints gbc_p1card_11 = new GridBagConstraints();
		gbc_p1card_11.fill = GridBagConstraints.BOTH;
		gbc_p1card_11.insets = zeroinests;
		gbc_p1card_11.gridx = 16;
		gbc_p1card_11.gridy = 5;
		contentPane.add(p1card_11, gbc_p1card_11);
		
		p3card_5 = new JButton("");
		GridBagConstraints gbc_p3card_5 = new GridBagConstraints();
		gbc_p3card_5.fill = GridBagConstraints.BOTH;
		gbc_p3card_5.insets = zeroinests;
		gbc_p3card_5.gridx = 1;
		gbc_p3card_5.gridy = 6;
		contentPane.add(p3card_5, gbc_p3card_5);
		
		p1card_10 = new JButton("");
		GridBagConstraints gbc_p1card_10 = new GridBagConstraints();
		gbc_p1card_10.fill = GridBagConstraints.BOTH;
		gbc_p1card_10.insets = zeroinests;
		gbc_p1card_10.gridx = 16;
		gbc_p1card_10.gridy = 6;
		contentPane.add(p1card_10, gbc_p1card_10);
		
		p3card_6 = new JButton("");
		GridBagConstraints gbc_p3card_6 = new GridBagConstraints();
		gbc_p3card_6.fill = GridBagConstraints.BOTH;
		gbc_p3card_6.insets = zeroinests;
		gbc_p3card_6.gridx = 1;
		gbc_p3card_6.gridy = 7;
		contentPane.add(p3card_6, gbc_p3card_6);
		
		getblackcard = new JButton("");
		getblackcard.setAction(TakeBlack);
		getblackcard.setBackground(Color.BLACK);
		getblackcard.setForeground(Color.WHITE);
		GridBagConstraints gbc_getblackcard = new GridBagConstraints();
		gbc_getblackcard.gridheight = 2;
		gbc_getblackcard.gridwidth = 2;
		gbc_getblackcard.fill = GridBagConstraints.BOTH;
		gbc_getblackcard.insets = zeroinests;
		gbc_getblackcard.gridx = 6;
		gbc_getblackcard.gridy = 7;
		contentPane.add(getblackcard, gbc_getblackcard);
		
		getwhitecard = new JButton("");
		getwhitecard.setAction(TakeWhite);
		getwhitecard.setBackground(Color.WHITE);
		getwhitecard.setForeground(Color.BLACK);
		GridBagConstraints gbc_getwhitecard= new GridBagConstraints();
		gbc_getwhitecard.gridheight = 2;
		gbc_getwhitecard.gridwidth = 2;
		gbc_getwhitecard.fill = GridBagConstraints.BOTH;
		gbc_getwhitecard.insets = zeroinests;
		gbc_getwhitecard.gridx = 10;
		gbc_getwhitecard.gridy = 7;
		contentPane.add(getwhitecard, gbc_getwhitecard);
		
		p1card_9 = new JButton("");
		GridBagConstraints gbc_p1card_9 = new GridBagConstraints();
		gbc_p1card_9.fill = GridBagConstraints.BOTH;
		gbc_p1card_9.insets = zeroinests;
		gbc_p1card_9.gridx = 16;
		gbc_p1card_9.gridy = 7;
		contentPane.add(p1card_9, gbc_p1card_9);
		
		p3card_7 = new JButton("");
		GridBagConstraints gbc_p3card_7 = new GridBagConstraints();
		gbc_p3card_7.fill = GridBagConstraints.BOTH;
		gbc_p3card_7.insets = zeroinests;
		gbc_p3card_7.gridx = 1;
		gbc_p3card_7.gridy = 8;
		contentPane.add(p3card_7, gbc_p3card_7);
		
		p1card_8 = new JButton("");
		GridBagConstraints gbc_p1card_8 = new GridBagConstraints();
		gbc_p1card_8.fill = GridBagConstraints.BOTH;
		gbc_p1card_8.insets = zeroinests;
		gbc_p1card_8.gridx = 16;
		gbc_p1card_8.gridy = 8;
		contentPane.add(p1card_8, gbc_p1card_8);
		
		p3card_8 = new JButton("");
		GridBagConstraints gbc_p3card_8 = new GridBagConstraints();
		gbc_p3card_8.fill = GridBagConstraints.BOTH;
		gbc_p3card_8.insets = zeroinests;
		gbc_p3card_8.gridx = 1;
		gbc_p3card_8.gridy = 9;
		contentPane.add(p3card_8, gbc_p3card_8);
		
		passbutton = new JButton("");
		passbutton.setAction(passturn);
		GridBagConstraints gbc_passbutton = new GridBagConstraints();
		gbc_passbutton.gridheight = 2;
		gbc_passbutton.gridwidth = 2;
		gbc_passbutton.fill = GridBagConstraints.BOTH;
		gbc_passbutton.insets = zeroinests;
		gbc_passbutton.gridx = 8;
		gbc_passbutton.gridy = 9;
		contentPane.add(passbutton, gbc_passbutton);
		
		p1card_7 = new JButton("");
		GridBagConstraints gbc_p1card_7 = new GridBagConstraints();
		gbc_p1card_7.fill = GridBagConstraints.BOTH;
		gbc_p1card_7.insets = zeroinests;
		gbc_p1card_7.gridx = 16;
		gbc_p1card_7.gridy = 9;
		contentPane.add(p1card_7, gbc_p1card_7);
		
		p3card_9 = new JButton("");
		GridBagConstraints gbc_p3card_9 = new GridBagConstraints();
		gbc_p3card_9.fill = GridBagConstraints.BOTH;
		gbc_p3card_9.insets = zeroinests;
		gbc_p3card_9.gridx = 1;
		gbc_p3card_9.gridy = 10;
		contentPane.add(p3card_9, gbc_p3card_9);
		
		p1card_6 = new JButton("");
		GridBagConstraints gbc_p1card_6 = new GridBagConstraints();
		gbc_p1card_6.fill = GridBagConstraints.BOTH;
		gbc_p1card_6.insets = zeroinests;
		gbc_p1card_6.gridx = 16;
		gbc_p1card_6.gridy = 10;
		contentPane.add(p1card_6, gbc_p1card_6);
		
		p3card_10 = new JButton("");
		GridBagConstraints gbc_p3card_10 = new GridBagConstraints();
		gbc_p3card_10.fill = GridBagConstraints.BOTH;
		gbc_p3card_10.insets = zeroinests;
		gbc_p3card_10.gridx = 1;
		gbc_p3card_10.gridy = 11;
		contentPane.add(p3card_10, gbc_p3card_10);
		
		p1card_5 = new JButton("");
		GridBagConstraints gbc_p1card_5 = new GridBagConstraints();
		gbc_p1card_5.fill = GridBagConstraints.BOTH;
		gbc_p1card_5.insets = zeroinests;
		gbc_p1card_5.gridx = 16;
		gbc_p1card_5.gridy = 11;
		contentPane.add(p1card_5, gbc_p1card_5);
		
		p3card_11 = new JButton("");
		GridBagConstraints gbc_p3card_11 = new GridBagConstraints();
		gbc_p3card_11.fill = GridBagConstraints.BOTH;
		gbc_p3card_11.insets = zeroinests;
		gbc_p3card_11.gridx = 1;
		gbc_p3card_11.gridy = 12;
		contentPane.add(p3card_11, gbc_p3card_11);
		
		p1card_4 = new JButton("");
		GridBagConstraints gbc_p1card_4 = new GridBagConstraints();
		gbc_p1card_4.fill = GridBagConstraints.BOTH;
		gbc_p1card_4.insets = zeroinests;
		gbc_p1card_4.gridx = 16;
		gbc_p1card_4.gridy = 12;
		contentPane.add(p1card_4, gbc_p1card_4);
		
		p3card_12 = new JButton("");
		GridBagConstraints gbc_p3card_12 = new GridBagConstraints();
		gbc_p3card_12.fill = GridBagConstraints.BOTH;
		gbc_p3card_12.insets = zeroinests;
		gbc_p3card_12.gridx = 1;
		gbc_p3card_12.gridy = 13;
		contentPane.add(p3card_12, gbc_p3card_12);
		
		p1card_3 = new JButton("");
		GridBagConstraints gbc_p1card_3 = new GridBagConstraints();
		gbc_p1card_3.fill = GridBagConstraints.BOTH;
		gbc_p1card_3.insets = zeroinests;
		gbc_p1card_3.gridx = 16;
		gbc_p1card_3.gridy = 13;
		contentPane.add(p1card_3, gbc_p1card_3);
		
		p3card_13 = new JButton("");
		GridBagConstraints gbc_p3card_13 = new GridBagConstraints();
		gbc_p3card_13.fill = GridBagConstraints.BOTH;
		gbc_p3card_13.insets = zeroinests;
		gbc_p3card_13.gridx = 1;
		gbc_p3card_13.gridy = 14;
		contentPane.add(p3card_13, gbc_p3card_13);
		
		p1card_2 = new JButton("");
		GridBagConstraints gbc_p1card_2 = new GridBagConstraints();
		gbc_p1card_2.fill = GridBagConstraints.BOTH;
		gbc_p1card_2.insets = zeroinests;
		gbc_p1card_2.gridx = 16;
		gbc_p1card_2.gridy = 14;
		contentPane.add(p1card_2, gbc_p1card_2);
		
		p3card_14 = new JButton("");
		GridBagConstraints gbc_p3card_14 = new GridBagConstraints();
		gbc_p3card_14.fill = GridBagConstraints.BOTH;
		gbc_p3card_14.insets = zeroinests;
		gbc_p3card_14.gridx = 1;
		gbc_p3card_14.gridy = 15;
		contentPane.add(p3card_14, gbc_p3card_14);
		
		p1card_1 = new JButton("");
		GridBagConstraints gbc_p1card_1 = new GridBagConstraints();
		gbc_p1card_1.fill = GridBagConstraints.BOTH;
		gbc_p1card_1.insets = zeroinests;
		gbc_p1card_1.gridx = 16;
		gbc_p1card_1.gridy = 15;
		contentPane.add(p1card_1, gbc_p1card_1);
		
		mycard_1 = new JButton("");
		GridBagConstraints gbc_mycard_1 = new GridBagConstraints();
		gbc_mycard_1.fill = GridBagConstraints.BOTH;
		gbc_mycard_1.insets = zeroinests;
		gbc_mycard_1.gridx = 2;
		gbc_mycard_1.gridy = 16;
		contentPane.add(mycard_1, gbc_mycard_1);
		
		mycard_2 = new JButton("");
		GridBagConstraints gbc_mycard_2 = new GridBagConstraints();
		gbc_mycard_2.fill = GridBagConstraints.BOTH;
		gbc_mycard_2.insets = zeroinests;
		gbc_mycard_2.gridx = 3;
		gbc_mycard_2.gridy = 16;
		contentPane.add(mycard_2, gbc_mycard_2);
		
		mycard_3 = new JButton("");
		GridBagConstraints gbc_mycard_3 = new GridBagConstraints();
		gbc_mycard_3.fill = GridBagConstraints.BOTH;
		gbc_mycard_3.insets = zeroinests;
		gbc_mycard_3.gridx = 4;
		gbc_mycard_3.gridy = 16;
		contentPane.add(mycard_3, gbc_mycard_3);
		
		mycard_4 = new JButton("");
		GridBagConstraints gbc_mycard_4 = new GridBagConstraints();
		gbc_mycard_4.fill = GridBagConstraints.BOTH;
		gbc_mycard_4.insets = zeroinests;
		gbc_mycard_4.gridx = 5;
		gbc_mycard_4.gridy = 16;
		contentPane.add(mycard_4, gbc_mycard_4);
		
		mycard_5 = new JButton("");
		GridBagConstraints gbc_mycard_5 = new GridBagConstraints();
		gbc_mycard_5.fill = GridBagConstraints.BOTH;
		gbc_mycard_5.insets = zeroinests;
		gbc_mycard_5.gridx = 6;
		gbc_mycard_5.gridy = 16;
		contentPane.add(mycard_5, gbc_mycard_5);
		
		mycard_6 = new JButton("");
		GridBagConstraints gbc_mycard_6 = new GridBagConstraints();
		gbc_mycard_6.fill = GridBagConstraints.BOTH;
		gbc_mycard_6.insets = zeroinests;
		gbc_mycard_6.gridx = 7;
		gbc_mycard_6.gridy = 16;
		contentPane.add(mycard_6, gbc_mycard_6);
		
		mycard_7 = new JButton("");
		GridBagConstraints gbc_mycard_7 = new GridBagConstraints();
		gbc_mycard_7.fill = GridBagConstraints.BOTH;
		gbc_mycard_7.insets = zeroinests;
		gbc_mycard_7.gridx = 8;
		gbc_mycard_7.gridy = 16;
		contentPane.add(mycard_7, gbc_mycard_7);
		
		exitbutton = new JButton("exit\n");
		exitbutton.setToolTipText("");
		exitbutton.setAction(exitaction);
		
		mycard_8 = new JButton("");
		GridBagConstraints gbc_mycard_8 = new GridBagConstraints();
		gbc_mycard_8.fill = GridBagConstraints.BOTH;
		gbc_mycard_8.insets = zeroinests;
		gbc_mycard_8.gridx = 9;
		gbc_mycard_8.gridy = 16;
		contentPane.add(mycard_8, gbc_mycard_8);
		
		mycard_9 = new JButton("");
		GridBagConstraints gbc_mycard_9 = new GridBagConstraints();
		gbc_mycard_9.fill = GridBagConstraints.BOTH;
		gbc_mycard_9.insets = zeroinests;
		gbc_mycard_9.gridx = 10;
		gbc_mycard_9.gridy = 16;
		contentPane.add(mycard_9, gbc_mycard_9);
		
		mycard_10 = new JButton("");
		GridBagConstraints gbc_mycard_10 = new GridBagConstraints();
		gbc_mycard_10.fill = GridBagConstraints.BOTH;
		gbc_mycard_10.insets = zeroinests;
		gbc_mycard_10.gridx = 11;
		gbc_mycard_10.gridy = 16;
		contentPane.add(mycard_10, gbc_mycard_10);
		
		mycard_11 = new JButton("");
		GridBagConstraints gbc_mycard_11 = new GridBagConstraints();
		gbc_mycard_11.fill = GridBagConstraints.BOTH;
		gbc_mycard_11.insets = zeroinests;
		gbc_mycard_11.gridx = 12;
		gbc_mycard_11.gridy = 16;
		contentPane.add(mycard_11, gbc_mycard_11);
		
		mycard_12 = new JButton("");
		GridBagConstraints gbc_mycard_12 = new GridBagConstraints();
		gbc_mycard_12.fill = GridBagConstraints.BOTH;
		gbc_mycard_12.insets = zeroinests;
		gbc_mycard_12.gridx = 13;
		gbc_mycard_12.gridy = 16;
		contentPane.add(mycard_12, gbc_mycard_12);
		
		mycard_13 = new JButton("");
		GridBagConstraints gbc_mycard_13 = new GridBagConstraints();
		gbc_mycard_13.fill = GridBagConstraints.BOTH;
		gbc_mycard_13.insets = zeroinests;
		gbc_mycard_13.gridx = 14;
		gbc_mycard_13.gridy = 16;
		contentPane.add(mycard_13, gbc_mycard_13);
		
		mycard_14 = new JButton("");
		GridBagConstraints gbc_mycard_14 = new GridBagConstraints();
		gbc_mycard_14.fill = GridBagConstraints.BOTH;
		gbc_mycard_14.insets = zeroinests;
		gbc_mycard_14.gridx = 15;
		gbc_mycard_14.gridy = 16;
		contentPane.add(mycard_14, gbc_mycard_14);
		GridBagConstraints gbc_exitbutton = new GridBagConstraints();
		gbc_exitbutton.insets = zeroinests;
		gbc_exitbutton.gridwidth = 2;
		gbc_exitbutton.fill = GridBagConstraints.BOTH;
		gbc_exitbutton.gridx = 16;
		gbc_exitbutton.gridy = 16;
		contentPane.add(exitbutton, gbc_exitbutton);
		mycard_list = new JButton[]{mycard_1,mycard_2,mycard_3,mycard_4,mycard_5,mycard_6,mycard_7,mycard_8,mycard_9,mycard_10,mycard_11,mycard_12,mycard_13,mycard_14};
		p1card_list = new JButton[]{p1card_1,p1card_2,p1card_3,p1card_4,p1card_5,p1card_6,p1card_7,p1card_8,p1card_9,p1card_10,p1card_11,p1card_12,p1card_13,p1card_14};
		p2card_list = new JButton[]{p2card_1,p2card_2,p2card_3,p2card_4,p2card_5,p2card_6,p2card_7,p2card_8,p2card_9,p2card_10,p2card_11,p2card_12,p2card_13,p2card_14};
		p3card_list = new JButton[]{p3card_1,p3card_2,p3card_3,p3card_4,p3card_5,p3card_6,p3card_7,p3card_8,p3card_9,p3card_10,p3card_11,p3card_12,p3card_13,p3card_14};
		if(davinchicodehelper.getPeople() == 4) listarray =new JButton[][] {mycard_list, p1card_list, p2card_list, p3card_list};
		else if (davinchicodehelper.getPeople() == 3) {
			listarray =new JButton[][] {mycard_list, p1card_list, p3card_list};
			for (JButton button : p2card_list){
				button.setVisible(false);
			}
		}
		else if (davinchicodehelper.getPeople() == 2) {
			listarray =new JButton[][] {mycard_list, p2card_list};
			for (JButton button : p1card_list){
				button.setVisible(false);
			}
			for (JButton button : p3card_list){
				button.setVisible(false);
			}
		}
		
		for (JButton[] list : this.listarray){
			for(JButton button : list){
				button.addMouseListener(mouse);
			}
		}
		
		
		davinchicodehelper.gamestart();
		
	}
	
	public void update(){
		
		
		
		if (davinchicodehelper.getTurnindex() == Turn.CARDGET){
			if (davinchicodehelper.getRemainder_black() != 0) this.getblackcard.setEnabled(true);
			if (davinchicodehelper.getRemainder_white() != 0) this.getwhitecard.setEnabled(true);
			for(JButton[] list : this.listarray){
				for(JButton button : list){
					button.setEnabled(false);
				}
			}
			this.passbutton.setEnabled(davinchicodehelper.isCanpass());
		} else if (davinchicodehelper.getTurnindex() == Turn.SELECT){
			for(JButton[] list : this.listarray){
				for(JButton button : list){
					button.setEnabled(true);
				}
			}
			this.getblackcard.setEnabled(false);
			this.getwhitecard.setEnabled(false);
			this.passbutton.setEnabled(false);
		}
		updatecard();
	}
	private void updatecard() {
		
		for(JButton[] list : this.listarray){
			for (JButton button : list){
				button.setText("");
			}
		}
		int j = 0;
		for(int i = davinchicodehelper.getTurn(); i < davinchicodehelper.getTurn() + davinchicodehelper.getPeople();i++,j++){
			int k = 0;
			for(int number = 0; number <12; number++){
				if (davinchicodehelper.getcardinhand(i, Dacolor.BLACK, number)){
					this.listarray[j][k].setBackground(Color.BLACK);
					this.listarray[j][k].setForeground(Color.WHITE);
					if (j == 0 || davinchicodehelper.getopencardinhand(i, Dacolor.BLACK, number)) {
						this.listarray[j][k].setText(Integer.toString(number));
						this.listarray[j][k].setEnabled(false);
					}
					if (j == 0 && davinchicodehelper.getopencardinhand(i, Dacolor.BLACK, number)) {
						this.listarray[j][k].setForeground(Color.red);
						this.listarray[j][k].setEnabled(true);
					}
					this.listarray[j][k].setVisible(true);
					k++;
				}
				if(davinchicodehelper.getcardinhand(i, Dacolor.WHITE, number)){
					this.listarray[j][k].setBackground(Color.WHITE);
					this.listarray[j][k].setForeground(Color.BLACK);
					if (j == 0 || davinchicodehelper.getopencardinhand(i, Dacolor.WHITE, number)) {
						this.listarray[j][k].setText(Integer.toString(number));
						this.listarray[j][k].setEnabled(false);;
					}
					if (j == 0 && davinchicodehelper.getopencardinhand(i, Dacolor.WHITE, number)) {
						this.listarray[j][k].setForeground(Color.red);
						this.listarray[j][k].setEnabled(true);
					}
					this.listarray[j][k].setVisible(true);
					k++;
				}
			}
			for(;k<listarray[j].length;k++){
				this.listarray[j][k].setBackground(Color.GRAY);
				this.listarray[j][k].setForeground(Color.GRAY);
				this.listarray[j][k].setText("");
				this.listarray[j][k].setVisible(false);
			}
		}
	}
	
	private void assertcard(JButton source){
		for(int i = 1; i<listarray.length;i++){
			for(int j = 0; j<listarray[i].length;j++){
				if(listarray[i][j] == source) {
					Dacolor color = (source.getBackground().equals(Color.BLACK)) ? Dacolor.BLACK : Dacolor.WHITE;
					davinchicodehelper.assertcard(i, j, color, this.numberBox.getSelectedIndex());
					break;
				};
			}
		}
	}


	private class ExitAction extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 4452745771414137841L;
		public ExitAction() {
			putValue(NAME, "Exit game");
			putValue(SHORT_DESCRIPTION, "Exit the game.");
		}
		public void actionPerformed(ActionEvent e) {
			dispose();
			System.exit(0);
		}
	}
	private class Takeblack extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 4986226191171118579L;
		public Takeblack() {
			putValue(NAME, "Black Card");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			davinchicodehelper.takecard(davinchicodehelper.getTurn(), Dacolor.BLACK);
		}
	}
	private class Takewhite extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = -828002273645918021L;
		public Takewhite() {
			putValue(NAME, "White Card");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			davinchicodehelper.takecard(davinchicodehelper.getTurn(), Dacolor.WHITE);
		}
	}
	private class PassTurn extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = -3402109466539778898L;
		public PassTurn() {
			putValue(NAME, "Pass");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			davinchicodehelper.passturn();
		}
	}
}
