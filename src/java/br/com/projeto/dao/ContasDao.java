
package br.com.projeto.dao;

import br.com.projeto.entity.Conta;
import br.com.projeto.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class ContasDao {
    private Session sessao;
    private Transaction trans;
    public List <Conta> list;
    
    public Conta getConta(int id){
        sessao = HibernateUtil.getSessionFactory().getCurrentSession();
        return (Conta) sessao.load(Conta.class,id);
    }
    public void addConta(Conta c){
        try {
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        
//        Conta conta = new Conta();
//        conta.setNome_cliente(c.getNome_cliente());
//        conta.setSaldo(c.getSaldo());
//        conta.setCpf(c.getCpf());
            try {
            sessao.save(c);
            trans.commit();  
            } catch (Exception e) {
                if(trans !=null){
                    trans.rollback();
                }
                throw e;
            }
       
        
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            sessao.close();
        }
    }
    public void removeConta(Conta c){
        try {
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        sessao.delete(c);
        trans.commit();
        
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            sessao.close();
        }
    }
    public void atualizarConta(Conta c){
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        sessao.update(c);
        trans.commit();
        
    }
              
        public List<Conta> list(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
            try {
                List<Conta> lista = (List<Conta>)session.createQuery("FROM Conta ").list();
                t.commit();
                return lista;
            } catch (Exception e) {
                if(list==null){
                   throw e;
                }
                throw e;
            }
       
    }
}
