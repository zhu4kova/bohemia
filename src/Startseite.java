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
import java.awt.Window;
import java.awt.Component;
import javax.swing.Box;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import javax.swing.JPopupMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JCheckBoxMenuItem;

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
		frame.getContentPane().setLayout(new MigLayout("", "[50%][100][50%]", "[88.00px][][][][30.00]"));
		
		JLabel lblWillkommen = new JLabel("Bohemia - Literaturverwaltung");
		lblWillkommen.setForeground(new Color(178, 34, 34));
		lblWillkommen.setFont(new Font("Arial", Font.BOLD, 24));
		frame.getContentPane().add(lblWillkommen, "cell 0 0 3 1");
		
		/*
		 * Button zur Erfassungsmaske einer Person
		*/
		JButton btnPersonErfassen = new JButton("Person erfassen");
		btnPersonErfassen.setFocusPainted(false);
		btnPersonErfassen.setHorizontalAlignment(SwingConstants.LEFT);
		btnPersonErfassen.setIconTextGap(30);
		btnPersonErfassen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Person_erfassen window = new Person_erfassen();
				window.getPersonErfassenFrame().setVisible(true);
			}
		});
		btnPersonErfassen.setBackground(new Color(192, 192, 192));
		btnPersonErfassen.setForeground(new Color(178, 34, 34));
		btnPersonErfassen.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnPersonErfassen.setIcon(new ImageIcon(Startseite.class.getResource("/Bilder/online-student.png")));
		frame.getContentPane().add(btnPersonErfassen, "cell 0 1,grow");
		
		/*
		 * Button zur Erfassungsmaske einer Literatur
		*/
		
		JButton btnLiteraturErfassen = new JButton("Literatur erfassen");
		btnLiteraturErfassen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Literatur_erfassen window = new Literatur_erfassen();
				window.getLiteraturErfassenFrame().setVisible(true);
			}
		});
		btnLiteraturErfassen.setFocusPainted(false);
		btnLiteraturErfassen.setHorizontalAlignment(SwingConstants.LEFT);
		btnLiteraturErfassen.setIconTextGap(30);
		btnLiteraturErfassen.setBackground(new Color(192, 192, 192));
		btnLiteraturErfassen.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLiteraturErfassen.setForeground(new Color(178, 34, 34));
		btnLiteraturErfassen.setIcon(new ImageIcon(Startseite.class.getResource("/Bilder/books-stack.png")));
		frame.getContentPane().add(btnLiteraturErfassen, "cell 0 2,grow");
		
		/*
		 * Button zur Erfassungsmaske eines Moduls
		*/
		
		JButton btnModulErfassen = new JButton("Modul erfassen");
		btnModulErfassen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Modul_erfassen window = new Modul_erfassen();
				window.getModulErfassenFrame().setVisible(true);
			}
		});
		btnModulErfassen.setFocusPainted(false);
		btnModulErfassen.setIconTextGap(30);
		btnModulErfassen.setHorizontalAlignment(SwingConstants.LEFT);
		btnModulErfassen.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnModulErfassen.setBackground(new Color(192, 192, 192));
		btnModulErfassen.setForeground(new Color(178, 34, 34));
		btnModulErfassen.setIcon(new ImageIcon(Startseite.class.getResource("/Bilder/internet-education-graduation.png")));
		frame.getContentPane().add(btnModulErfassen, "cell 0 3,grow");

	}
	
	public JFrame getStartseite() {
		return frame;
	}

	public void setStartseite(JFrame frame) {
		this.frame = frame;
	}
}
