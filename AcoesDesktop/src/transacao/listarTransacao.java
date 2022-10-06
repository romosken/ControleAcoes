/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transacao;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import acoesbackend.controller.ControleTransacao;
import acoesbackend.model.bean.Transacao;

/**
 *
 * @author ProfAlexandre
 */
public class listarTransacao {
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException {     
    
         String data = JOptionPane.showInputDialog("Entre com a Data");
         Transacao tr = new Transacao(0,0,0,"",data,"",0,0,0,0,0,0,"");
         ControleTransacao trCont = new ControleTransacao();
         List<Transacao> transacoes = trCont.listar(tr);

         for (Transacao usupesL : transacoes) {
            JOptionPane.showMessageDialog(null, usupesL.toString());
         }
                 

    }
}
