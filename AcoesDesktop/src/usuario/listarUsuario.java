/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuario;

import acoesbackend.controller.ControleUsuario;
import acoesbackend.model.bean.Usuario;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ProfAlexandre
 */
public class listarUsuario {
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException {     
    
           
        String nome = JOptionPane.showInputDialog("Entre com o Login");
         Usuario us = new Usuario(0,"","","",nome,"","","");
         ControleUsuario usCont = new ControleUsuario();
         List<Usuario> usuarios = usCont.listar(us);

         for (Usuario usuL : usuarios) {
            JOptionPane.showMessageDialog(null, usuL.toString());
         }
                 

    }
}
