import School.School;

public class main {
    public static void main(String[] args){
        //sınıf aralığı, her sınıftaki şobe sayısı, her şubedeki öğrenci sayısı değişken sabit değişkenlere atanıyor
        final int MIN_GRADE = 1 , MAX_GRADE = 5, CLASS_COUNT_EVERY_GRADE = 1 , MAX_CLASS_SIZE = 2;

        new School(MIN_GRADE ,MAX_GRADE ,CLASS_COUNT_EVERY_GRADE ,MAX_CLASS_SIZE)
                .addAllStudents()
                .ListALlStudents();
    }
}
