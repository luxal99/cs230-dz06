package Student;

import services.StudentDao;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import model.Student;

@Named(value = "studentBean")
@RequestScoped
public class StudentBean {

    private String firstName;
    private String lastName;
    private Integer age;
    private String location;
    private String chosenOne;
    private Student student = new Student();
    private long tempId;

    private List<Student> students = new ArrayList<>();
    
    @Inject
    private StudentDao studentDao;

    public String saveStudent() {

        student.setName(firstName);
        student.setLastname(lastName);
        student.setAge(age);
        student.setLocation(nav.getLocation());
        student.setSubject1(subject.getSubject1());
        student.setSubject2(subject.getSubject2());
        student.setSubject3(subject.getSubject3());
        student.setSubject4(subject.getSubject4());

        studentDao.createStudent(student);

        return nav.navigate();
    }

    public long getTempId() {
        return tempId;
    }

    public void setTempId(long tempId) {
        this.tempId = tempId;
    }

    public String getChosenOne() {
        return chosenOne;
    }

    public void setChosenOne(String chosenOne) {
        this.chosenOne = chosenOne;
    }

    public List<Student> getStudents() {

        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

       public void fillArrayFromDb() {
        students = (List<Student>) studentDao.findAllStudents();
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
    
    @Inject
    private StudentDao sDao;
    
    @Inject
    private navigationController nav;
    @Inject
    private Subject subject;
    
    public String createStudent(){
    Student student1 = new Student(age,  lastName, location, firstName,
    subject.getSubject1(), subject.getSubject2(), subject.getSubject3(), subject.getSubject4());
    sDao.createStudent(student1);
    return nav.navigate();
    }

    public StudentDao getStudentDao() {
        return studentDao;
    }

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public String deleteStudent() {
        studentDao.removeStudent(Long.parseLong(chosenOne));
        return "deleteStudent";
    }

    public String updateStudent() {
        studentDao.edit(studentDao.findStudent(Long.parseLong(chosenOne)));
        return "updateStudent";
    }

    public void updateStudent2() {
        studentDao.findStudentAndUpdateAge(tempId, age);
    }

    public navigationController getNav() {
        return nav;
    }

    public void setNav(navigationController nav) {
        this.nav = nav;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
