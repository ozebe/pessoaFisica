/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

/**
 *
 * @author wesley.santos
 */
public class Profissao {
    private int id;
    private int tipoProfissaoId;
    private int salario;
    private String admissao;
    private String criado;
    private String editado;
    
    public Profissao() {
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public String getAdmissao() {
        return admissao;
    }

    public void setAdmissao(String admissao) {
        this.admissao = admissao;
    }

    public String getCriado() {
        return criado;
    }

    public void setCriado(String criado) {
        this.criado = criado;
    }

    public String getEditado() {
        return editado;
    }

    public void setEditado(String editado) {
        this.editado = editado;
    }
}   
