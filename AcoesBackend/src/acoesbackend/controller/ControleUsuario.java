/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acoesbackend.controller;

import acoesbackend.model.bean.Usuario;
import acoesbackend.model.dao.DaoUsuario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author RODRIGORICCIDEPAULAM
 */
public class ControleUsuario {
    
    static DaoUsuario daoUs;
    
    public ControleUsuario () throws SQLException, ClassNotFoundException{
        daoUs = new DaoUsuario();
    }
    
    public Usuario validar(Usuario us) throws SQLException{
        return daoUs.validar(us);
    }
    
    public Usuario inserir(Usuario us) throws SQLException{
        return daoUs.inserir(us);
    }
    
    public Usuario alterar(Usuario us) throws SQLException{
        return daoUs.alterar(us);
    }
    
    public Usuario excluir(Usuario us) throws SQLException{
        return daoUs.excluir(us);
    }
    
    public Usuario buscar(Usuario us) throws SQLException{
        return daoUs.buscar(us);
    }
    
     public List<Usuario> listar (Usuario us) throws SQLException {
       List<Usuario> usuarios = new ArrayList<>();
       usuarios=daoUs.listar(us);
        return usuarios;
    }
}
