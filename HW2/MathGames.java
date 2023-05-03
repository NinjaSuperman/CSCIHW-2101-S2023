package HW2;

import java.util.Scanner;

public class MathGames {
    // 1. Create a method that will calculate the Pythagorean Theorem (https://en.wikipedia.org/wiki/Pythagorean_theorem)
    // c = sqrt(a^2+b^2)
    // NOTE: You can assume you will only need to calculate the Hypotenuse
    // Hint 1: Method should take in 2 sides(a and b) of the triangle and return the missing side.
    //      Remember the Triangle has a base, Perpendicular, and Hypotenuse
    // Hint 2: Math.pow and Math.sqrt are your friend here
    // Bonus points: Try to make it accept any 2 sides and return the 3rd. So it can take in
    // Hypotenuse and Perpendicular and return the base.
    // Example 1: pythagorean(3,4) would return 5
    
    //no error handling, will crash on multiple nulls. Requires a single null to run.
    public static double PTAnswer(Double a, Double b, Double c){
        if (c == null){
            //c = (a^2 + b^2)^1/2
            return Math.sqrt(Math.pow(a,2) + Math.pow(b, 2));
        }else if (a == null){
            //a = (c^2 - b^2)^1/2
            return Math.sqrt(Math.pow(c, 2) - Math.pow(b, 2));
        }else if (b == null){
            //b = (c^2 - a^2)^1/2
            return Math.sqrt(Math.pow(c, 2) - Math.pow(a, 2));
        }else{
            return 0;
        }
    }
    
    // 2. Create a method that will calcuate my grade in the class. You can use the grade range as follows
        // A: 100 - 90
        // B:  89 - 80
        // C:  79 - 70
        // D:  69 - 60
        // F:  60 -  0 
        // method should accept the grade as a double and return the letter grade of what I got
        // NOTE: Im a really nice guy and always round up on my grading so a 69.3 will round up to a 70.0
        // Hint 1: if statements required here you will probably need at the least 5 if / ifelse / else statments
        // Hint 2: You will probably need to cast the double to an int
        // Hint 3: You will probably need to use the Math.ceil() method
        // Example: grade(69.3) would return a D
    public static char Grade(double grade){
        int gradeInt = (int)Math.ceil(grade);

        if (gradeInt >= 0 && gradeInt < 60) {
            return 'F';
        }else if (gradeInt >= 60 && gradeInt < 70) {
            return 'D';
        }else if (gradeInt >= 70 && gradeInt < 80) {
            return 'C';
        }else if (gradeInt >= 80 && gradeInt < 90) {
            return 'B';
        }else if (gradeInt >= 90 && gradeInt <= 100) {
            return 'A';
        }else{
            return 'N';
        }
    }





    // 3. Create a method that will calculate the tip on a bill per person
    //      Method parameters: total bill, amount of people splitting the bill, percentage to tip.
    //      Note: I would like the total always rounded up to a whole number
    //      Hint 1: percentage can be made easier to work with if you divide by 100 so 18% is 18/100 = 0.18
    //      Hint 2: Using doubles will be helpful for when you need to calculate decimals
    //      Hint 3: It is possible you might need to Cast a double to an int or vice versa
    //      Hint 4: You will probably need to use the Math.ceil() method
    //      Example: tip(100, 4, 18) would return 5.0
    public static double bill(double total, int people, double percent){        
        double usableTotal = Math.ceil(total);
        double usablePercent = percent/100;
        double tip = usableTotal * usablePercent;

        return tip/people;
    }
    
 


    // You can either create a tester class or put your code here
     public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("I'll solve a right triangle for you.\n");

        System.out.println("What is a?");
        String inputa = scanner.nextLine();
        Double a = null;
        if (inputa.length() != 0){
            a = Double.parseDouble(inputa);
        }

        System.out.println("What is b?");
        String inputb = scanner.nextLine();
        Double b = null;
        if (inputb.length() != 0){
            b = Double.parseDouble(inputb);
        }

        System.out.println("What is c?");
        String inputc = scanner.nextLine();
        Double c = null;
        if (inputc.length() != 0){
            c = Double.parseDouble(inputc);
        }
        System.out.println(PTAnswer(a, b, c));

        System.out.println("What was your grade?");
        double grade = Double.parseDouble(scanner.nextLine());
        System.out.println(Grade(grade));

        System.out.println("Now we'll calculate a tip for your bill.\n");
        System.out.println("What was the total of your bill?");
        double total = Double.parseDouble(scanner.nextLine());

        System.out.println("How many people were there?");
        int people = Integer.parseInt(scanner.nextLine());

        System.out.println("And what percentage of tip would you like to give?");
        double percent = Double.parseDouble(scanner.nextLine());

        System.out.println(bill(total, people, percent));

        scanner.close();
    }
}