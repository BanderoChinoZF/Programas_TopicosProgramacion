package codigoClase;

import javax.swing.JFrame;
//import misComponentes.MiBoton;

public class MiBotonEjemplo extends JFrame{
	private MiBoton btn;
	
	public MiBotonEjemplo()
	{
		super("Mi Boton Ejemplo");
		btn = new MiBoton("Boton");
		add(btn);
		setVisible(true);
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args)
	{
		new MiBotonEjemplo();
	}

}