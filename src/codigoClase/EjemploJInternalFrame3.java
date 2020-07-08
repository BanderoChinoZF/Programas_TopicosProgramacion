import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class EjemploJInternalFrame3 extends JFrame {
	
	JToolBar barra;
	JDesktopPane escritorio;
	JInternalFrame interna1,interna2;
	
	public EjemploJInternalFrame3(){
		super("EjemploJInternalFrame3");
		// ColocarSkin();
		
		barra=new JToolBar();
		JButton llamar1=new JButton("Interna 1");
		llamar1.addActionListener(new ActionListener(){


			@Override
			public void actionPerformed(ActionEvent e) {
				interna1=new JInternalFrame("Interna1",true,true,true,true);
				interna1.setVisible(true);
				interna1.setBounds(0, 0, 200, 100);
				escritorio.add(interna1);
			}
			
		});
		JButton llamar2=new JButton("Interna 2");
		llamar2.addActionListener(new ActionListener(){


			@Override
			public void actionPerformed(ActionEvent e) {
				interna2=new JInternalFrame("Interna2",true,true,true,true);
				interna2.setVisible(true);
				interna2.setBounds(0, 0, 300, 100);
				escritorio.add(interna2);
			}
			
		});
		barra.add(llamar1);
		barra.add(llamar2);
		
		add(barra,BorderLayout.NORTH);
		
		escritorio=new JDesktopPane();
		add(escritorio);
		setSize(300,100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	
	public void ColocarSkin(){
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
			} catch (ClassNotFoundException e) {
			 e.printStackTrace();
			} catch (InstantiationException e) {
			 e.printStackTrace();
			} catch (IllegalAccessException e) {
			 e.printStackTrace();
			} catch (UnsupportedLookAndFeelException e) {
			 e.printStackTrace();
			}
	}
	public static void main(String[] args){
		new EjemploJInternalFrame3();
	}
}
