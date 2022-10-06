/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acoesbackend.model.dao;

import acoesbackend.model.bean.Acao;
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
public class DaoAcao {
    
    private final Connection con;
    
    public DaoAcao() throws SQLException, ClassNotFoundException{
        this.con = new ConexaoBD().getConnection();
    } 
    
    public Acao inserir(Acao ac) throws SQLException{
        
        String sql = "insert into acoes" + " (ticker, empresa, cotacao)" + " values (?,?,?)";
    
        // prepared statement para inserção
        PreparedStatement stmt = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        stmt.setString(1,ac.getTicker());
        stmt.setString(2,ac.getEmpresa());
        stmt.setDouble(3,ac.getCotacao());
       
        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            ac.setId(id);
        }
        stmt.close();
        con.close();
        return ac;
    }
    public Acao alterar(Acao ac) throws SQLException{
        
        String sql = "UPDATE acoes SET ticker = ?, empresa = ?, cotacao = ? WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = con.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,ac.getTicker());
        stmt.setString(2,ac.getEmpresa());
        stmt.setDouble(3,ac.getCotacao());
        stmt.setInt(4,ac.getId());

        // executa
        stmt.execute();
        stmt.close();
        return ac;
    }
    public Acao excluir(Acao ac) throws SQLException{
        
        String sql = "delete from acoes WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = con.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,ac.getId());
        // executa
        stmt.execute();
        stmt.close();
        con.close();
        return ac; 
    }
    public Acao buscar(Acao ac) throws SQLException{
        
        String sql = "select * from acoes WHERE id = ?";
        PreparedStatement stmt = this.con.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1, ac.getId());
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
    public List<Acao> listar(Acao ac) throws SQLException{
        
        // usus: array armazena a lista de registros
        List<Acao> acoes = new ArrayList<>();
        
        String sql = "select * from acoes where ticker like ?";
        PreparedStatement stmt = this.con.prepareStatement(sql);
        // seta os valores
        stmt.setString(1, "%"+ac.getTicker() + "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Usuario
            Acao acSaida = new Acao(
                rs.getInt(1),
                rs.getString(2),
                rs.getString(3),
                rs.getDouble(4)
            );
            // adiciona o usu à lista de usus
            acoes.add(acSaida);
        }
        
        rs.close();
        stmt.close();
        return acoes;
    }
}
