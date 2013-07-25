

package almacen;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


 //@version 1.0
 //@author familia_
 
public  class Almacen  {
private JButton btn_a_refer,btn_agre_ped,btn_vent,btn_hist_vent; 
public DefaultTableModel modelo;
public JTable tabla;
public JPanel panel_central;
private JDialog ventana1,ventana2,ventana3,ventana4;
private JFrame frame; 
public Almacen(){
  
   }
   public void mostrar(){
    
    btn_a_refer = new JButton("Referencias");
    btn_agre_ped = new JButton("Agregar nuevo pedido");
    btn_vent = new JButton("Venta");
    btn_hist_vent = new JButton("Historia de Venta");
    
    frame = new JFrame();
    //frame.setLayout(new BorderLayout());
    Container contenedor1 = new Container();
    contenedor1.add(btn_a_refer);
    contenedor1.add(btn_agre_ped);
    contenedor1.add(btn_vent);
    contenedor1.add(btn_hist_vent);
    contenedor1.setLayout(new BoxLayout(contenedor1,BoxLayout.Y_AXIS));
    frame.add(contenedor1,BorderLayout.WEST); // Contenedor izquierdo
    frame.setVisible(true);
   
     
    btn_a_refer.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
            ventana_1();
           }
       });
        btn_agre_ped.addActionListener(new ActionListener() {

           @Override
           public void actionPerformed(ActionEvent e) {
               ventana_2();
           }
       });
        btn_vent.addActionListener(new ActionListener() {

           @Override
           public void actionPerformed(ActionEvent e) {
               ventana_3();
           }
       });
        btn_hist_vent.addActionListener(new ActionListener() {

           @Override
           public void actionPerformed(ActionEvent e) {
               ventana_4();
           }
       });
        
    
    frame.setVisible(true);
    frame.setSize(400,500);
    
   }
   
   public void ventana_1(){
       ventana1 = new JDialog(frame,"Tablas de referencia");
       ventana1.setSize(400,300);
       Tabla modelo = new Tabla();
       tabla = new JTable(modelo);
       JScrollPane scroll = new JScrollPane(tabla);
       ventana1.add(scroll);
       //ventana1.setVisible(true);
       Clase_DB e = new Clase_DB(); 
     
       JOptionPane.showMessageDialog( null, e.bodega.get_referencia() , "Título", JOptionPane.PLAIN_MESSAGE,null);
   }
   public void ventana_2(){
       ventana2 = new JDialog(frame,"Agregar Pedido");
       ventana2.setSize(400,500);
       ventana2.setVisible(true);
       JLabel l1,l2,l3;
       l1 = new JLabel("Agregar ID de pedido"); 
       l2 = new JLabel("Agregar Referencia"); 
       l3 = new JLabel("Agregar Cantidad");
       JTextField id_compra,referencia,cantidad;
       JButton b1 = new JButton("Agregar");
       id_compra = new JTextField(4);
       referencia = new JTextField(5);
       cantidad = new JTextField(2);
       Container contenedor = new Container();
       contenedor.setLayout(new FlowLayout());
       contenedor.add(l1);
       contenedor.add(id_compra);
       contenedor.add(l2);
       contenedor.add(referencia);
       contenedor.add(l3);
       contenedor.add(cantidad);
       contenedor.add(b1);
       ventana2.add(contenedor,BorderLayout.NORTH);
       modelo = new DefaultTableModel();
       tabla = new JTable(modelo);
       modelo.addColumn("ID Compra");
       modelo.addColumn("Referencia");
       modelo.addColumn("Cantidad");
       JScrollPane scroll = new JScrollPane(tabla);
       ventana2.add(scroll,BorderLayout.CENTER);
   }
   public void ventana_3(){
   ventana3 = new JDialog(frame,"Registrar Venta");
   ventana3.setSize(400,300);
   ventana3.setVisible(true);
   JLabel l2,l3; 
   l2 = new JLabel("Agregar Referencia"); 
   l3 = new JLabel("Agregar Cantidad");
   JTextField referencia,cantidad;

   JButton b1 = new JButton("Agregar");
   referencia = new JTextField(5);
   cantidad = new JTextField(2);
   Container contenedor = new Container();
   contenedor.setLayout(new FlowLayout());
   contenedor.add(l2);
   contenedor.add(referencia);
   contenedor.add(l3);
   contenedor.add(cantidad);
   contenedor.add(b1);
   Date now = new Date();
   DateFormat df = DateFormat.getDateInstance();
   String s = df.format(now);
   
   
   ventana3.add(contenedor,BorderLayout.NORTH);
   modelo = new DefaultTableModel();
   tabla = new JTable(modelo);
   modelo.addColumn("ID venta");
   modelo.addColumn("Referencia");
   modelo.addColumn("Cantidad");
   modelo.addColumn("Fecha de Venta");
   
   JScrollPane scroll = new JScrollPane(tabla);
   ventana3.add(scroll,BorderLayout.CENTER);
   }
    
   public void ventana_4(){
   ventana4 = new JDialog(frame,"Historial de Ventas");
   ventana4.setSize(400,300);
   ventana4.setVisible(true);
   modelo = new DefaultTableModel();
   tabla = new JTable(modelo);
   modelo.addColumn("Contador");
   modelo.addColumn("Referencia");
   modelo.addColumn("Cantidad");
   modelo.addColumn("Descripcion");
   modelo.addColumn("Fecha de venta");
   
   JScrollPane scroll = new JScrollPane(tabla);
   ventana4.add(scroll);
   }
  
   
  
    public static void main(String[] args) {
    Almacen aplicacion = new Almacen();
    aplicacion.mostrar();
   
    
    
    
    
    }

    

  

  
}
