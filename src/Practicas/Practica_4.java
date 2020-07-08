/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practicas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.Color;
import javax.swing.WindowConstants;

public class Practica_4{
    
    JFrame frame;
    JPanel panelEntradas, panelTabla;
    
    public Practica_4()
    {
        construyeEntradas();
        construyeTabla();
        construyeVentana();
    }
    
    public void construyeEntradas()
    {
        panelEntradas = new JPanel();
        panelEntradas.setBackground(Color.red);
        
        
    }
    
    public void construyeTabla()
    {
        panelTabla = new JPanel();
        panelTabla.setBackground(Color.CYAN);
        
        
    }
    
    public void construyeVentana()
    {
        frame = new JFrame();
        frame.setLayout(new BoxLayout(frame.getContentPane(),BoxLayout.Y_AXIS));
        frame.add(panelEntradas);
        frame.add(panelTabla);
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
    public static void main(String []args)
    {
        new Practica_4();
    }
        
}