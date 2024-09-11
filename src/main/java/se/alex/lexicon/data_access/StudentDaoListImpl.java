package se.alex.lexicon.data_access;

import se.alex.lexicon.models.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component  // Marks this class as a Spring-managed component
public class StudentDaoListImpl implements StudentDao {
    private final List<Student> students = new ArrayList<>();

    @Override
    public Student find(int id) {
        return students.stream().filter(s -> s.getId() == id).findFirst().orElse(null);
    }

    @Override
    public Student save(Student student) {
        students.add(student);
        return student;
    }

    @Override
    public List<Student> findAll() {
        return students;
    }

    @Override
    public void delete(int id) {
        students.removeIf(s -> s.getId() == id);
    }
}
