package beanI;

import beanI.StudentI;
import model.Student;

import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class StudentB implements StudentI {

    @PersistenceContext
    EntityManager em;

    @Override
    public List<Student> findAll() {
        return em.createQuery("select s from Student s").getResultList();
    }

    @Override
    public List<Student> findById(long studentId){
        return em.createQuery("select s from Student s where s.id=:id")
                .setParameter("id", studentId)
                .getResultList();
    }
}
