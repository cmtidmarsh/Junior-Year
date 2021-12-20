// C343 / Summer 2020
// Homework 01-Task A
// June 30, 2020 10:00
// Clare Tidmarsh, cmtidmar

public class Student {
    private String name;
    private String major;
    private String year;
    private double credits;

    //constructor
    public void studentAttributes(String name,
                                  String major,
                                  String year,
                                  double credits){
        this.name = name;
        this.major = major;
        this.year = year;
        this.credits = credits;
    }
    //setting and retrieving student's name (obj 1)
    public void setName(String name) {
        this.name = name; }
    public String getName() {
        return name; }

    // setting and retrieving student's major (obj 2)
    public void setMajor(String major) {
        this.major = major; }
    public String getMajor() {
        return major; }

    // setting and retrieving student's year in school (obj 3)
    public void setYear(String year) {
        this.year = year; }
    public String getYear() {
        return year;
    }
    // setting and retrieving student's credits till graduation (obj 4)
    public void setCredits(double credits) {
        this.credits = credits;
    }
    public double getCredits() {
        return credits;
    }


    public static void main(String[] args) {
        // create first student
        Student student1 = new Student();
        student1.setName("Kevin");
        student1.setMajor("Finance");
        student1.setYear("junior");
        student1.setCredits(90.5);

        // create second student
        Student student2 = new Student();
        student2.setName("Jenny");
        student2.setMajor("undecided");
        student2.setYear("freshman");
        student2.setCredits(20);

        // create third student
        Student student3 = new Student();
        student3.setName("Christine");
        student3.setMajor("Marketing");
        student3.setYear("sophomore");
        student3.setCredits(60.5);

        // create array, or "roster", of students
        Student[] roster = new Student[3];
        roster[0] = student1;
        roster[1] = student2;
        roster[2] = student3;

        // display students
        System.out.println("Student 1 is a " + roster[0].getMajor() + " major " + "named " + roster[0].getName() + ". " +
                "He is a " + roster[0].getYear() + " and has " + roster[0].getCredits() + " of 120 credits completed.");
        System.out.println("Student 2 is an " + roster[1].getMajor() + " major " + "named " + roster[1].getName() + ". " +
                "She is a " + roster[1].getYear() + " and has " + roster[1].getCredits() + " of 120 credits completed.");
        System.out.println("Student 3 is a " + roster[2].getMajor() + " major " + "named " + roster[2].getName() + ". " +
                "She is a " + roster[2].getYear() + " and has " + roster[2].getCredits() + " of 120 credits completed.");







    }

}
