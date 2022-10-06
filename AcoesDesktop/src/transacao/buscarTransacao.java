/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transacao;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import acoesbackend.controller.ControleTransacao;
import acoesbackend.model.bean.Transacao;

/**
 *
 * @author ProfAlexandre
 */
public class buscarTransacao {
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
            
         int id = Integer.parseInt(JOptionPane.showInputDialog("Entre com o ID"));
         Transacao tr = new Transacao(id);
         ControleTransacao trCont = new ControleTransacao();
         tr = trCont.buscar(tr);
         JOptionPane.showMessageDialog(null, tr.toString());
    }

    
}
