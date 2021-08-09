package jpabook.jpashop;

import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.Orderitem;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        //transcation 설정
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        //code

        try {
            Order order = new Order();
            em.persist(order);

            order.addOrderItem(new Orderitem());

        } catch (Exception e){
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }

}
