/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acoesbackend.model.bean;

/**
 *
 * @author RODRIGORICCIDEPAULAM
 */
public class Usuario {
    
    private int id;
    private String login;
    private String senha;
    private String cpf;
    private String nome;
    private String sobrenome;
    private String status;
    private String tipo;

    public Usuario(int id) {
        this.id = id;
    }

    public Usuario(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public Usuario(int id, String login, String senha, String cpf, String nome, String sobrenome, String status, String tipo) {
        this.id = id;
        this.login = login;
        this.senha = senha;
        this.cpf = cpf;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.status = status;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", login=" + login + ", senha=" + senha + ", cpf=" + cpf + ", nome=" + nome + ", sobrenome=" + sobrenome + ", status=" + status + ", tipo=" + tipo + '}';
    }
    
    
    
}
