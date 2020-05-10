
package controle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class ConexaoBD {
    
   
    // Preparar e realizar pesquisar "Statement" 
  public  Statement stm ;
    
    //guarda o que foi pesquisado 
  public  ResultSet rs ;
    
    // conectar com banco de daos
  public  Connection ctm ;
  
    
  public  String Driver = "org.postgresql.Driver";
  public  String caminho ="jdbc:mysql://localhost:3306/lojainformatica" ;
  public  String usuario = "root" ;
  public  String senha = "root";
    
    
    
    public void conexao(){
        
        System.setProperty("jdbc.Drivers", Driver);
        
        try {
         
        
            ctm= DriverManager.getConnection(caminho,usuario,senha);
            JOptionPane.showMessageDialog(null, "danco de dados conectado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"erro ao se conectar com banco de dados0 "+ ex);
        }
        
    }  
        
    public void executaSQl(String sql){
        
      try {
          stm = ctm.createStatement(rs.TYPE_SCROLL_INSENSITIVE,rs.CONCUR_READ_ONLY);
          rs = stm.executeQuery(sql);
          
          
          
      } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null,"erro ao executar sql"+ex);
      }
        
        
    }
    public void desconecta (){
        try {
            ctm.close();
            JOptionPane.showMessageDialog(null, "banco de dados desconectado");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro ao ser desconectar" + ex);
        }
        
    }

   
    
}
