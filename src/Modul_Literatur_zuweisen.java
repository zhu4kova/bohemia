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
import javax.swing.JPanel;

public class Modul_Literatur_zuweisen {

	private JFrame frame;
	private JTextField modul;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Modul_Literatur_zuweisen window = new Modul_Literatur_zuweisen();
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
	public Modul_Literatur_zuweisen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Modul_Literatur_zuweisen.class.getResource("/Bilder/logo@2x.png")));
		frame.setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 591, 483);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenuItem mntmStartseite = new JMenuItem("Startseite");
		menuBar.add(mntmStartseite);
		frame.getContentPane().setLayout(new MigLayout("", "[100][33.45%,grow][61.00][39.00][50%,grow]", "[39px,grow][60px][30][30][30][30.00][][30.00][60.00px][30.00][30.00]"));
		
		JLabel lblLiteraturzuweisen = new JLabel("Literatur zuweisen");
		lblLiteraturzuweisen.setFont(new Font("Tahoma", Font.BOLD, 24));
		frame.getContentPane().add(lblLiteraturzuweisen, "cell 0 0 2 1,grow");
		
		JLabel lblModul = new JLabel("Modul");
		frame.getContentPane().add(lblModul, "cell 0 2,alignx left,aligny center");
		
		modul = new JTextField();
		modul.setText("");
		frame.getContentPane().add(modul, "cell 1 2 2 1,growx,aligny center");
		modul.setColumns(10);
		
		JButton btnLiteraturhinzufuegen = new JButton("Literatur hinzuf\u00FCgen");
		btnLiteraturhinzufuegen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		frame.getContentPane().add(btnLiteraturhinzufuegen, "cell 4 2,growx,aligny center");
		
		JLabel lblLiteratur = new JLabel("Literatur");
		frame.getContentPane().add(lblLiteratur, "cell 0 4,alignx left,aligny center");
		
		JComboBox literaturzuweisen = new JComboBox();
		frame.getContentPane().add(literaturzuweisen, "cell 1 4 3 1,growx");
		
		JButton btnMinus = new JButton("-");
		frame.getContentPane().add(btnMinus, "cell 4 4");
		
		JButton btnSpeichern = new JButton("Speichern");
		frame.getContentPane().add(btnSpeichern, "flowx,cell 1 9,alignx left,aligny center");
		
		JButton btnAbbrechen = new JButton("Abbrechen");
		btnAbbrechen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		frame.getContentPane().add(btnAbbrechen, "cell 1 9,alignx right,aligny center");

	}
}
