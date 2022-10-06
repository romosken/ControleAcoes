/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acoesbackend.model.dao;

import acoesbackend.model.bean.Acao;
import acoesbackend.model.bean.Transacao;
import acoesbackend.util.ConexaoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author RODRIGORICCIDEPAULAM
 */
public class DaoTransacao {
    
    private final Connection con;
    
    public DaoTransacao() throws SQLException, ClassNotFoundException{
        this.con = new ConexaoBD().getConnection();
    }
    
    public Transacao inserir(Transacao tr) throws SQLException, ClassNotFoundException{
        
        String sql = "insert into transacoes" + " (idUsuario, idAcao, papel, data, tipo, quantidade, preco,taxas,valorOperacao,valorLiquido,lucro,corretora)" + " values (?,?,?,?,?,?,?,?,?,?,?,?)";
    
        // prepared statement para inserção
        PreparedStatement stmt = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        stmt.setInt(1,tr.getIdU());
        stmt.setInt(2,tr.getIdA());
        stmt.setString(3,tr.getPapel());
        stmt.setString(4,tr.getData());
        stmt.setString(5,tr.getTipo());
        stmt.setInt(6,tr.getQtd());
        stmt.setDouble(7,tr.getPreco());
        stmt.setDouble(8,tr.getTaxas());
        stmt.setDouble(9,tr.getValorOpe());
        stmt.setDouble(10,tr.getValorLiq());
        stmt.setDouble(11,tr.getLucro());
        stmt.setString(12,tr.getCorretora());
       
        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            tr.setId(id);
        }
        stmt.close();
        con.close();
        return tr;
    }
    
    public Transacao alterar(Transacao tr) throws SQLException, ClassNotFoundException{
        
        String sql = "UPDATE transacoes SET idUsuario=?, idAcao=?, papel=?, data=?, tipo=?, quantidade=?, preco=?, taxas=?,valorOperacao=?,valorliquido=?, lucro=?,corretora=? WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = con.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,tr.getIdU());
        stmt.setInt(2,tr.getIdA());
        stmt.setString(3,tr.getPapel());
        stmt.setString(4,tr.getData());
        stmt.setString(5,tr.getTipo());
        stmt.setInt(6,tr.getQtd());
        stmt.setDouble(7,tr.getPreco());
        stmt.setDouble(8,tr.getTaxas());
        stmt.setDouble(9,tr.getValorOpe());
        stmt.setDouble(10,tr.getValorLiq());
        stmt.setDouble(11,tr.getLucro());
        stmt.setString(12,tr.getCorretora());
        stmt.setInt(13,tr.getId());

        // executa
        stmt.execute();
        stmt.close();
        return tr;
    }
    
    public Transacao excluir(Transacao tr) throws SQLException{
        
        String sql = "delete from transacoes WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = con.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,tr.getId());
        // executa
        stmt.execute();
        stmt.close();
        con.close();
        return tr; 
    }
    
    public Transacao buscar(Transacao tr) throws SQLException{
        
        String sql = "select * from transacoes WHERE id = ?";
        PreparedStatement stmt = this.con.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1,tr.getId());
            // executa
            ResultSet rs = stmt.executeQuery();
            Transacao retorno = null;
            while (rs.next()) {      
            // criando o objeto Usuario
                retorno = new Transacao(
                    rs.getInt(1),    
                    rs.getInt(2),
                    rs.getInt(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getInt(7),
                    rs.getDouble(8),
                    rs.getDouble(9),
                    rs.getDouble(10),
                    rs.getDouble(11),
                    rs.getDouble(12),
                    rs.getString(13)
                );
            // adiciona o usu à lista de usus
            }
            stmt.close();
            con.close();
            return retorno;
    }
    
    public List<Transacao> listar(Transacao tr) throws SQLException{
        
       
        List<Transacao> transacoes = new ArrayList<>();
        
        String sql = "select * from transacoes WHERE data like ?";
        
     
        PreparedStatement stmt = this.con.prepareStatement(sql);
        stmt.setString(1, "%"+tr.getData()+"%");
        
        
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Usuario
            Transacao trSaida = new Transacao(
                rs.getInt(1),    
                rs.getInt(2),
                rs.getInt(3),
                rs.getString(4),
                rs.getString(5),
                rs.getString(6),
                rs.getInt(7),
                rs.getDouble(8),
                rs.getDouble(9),
                rs.getDouble(10),
                rs.getDouble(11),
                rs.getDouble(12),
                rs.getString(13)
            );
            // adiciona o usu à lista de usus
            transacoes.add(trSaida);
        }
        
        rs.close();
        stmt.close();
        return transacoes;
    }
    
     public Acao buscarPapel(Transacao tr) throws SQLException{
        
        String sql = "select * from acoes WHERE id = ?";
        PreparedStatement stmt = this.con.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1,tr.getIdA());
            // executa
            ResultSet rs = stmt.executeQuery();
            Acao retorno = null;
            while (rs.next()) {      
            // criando o objeto Usuario
                retorno = new Acao(
                    rs.getInt(1),   
                    rs.getString(2),
                    rs.getString(3),
                    rs.getDouble(4)
                );
            // adiciona o usu à lista de usus
            }
            stmt.close();
            con.close();
            return retorno;
    }
}
