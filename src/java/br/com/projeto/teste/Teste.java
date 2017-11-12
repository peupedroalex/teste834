
package br.com.projeto.teste;

import br.com.projeto.dao.ContasDao;
import br.com.projeto.entity.Conta;
import br.com.projeto.util.HibernateUtil;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;


public class Teste {
    public static void main(String[] args) {
        
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        Transaction t = session.beginTransaction();
//        
//        List<Conta> lista = (List<Conta>)session.createQuery("FROM Conta ").list();
//        for(Conta conta: lista){
//            JOptionPane.showMessageDialog(null,conta.getNome_cliente());
//        }
//        t.commit();
      List<Conta> lista = new ContasDao().list();
      String rec = "";
      for(Conta conta:lista){
          rec = rec +"\n Nome: "+conta.getNome_cliente()+"  cpf: "+conta.getCpf();
      }
      JOptionPane.showMessageDialog(null, rec);
    }
}
