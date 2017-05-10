/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelDao;

import ModelBeans.BeansOrgao;
import ModelConection.ConexaoBD;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ander
 */
public class OrgaoDao {
    
     ConexaoBD conex = new ConexaoBD();
     BeansOrgao mod = new BeansOrgao();
     
     public void salvar(BeansOrgao mod){
         conex.conexao();
         
         try {
            PreparedStatement pst = conex.con.prepareStatement("INSERT INTO orgao(nome, senha) VALUES ( ?, ?);");
            pst.setString(1, mod.getNome());
            pst.setString(2,mod.getSenha());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso!!!");
         } catch (SQLException ex) {
              JOptionPane.showMessageDialog(null, "nao foi possivel salvar (orgaoDao) \n" + ex);
         }
         conex.desconecta();
     }
     
     public void editar(BeansOrgao mod){
        
         conex.conexao();
         
         try {
             PreparedStatement pst = conex.con.prepareStatement("UPDATE orgao SET nome=?, senha=? WHERE id=?;");
             pst.setString(1, mod.getNome());
             pst.setString(2, mod.getSenha());
             pst.setInt(3, mod.getCodigo());
             pst.execute();
              JOptionPane.showMessageDialog(null, "Dados alterados com sucesso!!!");
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "nao foi possivel alterar os dados (orgaoDao)\n" + ex);
         }
         conex.desconecta();
    }
     
     public void excluir(BeansOrgao mod){
         conex.conexao();
            
         try {
             PreparedStatement pst = conex.con.prepareCall("DELETE FROM orgao WHERE id=? ;");
             pst.setInt(1, mod.getCodigo());
              pst.execute();
            JOptionPane.showMessageDialog(null, "Dados deletados com sucesso!!!");
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "nao foi possivel excluir os dados (feedDeNoticiaDao) \n" + ex);
         }
         
         conex.desconecta();
     }
    
}
