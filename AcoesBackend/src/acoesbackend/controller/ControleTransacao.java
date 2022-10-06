/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acoesbackend.controller;

import acoesbackend.model.bean.Transacao;
import acoesbackend.model.dao.DaoTransacao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author RODRIGORICCIDEPAULAM
 */
public class ControleTransacao {
    
    static DaoTransacao daoTr;
    
    public ControleTransacao () throws SQLException, ClassNotFoundException{
        daoTr = new DaoTransacao();
    }
    
    public Transacao inserir(Transacao tr) throws SQLException, ClassNotFoundException{
        return daoTr.inserir(tr);
    }
    
    public Transacao alterar(Transacao tr) throws SQLException, ClassNotFoundException{
        return daoTr.alterar(tr);
    }
    
    public Transacao excluir(Transacao tr) throws SQLException{
        return daoTr.excluir(tr);
    }
    
    public Transacao buscar(Transacao tr) throws SQLException{
        return daoTr.buscar(tr);
    }
    
     public List<Transacao> listar (Transacao tr) throws SQLException {
       List<Transacao> transacoes = new ArrayList<>();
       transacoes=daoTr.listar(tr);
        return transacoes;
    }
}
