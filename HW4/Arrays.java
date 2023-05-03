package HW4;
import java.util.Scanner;
import java.util.ArrayList;

public class Arrays {

    // CONVERT THE SUMS METHOD FROM HW3 TO ADD EACH VALUE TO AN ARRAY AND THEN OUTPUT THE 
    // ARRAY AND THE TOTAL.
    // SEE HW3 FOR SUMS METHOD
    // If you want to use an ArrayList for the inputs to be dynamic that is okay
    // Otherwise if you are using a regular array, assume the size is 10 total. 
    // EXAMPLE 
    // I will add up the numbers you give me....
    // Number: 12
    // The total so far is 12.
    // Number: 2
    // The total so far is 14.
    // Number: 3
    // The total so far is 17.
    // Number: 4
    // The total so far is 21.
    // Number: 1
    // The total so far is 22.
    // Number: 0
    // Total: 22
    // Array: {12,2,3,4,1,0}
    public static void Arraysums(){
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();
        int total = 0;
        System.out.println("I will add up the numbers you give me...");
        while (true) {
            System.out.print("Number: ");
            int num = scanner.nextInt();
            if (num == 0) {
                System.out.println("TOTAL ENDED --- The total is " + total + ".");
                System.out.println("Numbers entered: " + numbers.toString());
                break;
            }
            numbers.add(num);
            total += num;
            System.out.println("The total so far is " + total + ".");
        }
        scanner.close();
    }

    // Create a method that will brute force a password EX.
    // bruteForce("ZZZZ")
    // The program should then guess each char of the string and compare it to see if it is equal
    // to the index of the alphabet char array below
    // Output Example:
    // Z
    // ZZ
    // ZZZ
    // ZZZZ

    // Hint 1: using a char array for the password is helpful here 
    // Hint 2: using the method .toCharArray is a way to convert the password parameter to a char array as well
    // From there creating for and while loops to compare the values is trivial

    public static void bruteForce(String password) {
        char[] passwordArr = password.toCharArray();
        char[] alphabetArr = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%^&*(),./;'<>?:".toCharArray();
    
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int attempts = 0;

        while (i < passwordArr.length) {
            for (char c : alphabetArr) {
                sb.append(c);
                attempts++;

                System.out.println(sb.toString());

                if (sb.toString().equals(String.valueOf(passwordArr))) {
                    System.out.println("Password found after " + attempts + " attempts.");
                    return;
                }

                if (sb.charAt(i) == passwordArr[i]) {
                    i++;
                } else {
                    sb.setLength(i);
                }
            }
        }
    }
    // Create a method that will sort an Array of integers from smallest to greatest.
    // NOTE: You CANNOT use the built in Arrays.sort method
    // Ex. 
    // sorter([9,10,2,5,3,4,7,8]) -> [2,3,4,5,7,8,9,10]

    // Hint 1: a temp Array is a helpful way to store variables for comparing 
    // Hint 2: 2 nested For loops should be all thats needed for the swapping logic
    public static int[] sorter(int[] nums) {
        int[] sortedArray = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sortedArray[i] = nums[i];
        }
    
        for (int i = 0; i < sortedArray.length - 1; i++) {
            for (int j = i + 1; j < sortedArray.length; j++) {
                if (sortedArray[i] > sortedArray[j]) {
                    int temp = sortedArray[i];
                    sortedArray[i] = sortedArray[j];
                    sortedArray[j] = temp;
                }
            }
        }
        System.out.println("Sorted array: " + java.util.Arrays.toString(sortedArray));
        return sortedArray;
    }




    public static void main(String[] args) {
        // Tester main method for your methods
        Arraysums();
        bruteForce("ZZZZ");
        sorter(new int[]{9,10,2,5,3,4,7,8});
    }
}