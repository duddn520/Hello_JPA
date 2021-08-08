package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class jpa_main{
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        //transcation 설정
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        //code

        try{
            Member findmember = em.find(Member.class, 1L);
            List<Member> findmemberList = findmember.getTeam().getMemberList();

            for (Member member : findmemberList) {
                System.out.println("member.name = "+ member.getUsername());
            }
            //tx 커밋
            tx.commit();

        } catch (Exception e){
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}