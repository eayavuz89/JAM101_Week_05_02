package School;

import javax.naming.directory.InvalidAttributeIdentifierException;

public class Student {
    private final String name, surName;
    private int age;
    private String schoolNo;


    public Student(String name , String surName, int age) throws InvalidAttributeIdentifierException {
        this.name = name;
        this.surName = surName;

        if(age<6 || age >10)
            throw new InvalidAttributeIdentifierException("Studenf age must be betwwwn 6-10");

        this.age = age;
    }

    public int getGrade() {
        return age - 5;
    }

    private int grade;

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSchoolNo() {
        // School no daha önce hesaplamışsa yeniden işlem yapmamak için bu veri göndirilir. hesaplanmışsa hesaplanan veri gönderilir.
        if(schoolNo == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(name.substring(0, name.length() > 1 ? 2 : name.length()).toUpperCase());
            sb.append((surName.length() > 2 ? surName.substring(surName.length() - 3) : surName).toUpperCase());
            sb.append(age);
            schoolNo = sb.toString();
        }
        return schoolNo;
    }

}
