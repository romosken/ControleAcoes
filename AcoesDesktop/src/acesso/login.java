/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acesso;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import acoesbackend.controller.ControleUsuario;
import acoesbackend.model.bean.Usuario;
import transacao.buscarTransacao;

/**
 *
 * @author ProfAlexandre
 */
public class login {
    
    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

         String login;
         String senha;
         
         login = JOptionPane.showInputDialog("Entre com o Login");
         senha = JOptionPane.showInputDialog("Entre com o Senha");
         Usuario us = new Usuario(login,senha);
         ControleUsuario usCont = new ControleUsuario();
         us = usCont.validar(us);
        
    }
    
}
