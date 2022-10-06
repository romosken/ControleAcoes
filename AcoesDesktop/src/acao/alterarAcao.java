/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acao;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import acoesbackend.controller.ControleAcao;
import acoesbackend.model.bean.Acao;

/**
 *
 * @author ProfAlexandre
 */
public class alterarAcao {
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
         
         int id = Integer.parseInt(JOptionPane.showInputDialog("Entre com o ID"));
         String ticker = JOptionPane.showInputDialog("Entre com o Ticker");
         String empresa = JOptionPane.showInputDialog("Entre com a Empresa");
         double cotacao = Double.parseDouble(JOptionPane.showInputDialog("Entre com a Cotação"));
         
         Acao ac = new Acao(id,ticker,empresa,cotacao);
         ControleAcao acCont = new ControleAcao();
         ac = acCont.alterar(ac);
         JOptionPane.showMessageDialog(null, ac.toString());

    }
    
}
