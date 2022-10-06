/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acoesbackend.controller;

import acoesbackend.model.bean.Acao;
import acoesbackend.model.dao.DaoAcao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author RODRIGORICCIDEPAULAM
 */
public class ControleAcao {
    
    static DaoAcao daoAc;
    
    public ControleAcao () throws SQLException, ClassNotFoundException{
        daoAc = new DaoAcao();
    }
    
    public Acao inserir(Acao ac) throws SQLException{
        return daoAc.inserir(ac);
    }
    
    public Acao alterar(Acao ac) throws SQLException{
        return daoAc.alterar(ac);
    }
    
    public Acao excluir(Acao ac) throws SQLException{
        return daoAc.excluir(ac);
    }
    
    public Acao buscar(Acao ac) throws SQLException{
        return daoAc.buscar(ac);
    }
    
     public List<Acao> listar (Acao ac) throws SQLException {
       List<Acao> acoes = new ArrayList<>();
       acoes = daoAc.listar(ac);
        return acoes;
    }
    
}
