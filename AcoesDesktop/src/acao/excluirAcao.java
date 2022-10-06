/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acao;

import acoesbackend.controller.ControleAcao;
import acoesbackend.model.bean.Acao;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ProfAlexandre
 */
public class excluirAcao {
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
         
         int id = Integer.parseInt(JOptionPane.showInputDialog("Entre com o ID"));
         Acao ac = new Acao(id);
         ControleAcao acCont = new ControleAcao();
         ac = acCont.excluir(ac);
         JOptionPane.showMessageDialog(null, ac.toString());

    }
    
}
