package rest;

import beanI.StudentI;
import model.Student;

import javax.ejb.EJB;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/view")
public class ViewS {

    @EJB
    private StudentI student;

    @POST
    @Path("/findAllStudents")
    @Produces(MediaType.APPLICATION_JSON)

    public List<Student> findAllStudents(){
        return student.findAll();
    }
}
