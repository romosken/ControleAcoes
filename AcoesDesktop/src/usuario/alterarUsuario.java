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
public class alterarUsuario {
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

         int id;   
         String login;
         String senha;
         String cpf;
         String nome;
         String sobrenome;
         String status;
         String tipo;
         
         id = Integer.parseInt(JOptionPane.showInputDialog("Entre com o ID"));
         login = JOptionPane.showInputDialog("Entre com o Login");
         senha = JOptionPane.showInputDialog("Entre com o Senha");
         cpf = JOptionPane.showInputDialog("Entre com o CPF");
         nome = JOptionPane.showInputDialog("Entre com o Nome");
         sobrenome = JOptionPane.showInputDialog("Entre com o Sobrenome");
         status = JOptionPane.showInputDialog("Entre com o Status");
         tipo = JOptionPane.showInputDialog("Entre com o Tipo");

         Usuario us = new Usuario(id,login,senha,cpf,nome,sobrenome,status,tipo);
         ControleUsuario usCont = new ControleUsuario();
         us = usCont.alterar(us);
         JOptionPane.showMessageDialog(null, us.toString());
    }
    
}
