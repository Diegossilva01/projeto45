/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.modeloComputador;

/**
 *
 * @author diego
 */
public class controleComputador {
    
    modelo.modeloComputador mod = new modeloComputador();
    ConexaoBD conecta = new ConexaoBD();
    
    public void inserirComputador(modeloComputador mod){
        
       conecta.conexao();
       
        try {
            PreparedStatement pst = conecta.ctm.prepareStatement("insert into computador (marca,hd,processador) values (?,?,?)");
         
            pst.setString(1,mod.getMarca());
            pst.setString(2,mod.getHb());
            pst.setString(3,mod.getProcessador());
            pst.execute();
            JOptionPane.showMessageDialog(null,"dados inseridos");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"erro ao inserir dados "+ex);
        }
       
       
       
       
       conecta.desconecta();
        
       
    }
    
    
    public void editar(modeloComputador mod){
        
        conecta.conexao();
        
        try {
            PreparedStatement pst = conecta.ctm.prepareStatement("update computador set marca=?,hd=?,processador=?  where id_computador=?");
            pst.setString(1,mod.getMarca());
            pst.setString(2,mod.getHb());
            pst.setString(3, mod.getProcessador());
            pst.setInt(4,mod.getId_computador());
            pst.execute();
            JOptionPane.showMessageDialog(null,"dados alterados com sucesso");
            
            
        } catch (SQLException ex) {
         JOptionPane.showMessageDialog(null,"erro ao incerrir codigo" + ex);

        }
        
        
        conecta.desconecta();
        
        
    }
    
  
    public void excluir (modeloComputador mod){
        conecta.conexao();
        
        try {
            PreparedStatement pst = conecta.ctm.prepareStatement("delete from computador where id_computador=?");
            pst.setInt(1,mod.getId_computador());
            pst.execute();
            JOptionPane.showMessageDialog(null,"dados excluidos com sucesso");
        } catch (SQLException ex) {
                 JOptionPane.showMessageDialog(null,"dados  nao inceridos ");
        }
        
        
        
        
        
        conecta.desconecta();
        
        
        
        
        
    }
    
        
       public modeloComputador buscaComp(modeloComputador mod){
           conecta.conexao();
           System.out.println(mod.getPesuisar());
           conecta.executaSQl("select * from computador where marca like'%"+mod.getPesuisar()+"%'");
        try {
            conecta.rs.first();
            
             mod.setId_computador(conecta.rs.getInt("id_computador"));
             mod.setMarca(conecta.rs.getString("marca"));
             mod.setHb(conecta.rs.getString("hd"));
             mod.setProcessador(conecta.rs.getString("processador"));
            
            
            
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"dados nao encontrados");
        }
           
           
           conecta.desconecta();
           
           
           
           
           
           
    return mod;
               
           }
           
           
           
       
        
        
        
       
        
        
        
      
        
      
        
        
        
        
        
    }    
    
    
    