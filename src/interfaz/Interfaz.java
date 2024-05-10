package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import java.awt.Font;
import javax.swing.JTextField;

import grafo.Grafo;
import grafo.Vertice;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class Interfaz {

	private JFrame frame;
	private JFrame frame2;
	private JTextField textFieldCantProv;
	private JLayeredPane layeredPane;
	private JTextField textFieldCargarProv;
	private Grafo grafo;
	private JTextField textFieldSimilaridad;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz window = new Interfaz();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public void cambiarPanel(JPanel panel){
		panel.setVisible(true);
		this.layeredPane.removeAll();
		this.layeredPane.add(panel);
		this.layeredPane.repaint();
		this.layeredPane.revalidate();
	}

	/**
	 * Create the application.
	 */
	public Interfaz() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		frame2 = new JFrame();
		frame2.setBounds(100, 100, 450, 300);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.getContentPane().setLayout(null);
		
		this.layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 436, 252);
		frame.getContentPane().add(layeredPane);
		layeredPane.setLayout(null);
		
		
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setBounds(0, 0, 436, 252);
		layeredPane.add(panelPrincipal);
		panelPrincipal.setLayout(null);
		
		JLabel Principal = new JLabel("Diseño de regiones");
		Principal.setFont(new Font("Arial", Font.PLAIN, 20));
		Principal.setBounds(132, 11, 210, 50);
		panelPrincipal.add(Principal);
		
		
		JLabel lblCantProvincias = new JLabel("Ingrese la cantidad de provincias");
		lblCantProvincias.setFont(new Font("Arial", Font.PLAIN, 14));
		lblCantProvincias.setBounds(108, 92, 210, 28);
		panelPrincipal.add(lblCantProvincias);
		
		
		
		textFieldCantProv = new JTextField();
		textFieldCantProv.setBounds(176, 131, 96, 20);
		textFieldCantProv.setColumns(10);
		panelPrincipal.add(textFieldCantProv);
		
		
		//-----------------------------------------------------------
		//-----------------------------------------------------------
		
				JPanel panelCargarArista = new JPanel();
				panelCargarArista.setBounds(0, 0, 436, 263);
				layeredPane.add(panelCargarArista);
				panelCargarArista.setLayout(null);
				panelCargarArista.setVisible(false);
				
				JLabel lblCargarArista = new JLabel("Cargar arista");
				lblCargarArista.setFont(new Font("Arial", Font.PLAIN, 17));
				lblCargarArista.setBounds(163, 22, 141, 27);
				panelCargarArista.add(lblCargarArista);
				
				JComboBox<String> comboBox1 = new JComboBox<>();
				comboBox1.setBounds(38, 89, 85, 22);
				panelCargarArista.add(comboBox1);
				
				JComboBox<String> comboBox2 = new JComboBox<>();
				comboBox2.setBounds(163, 89, 77, 22);
				panelCargarArista.add(comboBox2);
				
				JLabel lblProv1 = new JLabel("Provincia 1");
				lblProv1.setFont(new Font("Arial", Font.PLAIN, 17));
				lblProv1.setBounds(38, 64, 85, 14);
				panelCargarArista.add(lblProv1);
				
				JLabel lblProv2 = new JLabel("Provincia 2");
				lblProv2.setFont(new Font("Arial", Font.PLAIN, 17));
				lblProv2.setBounds(173, 64, 85, 14);
				panelCargarArista.add(lblProv2);
				
				textFieldSimilaridad = new JTextField();
				textFieldSimilaridad.setBounds(294, 90, 96, 20);
				panelCargarArista.add(textFieldSimilaridad);
				textFieldSimilaridad.setColumns(10);
				
				JLabel lblPeso = new JLabel("similaridad");
				lblPeso.setFont(new Font("Arial", Font.PLAIN, 17));
				lblPeso.setBounds(294, 53, 85, 36);
				panelCargarArista.add(lblPeso);
				
				JButton btnCargarArista = new JButton("Cargar arista");
				btnCargarArista.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
					}
					});
				btnCargarArista.setBounds(294, 133, 96, 36);
				panelCargarArista.add(btnCargarArista);
				
				JButton btnVerGrafo = new JButton("Visualizar grafo");
				btnVerGrafo.setBounds(58, 200, 132, 36);
				panelCargarArista.add(btnVerGrafo);
				
				JButton btnVerRegiones = new JButton("Visualizar regiones");
				btnVerRegiones.setBounds(247, 200, 132, 36);
				panelCargarArista.add(btnVerRegiones);
				//-----------------------------------------------------------
		//-----------------------------------------------------------
		
		JPanel panelRegistrarProv = new JPanel();
		panelRegistrarProv.setBounds(0, 0, 436, 252);
		layeredPane.add(panelRegistrarProv);
		panelRegistrarProv.setLayout(null);
		panelRegistrarProv.setVisible(false);
		
		JLabel lblCargarProv = new JLabel("Cargar provincia");
		lblCargarProv.setFont(new Font("Arial", Font.PLAIN, 20));
		lblCargarProv.setBounds(131, 25, 210, 39);
		panelRegistrarProv.add(lblCargarProv);
		
		textFieldCargarProv = new JTextField();
		textFieldCargarProv.setBounds(151, 78, 138, 32);
		panelRegistrarProv.add(textFieldCargarProv);
		textFieldCargarProv.setColumns(10);
		
		JButton btnCargarProv = new JButton("Cargar");
		btnCargarProv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					grafo.registrarProvincia(textFieldCargarProv.getText());
					textFieldCargarProv.setText("");
					if(grafo.tamano()==grafo.tamano()) {
						for (Vertice prov : grafo.getVertices()) {
				            comboBox1.addItem(prov.getNombre());
				            comboBox2.addItem(prov.getNombre());
				        }
						btnCargarProv.setEnabled(false);
						textFieldCargarProv.setEnabled(false);
					}	
					
				
			}
			});
		btnCargarProv.setBounds(179, 121, 89, 23);
		panelRegistrarProv.add(btnCargarProv);
		
		
		JButton btnFinCargarProv = new JButton("Listo!");
		btnFinCargarProv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				grafo=new Grafo(Integer.parseInt(textFieldCantProv.getText()));
					
				cambiarPanel(panelCargarArista);

				}
			});
		
		btnFinCargarProv.setBounds(179, 194, 89, 23);
		panelRegistrarProv.add(btnFinCargarProv);
		
		//---------------------------------------------------------------
		
			
		JButton btnPrincipal = new JButton("OK");
		btnPrincipal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				grafo=new Grafo(Integer.parseInt(textFieldCantProv.getText()));
					
				cambiarPanel(panelRegistrarProv);

				}
			});
		btnPrincipal.setBounds(183, 173, 89, 23);
		panelPrincipal.add(btnPrincipal);
		//frame.add(textFieldCantProv);
		
		
		
		
		
		
		
		
		
	}
}

