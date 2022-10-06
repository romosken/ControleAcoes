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
public class buscarUsuario {
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

         int id;   
         
         id = Integer.parseInt(JOptionPane.showInputDialog("Entre com o ID"));

         Usuario us = new Usuario(id);
         ControleUsuario contUsu = new ControleUsuario();
         us = contUsu.buscar(us);
         JOptionPane.showMessageDialog(null, us.toString());
    }

    
}
