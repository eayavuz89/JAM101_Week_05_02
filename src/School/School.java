package School;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class School {
    private final int minGrade , maxGrade, classCountEveryGrade, maxClassSize;
    private final List<Grade> gradesList;
    private final Scanner inpObj;

    public School(int minGrade , int maxGrade, int maxClassCountEachGrade, int maxStudentCountEachClass){
        this.classCountEveryGrade = maxClassCountEachGrade;
        this.minGrade = minGrade;
        this.maxGrade = maxGrade;
        this.maxClassSize = maxStudentCountEachClass;
        inpObj = new Scanner(System.in);

        gradesList = new ArrayList<Grade>(maxGrade - minGrade + 1);

        //Sınıflar ve şubeleri oluştuurluyor
        for (int i = minGrade ; i<=maxGrade ; i++) {
            Grade g = new Grade(i , maxClassCountEachGrade);
            for (int j = 0; j < maxClassCountEachGrade; j++)
                g.addClassRoom(new ClassRoom(maxStudentCountEachClass));

            gradesList.add(g);
        }
    }

    public boolean addStudent(String name , String surName , int age) {
        boolean result = false;
        try {
            Student newStudent = new Student(name , surName , age);
            Grade grade = gradesList.get(newStudent.getGrade()-1);

            // öğrenci eklenirken ilgili sınıftaki tüm şubeler sırayla gezliyor boşluk varsa öğrenci o şubeye ekleniyor
            for (ClassRoom classRoom : grade.getClassRoomList()) {
                if(!classRoom.isFull()) {
                    classRoom.addStudent(newStudent);
                    result= true;
                }
            }

            //üstteki döngüde hiç bir sınıf boş değilse reselt false olarak döner ve kullanıcıya tüm şubkerin dolu olduğu bilgisi verilir
            if(!result)
                System.out.println("All " + newStudent.getGrade() + " grade classes are full. Student can't be added");
            else
                System.out.println(newStudent.getSchoolNo() + " student added");

            return result;
        }
        catch (Exception ex){
            System.out.println( ex.getMessage());
            return false;
        }
    }

    private boolean addStudentFromSystemInput(int index){
        String name , surName;
        int age ;

        System.out.println("\n");

        do {
            System.out.println("Please enter number " + index + " student NAME:");
            name = inpObj.nextLine();
        }while(name.isBlank());

        do {
            System.out.println("Please enter number " + index + " student SURNAME:");
            surName = inpObj.nextLine();
        }while(name.isBlank());

       do {
            System.out.println("Please enter number " + index + " student AGE (6-10):");
            age = inpObj.nextInt();
        }while(age<6 || age>10);

       return addStudent(name , surName , age);
    }

    public School addAllStudents(){
        for(int i = 0 ; i < (maxGrade - minGrade + 1)  * classCountEveryGrade * maxClassSize ; i++)
            while(!addStudentFromSystemInput(i + 1)); //Öğrenci ekleme işlemi başarılı olana kadar döndür

        return this; //içinde bulunduğumuz obje döndürülüyor ki zinvirleme metod çağırılabilsin
    }


    public void ListALlStudents(){
        for (Grade grade:gradesList) {
            System.out.println("Grade - " + grade.getGrade());

            int classRoomIndex = 1 ;
            for (ClassRoom classRoom:grade.getClassRoomList()) {
                System.out.println("\t+ClassRoom " + classRoomIndex++);

                for (Student student:classRoom.getStudents())
                    System.out.println("\t\t- " + student.getSchoolNo());
            }
        }
    }
}
