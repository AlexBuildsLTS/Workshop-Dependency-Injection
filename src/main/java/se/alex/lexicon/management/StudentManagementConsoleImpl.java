package se.alex.lexicon.management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.alex.lexicon.data_access.StudentDao;
import se.alex.lexicon.models.Student;
import se.alex.lexicon.services.UserInputService;

import java.util.List;

@Component
public class StudentManagementConsoleImpl implements StudentManagement {

    private final UserInputService userInputService;
    private final StudentDao studentDao;

    @Autowired
    public StudentManagementConsoleImpl(UserInputService userInputService, StudentDao studentDao) {
        this.userInputService = userInputService;
        this.studentDao = studentDao;
    }

    @Override
    public Student create() {
        Student student = new Student();
        System.out.println("Enter student ID:");
        student.setId(userInputService.getInt());
        System.out.println("Enter student name:");
        student.setName(userInputService.getString());
        return student;
    }

    @Override
    public Student save(Student student) {
        return studentDao.save(student);
    }

    @Override
    public Student find(int id) {
        return studentDao.find(id);
    }

    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    @Override
    public void delete(int id) {
        studentDao.delete(id);
    }
}
