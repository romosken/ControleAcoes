/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transacao;

import acoesbackend.controller.ControleTransacao;
import acoesbackend.model.bean.Transacao;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ProfAlexandre
 */
public class inserirTransacao {
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

         
         int idU = Integer.parseInt(JOptionPane.showInputDialog("Entre com o Id do Usuário"));
         int idA = Integer.parseInt(JOptionPane.showInputDialog("Entre com o Id da Ação"));
         String data = JOptionPane.showInputDialog("Entre com a Data");
         String tipo = JOptionPane.showInputDialog("Entre com o Tipo");
         int qtd = Integer.parseInt(JOptionPane.showInputDialog("Entre com a Quantidade"));
         double preco = Double.parseDouble(JOptionPane.showInputDialog("Entre com o Preço"));
         double taxas = Double.parseDouble(JOptionPane.showInputDialog("Entre com as Taxas"));
         String corretora = JOptionPane.showInputDialog("Entre com a Corretora");

         Transacao tr = new Transacao(0,idU,idA,data,tipo,qtd,preco,taxas,corretora);
         ControleTransacao trCont = new ControleTransacao();
         tr = trCont.inserir(tr);
         JOptionPane.showMessageDialog(null, tr.toString());

    }

    
}
