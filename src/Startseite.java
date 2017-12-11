import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import net.miginfocom.swing.MigLayout;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Component;
import javax.swing.Box;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.UIManager;

public class Startseite {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Startseite window = new Startseite();
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
	public Startseite() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Startseite.class.getResource("/Bilder/logo@2x.png")));
		frame.setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 591, 483);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenuItem mntmStartseite = new JMenuItem("Startseite");
		menuBar.add(mntmStartseite);
		frame.getContentPane().setLayout(new MigLayout("", "[50%][33.45%][100][50%]", "[88.00px][66.00][107.00][60.00px][30.00]"));
		
		JLabel lblWillkommen = new JLabel("Bohemia - Literaturverwaltung");
		lblWillkommen.setForeground(new Color(178, 34, 34));
		lblWillkommen.setFont(new Font("Arial", Font.BOLD, 24));
		frame.getContentPane().add(lblWillkommen, "cell 0 0 4 1");
		
		JButton btnPersonErfassen = new JButton("Person erfassen");
		btnPersonErfassen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnPersonErfassen.setBackground(UIManager.getColor("Button.background"));
		btnPersonErfassen.setForeground(new Color(178, 34, 34));
		btnPersonErfassen.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnPersonErfassen.setIcon(new ImageIcon(Startseite.class.getResource("/Bilder/verification (2).png")));
		frame.getContentPane().add(btnPersonErfassen, "cell 0 1,grow");
		
		JButton btnNewButton = new JButton("Modul erfassen");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBackground(UIManager.getColor("Button.background"));
		btnNewButton.setForeground(new Color(178, 34, 34));
		btnNewButton.setIcon(new ImageIcon(Startseite.class.getResource("/Bilder/science-book (1).png")));
		frame.getContentPane().add(btnNewButton, "cell 3 1,grow");
		
		JButton btnLiteraturErfassen = new JButton("Literatur erfassen");
		btnLiteraturErfassen.setBackground(UIManager.getColor("Button.background"));
		btnLiteraturErfassen.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLiteraturErfassen.setForeground(new Color(178, 34, 34));
		btnLiteraturErfassen.setIcon(new ImageIcon(Startseite.class.getResource("/Bilder/library (1).png")));
		frame.getContentPane().add(btnLiteraturErfassen, "cell 0 2,grow");

	}
}
