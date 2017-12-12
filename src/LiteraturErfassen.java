import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

public class LiteraturErfassen extends JFrame {
	
	private JTextField textId;
	private JTextField isbn;
	private JTextField titel;
	private JTextField autor;
	private JTextField auflage;
	private JTextField herausgeber;
	private JComboBox<?> jahr;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LiteraturErfassen frame = new LiteraturErfassen();
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
	public LiteraturErfassen() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(PersonErfassen.class.getResource("/Bilder/FFHS_logo.png")));
		setTitle("Literatur erfassen");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 712, 450);
		

		/*
		 * Menue bar mit Verlinkungen zu anderen Menuepunkten	
		 */
			
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnErfassung = new JMenu("Erfassung");
		menuBar.add(mnErfassung);
		
		JMenuItem mntmPersonErfassen = new JMenuItem("Person erfassen");
		mntmPersonErfassen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				PersonErfassen PersErf = new PersonErfassen();
				PersErf.setVisible(true);
			}
		});
		
		JMenuItem mntmLiteraturErfassen = new JMenuItem("Literatur erfassen");
		mntmLiteraturErfassen.setEnabled(false);
		mntmLiteraturErfassen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				LiteraturErfassen LitErf = new LiteraturErfassen();
				LitErf.setVisible(true);
			}
		});
		mntmLiteraturErfassen.setIcon(new ImageIcon(ModulErfassen.class.getResource("/Bilder/books-stack_small.png")));
		mnErfassung.add(mntmLiteraturErfassen);
		
		JSeparator separator = new JSeparator();
		mnErfassung.add(separator);
		mntmPersonErfassen.setIcon(new ImageIcon(ModulErfassen.class.getResource("/Bilder/online-student_small.png")));
		mntmPersonErfassen.setSelectedIcon(null);
		mntmPersonErfassen.setSelected(true);
		mnErfassung.add(mntmPersonErfassen);
		
		JMenuItem mntmModulErfassen = new JMenuItem("Modul erfassen");
		mntmModulErfassen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				ModulErfassen ModErf = new ModulErfassen();
				ModErf.setVisible(true);
			}
		});
		mntmModulErfassen.setIcon(new ImageIcon(ModulErfassen.class.getResource("/Bilder/internet-education-graduation_small.png")));
		mnErfassung.add(mntmModulErfassen);
		
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
		mntmPersonZuModul.setIcon(new ImageIcon(LiteraturErfassen.class.getResource("/Bilder/classroom_small.png")));
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
		
		JLabel lblTitel = new JLabel("Literatur erfassen");
		lblTitel.setIcon(new ImageIcon(LiteraturErfassen.class.getResource("/Bilder/books-stack.png")));
		lblTitel.setFont(new Font("Tahoma", Font.BOLD, 24));
		contentPane.add(lblTitel, "cell 0 0 2 1,grow");
		
		
		/*
		 * Modul ID Feld wird erst in der DB vergeben
		 */
		JLabel lblId = new JLabel("ID");
		contentPane.add(lblId, "cell 0 2");
		
		textId = new JTextField();
		textId.setEnabled(false);
		textId.setColumns(50);
		textId.setBackground(new Color(204, 204, 204));
		contentPane.add(textId, "cell 1 2");
		
		/*
		 * Feld fuer die ISBN
		 */
		JLabel lblISBN = new JLabel("ISBN");
		contentPane.add(lblISBN, "cell 0 3");
		
		isbn = new JTextField();
		isbn.setColumns(50);
		isbn.setBackground(Color.WHITE);
		contentPane.add(isbn, "cell 1 3 3 1,growx");
		
		/*
		 * Feld fuer den Autor
		 */
		JLabel lblAutor = new JLabel("Autor");
		contentPane.add(lblAutor, "cell 0 4");
			
		autor = new JTextField();
		autor.setColumns(50);
		autor.setBackground(Color.WHITE);
		contentPane.add(autor, "cell 1 4 3 1,growx,aligny center");
		
		/*
		 * Feld fuer den Herausgeber
		 */
		
		JLabel lblHerausgeber = new JLabel("Herausgeber");
		contentPane.add(lblHerausgeber, "cell 0 5,alignx trailing");
		
		herausgeber = new JTextField();
		contentPane.add(herausgeber, "cell 1 5,growx,aligny center");
		herausgeber.setColumns(10);
		
		/*
		 * Feld fuer die Auflage
		 */
		
		JLabel lblAuflage = new JLabel("Auflage");
		contentPane.add(lblAuflage, "cell 0 6");
		
		auflage = new JTextField();
		auflage.setColumns(50);
		auflage.setBackground(Color.WHITE);
		contentPane.add(auflage, "cell 1 6,growx,aligny center");
		
		/*
		 * Dropdown Feld fuer Jahr
		 */
		JLabel lblJahr = new JLabel("Jahr");
		contentPane.add(lblJahr, "cell 2 6,alignx center");
		
		jahr = new JComboBox();
		contentPane.add(jahr, "cell 3 6,growx,aligny center");
		
		/*
		 * Speichern Button
		 */
		
		/*
		 * Speichern und Modul zuweisen Button
		 */
		
		
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
		JButton btnSpeichern = new JButton("Speichern");
		btnSpeichern.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					addLiteraturToDb();
				} catch (SQLException e) {
				}
			}
		});
		contentPane.add(btnSpeichern, "flowx,cell 1 8,alignx left,aligny center");
		contentPane.add(btnAbbrechen, "cell 1 8,alignx right,aligny center");
	}
	
	/*
	 * Füge die im GUI eingegebenen Daten in die Datenbank hinzu. 
	 * @author Halil Koca
	 * @version 1.0
	 * @param 
	 * @return
	 */
	private void addLiteraturToDb () throws SQLException  {
		
		// Daten auslesen
			String id_ = textId.getText();
			String isbn_ = isbn.getText();
			String titel_ = titel.getText();
			String autor_ = autor.getText();
			String auflage_ = auflage.getText();
			String herausgeber_ = herausgeber.getText();
		
		// Verbindung mit Datenbank herstellen
			String url = "jdbc:mysql://localhost:3306/bohemia?autoReconnect=true&useSSL=false"; // evtl. anpassen gem. DB-Konfiguration
	        String username = "root"; // DB-Benutzername
	        String password = ""; // DB-Passwort	         
	        
	        // Überprüfe, ob DB Benutzername und Passwort mitgegeben werden! 
	        	if (username == "" || password == "") {
	        		JOptionPane.showMessageDialog(null, "DB username or password is missing!");
	        		return;
	        	}
	        try (Connection connection = DriverManager.getConnection(url, username, password)) {
	        	//Erstelle neues Statement
	        	Statement st = connection.createStatement();
	        	// Aufbau SQL-Befehl
		        	try { 
		        		st.executeUpdate("INSERT INTO literatur  " + "VALUES (2, '"+titel_+"', '"+ autor_+"', '"+ isbn_+"', '" + herausgeber_ +"', '"+ auflage_+ "', 2017)");
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
