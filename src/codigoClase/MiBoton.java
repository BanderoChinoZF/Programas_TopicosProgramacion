/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigoClase;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.*;

public class MiBoton extends JButton{
	
	public MiBoton(String txt)
	{
		super(txt);
		this.setBorder(null);
		this.setContentAreaFilled(false); //Relleno
		this.setOpaque(true);    //Color solido
		this.setFont(new Font("Tahoma", Font.BOLD, 24)); //Asignamos el tamaño y tipo de letra
		this.setBackground(Color.BLUE);
		this.setForeground(Color.WHITE);
		this.setPreferredSize(new Dimension(200,40));
		this.setSize(200,40);
	}
	
	

}
