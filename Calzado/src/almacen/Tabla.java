

package almacen;


import java.util.LinkedList;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;


public class Tabla implements TableModel{
   public Clase_DB objeto;
  
    @Override
    public int getRowCount() {
      // debe retornar la cantidade de objetos o registros
       return 5; 
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public String getColumnName(int i) {
        
        switch(i){
            case 0:
                return "Referencia";
            case 1:
                return "Nombre";
            case 2:
                return "Color";
            case 3:
                return "Talla";
            case 4:
                return "Precio";
        }
        return null;
    }

    @Override
    public Class<?> getColumnClass(int i) {
     switch (i){
        case 0:
        return Integer.class;
        case 1:
        return String.class;
        case 2:
        return String.class;
        default:
        case 3:
        return Integer.class;
        case 4: 
        return Integer.class; 
        
}
    
    }

    @Override
    public boolean isCellEditable(int i, int i1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getValueAt(int i, int i1) {
        // retorna y muestra los datos en cada celda
     
       switch(i1){   
          
           case 0: 
              return objeto.mostrar().get_referencia();
           case 1:
              return objeto.mostrar().get_nombre();
           case 2:
              return objeto.mostrar().get_color();
           case 3:
              return objeto.mostrar().get_talla();
           case 4:
              return objeto.mostrar().get_precio();
       }
       i++;
       return null;
        
        }

    @Override
    public void setValueAt(Object o, int i, int j) {
            // debe de poner cada valor en cada celda pero no las muestra eso le pertenece al getValueAt
        objeto = new Clase_DB();
        //o = objeto.bodega[i];
       o = objeto.mostrar();
            switch(j){
                case 1:
                   objeto.mostrar().get_referencia();
                case 2:
                    objeto.mostrar().get_nombre();
                case 3:
                    objeto.mostrar().get_color();
                case 4:
                    objeto.mostrar().get_talla();
                case 5:
                    objeto.mostrar().get_precio();
            }
            i++;
    }

    @Override
    public void addTableModelListener(TableModelListener tl) {
    }

    @Override
    public void removeTableModelListener(TableModelListener tl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
   
  
    
    

    
}
