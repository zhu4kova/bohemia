import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;

public class PersonErfassen extends JFrame {
	
	private JTextField id;
	private JTextField nachname;
	private JTextField vorname;
	private JTextField adresse;
	private JTextField plz;
	private JTextField ort;
	private JComboBox<?> land;

	private JPanel contentPane;


	/**
	 * Launch the application.

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PersonErfassen frame = new PersonErfassen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	 */

	/**
	 * Create the frame.
	 */
	public PersonErfassen() {
		setName("PersonErfassen");
		setIconImage(Toolkit.getDefaultToolkit().getImage(PersonErfassen.class.getResource("/Bilder/FFHS_logo.png")));
		setTitle("Person erfassen");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 712, 450);
		
		/*
		 * Menue Bar mit Verlinkungen zu anderen Menuepunkten
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
		
		JMenuItem mntmPersonErfassen = new JMenuItem("Person erfassen");
		mntmPersonErfassen.setEnabled(false);
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
		
		JSeparator separator = new JSeparator();
		mnErfassung.add(separator);
		mntmModulErfassen.setIcon(new ImageIcon(ModulErfassen.class.getResource("/Bilder/internet-education-graduation_small.png")));
		mnErfassung.add(mntmModulErfassen);
		
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
		mntmPersonZuModul.setIcon(new ImageIcon(PersonErfassen.class.getResource("/Bilder/classroom_small.png")));
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
		JLabel lblTitel = new JLabel("Person erfassen");
		lblTitel.setIcon(new ImageIcon(PersonErfassen.class.getResource("/Bilder/online-student.png")));
		lblTitel.setFont(new Font("Tahoma", Font.BOLD, 24));
		contentPane.add(lblTitel, "cell 0 0 2 1,grow");
		
		/*
		 * Modul ID Feld wird erst in der DB vergeben
		 */
		JLabel lblId = new JLabel("ID");
		contentPane.add(lblId,"cell 0 2,alignx left");
		
		id = new JTextField();
		id.setEnabled(false);
		id.setColumns(50);
		id.setBackground(new Color(204, 204, 204));
		contentPane.add(id, "cell 1 2");
		
		/*
		 * Eingabe f�r Nachname
		 */
		JLabel lblNachname = new JLabel("Nachname");
		contentPane.add(lblNachname, "cell 0 3");
		
		nachname = new JTextField();
		nachname.setColumns(50);
		nachname.setBackground(Color.WHITE);
		contentPane.add(nachname, "cell 1 3");
		
		/*
		 * Eingabe f�r Vorname
		 */
		
		JLabel lblVorname = new JLabel("Vorname");
		contentPane.add(lblVorname, "cell 2 3");
		
		vorname = new JTextField();
		vorname.setColumns(50);
		vorname.setBackground(Color.WHITE);
		contentPane.add(vorname, "cell 3 3");
		
		/*
		 * Eingabe f�r Adresse
		 */
		JLabel lblAdresse = new JLabel("Adresse");
		contentPane.add(lblAdresse, "cell 0 4");
		
		adresse = new JTextField();
		adresse.setColumns(50);
		adresse.setBackground(Color.WHITE);
		contentPane.add(adresse, "cell 1 4 3 1,growx");
		
		/*
		 * Eingabe f�r PLZ
		 */
		JLabel lblPlz = new JLabel("PLZ");
		contentPane.add(lblPlz, "cell 0 5");
		
		plz = new JTextField();
		plz.setColumns(50);
		plz.setBackground(Color.WHITE);
		contentPane.add(plz, "cell 1 5,growx,aligny center");
		
		
		/*
		 * Eingabe f�r Ort
		 */
		JLabel lblOrt = new JLabel("Ort");
		contentPane.add(lblOrt, "cell 2 5");
		
		ort = new JTextField();
		ort.setColumns(50);
		ort.setBackground(Color.WHITE);
		contentPane.add(ort, "cell 3 5,growx,aligny center");
		
		
		/*
		 * Eingabe f�r Land aus Liste
		 */
		JLabel lblLand = new JLabel("Land");
		contentPane.add(lblLand, "cell 0 6");
		
		JComboBox<?> land = new JComboBox();
		contentPane.add(land, "cell 1 6,growx,aligny center");
		
		/*
		 * Speichern Button
		 */
		JButton btnSpeichern = new JButton("Speichern");
		btnSpeichern.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					addPersonToDb();
					// Module zuweisen �ffnen (TODO)
				} catch (SQLException e) {
				}
			}
		});
		contentPane.add(btnSpeichern, "flowx,cell 1 8,alignx left,aligny center");
		
		/*
		 * Speichern und Module zuordnen Button
		 */
		JButton btnSpeichernUndModule = new JButton("Speichern und Module zuweisen");
		contentPane.add(btnSpeichernUndModule, "cell 1 9,alignx left,aligny center");
		
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
		contentPane.add(btnAbbrechen, "flowx,cell 1 8,alignx right,aligny center");
	}

	public JComboBox<?> getLand() {
		return land;
	}

	public void setLand(JComboBox<?> land) {
		this.land = land;
	}

}
