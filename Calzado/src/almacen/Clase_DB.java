/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package almacen;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Objects;




/**
 *
 * @author ñ
 */
public class Clase_DB {
   
    private ResultSet rs;
    private Statement estatuto;
    private Connection conexion;
    private referencia_bodega refe_bo;
    public LinkedList <referencia_bodega> linked ;
    public referencia_bodega bodega;
    public Clase_DB() {
    refe_bo = new referencia_bodega();
    linked = new LinkedList<>();
    }
    public void conectar() throws SQLException{
    try{
            Class.forName("com.mysql.jdbc.Driver"); 
		}catch(ClassNotFoundException e){
			System.out.println(e.getMessage());
		}
             conexion =  (Connection) DriverManager.getConnection("jdbc:mysql://localhost/venus","root","");
	     estatuto =  (Statement) conexion.createStatement();
	     this.rs = estatuto.executeQuery("select * FROM tipo_zapato");
    
    }
    
   //----------------------------- datos para la tabla tipo_zapato -----------------------//
	public void datos() throws SQLException{	
           
            try{
                        while(rs.next()){
				int referencia = rs.getInt("referencia");
				String nombre = rs.getString("nombre");
				String color = rs.getString("color");
				int talla = rs.getInt("talla");
				int precio = rs.getInt("precio");
                                refe_bo.agregar(referencia,nombre,color,talla,precio);
                                linked.add(refe_bo);
                                
                                this.linked = linked;
			}
                        
			estatuto.close();
			conexion.close();
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
	   }
    public void mostrar(){
        for(referencia_bodega bodega: linked){   
           this.bodega; 
        }
       
    }
    
 
    public static void main(String arg[]) throws SQLException{
    Clase_DB aplicacion = new Clase_DB();
    aplicacion.conectar();
    aplicacion.datos(); 
    aplicacion.mostrar();
      
    
        
    
    
    }
}
