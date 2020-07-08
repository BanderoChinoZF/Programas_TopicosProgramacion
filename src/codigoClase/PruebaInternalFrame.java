import java.awt.FlowLayout;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.WindowConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.beans.PropertyVetoException;

/**
 * Instancia un JFrame con un JDesktopPane y dentro de este
 * un JInternalFrame.
 * @author chuidiang
 *
 */
public class PruebaInternalFrame implements ActionListener{
    JInternalFrame internal;
	
	/** Instancia esta clase */
	public static void main(String[] args) {
		new PruebaInternalFrame();
	}
	
	/**
	 * Crea el JFrame, el JDesktopPane, un JInternalFrame de
	 * muestra y lo visualiza.
	 */
	public PruebaInternalFrame()
	{
		// El JFrame con el JDesktopPane
		JFrame v = new JFrame("Prueba JInternalFrame");
		JDesktopPane dp = new JDesktopPane();
		v.getContentPane().add(dp);
		
		// Se construye el panel que irá dentro del JInternalFrame
		JPanel p = new JPanel();
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(this);
		p.setLayout(new FlowLayout());
		p.add (new JLabel("Una etiqueta"));
		p.add (new JTextField(10));
		p.add (btnSalir);
		
		// Se construye el JInternalFrame
		internal = new JInternalFrame("Un Internal Frame");
		internal.add(p);
		
		// Es importante darle tamaño -pack()- al JInternalFrame,
		// porque si no, tendrá tamaño 0,0 y no lo veremos.
		//internal.pack();
		
		// Por defecto el JInternalFrame no es redimensionable ni
		internal.setResizable(false);
		internal.setClosable(false);
		
		// Se agrega el internal en el JDesktopPane
		dp.add(internal);
		
		// Se visualiza todo.
		v.setSize(500,500);
		v.setVisible(true);
		v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Se visualiza el JInternalFrame 
		
		try {
			internal.setMaximum(true);
			
		} catch(PropertyVetoException e) { e.printStackTrace(); }
		internal.setVisible(true);
	}
	
	public void actionPerformed (ActionEvent e){
         internal.dispose();		
	}
}
