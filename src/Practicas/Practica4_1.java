package Practicas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class Practica4_1 extends JFrame{
    
    JPanel panelCampos, panelBotones, panelTabla;
    JLabel campo;
    JTextField txtCampo;
    
    public Practica4_1(String []titulos, Object [][]datos)
    {
        //Configurar Ventana.
        this.setLayout(new BoxLayout(getContentPane(),BoxLayout.Y_AXIS));
        this.setTitle("JTab");
        this.setSize(600,700);
        this.setLocationRelativeTo(null);
        
        //Construimos nuestros paneles.
        panelCampos = new JPanel();
        panelBotones = new JPanel();
        panelTabla = new JPanel();
        
        
        //Configuramos los paneles.
        panelCampos.setBackground(Color.BLACK);
        panelCampos.setLayout(new FlowLayout());
        
        campo.setPreferredSize(new Dimension(70,25));
        txtCampo.setPreferredSize(new Dimension(130,25));
        
        for(int i=0;i<titulos.length;i++)
        {
            campo = new JLabel(titulos[i]);
            panelCampos.add(campo);
            
            txtCampo = new JTextField();
            txtCampo.setEditable(false);
            panelCampos.add(txtCampo);   
        }
        
        panelBotones.setBackground(Color.CYAN);
        
        panelTabla.setBackground(Color.RED);
        
        
        this.add(panelCampos);
        this.add(panelBotones);
        this.add(panelTabla);
        
        //Configuraciones finales de nuestra ventana.
        //this.pack();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    
    
    public static void main(String []args)
    {
        String[] titulos = {"ISBN","Titulo","Año","Autor","Editorial"};
        Object[][] datos = {};
        
        new Practica4_1(titulos,datos);        
    }
}