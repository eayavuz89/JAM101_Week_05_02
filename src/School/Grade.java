package School;

import java.util.ArrayList;
import java.util.List;

public class Grade {
    private final int grade, maxClassRoomCount;
    private final List<ClassRoom> classRoomList;

    public Grade(int grade, int maxClassRoomCount) {
        this.grade = grade;
        this.maxClassRoomCount = maxClassRoomCount;
        classRoomList = new ArrayList<ClassRoom>(maxClassRoomCount);
    }

    public List<ClassRoom> getClassRoomList(){
        return this.classRoomList;
    }

    public void addClassRoom(ClassRoom newClassRoom){
        this.classRoomList.add(newClassRoom);
    }

    public boolean isFull(){
        return classRoomList.size() == maxClassRoomCount;
    }

    public int getGrade() {
        return grade;
    }
}
