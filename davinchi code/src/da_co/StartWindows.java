package da_co;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class StartWindows {

	private JFrame frame;
	private GameWindows gamewindows;
	private final Action gamestart = new GameStart();
	private JComboBox gamepeople;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartWindows window = new StartWindows();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StartWindows() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("\uB2E4\uBE48\uCE58 \uCF54\uB4DC");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblNewLabel, BorderLayout.NORTH);
		

		
		JButton btnGameStart = new JButton("Game Start");
		btnGameStart.setAction(gamestart);
		frame.getContentPane().add(btnGameStart, BorderLayout.CENTER);
		
		gamepeople = new JComboBox();
		gamepeople.setModel(new DefaultComboBoxModel(new String[] {"2", "3", "4", "5"}));
		gamepeople.setSelectedIndex(2);
		frame.getContentPane().add(gamepeople, BorderLayout.WEST);
	}

	private class GameStart extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = -7008171307532523937L;
		/**
		 * 
		 */
		public GameStart() {
			putValue(NAME, "Game Start");
			putValue(SHORT_DESCRIPTION, "Press this button to start the game.");
		}
		public void actionPerformed(ActionEvent e) {

				gamewindows = new GameWindows();

			gamewindows.setVisible(true);
			frame.setVisible(false);
		}
	}
}
