/*
 * Author: MB
 * Course: CS 143, Fall 2021
 * Date: 10/19/2021
 */


public class Essay extends GradedActivity{

    // class variables/fields
    private double grammarScore;
    private double spellingScore;
    private double correctLenScore;
    private double contentScore;

    /**
     * Class Constructor
     * @param grammar = score can be 0 - 30
     * @param spelling = score can be 0 - 20
     * @param length = score can be 0 - 20
     * @param content = score can be 0 - 30
     * variable essay holds all values of parameters
     */
    public Essay(double grammar, double spelling, double length, double content){

        grammarScore = grammar;            // 30 points
        spellingScore = spelling;          // 20 points
        correctLenScore = length;          // 20 points
        contentScore = content;            // 30 points

        checkInput30(grammar);             // validate score entries
        checkInput20(spelling);            // ""
        checkInput20(length);              // ""
        checkInput30(content);             // ""

        double essay = (grammar + spelling + length + content);      // add variables to essay var

        checkTotal(essay);                  // check that essay meets requirements(100 points total score possible)

        setScore(essay);                    // set score from GradedActivity

        // System.out.println("\nStudent final grade is: " + getGrade() + "\n");    // print out grade
    }

    /**
     * checkInput20 checks all scores that should be between 0 and 20
     * @return value of input if conditions are met, throws error if not
     */
    public double checkInput20(double input) {
        if (input > 20 || input < 0) {
            throw new IllegalArgumentException("Invalid input, you entered: "
                    + input+ ". Values of 0 - 20 expected.");
        }
        else return input;
    }


    /**
     * checkInput30 checks all scores that should be between 0 and 30
     * @return value of input if conditions are met, throws error if not
     */
    public double checkInput30(double input){
        if(input > 30 || input < 0) {
            throw new IllegalArgumentException("Invalid input, you entered: "
                    + input + ". Values of 0 - 30 expected.");
        }
        else return input;
    }

    /**
     * checkTotal checks that the sum of the score is not more than 100 or less than 0
     * @return value of input if conditions are met, throws error if not
     */
    public double checkTotal(double tot){
        if(tot > 100 || tot < 0){
            throw new IllegalArgumentException("Score values can be 0" +
                    " - 100, this score is: " + tot);
        }
        else return tot;
    }

/*
    @Override
    public String toString() {
        return  "-----  Scores  -----\n" +
                "   Grammar  : " + this.grammarScore + "\n" +
                "   Spelling : " + this.spellingScore + "\n" +
                "   Length   : " + this.correctLenScore + "\n" +
                "   Content  : " + this.contentScore + "\n" +
                "---------------------" + "\n" +
                "Total Score : " + (this.grammarScore +
                this.spellingScore + this.correctLenScore + this.contentScore);
    }
 */
}
