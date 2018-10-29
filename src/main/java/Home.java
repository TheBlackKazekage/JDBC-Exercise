import beanI.StudentI;
import model.Student;
import org.json.JSONObject;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "home", urlPatterns = "/home")
public class Home extends HttpServlet {
    @EJB
    StudentI student;


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> list = student.findAll();
        for(Student s : list){
            resp.getWriter().println(s.getId() + " " + s.getName() + " "+ s.getAge());
        }

        JSONObject object = new JSONObject();
        object.put("list", student.findAll());
        resp.getWriter().println(object.get("list"));

        resp.getWriter().println();

        List<Student> student1 = student.findById(2);
        for(Student s2 : student1){
            resp.getWriter().println(s2.getId() + " " + s2.getName() + " "+ s2.getAge());
        }
    }
}
