
package br.com.projeto.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "contas")
public class Conta implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID;
    @Column
    private String nome_cliente;
    @Column
    private double saldo;
    @Column
    private String cpf;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNome_cliente() {
        return nome_cliente;
    }

    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.ID;
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
        final Conta other = (Conta) obj;
        if (this.ID != other.ID) {
            return false;
        }
        return true;
    }

    public Conta() {
    }

    public Conta(int ID, String nome_cliente, double saldo, String cpf) {
        this.ID = ID;
        this.nome_cliente = nome_cliente;
        this.saldo = saldo;
        this.cpf = cpf;
    }
    
    
}
