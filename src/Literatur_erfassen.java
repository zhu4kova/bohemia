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
import javax.swing.JPanel;

public class Literatur_erfassen {

	private JFrame frame;
	private JTextField textId;
	private JTextField isbn;
	private JTextField titel;
	private JTextField autor;
	private JTextField auflage;
	private JTextField herausgeber;
	private JComboBox jahr;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Literatur_erfassen window = new Literatur_erfassen();
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
	public Literatur_erfassen() {
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
		frame.getContentPane().setLayout(new MigLayout("", "[100][33.45%,grow][100][50%,grow]", "[39px,grow][60px][30][30][30][30.00][][30.00][60.00px][30.00][30.00]"));
		
		JLabel lblLiteratur = new JLabel("Literatur erfassen");
		lblLiteratur.setFont(new Font("Tahoma", Font.BOLD, 24));
		frame.getContentPane().add(lblLiteratur, "cell 0 0 2 1,grow");
		
		JLabel lblId = new JLabel("ID");
		frame.getContentPane().add(lblId, "cell 0 2");
		
		textId = new JTextField();
		textId.setEnabled(false);
		textId.setColumns(50);
		textId.setBackground(new Color(204, 204, 204));
		frame.getContentPane().add(textId, "cell 1 2");
		
		JLabel lblISBN = new JLabel("ISBN");
		frame.getContentPane().add(lblISBN, "cell 0 3");
		
		isbn = new JTextField();
		isbn.setColumns(50);
		isbn.setBackground(Color.WHITE);
		frame.getContentPane().add(isbn, "cell 1 3 3 1");
		
		JLabel lblTitel = new JLabel("Titel");
		frame.getContentPane().add(lblTitel, "cell 0 4");
		
		titel = new JTextField();
		titel.setColumns(50);
		titel.setBackground(Color.WHITE);
		frame.getContentPane().add(titel, "cell 1 4 3 1,growx");
		
		JLabel lblAutor = new JLabel("Autor");
		frame.getContentPane().add(lblAutor, "cell 0 5");
		
		autor = new JTextField();
		autor.setColumns(50);
		autor.setBackground(Color.WHITE);
		frame.getContentPane().add(autor, "cell 1 5 3 1,growx,aligny center");
		
		JLabel lblHerausgeber = new JLabel("Herausgeber");
		frame.getContentPane().add(lblHerausgeber, "cell 0 6,alignx trailing");
		
		herausgeber = new JTextField();
		frame.getContentPane().add(herausgeber, "cell 1 6 3 1,growx,aligny center");
		herausgeber.setColumns(10);
		
		JLabel lblAuflage = new JLabel("Auflage");
		frame.getContentPane().add(lblAuflage, "cell 0 7");
		
		auflage = new JTextField();
		auflage.setColumns(50);
		auflage.setBackground(Color.WHITE);
		frame.getContentPane().add(auflage, "cell 1 7,growx,aligny center");
		
		JLabel lblJahr = new JLabel("Jahr");
		frame.getContentPane().add(lblJahr, "cell 2 7,alignx trailing");
		
		jahr = new JComboBox();
		frame.getContentPane().add(jahr, "cell 3 7,growx,aligny center");
		
		JButton btnSpeichern = new JButton("Speichern");
		btnSpeichern.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					addLiteraturToDb();
				} catch (SQLException e) {
				}
			}
		});
		frame.getContentPane().add(btnSpeichern, "flowx,cell 1 9,alignx left,aligny center");
		
		JButton btnAbbrechen = new JButton("Abbrechen");
		btnAbbrechen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		frame.getContentPane().add(btnAbbrechen, "cell 1 9,alignx right,aligny center");

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
