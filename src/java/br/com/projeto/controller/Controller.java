
package br.com.projeto.controller;

import br.com.projeto.dao.ContasDao;
import br.com.projeto.entity.Conta;
import java.awt.event.ActionEvent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import java.util.List;
import javax.faces.model.ListDataModel;
@ManagedBean
@SessionScoped
public class Controller {
    
    private Conta conta;
    private DataModel listaConta;

    public Conta getConta() {
        if(this.conta==null){
            this.conta = new Conta();
        }
        return conta;
    }

    
    public void setConta(Conta conta) {
        this.conta = conta;
    }
    public DataModel getListaConta(){
        List<Conta> lista = new ContasDao().list();
        listaConta = new ListDataModel(lista);
        return listaConta;
    }
    
    public void prepararAdicionar(ActionEvent action){
        conta = new Conta();
    }
    public void prepararAlterarConta(ActionEvent action){
        conta = (Conta)(listaConta.getRowData());
    }
    public void adicionar(ActionEvent action){
        ContasDao dao = new ContasDao();
        dao.addConta(conta);
    }
    public void alterar(ActionEvent action){
        ContasDao dao = new ContasDao();
        dao.atualizarConta(conta);
    }
    public String excluir(){
        Conta conta = (Conta)(listaConta.getRowData());
        ContasDao dao = new ContasDao();
        dao.removeConta(conta);
        return "index";
    }
}
