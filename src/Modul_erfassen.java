import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Modul_erfassen {

	private JFrame frame;
	private JTextField id;
	private JTextField kuerzel;
	private JTextField bezeichnung;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Modul_erfassen window = new Modul_erfassen();
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
	public Modul_erfassen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\annaz\\Pictures\\logo@2x.png"));
		frame.setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 591, 483);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenuItem mntmStartseite = new JMenuItem("Startseite");
		menuBar.add(mntmStartseite);
		frame.getContentPane().setLayout(new MigLayout("", "[100][33.45%][100][50%]", "[39px][60px][30][30][30][30.00][30.00][60.00px][30.00][30.00]"));
		
		JLabel lblModul = new JLabel("Modul erfassen");
		lblModul.setFont(new Font("Tahoma", Font.BOLD, 24));
		frame.getContentPane().add(lblModul, "cell 0 0 2 1,grow");
		
		JLabel lblId = new JLabel("ID");
		frame.getContentPane().add(lblId, "cell 0 2");
		
		id = new JTextField();
		id.setEnabled(false);
		id.setColumns(50);
		id.setBackground(new Color(204, 204, 204));
		frame.getContentPane().add(id, "cell 1 2");
		
		JLabel lblKuerzel = new JLabel("K\u00FCrzel");
		frame.getContentPane().add(lblKuerzel, "cell 0 3");
		
		kuerzel = new JTextField();
		kuerzel.setColumns(50);
		kuerzel.setBackground(Color.WHITE);
		frame.getContentPane().add(kuerzel, "cell 1 3");
		
		JLabel lblBezeichnung = new JLabel("Bezeichnung");
		frame.getContentPane().add(lblBezeichnung, "cell 0 4");
		
		bezeichnung = new JTextField();
		bezeichnung.setColumns(50);
		bezeichnung.setBackground(Color.WHITE);
		frame.getContentPane().add(bezeichnung, "cell 1 4 3 1,growx");
		
		JButton btnModulplneAnsehen = new JButton("Modulpl\u00E4ne ansehen");
		frame.getContentPane().add(btnModulplneAnsehen, "cell 1 6,growx,aligny center");
		
		JButton btnSpeichern = new JButton("Speichern");
		btnSpeichern.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					addModulToDb();
				} catch (SQLException e) {
				}
			}
		});
		frame.getContentPane().add(btnSpeichern, "flowx,cell 1 8,alignx left,aligny center");
		
		JButton btnSpeichernUndModule = new JButton("Speichern und Literatur zuweisen");
		btnSpeichernUndModule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					addModulToDb();
					// Module zuweisen öffnen (TODO)
				} catch (SQLException e) {
				}
			}
		});
		frame.getContentPane().add(btnSpeichernUndModule, "cell 1 9,alignx left,aligny center");
		
		JButton btnAbbrechen = new JButton("Abbrechen");
		btnAbbrechen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		frame.getContentPane().add(btnAbbrechen, "cell 1 8,alignx right,aligny center");

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
