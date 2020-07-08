package Practicas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import java.awt.*;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class JTabb_5 extends JFrame implements ActionListener {

    JPanel panelEntradas, panelBotones, panelTabla, panelcito;
    JLabel labelCampo;
    JButton btnNuevo, btnEditar, btnEliminar, btnGuardar1, btnGuardar2;
    DefaultTableModel dtm;
    JTable table;
    
    JTextField[] campos;
    String[] titulos;
    int id;
	
	public JTabb_5(String []arreT, Object [][]arreD)
	{
		String []arreglo1 = arreT;
		Object [][]arreglo2 = arreD;
                
                ArrayList<String> p =  new ArrayList<String>();
                
                String palabra = "ID";
                
                p.add(palabra);
                
                for(int i=0;i<arreT.length;i++)
                {
                    p.add(arreT[i]);   
                }
                
                String []titulos2 = new String[p.size()];
                
                for(int b=0;b<p.size();b++)
                {
                    titulos2[b] = p.get(b);
                    //System.out.println(titulos2[b]);
                }
                
		initComponents(titulos2,arreglo2);
	}

    public void initComponents(String []titulos, Object [][]datos)
    {
        this.titulos = titulos;

        //Asignamos el layout que utilizaremos en la ventana principal
        setLayout(new BoxLayout(getContentPane(),BoxLayout.Y_AXIS));
        setTitle("JTabb");
        setSize(600,700);
        setLocationRelativeTo(null);
        
        setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("estudiante.png")));

        //Construimos el panel de los campos
        panelEntradas = new JPanel();
        //panelEntradas.setBackground(Color.red);

        campos = new JTextField[titulos.length];

        for(int i=0;i<titulos.length;i++)
        {
            panelEntradas.add(hacerPanel(titulos[i], i));
        }

        //Construimos el panel donde van a ir nuestro botones.
        panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout());
        //panelBotones.setBackground(Color.ORANGE);
        panelBotones.setPreferredSize(new Dimension(600,80));

        //Creamos nuestros Botones.
        btnNuevo = new JButton();
        btnNuevo.setText("Nuevo");
        btnNuevo.setPreferredSize(new Dimension(85,35));
        btnNuevo.addActionListener(this);
        
        //Boton Guardar :v
        btnGuardar1 = new JButton();
        btnGuardar1.setText("Guardar");
        btnGuardar1.setPreferredSize(new Dimension(85,35));
        btnGuardar1.setVisible(false);
        btnGuardar1.addActionListener(this);

        btnEditar  = new JButton();
        btnEditar.setText("Editar");
        btnEditar.setPreferredSize(new Dimension(85,35));
        btnEditar.addActionListener(this);
        
        //Boton guardar que cambia con el boton editar.
        btnGuardar2 = new JButton();
        btnGuardar2.setText("Guardar");
        btnGuardar2.setPreferredSize(new Dimension(85,35));
        btnGuardar2.setVisible(false);
        btnGuardar2.addActionListener(this);

        btnEliminar  = new JButton();
        btnEliminar.setText("Eliminar");
        btnEliminar.setPreferredSize(new Dimension(85,35));
        btnEliminar.addActionListener(this);

        panelBotones.add(btnNuevo);
        panelBotones.add(btnGuardar1);
        panelBotones.add(btnEditar);
        panelBotones.add(btnGuardar2);
        panelBotones.add(btnEliminar);

        //Eventos de los botones

        //Construimos el panel donde estara la tabla
        panelTabla = new JPanel();
        panelTabla.setLayout(new FlowLayout());
        
        dtm = new DefaultTableModel(datos,titulos){
            @Override
            public boolean isCellEditable(int rowIndex,int columnIndex)
            {
                return false;
            }
        };
        
        Object[] newColumn = new Object[dtm.getRowCount()];
        
        for(int e=0;e<newColumn.length;e++)
        {
            newColumn[e]= id++;            
        }
        
        dtm.addColumn("ID",newColumn);
        
        table = new JTable(dtm);
        table.setPreferredScrollableViewportSize(new Dimension(700, 90));
        table.addMouseListener(new MyClickListener());
        JScrollPane scrollPane = new JScrollPane(table);

        panelTabla.add(scrollPane);

        add(panelEntradas);
        add(panelBotones);
        add(panelTabla);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    private class MyClickListener extends MouseAdapter
    {
        public void mouseClicked(MouseEvent event)
        {
            int filaSeleccionada;
            
            try{
                
                filaSeleccionada = table.getSelectedRow();
                
                for(int i=0;i<campos.length;i++)
                {
                    campos[i].setText(table.getValueAt(filaSeleccionada, i).toString());
                }
                
                if(filaSeleccionada == -1)
                {
                    JOptionPane.showMessageDialog(null, "No ha seleccionado ninguna fila.");
                }
                else if(filaSeleccionada != -1)
                {
                }
                
            }catch(Exception e)
            {
            }
        }   
    }

    public JPanel hacerPanel(String nombre, int count)
    {
        panelcito = new JPanel();
        panelcito.setLayout(new FlowLayout());

        //Creamos nuestros componentes.
        labelCampo = new JLabel();
        labelCampo.setText(nombre + ":");
        labelCampo.setPreferredSize(new Dimension(50,50));

        campos[count] = new JTextField();
        campos[count].setPreferredSize(new Dimension(150,25));
        campos[count].setEnabled(false);

        //Los agregamos a nuestros panel..
        panelcito.add(labelCampo);
        panelcito.add(campos[count]);

        return panelcito;
    }

    private String[] getElementsTextFields() {
        
        String[] textos = new String[titulos.length];
        for (int i = 0; i < titulos.length; i++)
            textos[i]  = campos[i].getText();
        
        return textos;
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == btnNuevo)
        {
            
            for(int y=0;y<campos.length;y++)
            {
                campos[y].setText("");                
            }
            
            btnNuevo.setVisible(false);
            
            for(int x=0;x<campos.length;x++)
            {
                campos[x].setEnabled(true);                
            }
            
            /*campos[0].setText(valorF);
            campos[0].setEnabled(false);*/
            
            btnGuardar1.setVisible(true);
            
        }
        else if(e.getSource() == btnGuardar1)
        {
            //int indiceUltimaFila = dtm.getRowCount() - 1;
            
            btnGuardar1.setVisible(false);
                        
            String[] a = getElementsTextFields();
            
            dtm.addRow(a);  
            
            for(int y=0;y<campos.length;y++)
            {
                campos[y].setText("");                
            }
            
            for(int x=0;x<campos.length;x++)
            {
                campos[x].setEnabled(false);                
            }
             
            dtm.setValueAt(id++, dtm.getRowCount()-1,dtm.getColumnCount()-1);
            
            btnNuevo.setVisible(true);
        }
        if(e.getSource() == btnEditar)
        {
            btnEditar.setVisible(false);
            
            for(int x=0;x<campos.length;x++)
            {
                campos[x].setEnabled(true);                
            }
            
            btnGuardar2.setVisible(true);
            
            //campos[0].setEnabled(false);
        }
        else if(e.getSource() == btnGuardar2)
        {
            btnGuardar2.setVisible(false);
            
            int fila = table.getSelectedRow();
            
            String[] a = getElementsTextFields();
            dtm.insertRow(fila, a);
            
            dtm.removeRow(fila+1);
            
            btnEditar.setVisible(true);
            
            for(int y=0;y<campos.length;y++)
            {
                campos[y].setText("");                
            }
        }
        else if(e.getSource() == btnEliminar)
        {
            int filita = table.getSelectedRow();
            
            dtm.removeRow(filita);
            
            for(int y=0;y<campos.length;y++)
            {
                campos[y].setText("");                
            }
            
        }
    }
    
    public static void main(String[] args) {
        
        String[] titulos = {"Clave","Fecha Inicio","Fecha Termino","Nombre","Horas","Facilitador","Capacidad"};

        Object[][] datos = {{"MV0218","13/02/2012","15/09/2015","Juan Vazquez","800","Facilitador","Capacidad"},
                            {"HZ0215","21/01/1998","24/11/2000","Hector Madrigal","4502","Facilitador","Capacidad"},
                            {"JH0478","29/08/2017","20/03/2018","Jhovannny Farrera","100","Facilitador","Capacidad"}};
        
        
        JTabb_5 jt = new JTabb_5(titulos,datos);
    }
}
