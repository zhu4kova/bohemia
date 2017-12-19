import java.awt.Desktop;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

public class LiteraturModulzuweisen extends JFrame {
	
	private JComboBox modul;
	private JComboBox literatur1;
	private JComboBox literatur2;
	private JComboBox literatur3;
	private JComboBox literatur4;
	

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public LiteraturModulzuweisen() {
		setName("LiteraturModulzuweisen");
		setIconImage(Toolkit.getDefaultToolkit().getImage(LiteraturModulzuweisen.class.getResource("/Bilder/FFHS_logo.png")));
		setTitle("Literatur zu Modul zuweisen");
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
		mntmPersonErfassen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				PersonErfassen PersErf = new PersonErfassen();
				PersErf.setVisible(true);
			}
		});
		mntmPersonErfassen.setIcon(new ImageIcon(LiteraturModulzuweisen.class.getResource("/Bilder/online-student_small.png")));
		mntmPersonErfassen.setSelectedIcon(null);
		mntmPersonErfassen.setSelected(true);
		mnErfassung.add(mntmPersonErfassen);
		mntmModulErfassen.setIcon(new ImageIcon(LiteraturModulzuweisen.class.getResource("/Bilder/internet-education-graduation_small.png")));
		mnErfassung.add(mntmModulErfassen);
		
		JMenuItem mntmLiteraturErfassen = new JMenuItem("Literatur erfassen");
		mntmLiteraturErfassen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				LiteraturErfassen LitErf = new LiteraturErfassen();
				LitErf.setVisible(true);
			}
		});
		mntmLiteraturErfassen.setIcon(new ImageIcon(LiteraturModulzuweisen.class.getResource("/Bilder/books-stack_small.png")));
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
		mntmPersonZuModul.setIcon(new ImageIcon(LiteraturModulzuweisen.class.getResource("/Bilder/classroom_small.png")));
		mnZuweisung.add(mntmPersonZuModul);
		
		JMenuItem mntmLiteraturZuModul = new JMenuItem("Literatur zu Modul zuweisen");
		mntmLiteraturZuModul.setEnabled(false);
		mntmLiteraturZuModul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				LiteraturModulzuweisen LMz = new LiteraturModulzuweisen();
				LMz.setVisible(true);
			}
		});
		mntmLiteraturZuModul.setIcon(new ImageIcon(LiteraturModulzuweisen.class.getResource("/Bilder/study_small.png")));
		mnZuweisung.add(mntmLiteraturZuModul);
		
		JMenu mnAuswertung = new JMenu("Auswertung");
		menuBar.add(mnAuswertung);
		
		JMenuItem mntmAuswertungLitBestellen = new JMenuItem("Auswertung zu bestellende Literatur");
		mntmAuswertungLitBestellen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				AuswertungLitBestellen lBs = new AuswertungLitBestellen();
				lBs.setVisible(true);
			}
		});
		mntmAuswertungLitBestellen.setIcon(new ImageIcon(LiteraturModulzuweisen.class.getResource("/Bilder/schedule_small.png")));
		mnAuswertung.add(mntmAuswertungLitBestellen);
		
		JMenuItem mntmHelp = new JMenuItem("Help");
		mntmHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (Desktop.isDesktopSupported()) {
		            try {
		            	ClassLoader classLoader = getClass().getClassLoader();
		            	File myFile = new File(classLoader.getResource("PA_5_kickoff_ZH_alles_2017_V02.pdf").getFile());
		                Desktop.getDesktop().open(myFile);
		            } catch (IOException ex) {
		                // no application registered for PDFs
		            }
		        }
			}
		});
		mntmHelp.setIcon(new ImageIcon(LiteraturModulzuweisen.class.getResource("/Bilder/question-mark_small.png")));
		menuBar.add(mntmHelp);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][200,grow][][]", "[][][][][][][][][][][]"));
		
		/*
		 * Titel der Seite
		 */
		JLabel lblTitel = new JLabel("Literatur zu Modul zuweisen");
		lblTitel.setIcon(new ImageIcon(LiteraturModulzuweisen.class.getResource("/Bilder/study.png")));
		lblTitel.setFont(new Font("Tahoma", Font.BOLD, 24));
		contentPane.add(lblTitel, "cell 0 0 2 1,grow");
		
		
		/*
		 * Auswahl Feld für das Modul
		 */
		JLabel lblModul = new JLabel("Modul");
		contentPane.add(lblModul, "cell 0 2,alignx left,aligny center");
		
		modul = new JComboBox();
		contentPane.add(modul, "cell 1 2,growx,aligny center");
		fillComboBoxModul();
		
		
		/*
		 * Feld für die Literaturauswahl aus bestehenden DB Eintraegen -> max. 4
		 */
		
		JLabel lblLiteratur1 = new JLabel("Literatur");
		contentPane.add(lblLiteratur1, "cell 0 5,alignx left,aligny center");
		
		literatur1 = new JComboBox();
		contentPane.add(literatur1, "cell 1 5,growx");
		
		JLabel lblLiteratur2 = new JLabel("Literatur");
		lblLiteratur2.setVisible(false);
		contentPane.add(lblLiteratur2, "cell 0 6,alignx trailing");
		
		literatur2 = new JComboBox();
		literatur2.setVisible(false);
		contentPane.add(literatur2, "cell 1 6,growx");
		
		JLabel lblLiteratur3 = new JLabel("Literatur");
		lblLiteratur3.setVisible(false);
		contentPane.add(lblLiteratur3, "cell 0 7,alignx trailing");
		
		literatur3 = new JComboBox();
		literatur3.setVisible(false);
		contentPane.add(literatur3, "cell 1 7,growx");
		
		JLabel lblLiteratur4 = new JLabel("Literatur");
		lblLiteratur4.setVisible(false);
		contentPane.add(lblLiteratur4, "cell 0 8,alignx trailing");
		
		literatur4 = new JComboBox();
		literatur4.setVisible(false);
		contentPane.add(literatur4, "cell 1 8,growx");
		
		fillComboBoxLiteratur();
		
		/*
		 * Literaturauwahl hinzufügen und entfernen Button, zusätzliche Buttons sind per default ausgeblendet
		 */
		JButton btnPlus1 = new JButton("+");
		btnPlus1.setVisible(true);
		contentPane.add(btnPlus1, "flowx,cell 3 5,alignx left,aligny center");
		JButton btnPlus2 = new JButton("+");
		btnPlus2.setVisible(false);
		JButton btnPlus3 = new JButton("+");
		btnPlus3.setVisible(false);
		JButton btnMinus1 = new JButton("-");
		btnMinus1.setVisible(false);
		JButton btnMinus2 = new JButton("-");
		btnMinus2.setVisible(false);
		JButton btnMinus3 = new JButton("-");
		btnMinus3.setVisible(false);
		
		
		/*
		 * zusätzliche Auswahl einblenden
		 */
		
		btnPlus1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblLiteratur2.setVisible(true);
				literatur2.setVisible(true);
				btnPlus2.setVisible(true);
				btnMinus1.setVisible(true);
			}
		});
		contentPane.add(btnPlus2, "flowx,cell 3 6");
		contentPane.add(btnMinus1, "cell 3 6");

		
		/*
		 * zweite zusätzliche Auswahl einblenden oder aktuelle ausblenden
		 */

		btnPlus2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblLiteratur3.setVisible(true);
				literatur3.setVisible(true);
				btnPlus3.setVisible(true);
				btnMinus2.setVisible(true);
			}
		});
		contentPane.add(btnPlus3, "flowx,cell 3 7");
		contentPane.add(btnMinus2, "cell 3 7");
		
		btnMinus1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblLiteratur2.setVisible(false);
				literatur2.setVisible(false);
				btnPlus2.setVisible(false);
				btnMinus1.setVisible(false);
			}
		});

		
		
		/*
		 * dritte zusätzliche Auswahl einblenden oder zweite ausblenden
		 */
		
		btnPlus3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblLiteratur4.setVisible(true);
				literatur4.setVisible(true);
				btnMinus3.setVisible(true);
			}
		});
		contentPane.add(btnMinus3, "cell 3 8,alignx right");
		
		btnMinus2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblLiteratur3.setVisible(false);
				literatur3.setVisible(false);
				btnPlus3.setVisible(false);
				btnMinus2.setVisible(false);
			}
		});

		
		/*
		 * dritte zusätzliche Auswahl ausblenden
		 */
		
		btnMinus3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblLiteratur4.setVisible(false);
				literatur4.setVisible(false);
				btnMinus3.setVisible(false);
			}
		});
		
		
		
		/*
		 * Speichern Button
		 */
		
		JButton btnSpeichern = new JButton("Speichern");
		contentPane.add(btnSpeichern, "flowx,cell 1 10,alignx left,aligny center");
		
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
		contentPane.add(btnAbbrechen, "cell 1 10,alignx right,aligny center");

		
	}
	
	/*
	 * Füge die im GUI eingegebenen Daten in die Datenbank hinzu. 
	 * @author Anna Zhuchkova
	 * @version 1.0
	 * @param 
	 * @return
	 */
	private void addLiteraturToModul () throws SQLException  {
		// Daten auslesen
			String modul_ = (String) modul.getSelectedItem();
			String literatur1_ = (String) literatur1.getSelectedItem();
			String literatur2_ = (String) literatur2.getSelectedItem();
			String literatur3_ = (String) literatur3.getSelectedItem();
			String literatur4_ = (String) literatur4.getSelectedItem();
		
		// Verbindung mit Datenbank herstellen
			String url = "jdbc:mysql://bohemia.mysql.database.azure.com:3306/bohemia?autoReconnect=true&useSSL=false"; 
	        String username = "myadmin@bohemia"; // DB-Benutzername
	        String password = "Bohemia2017"; // DB-Passwort	          
	        
	        // Überprüfe, ob DB Benutzername und Passwort mitgegeben werden! 
	        	if (username == "" || password == "") {
	        		JOptionPane.showMessageDialog(null, "DB username or password is missing!");
	        		return;
	        	}
	        	
	        // Lese die id des Moduls und der Literatur heraus ?????????wie????????
	        	
	        	
	        	
	        // Überprüfe, ob die Literatur ausgewählt wurde, wenn ja, dem Modul zuweisen
	      	

	        try (Connection connection = DriverManager.getConnection(url, username, password)) {
	        	//Erstelle neues Statement
	        	Statement st = connection.createStatement();
	        	
	        	// Aufbau SQL-Befehl
		        	try { 
		        		st.executeUpdate("INSERT INTO bohemia.modul_hat_literatur (modul_id,) VALUES ('"+modul_+"', '"+literatur1_+"')");
		        		JOptionPane.showMessageDialog(null, modul_ + " " + literatur1_ + " wurde erfolgreich erfasst.");
		        	}
		        	catch (SQLException e) {
		        		String error = e.getLocalizedMessage();
		        		JOptionPane.showMessageDialog(null, error);
		        	}
		        	
		        	if(literatur2.isVisible()) {
		        		try {
		        			st.executeUpdate("INSERT INTO bohemia.modul_hat_literatur (modul_id,) VALUES ('"+modul_+"', '"+literatur2_+"')");
		        			JOptionPane.showMessageDialog(null, modul_ + " " + literatur1_ + " wurde erfolgreich erfasst.");
		        		}
		        		catch (SQLException e) {
			        		String error = e.getLocalizedMessage();
			        		JOptionPane.showMessageDialog(null, error);
			        	}
		        	}
		        	else if(literatur3.isVisible()) {
		        		try {
		        			st.executeUpdate("INSERT INTO bohemia.modul_hat_literatur (modul_id,) VALUES ('"+modul_+"', '"+literatur3_+"')");
			        		JOptionPane.showMessageDialog(null, modul_ + " " + literatur1_ + " wurde erfolgreich erfasst.");
		        		}
		        		catch (SQLException e) {
			        		String error = e.getLocalizedMessage();
			        		JOptionPane.showMessageDialog(null, error);
			        	}
		        	}
		        	else if(literatur4.isVisible()) {
		        		try {
			        		st.executeUpdate("INSERT INTO bohemia.modul_hat_literatur (modul_id,) VALUES ('"+modul_+"', '"+literatur4_+"')");
			        		JOptionPane.showMessageDialog(null, modul_ + " " + literatur1_ + " wurde erfolgreich erfasst.");
		        		}
		        		catch (SQLException e) {
			        		String error = e.getLocalizedMessage();
			        		JOptionPane.showMessageDialog(null, error);
			        	}
		        	}
		        	
	        	
	        } catch (SQLException e) {
	        	JOptionPane.showMessageDialog(null, "Verbindung zur Datenbank ist fehlgeschlagen!");
	        }
	}
	
	/*
	 * Füge die Literatur aus der Datenbank in das Dropdown hinzu. 
	 * @author Anna Zhuchkova
	 * @version 1.0
	 * @param 
	 * @return
	 */
	
	public void fillComboBoxLiteratur() {
		// Verbindung mit Datenbank herstellen
					String url = "jdbc:mysql://bohemia.mysql.database.azure.com:3306/bohemia?autoReconnect=true&useSSL=false"; 
			        String username = "myadmin@bohemia"; // DB-Benutzername
			        String password = "Bohemia2017"; // DB-Passwort	          
			        
	   // Überprüfe, ob DB Benutzername und Passwort mitgegeben werden! 
			        if (username == "" || password == "") {
			        	JOptionPane.showMessageDialog(null, "DB username or password is missing!");
			        	return;
			        }
		
				try {
					Connection connection = DriverManager.getConnection(url, username, password);
					String query="SELECT * FROM bohemia.literatur order by titel asc";
					PreparedStatement pst = connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					
					while(rs.next()) {
						literatur1.addItem("titel");
						literatur2.addItem("titel");
						literatur3.addItem("titel");
						literatur4.addItem("titel");
					}
				}
				catch (SQLException e) {
					String error = e.getLocalizedMessage();
	        		JOptionPane.showMessageDialog(null, error);
				}
			
	}
	
	/*
	 * Füge die Module aus der Datenbank in das Dropdown hinzu. 
	 * @author Anna Zhuchkova
	 * @version 1.0
	 * @param 
	 * @return
	 */
	
	public void fillComboBoxModul() {
		// Verbindung mit Datenbank herstellen
					String url = "jdbc:mysql://bohemia.mysql.database.azure.com:3306/bohemia?autoReconnect=true&useSSL=false"; 
			        String username = "myadmin@bohemia"; // DB-Benutzername
			        String password = "Bohemia2017"; // DB-Passwort	          
			        
	   // Überprüfe, ob DB Benutzername und Passwort mitgegeben werden! 
			        if (username == "" || password == "") {
			        	JOptionPane.showMessageDialog(null, "DB username or password is missing!");
			        	return;
			        }
		
				try {
					Connection connection = DriverManager.getConnection(url, username, password);
					String query="SELECT * FROM bohemia.modul order by modul asc";
					PreparedStatement pst = connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					
					while(rs.next()) {
						String temp = rs.getString("kuerzel");
						temp += " ";
						temp += rs.getString("modul");
						modul.addItem(temp);
					}
				}
				catch (SQLException e) {
					String error = e.getLocalizedMessage();
	        		JOptionPane.showMessageDialog(null, error);
				}
			
	}

}
