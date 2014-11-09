package da_co;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.Font;

/**
 * @author marine and MDV
 * 
 */
public class StartWindows {

	private JFrame frame;
	private GameWindows gamewindows;
	private final Action gamestart = new GameStart();
	private JComboBox gamepeople;
	private JLabel label_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager
							.getCrossPlatformLookAndFeelClassName());
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
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 400, 400, 0 };
		gridBagLayout.rowHeights = new int[] { 99, 188, 289, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		frame.getContentPane().setLayout(gridBagLayout);

		JLabel lblNewLabel = new JLabel("\uB2E4\uBE48\uCE58 \uCF54\uB4DC");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		gbc_lblNewLabel.gridwidth = 2;
		frame.getContentPane().add(lblNewLabel, gbc_lblNewLabel);

		label_1 = new JLabel("\uAC8C\uC784 \uC778\uC6D0 : ");
		label_1.setFont(new Font("Dialog", Font.BOLD, 50));
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.fill = GridBagConstraints.VERTICAL;
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 1;
		frame.getContentPane().add(label_1, gbc_label_1);

		gamepeople = new JComboBox();
		gamepeople.setFont(new Font("Dialog", Font.BOLD, 60));
		gamepeople.setModel(new DefaultComboBoxModel(new String[] {
				"         2", "         3", "         4" }));
		gamepeople.setSelectedIndex(2);
		GridBagConstraints gbc_gamepeople = new GridBagConstraints();
		gbc_gamepeople.insets = new Insets(0, 0, 5, 0);
		gbc_gamepeople.fill = GridBagConstraints.BOTH;
		gbc_gamepeople.gridx = 1;
		gbc_gamepeople.gridy = 1;
		frame.getContentPane().add(gamepeople, gbc_gamepeople);

		JButton btnGameStart = new JButton("Game Start");
		btnGameStart.setAction(gamestart);
		GridBagConstraints gbc_btnGameStart = new GridBagConstraints();
		gbc_btnGameStart.fill = GridBagConstraints.BOTH;
		gbc_btnGameStart.gridx = 1;
		gbc_btnGameStart.gridy = 2;
		frame.getContentPane().add(btnGameStart, gbc_btnGameStart);
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

			gamewindows = new GameWindows(gamepeople.getSelectedIndex() + 2);

			gamewindows.setVisible(true);
			frame.setVisible(false);
		}
	}
}
