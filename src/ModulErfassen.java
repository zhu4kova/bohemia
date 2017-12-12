import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

public class ModulErfassen extends JFrame {
	
	private JTextField id;
	private JTextField kuerzel;
	private JTextField bezeichnung;

	private JPanel contentPane;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModulErfassen frame = new ModulErfassen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ModulErfassen() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(PersonErfassen.class.getResource("/Bilder/FFHS_logo.png")));
		setTitle("Modul erfassen");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 712, 450);

	/*
	 * Menue bar mit Verlinkungen zu anderen Menuepunkten	
	 */
		
	JMenuBar menuBar = new JMenuBar();
	setJMenuBar(menuBar);
	
	JMenu mnErfassung = new JMenu("Erfassung");
	menuBar.add(mnErfassung);
	
	JMenuItem mntmModulErfassen = new JMenuItem("Modul erfassen");
	mntmModulErfassen.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			dispose();
			ModulErfassen ModErf = new ModulErfassen();
			ModErf.setVisible(true);
		}
	});
	mntmModulErfassen.setIcon(new ImageIcon(ModulErfassen.class.getResource("/Bilder/internet-education-graduation_small.png")));
	mntmModulErfassen.setEnabled(false);
	mnErfassung.add(mntmModulErfassen);
	
	JSeparator separator = new JSeparator();
	mnErfassung.add(separator);
	
	JMenuItem mntmPersonErfassen = new JMenuItem("Person erfassen");
	mntmPersonErfassen.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			dispose();
			PersonErfassen PersErf = new PersonErfassen();
			PersErf.setVisible(true);
		}
	});
	mntmPersonErfassen.setIcon(new ImageIcon(ModulErfassen.class.getResource("/Bilder/online-student_small.png")));
	mntmPersonErfassen.setSelectedIcon(null);
	mntmPersonErfassen.setSelected(true);
	mnErfassung.add(mntmPersonErfassen);
	
	JMenuItem mntmLiteraturErfassen = new JMenuItem("Literatur erfassen");
	mntmLiteraturErfassen.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			dispose();
			LiteraturErfassen LitErf = new LiteraturErfassen();
			LitErf.setVisible(true);
		}
	});
	mntmLiteraturErfassen.setIcon(new ImageIcon(ModulErfassen.class.getResource("/Bilder/books-stack_small.png")));
	mnErfassung.add(mntmLiteraturErfassen);
	
	JMenu mnZuweisung = new JMenu("Zuweisung");
	menuBar.add(mnZuweisung);
	
	JMenuItem mntmPersonZuModul = new JMenuItem("Person zu Modul zuweisen");
	mntmPersonZuModul.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			dispose();
			PersonModulzuweisen PMz = new PersonModulzuweisen();
			PMz.setVisible(true);
		}
	});	
	mntmPersonZuModul.setIcon(new ImageIcon(ModulErfassen.class.getResource("/Bilder/classroom_small.png")));
	mnZuweisung.add(mntmPersonZuModul);
	
	JMenuItem mntmLiteraturZuModul = new JMenuItem("Literatur zu Modul zuweisen");
	mntmLiteraturZuModul.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			dispose();
			LiteraturModulzuweisen LMz = new LiteraturModulzuweisen();
			LMz.setVisible(true);
		}
	});
	mntmLiteraturZuModul.setIcon(new ImageIcon(ModulErfassen.class.getResource("/Bilder/study_small.png")));
	mnZuweisung.add(mntmLiteraturZuModul);
	
	JMenu mnAuswertung = new JMenu("Auswertung");
	menuBar.add(mnAuswertung);
	
	JMenuItem mntmFlligeLiteraturbestellungen = new JMenuItem("F\u00E4llige Literaturbestellungen");
	mntmFlligeLiteraturbestellungen.setSelectedIcon(new ImageIcon(PersonErfassen.class.getResource("/Bilder/books-stack.png")));
	mntmFlligeLiteraturbestellungen.setIcon(null);
	mnAuswertung.add(mntmFlligeLiteraturbestellungen);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(new MigLayout("", "[][200,grow][][]", "[][][][][][][][][]"));
	
	/*
	 * Titel der Seite
	 */
	
	JLabel lblTitel = new JLabel("Modul erfassen");
	lblTitel.setIcon(new ImageIcon(ModulErfassen.class.getResource("/Bilder/internet-education-graduation.png")));
	lblTitel.setFont(new Font("Tahoma", Font.BOLD, 24));
	contentPane.add(lblTitel, "cell 0 0 2 1,grow");
	
	/*
	 * Modul ID Feld wird erst in der DB vergeben
	 */
	
	JLabel lblId = new JLabel("ID");
	contentPane.add(lblId, "cell 0 2");
	
	id = new JTextField();
	id.setEnabled(false);
	id.setColumns(50);
	id.setBackground(new Color(204, 204, 204));
	contentPane.add(id, "cell 1 2");

	/*
	 * Feld fuer Eingabe des Modul Kuerzels
	 */
	
	JLabel lblKuerzel = new JLabel("K\u00FCrzel");
	contentPane.add(lblKuerzel, "cell 0 3");
	
	kuerzel = new JTextField();
	kuerzel.setColumns(50);
	kuerzel.setBackground(Color.WHITE);
	contentPane.add(kuerzel, "cell 1 3");
	
	/*
	 * Feld fuer Eingabe der Modul Bezeichnung
	 */
	
	JLabel lblBezeichnung = new JLabel("Bezeichnung");
	contentPane.add(lblBezeichnung, "cell 0 4");
	
	bezeichnung = new JTextField();
	bezeichnung.setColumns(50);
	bezeichnung.setBackground(Color.WHITE);
	contentPane.add(bezeichnung, "cell 1 4 3 1,growx");

	/*
	 * Speichern Button
	 */
	JButton btnSpeichern = new JButton("Speichern");
	btnSpeichern.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			try {
				addModulToDb();
			} catch (SQLException e) {
			}
		}
	});
	contentPane.add(btnSpeichern, "flowx,cell 1 8,alignx left,aligny center");

	
	/*
	 * Abbrechen Button
	 */
	JButton btnAbbrechen = new JButton("Abbrechen");
	btnAbbrechen.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			Bohemia window = new Bohemia();
			window.frmBohemiaLiteraturverwaltung.setVisible(true);
			dispose();
		}
	});
	contentPane.add(btnAbbrechen, "cell 1 8,alignx right,aligny center");
	
	}
	
	/*
	 * Füge die im GUI eingegebenen Daten in die Datenbank hinzu. 
	 * @author Halil Koca
	 * @version 1.0
	 * @param 
	 * @return
	 */
	private void addModulToDb () throws SQLException  {
		
		// Daten auslesen
			String id_ = id.getText();
			String kuerzel_ = kuerzel.getText();
			String bezeichnung_ = bezeichnung.getText();
		
		// Verbindung mit Datenbank herstellen
			String url = "jdbc:mysql://localhost:3306/bohemia?autoReconnect=true&useSSL=false"; // evtl. anpassen gem. DB-Konfiguration
	        String username = "root"; // DB-Benutzername
	        String password = "sivasli58"; // DB-Passwort	         
	        
	        // Überprüfe, ob DB Benutzername und Passwort mitgegeben werden! 
	        	if (username == "" || password == "") {
	        		JOptionPane.showMessageDialog(null, "DB username or password is missing!");
	        		return;
	        	}
	        	JOptionPane.showMessageDialog(null, "1");
	        try (Connection connection = DriverManager.getConnection(url, username, password)) {
	        	JOptionPane.showMessageDialog(null, "2");
	        	//Erstelle neues Statement
	        	Statement st = connection.createStatement();
	        	JOptionPane.showMessageDialog(null, "3");
	        	// Aufbau SQL-Befehl
		        	try { 
		        		st.executeUpdate("INSERT INTO modul  " + "VALUES (8, '"+ kuerzel_ +"', '"+ bezeichnung_ + "')");
		        		JOptionPane.showMessageDialog(null, "4");
		        	}
		        	catch (SQLException e) {
		        		String error = e.getLocalizedMessage();
		        		JOptionPane.showMessageDialog(null, error);
		        	}
	        	
	        } catch (SQLException e) {
	        	JOptionPane.showMessageDialog(null, "Cannot connect to DB!");
	        }
	}
}
