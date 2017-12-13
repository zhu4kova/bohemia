import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

public class PersonModulzuweisen extends JFrame {
	
	private JTextField person;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PersonModulzuweisen frame = new PersonModulzuweisen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public PersonModulzuweisen() {
		setName("PersonModulzuweisen");
		setIconImage(Toolkit.getDefaultToolkit().getImage(PersonModulzuweisen.class.getResource("/Bilder/FFHS_logo.png")));
		setTitle("Person zu Modul zuweisen");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 712, 450);
		
		/*
		 * Menue Bar mit Verlinkungen zu anderen Menuepunkten
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
		mntmLiteraturErfassen.setIcon(new ImageIcon(ModulErfassen.class.getResource("/Bilder/books-stack_small.png")));
		mnErfassung.add(mntmLiteraturErfassen);
		
		JMenu mnZuweisung = new JMenu("Zuweisung");
		menuBar.add(mnZuweisung);
		
		JMenuItem mntmPersonZuModul = new JMenuItem("Person zu Modul zuweisen");
		mntmPersonZuModul.setEnabled(false);
		mntmPersonZuModul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				PersonModulzuweisen PMz = new PersonModulzuweisen();
				PMz.setVisible(true);
			}
		});	
		mntmPersonZuModul.setIcon(new ImageIcon(PersonModulzuweisen.class.getResource("/Bilder/classroom_small.png")));
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
		mntmFlligeLiteraturbestellungen.setIcon(new ImageIcon(PersonModulzuweisen.class.getResource("/Bilder/schedule_small.png")));
		mnAuswertung.add(mntmFlligeLiteraturbestellungen);
		
		JMenu menu = new JMenu("Help");
		menu.setIcon(new ImageIcon(PersonModulzuweisen.class.getResource("/Bilder/question-mark_small.png")));
		menuBar.add(menu);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][200,grow][][]", "[][][][][][][][][]"));
		
		/*
		 * Titel der Seite
		 */
		JLabel lblTitel = new JLabel("Person zu Modul zuweisen");
		lblTitel.setIcon(new ImageIcon(PersonModulzuweisen.class.getResource("/Bilder/classroom.png")));
		lblTitel.setFont(new Font("Tahoma", Font.BOLD, 24));
		contentPane.add(lblTitel, "cell 0 0 2 1,grow");
		
		
		/*
		 * Auswahl Feld für die Person
		 */
		JLabel lblPerson = new JLabel("Person");
		contentPane.add(lblPerson, "cell 0 2,alignx left,aligny center");
		
		person = new JTextField();
		person.setText("");
		contentPane.add(person, "cell 1 2 2 1,growx,aligny center");
		person.setColumns(10);
		
		
		/*
		 * Zusaetzliche Module hinzufuegen -> max. 4
		 */
		JButton btnModulZuweisen = new JButton("Modul hinzuf\u00FCgen");
		btnModulZuweisen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		contentPane.add(btnModulZuweisen, "cell 3 2,growx,aligny center");
		JLabel lblModul = new JLabel("Modul");
		contentPane.add(lblModul, "cell 0 4,alignx left,aligny center");
		
		/*
		 * Auswahl Feld für das Modul
		 */
		JComboBox modul = new JComboBox();
		contentPane.add(modul, "cell 1 4 2 1,growx");
		
		/*
		 * Modul entfernen Button
		 */
		JButton btnMinus = new JButton("-");
		btnMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		contentPane.add(btnMinus, "cell 3 4");
		
		/*
		 * Speichern Button
		 */
		
		JButton btnSpeichern = new JButton("Speichern");
		contentPane.add(btnSpeichern, "flowx,cell 1 9,alignx left,aligny center");
		
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
		contentPane.add(btnAbbrechen, "cell 1 9,alignx right,aligny center");
	}

}
