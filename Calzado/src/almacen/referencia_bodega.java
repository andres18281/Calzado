/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package almacen;

/**
 *
 * @author familia_
 */
public class referencia_bodega {
    public int referencia;
    public String nombre;
    public String color;
    public int talla;
    public int precio;

   public void agregar(int referencia,String nombre,String color,int talla,int precio){
    this.referencia = referencia; 
    this.nombre = nombre;
    this.color = color;
    this.talla = talla;
    this.precio = precio;
   }
   public void set_referencia(int referencia){
    this.referencia = referencia;
   }
   public void set_nombre(String nombre){
    this.nombre = nombre;   
   }
   public void set_color(String color){
    this.color = color;
   }
   public void set_talla(int talla){
    this.talla = talla;
   }
   public void set_precio(int precio){
    this.precio = precio;
   }
   
   public int get_referencia(){
       return referencia;
   }
   public String get_nombre(){
       return nombre;
   }
   public String get_color(){
       return color;
   }
   public int get_talla(){
       return talla;
   }
   public int get_precio(){
       return precio;
   }
}
