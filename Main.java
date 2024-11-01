import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

       try {
           int num = 0;
           ArrayList<String> history = new ArrayList<>();
           do {
               boolean validInput=false;
               while (!validInput) {
                   System.out.println("Welcome to calculator");
                   System.out.println("Enter 1 to addition the numbers");
                   System.out.println("Enter 2 to subtraction the numbers");
                   System.out.println("Enter 3 to multiplication the numbers");
                   System.out.println("Enter 4 to division the numbers");
                   System.out.println("Enter 5 to modulus the numbers");
                   System.out.println("Enter 6 to find minimum number");
                   System.out.println("Enter 7 to find maximum number");
                   System.out.println("Enter 8 to find the average of numbers");
                   System.out.println("Enter 9 to print the last result in calculator");
                   System.out.println("Enter 10 to print the list of all results in calculator");
                   System.out.println("Enter 11 to exit");
                   try {
                       num = input.nextInt();
                       check(num);
                       validInput = true;
                   } catch (IllegalArgumentException e) {
                       System.out.println(e.getMessage());
                   } catch (InputMismatchException e) {
                       System.out.println("Enter correct number ");
                       input.nextLine();
                   }
               }
               switch (num) {
                   case 1:
                       double sum = 0;
                       System.out.println("Enter first number");
                       double num1 = input.nextDouble();
                       System.out.println("Enter second number");
                       double num2 = input.nextDouble();
                       sum = num1 + num2;
                       System.out.println("The sum of numbers = " + sum);
                       history.add("The sum of numbers = " + sum);
                       break;
                   case 2:
                       double sub = 0;
                       System.out.println("Enter first number");
                       num1 = input.nextDouble();
                       System.out.println("Enter second number");
                       num2 = input.nextDouble();
                       sub = num1 - num2;
                       System.out.println("The subtraction of numbers = " + sub);
                       history.add("The subtraction of numbers = " + sub);
                       break;
                   case 3:
                       System.out.println("Enter first number");
                       num1 = input.nextDouble();
                       System.out.println("Enter second number");
                       num2 = input.nextDouble();
                       double multy = num2 * num1;
                       System.out.println("The multiplication of numbers = " + multy);
                       history.add("The multiplication of numbers = " + multy);
                       break;
                   case 4:
                       double divide = 1;
                       System.out.println("Enter first number");
                       num1 = input.nextDouble();
                       System.out.println("Enter second number");
                       num2 = input.nextDouble();
                       while (num2==0){
                           System.out.println("Can't divide on zero , Enter valid number ");
                           num2 = input.nextDouble();
                       }
                       divide = num1 / num2;
                       System.out.println("The result of division is = " + divide);
                       history.add("The result of division is = " + divide);

                       break;
                   case 5:
                       double mod = 0;
                       System.out.println("Enter first number");
                       num1 = input.nextDouble();
                       System.out.println("Enter second number");
                       num2 = input.nextDouble();
                       mod = num1 % num2;
                       System.out.println("The result of modulus = " + mod);
                       history.add("The result of modulus = " + mod);
                       break;
                   case 6:
                       System.out.println("Enter first number");
                       num1 = input.nextDouble();
                       System.out.println("Enter second number");
                       num2 = input.nextDouble();
                       if (num1 < num2) {
                           System.out.println("Minimum number is : " + num1);
                           history.add("Minimum number is : " + num1);
                       } else if(num2<num1) {
                           System.out.println("Minimum number is : " + num2);
                           history.add("Minimum number is : " + num2);
                       }else {
                           System.out.println(num1+" equal "+num2);
                           history.add(num1+" equal "+num2);
                       }
                       break;
                   case 7:
                       System.out.println("Enter first number");
                       num1 = input.nextDouble();
                       System.out.println("Enter second number");
                       num2 = input.nextDouble();
                       if (num1 > num2) {
                           System.out.println("Maximum number is : " + num1);
                           history.add("Maximum number is : " + num1);
                    } else if(num2>num1) {System.out.println("Maximum number is : " + num2);
                       history.add("Maximum number is : " + num2);}
                       else {System.out.println(num1+" equal "+num2);
                       history.add(num1+" equal "+num2);}
                       break;
                   case 8:
                       sum = 0;
                       System.out.println("Enter first number");
                       num1 = input.nextDouble();
                       System.out.println("Enter second number");
                       num2 = input.nextDouble();
                       sum = num1 + num2;
                       double avg = sum / 2;
                       System.out.println("Average= " + avg);
                       history.add("Average= " + avg);
                       break;
                   case 9:
                       if(!history.isEmpty())
                       { System.out.println(history.getLast());}
                       else System.out.println("No history available.");
                       break;
                   case 10:
                       if(!history.isEmpty()){
                       System.out.println(history);}
                       else System.out.println("No history available.");
                       break;
               }
           } while (num != 11);
       } catch (InputMismatchException e){
           System.out.println("Enter Valid number ");
       }
    }//end main

    public static void check(int num)throws IllegalArgumentException{
        if(num>11||num<1){
            throw new IllegalArgumentException("Please enter number from 1 to 11");
        }
    }

}