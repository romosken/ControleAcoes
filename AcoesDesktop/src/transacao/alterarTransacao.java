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
public class alterarTransacao {
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

         int id = Integer.parseInt(JOptionPane.showInputDialog("Entre com o Id")); 
         int idU = Integer.parseInt(JOptionPane.showInputDialog("Entre com o IdUsuario"));
         int idP = Integer.parseInt(JOptionPane.showInputDialog("Entre com o IdPessoa"));
         String data = JOptionPane.showInputDialog("Entre com a Data");
         String tipo = JOptionPane.showInputDialog("Entre com o Tipo");
         int qtd = Integer.parseInt(JOptionPane.showInputDialog("Entre com a Quantidade"));
         double preco = Double.parseDouble(JOptionPane.showInputDialog("Entre com o Preço"));
         double taxas = Double.parseDouble(JOptionPane.showInputDialog("Entre com as Taxas"));
         String corretora = JOptionPane.showInputDialog("Entre com a Corretora");

         Transacao tr = new Transacao(id,idU,idP,data,tipo,qtd,preco,taxas,corretora);
         ControleTransacao trCont = new ControleTransacao();
         tr = trCont.alterar(tr);
         JOptionPane.showMessageDialog(null, tr.toString());

    }
    
}
