/**
 * Author: MB
 * Course: CS 143, Fall 2021
 * Date: 10/19/2021
 */


public class GradesDemo {
    public static void main(String[] args) {

        GradedActivity lab = new GradedActivity();
        lab.setScore(75.0);
        lab.getScore();
        lab.getGrade();
        PassFailExam pFE = new PassFailExam(100, 16, 80);
        Essay es = new Essay(25, 20, 20, 25);
        FinalExam fE = new FinalExam(100, 11);

        CourseGrades student1 = new CourseGrades(lab, pFE, es, fE);
        System.out.println(student1);
        //System.out.println(student1.getLowest());

    }
}
