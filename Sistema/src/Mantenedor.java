

import java.sql.*; //trae todas las librerias
import javax.swing.JOptionPane;




public class Mantenedor {
    Connection conexion = null;
    Statement sentencia = null;
   
    
    public void MetodoConexion() {
    
    try{
    Class.forName("org.sqlite.JDBC");
    conexion =DriverManager.getConnection("jdbc:sqlite:empresa.sqlite");
      JOptionPane.showMessageDialog(null, "Conexion Exitosa ;) " );
}
    
    catch(Exception e ){
      JOptionPane.showMessageDialog(null, "Error:" + e);
    System.exit(0);
    
    
}
       
    
    }
  /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////  
    
    
    
    
    public void MetodoCreaTabla() {
        try{
            Class.forName("org.sqlite.JDBC");
            conexion =DriverManager.getConnection("jdbc:sqlite:empresa2.sqlite");
       
            sentencia =conexion.createStatement();
         
            String sql = "CREATE TABLE CLIENTE2"+
                      "(ID INT PRIMARY KEY NOT NULL,"+
                      "NOMBRE TEXT NOT NULL,"+
                      "APELLIDO TEXT NOT NULL,"+
                      "EDAD INT);";
            sentencia.executeUpdate(sql);
            sentencia.close();
            conexion.close();
         
            JOptionPane.showMessageDialog(null, "Exito!! :)" );
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error:" + e);
        }  
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////
    public void MetodoInsertar(String c1, String c2, String c3, String c4){
        try{
        Class.forName("org.sqlite.JDBC");
        conexion =DriverManager.getConnection("jdbc:sqlite:empresa2.sqlite");
        //conexion.setAutoCommit(false);
        
        int caja1 = Integer.parseInt(c1);
        int caja4 = Integer.parseInt(c4);
        
         sentencia= conexion.createStatement();
         String sql = "INSERT INTO CLIENTE2(ID, NOMBRE, APELLIDO, EDAD)"+
                    "VALUES("+caja1+", '"+c2+"', '"+c3+"', "+caja4+");";
         
         sentencia.executeUpdate(sql);
         sentencia.close();
         //conexion.commit();
         
         conexion.close();
          JOptionPane.showMessageDialog(null, "EXITO al insertar :v " );
        }
        
        
        
        catch(Exception e){
          JOptionPane.showMessageDialog(null, "Error:" + e);
        }
        
    }
    
    ////////////////////////////////////////////////////////////////////
    public void MetodoMostrarDatos(){
        try{
             Class.forName("org.sqlite.JDBC");
             conexion =DriverManager.getConnection("jdbc:sqlite:empresa2.sqlite");
             //conexion.setAutoCommit(false);
             sentencia= conexion.createStatement();
             ResultSet resultado = sentencia.executeQuery("SELECT * FROM CLIENTE2");
             
             while(resultado.next()) //BUCLE
             {
                 int id = resultado.getInt("ID");
                 String nombre = resultado.getString("NOMBRE");
                 String apellido = resultado.getString("APELLIDO");
                 int edad = resultado.getInt("EDAD");
                 
                  JOptionPane.showMessageDialog(null, id +" "+ nombre +" "+ apellido +" "+ edad);
                 
                
             }
                 resultado.close(); 
                 sentencia.close();
                 conexion.close();
                 
            
        }
        catch(Exception e){
            
            JOptionPane.showMessageDialog(null, "Error:" + e);
            
        }
    }
    
    //////////////////////////////////////////////////////////////////////////////////////////////
    
    public void MetodoActualizar(String c1, String c2, String c3, String c4){
        try{
            
        
         Class.forName("org.sqlite.JDBC");
             conexion =DriverManager.getConnection("jdbc:sqlite:empresa2.sqlite");
             //conexion.setAutoCommit(false);
             sentencia= conexion.createStatement();
            int caja1 = Integer.parseInt(c1);
            int caja4 = Integer.parseInt(c4);
             
             String SQL ="UPDATE CLIENTE2 SET Nombre='"+c2+"', APELLIDO ='"+c3+"', EDAD="+caja4+" WHERE ID="+caja1+"";
             sentencia.executeUpdate(SQL);
           //  conexion.commit();
             conexion.close();
              
             JOptionPane.showMessageDialog(null, "Exito al Actualizar >:v " );
             
             
        }
        
        
        catch(Exception e){
          
        }      
        
    }
    
    
  public void MetodoEliminar(String c1){
        try{
        Class.forName("org.sqlite.JDBC");
        conexion =DriverManager.getConnection("jdbc:sqlite:empresa2.sqlite");
        //conexion.setAutoCommit(false);
        
        int caja1 = Integer.parseInt(c1);
       
         sentencia= conexion.createStatement();
         String sql = "DELETE FROM CLIENTE2 WHERE ID = "+caja1+" " ;
         
         sentencia.executeUpdate(sql);
         sentencia.close();
         //conexion.commit();
         
         conexion.close();
          JOptionPane.showMessageDialog(null, "Exito al eliminar >:v " );
        }
        
        
        
        catch(Exception e){
          JOptionPane.showMessageDialog(null, "Error:" + e);
        }
        
    }  
    
    
    
}
