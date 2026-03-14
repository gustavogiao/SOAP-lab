package org.example.clients;

import jakarta.xml.ws.Service;
import org.example.services.SchoolService;
import org.example.models.Student;

import javax.xml.namespace.QName;
import java.net.URL;
import java.util.List;

public class SchoolClient {

    public static void main(String[] args) throws Exception {

        URL wsdl = new URL("http://localhost:8080/schoolService?wsdl");

        QName qname = new QName(
                "http://services.example.org/",
                "SchoolServiceImplService"
        );

        Service service = Service.create(wsdl,qname);

        SchoolService port = service.getPort(SchoolService.class);

        port.addStudent("Maria","Computer Science",17);

        List<Student> students = port.getAllStudents();

        for(Student st:students){
            System.out.println(st.getId() + " " + st.getName()+" "+st.getCourse());
        }
    }
}