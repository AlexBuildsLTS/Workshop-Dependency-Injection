package se.alex.lexicon;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.alex.lexicon.management.StudentManagement;
import se.alex.lexicon.models.Student;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(se.alex.lexicon.config.ComponentScanConfig.class);

        StudentManagement studentManagement = context.getBean(StudentManagement.class);

        Student student = studentManagement.create();
        studentManagement.save(student);

        System.out.println("Student saved: " + studentManagement.find(student.getId()).getName());

        context.close();
    }
}
