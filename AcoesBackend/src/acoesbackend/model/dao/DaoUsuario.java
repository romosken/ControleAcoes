/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acoesbackend.model.dao;

import acoesbackend.model.bean.Usuario;
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
public class DaoUsuario {
    
    private final Connection con;
    
    public DaoUsuario() throws SQLException, ClassNotFoundException{
        this.con = new ConexaoBD().getConnection();
    } 
    
    public Usuario validar(Usuario us) throws SQLException{
        
        // cria o select para ser executado no banco de dados 
        String sql = "select * from usuarios WHERE login = ? AND senha = ?";
        // prepared statement para seleção
        PreparedStatement stmt = this.con.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,us.getLogin());
        stmt.setString(2,us.getSenha());
        // executa
        ResultSet rs = stmt.executeQuery();
        // percorrendo o rs
        Usuario retorno = null;
        while (rs.next()) {      
            // criando o objeto Usuario
            retorno = new Usuario(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7),
                    rs.getString(8)
            );
            // adiciona o usu à lista de usus
        }
        stmt.close();
        con.close();
        return retorno;  
    }
    
    public Usuario inserir(Usuario us) throws SQLException{
        
           String sql = "insert into usuarios" + " (login, senha,cpf, nome, sobrenome, status, tipo)" + " values (?,?,?,?,?,?,?)";
    
        // prepared statement para inserção
        PreparedStatement stmt = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        stmt.setString(1,us.getLogin());
        stmt.setString(2,us.getSenha());
        stmt.setString(3,us.getCpf());
        stmt.setString(4,us.getNome());
        stmt.setString(5,us.getSobrenome());
        stmt.setString(6,us.getStatus());
        stmt.setString(7,us.getTipo());
      

        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            us.setId(id);
        }
        stmt.close();
        con.close();
        return us;  
    }
    
    public Usuario alterar(Usuario us) throws SQLException{
        
         String sql = "UPDATE usuarios SET login = ?, senha = ?, cpf=?, nome=?, sobrenome=?, status = ?, tipo = ? WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = con.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,us.getLogin());
        stmt.setString(2,us.getSenha());
        stmt.setString(3,us.getCpf());
        stmt.setString(4,us.getNome());
        stmt.setString(5,us.getSobrenome());
        stmt.setString(6,us.getStatus());
        stmt.setString(7,us.getTipo());
        stmt.setInt(8,us.getId());

        // executa
        stmt.execute();
        stmt.close();
        return us;  
    }
    
    public Usuario excluir(Usuario us) throws SQLException{
        
      String sql = "delete from usuarios WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = con.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,us.getId());
        // executa
        stmt.execute();
        stmt.close();
        con.close();
        return us; 
    }
    
    public Usuario buscar(Usuario us) throws SQLException{
        
       String sql = "select * from usuarios WHERE id = ?";
        PreparedStatement stmt = this.con.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1, us.getId());
            // executa
            ResultSet rs = stmt.executeQuery();
            Usuario retorno = null;
            while (rs.next()) {      
            // criando o objeto Usuario
                retorno = new Usuario(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7),
                    rs.getString(8)
                );
            // adiciona o usu à lista de usus
            }
            stmt.close();
            con.close();
            return retorno; 
    }
    
    public List<Usuario> listar(Usuario us) throws SQLException{
        
        // usus: array armazena a lista de registros
        List<Usuario> usuarios = new ArrayList<>();
        
        String sql = "select * from usuarios where nome like ?";
        PreparedStatement stmt = this.con.prepareStatement(sql);
        
        stmt.setString(1,"%"+us.getNome()+"%");
      
        ResultSet rs = stmt.executeQuery();
        
        
        while (rs.next()) {      
            // criando o objeto Usuario
            Usuario usSaida = new Usuario(
                rs.getInt(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4),
                rs.getString(5),
                rs.getString(6),
                rs.getString(7),
                rs.getString(8)
            );
            // adiciona o usu à lista de usus
            usuarios.add(usSaida);
        }
        
        rs.close();
        stmt.close();
        return usuarios; 
    }
}
