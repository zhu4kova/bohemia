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
					window.getFrame().setVisible(true);
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
		setFrame(new JFrame());
		getFrame().setIconImage(Toolkit.getDefaultToolkit().getImage(Startseite.class.getResource("/Bilder/logo@2x.png")));
		getFrame().setBackground(Color.LIGHT_GRAY);
		getFrame().setBounds(100, 100, 591, 483);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		getFrame().setJMenuBar(menuBar);
		
		JMenuItem mntmStartseite = new JMenuItem("Startseite");
		menuBar.add(mntmStartseite);
		getFrame().getContentPane().setLayout(new MigLayout("", "[50%][33.45%][100][50%]", "[88.00px][66.00][107.00][60.00px][30.00]"));
		
		JLabel lblWillkommen = new JLabel("Bohemia - Literaturverwaltung");
		lblWillkommen.setForeground(new Color(178, 34, 34));
		lblWillkommen.setFont(new Font("Arial", Font.BOLD, 24));
		getFrame().getContentPane().add(lblWillkommen, "cell 0 0 4 1");
		
		JButton btnPersonErfassen = new JButton("Person erfassen");
		btnPersonErfassen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Person_erfassen window = new Person_erfassen();
				window.getPersonErfassenFrame().setVisible(true);
			}
		});
		btnPersonErfassen.setBackground(UIManager.getColor("Button.background"));
		btnPersonErfassen.setForeground(new Color(178, 34, 34));
		btnPersonErfassen.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnPersonErfassen.setIcon(new ImageIcon(Startseite.class.getResource("/Bilder/verification (2).png")));
		getFrame().getContentPane().add(btnPersonErfassen, "cell 0 1,grow");
		
		JButton btnModulErfassen = new JButton("Modul erfassen");
		btnModulErfassen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Modul_erfassen window = new Modul_erfassen();
				window.getModulErfassenFrame().setVisible(true);
			}
		});
		btnModulErfassen.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnModulErfassen.setBackground(UIManager.getColor("Button.background"));
		btnModulErfassen.setForeground(new Color(178, 34, 34));
		btnModulErfassen.setIcon(new ImageIcon(Startseite.class.getResource("/Bilder/science-book (1).png")));
		getFrame().getContentPane().add(btnModulErfassen, "cell 3 1,grow");
		
		JButton btnLiteraturErfassen = new JButton("Literatur erfassen");
		btnLiteraturErfassen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Literatur_erfassen window = new Literatur_erfassen();
				window.getLiteraturErfassenFrame().setVisible(true);
			}
		});
		btnLiteraturErfassen.setBackground(UIManager.getColor("Button.background"));
		btnLiteraturErfassen.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLiteraturErfassen.setForeground(new Color(178, 34, 34));
		btnLiteraturErfassen.setIcon(new ImageIcon(Startseite.class.getResource("/Bilder/library (1).png")));
		getFrame().getContentPane().add(btnLiteraturErfassen, "cell 0 2,grow");

	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
