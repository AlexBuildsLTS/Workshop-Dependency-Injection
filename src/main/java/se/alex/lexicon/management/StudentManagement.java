package se.alex.lexicon.management;

import se.alex.lexicon.models.Student;
import java.util.List;

public interface StudentManagement {
    Student create();
    Student save(Student student);
    Student find(int id);
    List<Student> findAll();
    void delete(int id);
}
