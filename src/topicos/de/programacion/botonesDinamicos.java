package topicos.de.programacion;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class botonesDinamicos extends JFrame implements ActionListener{

   private List<JButton> botones;
   private int indice;
   private JButton btnAgregar;
   private JPanel panel;
   
   public botonesDinamicos()
   {
       initComponents();
       botones = new ArrayList<>();
       indice=0;
   }
   
   public void initComponents()
   {
       btnAgregar = new JButton("Agregar.");
       panel = new JPanel();
       Container contenedor = getContentPane();
       panel.setLayout(new GridLayout(3,0));
       btnAgregar.addActionListener(this);
       contenedor.add(btnAgregar, BorderLayout.NORTH);
       contenedor.add(panel, BorderLayout.CENTER);
       
       setSize(300,200);
       setVisible(true);
       setDefaultCloseOperation(EXIT_ON_CLOSE);       
   }
   
   public void actionPerformed(ActionEvent evt)
   {
       JButton boton = new JButton("Botón " + indice);
       botones.add(boton);
       indice++;
       panel.updateUI();
       
       boton.addActionListener(new ActionListener()
               {
                   public void actionPerformed(ActionEvent e)
                   {
                       JOptionPane.showMessageDialog(null, "Presionaste el boton " + boton.getText());
                   }
               });
   }
    public static void main(String[] args) {
        new botonesDinamicos();
    }
    
}
