import java.util.*;
import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class botonesDinamicos extends JFrame implements ActionListener {
	private List<JButton> botones;
	private int indice;
	private JButton btnAgregar;
	private JScrollPane scroll;
	private JPanel panel;
	
	public botonesDinamicos (){
		initComponents();
		botones = new ArrayList<>();
		indice = 0;
	}
	
  public void initComponents(){
  		btnAgregar = new JButton("Agregar");
		panel = new JPanel();
		Container contenedor = getContentPane();
		panel.setLayout(new GridLayout(3,0));
		scroll = new JScrollPane(panel);
		btnAgregar.addActionListener(this);
		contenedor.add(btnAgregar, BorderLayout.NORTH);
		contenedor.add(scroll,BorderLayout.CENTER);
		setSize(300,200); 
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);			
	}
		
 public void actionPerformed(ActionEvent evt){
			JButton boton = new JButton("Botón " + indice);
			botones.add(boton);
			panel.add(boton);
			indice++;
			panel.updateUI();
			
			boton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					JOptionPane.showMessageDialog(null,"presionaste el "+ boton.getText());
				}
			});
		}
	
	
	public static void main(String args[]){
		new botonesDinamicos();
	}
  
}