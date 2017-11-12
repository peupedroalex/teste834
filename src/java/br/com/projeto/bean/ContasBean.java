/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.bean;

import br.com.projeto.dao.ContasDao;
import br.com.projeto.entity.Conta;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Objects;
import javax.faces.bean.ManagedBean;


@Named(value = "contasBean")
@ManagedBean
@SessionScoped
public class ContasBean implements Serializable {
    
    private Conta conta = new Conta();
    private ContasDao contasDao = new ContasDao();

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.conta);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ContasBean other = (ContasBean) obj;
        if (!Objects.equals(this.conta, other.conta)) {
            return false;
        }
        return true;
    }
    
    
    public ContasBean() {
    }
    
    public String adicionarConta(){
        contasDao.addConta(conta);
        conta.setNome_cliente(null);
        conta.setCpf(null);
        return "index";
    }
    public String removerConta(){
        contasDao.removeConta(conta);
        return "sucessoremove";
    }
}
