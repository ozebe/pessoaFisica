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
public abstract class Pessoa {

    private Endereco endereco;
    private Contato contato;
    
    
    public Pessoa(Endereco endereco, Contato contato) {
        this.endereco = endereco;
        this.contato = contato;
    }

    
}
