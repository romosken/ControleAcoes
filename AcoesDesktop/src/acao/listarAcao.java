/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acao;

import acoesbackend.controller.ControleAcao;
import acoesbackend.model.bean.Acao;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ProfAlexandre
 */
public class listarAcao {
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException {     
    
         String ticker = JOptionPane.showInputDialog("Entre com o Ticker");
         Acao ac = new Acao(0,ticker,"",0);
         ControleAcao acCont = new ControleAcao();
         List<Acao> acoes = acCont.listar(ac);

         for (Acao pesL : acoes) {
            JOptionPane.showMessageDialog(null, pesL.toString());
         }

    }
}
