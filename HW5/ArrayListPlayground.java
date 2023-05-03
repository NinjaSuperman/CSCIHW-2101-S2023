package HW5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class ArrayListPlayground {
    public static void main(String[] args) {
    // Question 1
    // Write Java statements that do the following:
    // a) Declare an arrayList nums of 15 elements of type int.
    // b) Output the value of the tenth element of the array nums.
    // c) Set the value of the 5th element of the array nums to 99.
    // d) set the value of the 13th element to 15
    // d) set the value of the 2nd element to 6
    // d) Set the value of the 9th element of the array nums to the sum of the 13th and 2nd elements of the array nums.

        ArrayList<Integer> nums = new ArrayList<Integer>(Collections.nCopies(15, 0));
        System.out.println(nums.get(9));
        nums.set(4, 99);
        nums.set(12, 15);
        nums.set(1, 6);
        nums.set(8, nums.get(12) + nums.get(1));
        System.out.println("Modified ArrayList: " + nums);
        weekdays(args);
        ArrayListMethods(args);
    }
         
    // Question 2
    // a) create an arrayList of Strings that contain each day of the week.(starting on monday)
    // b) output each of the days of the week
    // c) output the days of the week that we have class 
    // d) change the arrayList to start on Sunday

    public static void weekdays(String[] args) {
        ArrayList<String> weekdays = new ArrayList<String>();
        weekdays.add("Monday");
        weekdays.add("Tuesday");
        weekdays.add("Wednesday");
        weekdays.add("Thursday");
        weekdays.add("Friday");
        weekdays.add("Saturday");
        weekdays.add("Sunday");

        System.out.println("Days of the week:");
        for (String day : weekdays) {
            System.out.println(day);
        }

        System.out.println("\nDays of the week that we have class:");
        for (String day : weekdays) {
            if (day.equals("Tuesday") || day.equals("Thursday")) {
                System.out.println(day);
            }
        }

        weekdays.remove("Sunday");
        weekdays.add(0, "Sunday");

        System.out.println("\nDays of the week starting from Sunday:");
        for (String day : weekdays) {
            System.out.println(day);
        }
    }

    // Question 3 
    // a) create an ArrayList and prompt the user for numbers to add to it until the number 0 is selected
    // b) return the largest and smallest number
    // c) return the ArrayList sorted smallest to largest
    // d) take that ArrayList see if its size is divisable by 3 and then output the ArrayList in a matrix format
    // NOTE: make the matrix n X 3 so it can be n rows by 3 columns 
    // EX. ArrayList [1,2,3,4,5,6,7,8,9]
    // 1 2 3
    // 4 5 6
    // 7 8 9
    // NOTE: If the ArrayList is NOT divisable by 3 ask the user for more numbers and add them until it is
    // ArrayList Size: 7
    // Please enter 2 more numbers to create the matrix...
    // 
    // Hint 1: use collections sort to sort the numbers 
    // Hint 2: you can see if the size of the array list is divisible by 3 by running:
    //  numbers.size()%3==0
    // Hint 3: You can use this logic to print the array list in a 3x3 pattern once its created:
    // for(int i=0;i<numbers.size();i++)
    //     {
    //         System.out.print(numbers.get(i)+" ");
    //         if((i+1)%3==0)
    //         {
    //             System.out.println();
    //         }
    //     }
    
    public static void ArrayListMethods(String[] args) {
        ArrayList<Integer> list = createList();
        System.out.println("Largest number: " + getLargest(list));
        System.out.println("Smallest number: " + getSmallest(list));
        ArrayList<Integer> sortedList = sortList(list);
        System.out.println("Sorted list: " + sortedList);
        if (sortedList.size() % 3 == 0) {
            printMatrix(sortedList);
        }
    }
    
    public static ArrayList<Integer> createList() {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println("Enter numbers to add to the list, enter 0 to stop: ");
        int num = input.nextInt();
        while (num != 0) {
            list.add(num);
            num = input.nextInt();
        }
        input.close();
        return list;
    }
    
    public static int getLargest(ArrayList<Integer> list) {
        int max = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) > max) {
                max = list.get(i);
            }
        }
        return max;
    }
    
    public static int getSmallest(ArrayList<Integer> list) {
        int min = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < min) {
                min = list.get(i);
            }
        }
        return min;
    }
    
    public static ArrayList<Integer> sortList(ArrayList<Integer> list) {
        ArrayList<Integer> sortedList = new ArrayList<>(list);
        Collections.sort(sortedList);
        return sortedList;
    }
    
    public static void printMatrix(ArrayList<Integer> list) {
        int rows = list.size() / 3;
        int cols = 3;
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(list.get(index) + " ");
                index++;
            }
            System.out.println();
        }
    }
}




   

