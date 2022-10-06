/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuario;

import acoesbackend.controller.ControleUsuario;
import acoesbackend.model.bean.Usuario;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ProfAlexandre
 */
public class inserirUsuario {
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        String login = JOptionPane.showInputDialog("Entre com o Login");
        String senha = JOptionPane.showInputDialog("Entre com o Senha");
        String cpf = JOptionPane.showInputDialog("Entre com o CPF");
        String nome = JOptionPane.showInputDialog("Entre com o Nome");
        String sobrenome = JOptionPane.showInputDialog("Entre com o Sobrenome");
        String status = JOptionPane.showInputDialog("Entre com o Status");
        String tipo = JOptionPane.showInputDialog("Entre com o Tipo");

         Usuario us = new Usuario(0,login,senha,cpf,nome,sobrenome,status,tipo);
         ControleUsuario usCont = new ControleUsuario();
         us = usCont.inserir(us);
         JOptionPane.showMessageDialog(null, us.toString());

    }

    
}
