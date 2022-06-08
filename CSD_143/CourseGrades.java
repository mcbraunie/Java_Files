/*
 * Author: MB
 * Course: CS 143, Fall 2021
 * Date: 10/20/2021
 */

/**
 * Based on the Programming Challenges 4, 5, & 6 of Gaddis et.al.
 * (pgs 696, 697 in 4th ed.)
 * Class CourseGrades.java interacts with classes across the project:
 *      - GradedActivity.java
 *      - PassFailExam.java
 *      - Essay.java
 *      - FinalExam.java
 * to simulate the grading of a student's work.
 */

public class CourseGrades implements Analyzable{

    // class variables/fields
    private FinalExam finalExamGrade;
    private PassFailExam passFailExamGrade;
    private GradedActivity labGrade;
    private Essay essayGrade;
    private GradedActivity[] grades = {labGrade, passFailExamGrade, essayGrade, finalExamGrade};

    /**
     * Class Constructor
     * @param lab = index 0 of array grades
     * @param pF = index 1 of array grades
     * @param essay = index 2 of array grades
     * @param finalE = index 3 of array grades
     */

    public CourseGrades (GradedActivity lab, PassFailExam pF, Essay essay, FinalExam finalE){
        // GradedActivity [] grades values placed via calling the setter for each variable
        grades[0] = setLab(lab);
        grades[1] = setPassFailExam(pF);
        grades[2] = setEssay(essay);
        grades[3] = setFinalExam(finalE);
    }

    // lab setter/mutator
    public GradedActivity setLab(GradedActivity lab){
        this.labGrade = lab;
        return lab;
    }

    // pass/fail setter/mutator
    public PassFailActivity setPassFailExam(PassFailExam pF){
        this.passFailExamGrade = pF;
        return pF;
    }

    // essay setter/mutator
    public Essay setEssay(Essay essay){
        this.essayGrade = essay;
        return essay;
    }

    // final setter/mutator
    public FinalExam setFinalExam(FinalExam finalE){
        this.finalExamGrade = finalE;
        return finalE;
    }

    /**
     * @return toString() Override with formatted values to print out values from methods to user
     */
    @Override
    public String toString() {
        return  "\n            Student Test Results" + "\n" +
                " ----------------------------------------- " + "\n" +
                "   Lab            | Score: " + grades[0].getScore() + " | Grade: " + grades[0].getGrade() + "\n" +
                "   Pass/Fail Exam | Score: " + grades[1].getScore() + " | Grade: " + grades[1].getGrade() + "\n" +
                "   Essay          | Score: " + grades[2].getScore() + " | Grade: " + grades[2].getGrade() + "\n" +
                "   Final Exam     | Score: " + grades[3].getScore() + " | Grade: " + grades[3].getGrade() + "\n" +
                " ----------------------------------------- " + "\n" +
                "   Average Score  :  " + getAverage() + "\n" +
                "   Highest Score  :  " + getHighest().getScore() + "\n" +
                "   Lowest Score   :  " + getLowest().getScore() + "\n";

    }

    /**
     * Implements from interface -> Analyzable
     * @return finalScore (value of average scores) to user
     */

    @Override
    public Double getAverage() {
        double totScore = 0;                                // container for score values
        double finalScore = 0;                              // container for final score value
        try{                                                // catch errors if thrown
            for(int i = 0; i < this.grades.length; i++){    // loop through array
                totScore += grades[i].getScore();           // totScore value += each next value
            }
            finalScore = totScore/grades.length;            // finalScore is the result of totScore/the size of array
            return finalScore;                              // return value to caller
        }catch (Exception e){                               // catch exception
            System.out.println("Error: " + e);              // print msg
        }
        return null;                                        // if exception thrown, return null
    }

    /**
     * Implements from interface -> Analyzable
     * @return max (reference Obj to GradedActivity)
     * the result of the highest score student received
     */

    @Override
    public GradedActivity getHighest() {
        GradedActivity max = new GradedActivity();                  // reference object max for return variable
        double highestScore = 0;                                    // container for value of highest score
        int length = grades.length;                                 // loop controller based on array length
        try{                                                        // try/catch errors
            for(int i = 0; i < length; i++){                        // loop through entire array
                if(this.grades[i].getScore() > highestScore){       // if value at index [i] is > than container value
                    highestScore = grades[i].getScore();            // store value[i] in container
                    max = grades[i];                                    // set max (return value) = grade
                }
            }
            return max;                                            // return value to caller
        }catch (Exception e){                                      // catch exception
            System.out.println("Error: " + e);                     // print msg
        }
        return null;                                               // if exception thrown, return null
    }

    /**
     * Implements from interface -> Analyzable
     * @return min (value of lowest score) to user
     */
    @Override
    public GradedActivity getLowest() {
        GradedActivity min = new GradedActivity();                      // reference object min for return variable
        int length = grades.length;                                     // loop controller based on array length
        double lowest = grades[0].getScore();                           // lowest is set to starting index
        try{                                                            // try/catch errors
            for(int i = 0; i < length; i++){                            // loop through array
                if(grades[i].getScore() <= lowest){           // if any incremental val @ index is less or == to lowest
                    lowest = grades[i].getScore();                      // store lower value in lowest
                    min = grades[i];                                    // store index value in ref object min
                }
            }
            return min;                                                 // return min to user
        } catch (Exception e){                                          // catch exception
            System.out.print("Error: " + e);                            // print msg
        }
        return null;                                                    // if exception, return null
    }
}
