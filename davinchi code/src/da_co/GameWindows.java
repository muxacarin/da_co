package da_co;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;

import java.awt.Color;

public class GameWindows extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7954384317661319220L; //직렬화 uid
	
	private DavinchiCodeHelper davinchicodehelper;	//게임담당클래스 선언
	
	private JPanel contentPane;	//판때기
	
	
	private final Action exitaction = new ExitAction();	//종료액
	
	
	private final Insets zeroinests = new Insets(0,0,0,0);	//여백 0
	
	private JButton mycard_1;
	private JButton mycard_2;
	private JButton mycard_3;
	private JButton mycard_4;
	private JButton mycard_5;
	private JButton mycard_6;
	private JButton mycard_7;	//자기카드버튼
	private JButton[] mycard_list = new JButton[]{mycard_1,mycard_2,mycard_3,mycard_4,mycard_5,mycard_6,mycard_7};	//자기카드버튼배열
	
	private JButton p1card_1;
	private JButton p1card_2;
	private JButton p1card_3;
	private JButton p1card_4;
	private JButton p1card_5;
	private JButton p1card_6;
	private JButton p1card_7;	//p1카드버튼
	private JButton[] p1card_list = new JButton[]{p1card_1,p1card_2,p1card_3,p1card_4,p1card_5,p1card_6,p1card_7};	//p1카드버튼배열
			
	private JButton p2card_1;
	private JButton p2card_2;
	private JButton p2card_3;
	private JButton p2card_4;
	private JButton p2card_5;
	private JButton p2card_6;
	private JButton p2card_7;	//p2카드버튼
	private JButton[] p2card_list = new JButton[]{p2card_1,p2card_2,p2card_3,p2card_4,p2card_5,p2card_6,p2card_7};	//p2카드버튼배열
	
	private JButton p3card_1;
	private JButton p3card_2;
	private JButton p3card_3;
	private JButton p3card_4;
	private JButton p3card_5;
	private JButton p3card_6;
	private JButton p3card_7;	//p3카드버튼
	private JButton[] p3card_list = new JButton[]{p3card_1,p3card_2,p3card_3,p3card_4,p3card_5,p3card_6,p3card_7};	//p3카드버튼배열
	private JButton btnNewButton;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	//this comment is only for git test.
	public GameWindows() {
		this(4);
	}
	public GameWindows(int people)  {
		
		davinchicodehelper = new DavinchiCodeHelper(this, people);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		gbl_contentPane.columnWidths = new int[]{40,80,80,80,80,80,80,80,80,80,40};
		gbl_contentPane.rowHeights = new int[]{60,60,60,60,60,60,60,60,60};
		contentPane.setLayout(gbl_contentPane);
		
		p2card_7 = new JButton("");
		GridBagConstraints gbc_p2card_7 = new GridBagConstraints();
		gbc_p2card_7.fill = GridBagConstraints.BOTH;
		gbc_p2card_7.insets = zeroinests;
		gbc_p2card_7.gridx = 2;
		gbc_p2card_7.gridy = 0;
		contentPane.add(p2card_7, gbc_p2card_7);
		
		p2card_6 = new JButton("");
		GridBagConstraints gbc_p2card_6 = new GridBagConstraints();
		gbc_p2card_6.fill = GridBagConstraints.BOTH;
		gbc_p2card_6.insets = zeroinests;
		gbc_p2card_6.gridx = 3;
		gbc_p2card_6.gridy = 0;
		contentPane.add(p2card_6, gbc_p2card_6);
		
		p2card_5 = new JButton("");
		GridBagConstraints gbc_p2card_5 = new GridBagConstraints();
		gbc_p2card_5.fill = GridBagConstraints.BOTH;
		gbc_p2card_5.insets = zeroinests;
		gbc_p2card_5.gridx = 4;
		gbc_p2card_5.gridy = 0;
		contentPane.add(p2card_5, gbc_p2card_5);
		
		p2card_4 = new JButton("");
		GridBagConstraints gbc_p2card_4 = new GridBagConstraints();
		gbc_p2card_4.fill = GridBagConstraints.BOTH;
		gbc_p2card_4.insets = zeroinests;
		gbc_p2card_4.gridx = 5;
		gbc_p2card_4.gridy = 0;
		contentPane.add(p2card_4, gbc_p2card_4);
		
		p2card_3 = new JButton("");
		GridBagConstraints gbc_p2card_3 = new GridBagConstraints();
		gbc_p2card_3.fill = GridBagConstraints.BOTH;
		gbc_p2card_3.insets = zeroinests;
		gbc_p2card_3.gridx = 6;
		gbc_p2card_3.gridy = 0;
		contentPane.add(p2card_3, gbc_p2card_3);
		
		p2card_2 = new JButton("");
		GridBagConstraints gbc_p2card_2 = new GridBagConstraints();
		gbc_p2card_2.fill = GridBagConstraints.BOTH;
		gbc_p2card_2.insets = zeroinests;
		gbc_p2card_2.gridx = 7;
		gbc_p2card_2.gridy = 0;
		contentPane.add(p2card_2, gbc_p2card_2);
		
		p2card_1 = new JButton("");
		GridBagConstraints gbc_p2card_1 = new GridBagConstraints();
		gbc_p2card_1.fill = GridBagConstraints.BOTH;
		gbc_p2card_1.insets = zeroinests;
		gbc_p2card_1.gridx = 8;
		gbc_p2card_1.gridy = 0;
		contentPane.add(p2card_1, gbc_p2card_1);
		
		p3card_1 = new JButton("");
		GridBagConstraints gbc_p3card_1 = new GridBagConstraints();
		gbc_p3card_1.fill = GridBagConstraints.BOTH;
		gbc_p3card_1.insets = zeroinests;
		gbc_p3card_1.gridx = 1;
		gbc_p3card_1.gridy = 1;
		contentPane.add(p3card_1, gbc_p3card_1);
		
		p1card_7 = new JButton("");
		GridBagConstraints gbc_p1card_7 = new GridBagConstraints();
		gbc_p1card_7.fill = GridBagConstraints.BOTH;
		gbc_p1card_7.insets = zeroinests;
		gbc_p1card_7.gridx = 9;
		gbc_p1card_7.gridy = 1;
		contentPane.add(p1card_7, gbc_p1card_7);
		
		p3card_2 = new JButton("");
		GridBagConstraints gbc_p3card_2 = new GridBagConstraints();
		gbc_p3card_2.fill = GridBagConstraints.BOTH;
		gbc_p3card_2.insets = zeroinests;
		gbc_p3card_2.gridx = 1;
		gbc_p3card_2.gridy = 2;
		contentPane.add(p3card_2, gbc_p3card_2);
		
		p1card_6 = new JButton("");
		GridBagConstraints gbc_p1card_6 = new GridBagConstraints();
		gbc_p1card_6.fill = GridBagConstraints.BOTH;
		gbc_p1card_6.insets = zeroinests;
		gbc_p1card_6.gridx = 9;
		gbc_p1card_6.gridy = 2;
		contentPane.add(p1card_6, gbc_p1card_6);
		
		p3card_3 = new JButton("");
		GridBagConstraints gbc_p3card_3 = new GridBagConstraints();
		gbc_p3card_3.fill = GridBagConstraints.BOTH;
		gbc_p3card_3.insets = zeroinests;
		gbc_p3card_3.gridx = 1;
		gbc_p3card_3.gridy = 3;
		contentPane.add(p3card_3, gbc_p3card_3);
		
		p1card_5 = new JButton("");
		GridBagConstraints gbc_p1card_5 = new GridBagConstraints();
		gbc_p1card_5.fill = GridBagConstraints.BOTH;
		gbc_p1card_5.insets = zeroinests;
		gbc_p1card_5.gridx = 9;
		gbc_p1card_5.gridy = 3;
		contentPane.add(p1card_5, gbc_p1card_5);
		
		p3card_4 = new JButton("");
		GridBagConstraints gbc_p3card_4 = new GridBagConstraints();
		gbc_p3card_4.fill = GridBagConstraints.BOTH;
		gbc_p3card_4.insets = zeroinests;
		gbc_p3card_4.gridx = 1;
		gbc_p3card_4.gridy = 4;
		contentPane.add(p3card_4, gbc_p3card_4);
		
		btnNewButton = new JButton("");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton.insets = zeroinests;
		gbc_btnNewButton.gridx = 4;
		gbc_btnNewButton.gridy = 4;
		contentPane.add(btnNewButton, gbc_btnNewButton);
		
		btnNewButton_1 = new JButton("");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_1.insets = zeroinests;
		gbc_btnNewButton_1.gridx = 6;
		gbc_btnNewButton_1.gridy = 4;
		contentPane.add(btnNewButton_1, gbc_btnNewButton_1);
		
		p1card_4 = new JButton("");
		GridBagConstraints gbc_p1card_4 = new GridBagConstraints();
		gbc_p1card_4.fill = GridBagConstraints.BOTH;
		gbc_p1card_4.insets = zeroinests;
		gbc_p1card_4.gridx = 9;
		gbc_p1card_4.gridy = 4;
		contentPane.add(p1card_4, gbc_p1card_4);
		
		p3card_5 = new JButton("");
		GridBagConstraints gbc_p3card_5 = new GridBagConstraints();
		gbc_p3card_5.fill = GridBagConstraints.BOTH;
		gbc_p3card_5.insets = zeroinests;
		gbc_p3card_5.gridx = 1;
		gbc_p3card_5.gridy = 5;
		contentPane.add(p3card_5, gbc_p3card_5);
		
		p1card_3 = new JButton("");
		GridBagConstraints gbc_p1card_3 = new GridBagConstraints();
		gbc_p1card_3.fill = GridBagConstraints.BOTH;
		gbc_p1card_3.insets = zeroinests;
		gbc_p1card_3.gridx = 9;
		gbc_p1card_3.gridy = 5;
		contentPane.add(p1card_3, gbc_p1card_3);
		
		p3card_6 = new JButton("");
		GridBagConstraints gbc_p3card_6 = new GridBagConstraints();
		gbc_p3card_6.fill = GridBagConstraints.BOTH;
		gbc_p3card_6.insets = zeroinests;
		gbc_p3card_6.gridx = 1;
		gbc_p3card_6.gridy = 6;
		contentPane.add(p3card_6, gbc_p3card_6);
		
		p1card_2 = new JButton("");
		GridBagConstraints gbc_p1card_2 = new GridBagConstraints();
		gbc_p1card_2.fill = GridBagConstraints.BOTH;
		gbc_p1card_2.insets = zeroinests;
		gbc_p1card_2.gridx = 9;
		gbc_p1card_2.gridy = 6;
		contentPane.add(p1card_2, gbc_p1card_2);
		
		p3card_7 = new JButton("");
		GridBagConstraints gbc_p3card_7 = new GridBagConstraints();
		gbc_p3card_7.fill = GridBagConstraints.BOTH;
		gbc_p3card_7.insets = zeroinests;
		gbc_p3card_7.gridx = 1;
		gbc_p3card_7.gridy = 7;
		contentPane.add(p3card_7, gbc_p3card_7);
		
		p1card_1 = new JButton("");
		GridBagConstraints gbc_p1card_1 = new GridBagConstraints();
		gbc_p1card_1.fill = GridBagConstraints.BOTH;
		gbc_p1card_1.insets = zeroinests;
		gbc_p1card_1.gridx = 9;
		gbc_p1card_1.gridy = 7;
		contentPane.add(p1card_1, gbc_p1card_1);
		
		mycard_1 = new JButton("B");
		GridBagConstraints gbc_mycard_1 = new GridBagConstraints();
		gbc_mycard_1.fill = GridBagConstraints.BOTH;
		gbc_mycard_1.insets = zeroinests;
		gbc_mycard_1.gridx = 2;
		gbc_mycard_1.gridy = 8;
		contentPane.add(mycard_1, gbc_mycard_1);
		
		mycard_2 = new JButton("W");
		mycard_2.setForeground(Color.WHITE);
		GridBagConstraints gbc_mycard_2 = new GridBagConstraints();
		gbc_mycard_2.fill = GridBagConstraints.BOTH;
		gbc_mycard_2.insets = zeroinests;
		gbc_mycard_2.gridx = 3;
		gbc_mycard_2.gridy = 8;
		contentPane.add(mycard_2, gbc_mycard_2);
		
		mycard_3 = new JButton("");
		GridBagConstraints gbc_mycard_3 = new GridBagConstraints();
		gbc_mycard_3.fill = GridBagConstraints.BOTH;
		gbc_mycard_3.insets = zeroinests;
		gbc_mycard_3.gridx = 4;
		gbc_mycard_3.gridy = 8;
		contentPane.add(mycard_3, gbc_mycard_3);
		
		mycard_4 = new JButton("");
		GridBagConstraints gbc_mycard_4 = new GridBagConstraints();
		gbc_mycard_4.fill = GridBagConstraints.BOTH;
		gbc_mycard_4.insets = zeroinests;
		gbc_mycard_4.gridx = 5;
		gbc_mycard_4.gridy = 8;
		contentPane.add(mycard_4, gbc_mycard_4);
		
		mycard_5 = new JButton("");
		GridBagConstraints gbc_mycard_5 = new GridBagConstraints();
		gbc_mycard_5.fill = GridBagConstraints.BOTH;
		gbc_mycard_5.insets = zeroinests;
		gbc_mycard_5.gridx = 6;
		gbc_mycard_5.gridy = 8;
		contentPane.add(mycard_5, gbc_mycard_5);
		
		mycard_6 = new JButton("");
		GridBagConstraints gbc_mycard_6 = new GridBagConstraints();
		gbc_mycard_6.fill = GridBagConstraints.BOTH;
		gbc_mycard_6.insets = zeroinests;
		gbc_mycard_6.gridx = 7;
		gbc_mycard_6.gridy = 8;
		contentPane.add(mycard_6, gbc_mycard_6);
		
		mycard_7 = new JButton("");
		GridBagConstraints gbc_mycard_7 = new GridBagConstraints();
		gbc_mycard_7.fill = GridBagConstraints.BOTH;
		gbc_mycard_7.insets = zeroinests;
		gbc_mycard_7.gridx = 8;
		gbc_mycard_7.gridy = 8;
		contentPane.add(mycard_7, gbc_mycard_7);
		
		JButton exitbutton = new JButton("exit\n");
		exitbutton.setToolTipText("");
		exitbutton.setAction(exitaction);
		exitbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		GridBagConstraints gbc_exitbutton = new GridBagConstraints();
		gbc_exitbutton.gridwidth = 2;
		gbc_exitbutton.fill = GridBagConstraints.BOTH;
		gbc_exitbutton.gridx = 9;
		gbc_exitbutton.gridy = 8;
		contentPane.add(exitbutton, gbc_exitbutton);
		
		davinchicodehelper.gamestart();
		
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
}
