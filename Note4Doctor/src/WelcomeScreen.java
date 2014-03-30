package edu.lambda;

import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JTextPane;

import java.awt.Font;
import java.time.LocalDate;

import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WelcomeScreen {

	private JFrame frame;
	LocalDate date = LocalDate.now();
    LocalDate startDate = date.minusDays(7);
    LocalDate endDate = date.plusDays(7);
    LocalDate d;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnotherScreen window = new AnotherScreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
//code for nice UI
	/*
 private JFrame frame;
    LocalDate date = LocalDate.now();
    LocalDate startDate = date.minusDays(7);
    LocalDate endDate = date.plusDays(7);
    LocalDate d;*/

    /**
     * Launch the application.
     *
     * @param args
     */
    /*public static void main(String[] args) throws Exception {
        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                javax.swing.UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        }
        EventQueue.invokeLater(() -> {
            try {
                AnotherScreen window = new AnotherScreen();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
	 */
	
	/**
	 * Create the application.
	 */
	public AnotherScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 11));
		frame.getContentPane().setBackground(new Color(112, 128, 144));
		frame.setBounds(100, 100, 586, 360);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel headerPanel = new JPanel();
		headerPanel.setBackground(new Color(112, 128, 144));
		headerPanel.setBounds(0, 0, 269, 26);
		frame.getContentPane().add(headerPanel);
		headerPanel.setLayout(null);
		//headerPanel.isDisplayable()
		
		JPanel welcomeTextPanel = new JPanel();
		welcomeTextPanel.setBackground(new Color(112, 128, 144));
		welcomeTextPanel.setBounds(298, 11, 262, 73);
		frame.getContentPane().add(welcomeTextPanel);
		welcomeTextPanel.setLayout(null);
		
		JTextPane welcomeTextField = new JTextPane();
		welcomeTextField.setEditable(false);
		welcomeTextField.setFont(new Font("SansSerif", Font.BOLD, 12));
		welcomeTextField.setBackground(new Color(112, 128, 144));
		welcomeTextField.setText("Welcome to Lucky7 Note4 Doctor.\r\nAn application which helps you to track you health.");
		welcomeTextField.setBounds(10, 11, 242, 51);
		welcomeTextPanel.add(welcomeTextField);
		
		JPanel addEditPanel = new JPanel();
		addEditPanel.setVisible(false);
		addEditPanel.setBackground(new Color(112, 128, 144));
		addEditPanel.setBounds(308, 95, 252, 215);
		frame.getContentPane().add(addEditPanel);
		addEditPanel.setLayout(null);
		
		JComboBox dateComboBox = new JComboBox();
		dateComboBox.setBackground(Color.WHITE);
        dateComboBox.setEditable(true);
        String[] a = new String[15];
        int c = 0;
        String current_date = LocalDate.now().toString();
        for (d = startDate; d.isBefore(endDate) || d.isEqual(endDate); d = d.plusDays(1)) {
            a[c] = d.toString();
            c++;
        }
        dateComboBox.setModel(new DefaultComboBoxModel(a));
        dateComboBox.setSelectedItem(current_date);
        dateComboBox.setMaximumRowCount(15);
        //frame.getContentPane().add(dateComboBox);
		dateComboBox.setBounds(86, 59, 144, 20);
		addEditPanel.add(dateComboBox);
		
		JTextPane addEditTextPane = new JTextPane();
		addEditTextPane.setBackground(new Color(112, 128, 144));
		addEditTextPane.setFont(new Font("SansSerif", Font.BOLD, 10));
		addEditTextPane.setText("Select the date for which you want to Add/Edit entry.");
		addEditTextPane.setBounds(10, 11, 220, 37);
		addEditPanel.add(addEditTextPane);
		
		JButton addEditButton = new JButton("Add/Edit");
		addEditButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				welcomeTextPanel.setVisible(false);
				addEditPanel.setVisible(true);
			}
		});
		addEditButton.setBounds(0, 0, 89, 23);
		headerPanel.add(addEditButton);
		
		JButton loadSaveButton = new JButton("Load/Save");
		loadSaveButton.setBounds(177, 0, 99, 23);
		headerPanel.add(loadSaveButton);
		
		JButton viewPrintButton = new JButton("View/Print");
		viewPrintButton.setBounds(89, 0, 99, 23);
		headerPanel.add(viewPrintButton);
	}
	
}
