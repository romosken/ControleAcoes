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
public class inserirAcao {
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
         
         
         String ticker = JOptionPane.showInputDialog("Entre com o Ticker");
         String empresa = JOptionPane.showInputDialog("Entre com a Empresa");
         double cotacao = Double.parseDouble(JOptionPane.showInputDialog("Entre com a Cotação"));
         
         Acao ac = new Acao(0,ticker,empresa,cotacao);
         ControleAcao acCont = new ControleAcao();
         ac = acCont.inserir(ac);
         JOptionPane.showMessageDialog(null, ac.toString());

    }

    
}
