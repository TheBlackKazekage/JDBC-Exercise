package beanI;

import model.Student;

import javax.ejb.Local;
import java.util.List;

@Local
public interface StudentI {
    List<Student> findAll();
    List<Student> findById(long id);
}
