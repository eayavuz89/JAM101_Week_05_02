package School;

import java.util.ArrayList;
import java.util.List;

public class ClassRoom {
    private final int maxSize;
    private final List<Student> students;

    public ClassRoom(int maxSize){
        this.maxSize = maxSize;
        students = new ArrayList<Student>(maxSize) ;
    }

    public boolean isFull(){
        return students.size() == maxSize;
    }

    public void addStudent(Student newStudent){
        students.add(newStudent);
    }

    public List<Student> getStudents() {
        return students;
    }
}
