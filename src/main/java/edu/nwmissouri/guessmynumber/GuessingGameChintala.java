package edu.nwmissouri.guessmynumber;

import javax.swing.*;

/**
 * “Guess a Number” game that allows user to guess a random number. Uses Swing
 * to make a nice graphical user interface.
 *
 * Original Source: https://hackr.io/blog/java-projects
 *
 * Read about jOptionPane:
 * https://docs.oracle.com/javase/7/docs/api/javax/swing/JOptionPane.html
 * .showInputDialog() .showMessageDialog()
 *
 * @author Denise Case
 */
public class GuessingGameChintala {

    public static void main(String[] args) {
        // TODO: change secretNumber to secretNumber Hint: Right-click / Refactor / Rename
        int secretNumber = (int) (Math.random() * 100 + 1);
        int userAnswer = 0;
        System.out.println("The correct guess would be " + secretNumber);
        int count = 1;

        while (userAnswer != secretNumber) {
            // TODO: create 3 local variables for the arguments so we know what they mean
            // showInputDialog - the first argument is always null (no parent)
            String message = "Enter a guess between 1 and 100" ;// what type?
            String title = "Guessing Game"; // what type?
            int messageType = JOptionPane.INFORMATION_MESSAGE;
            // Works the same as original 3 but more expressive - this is an example of a what? Hint: enum
            
            String response = JOptionPane.showInputDialog(null,
                    message, title, messageType);
            userAnswer = Integer.parseInt(response);

            JOptionPane.showMessageDialog(null, "" + guessingANumber(userAnswer, secretNumber, count));
            count++;
        }
    }

    // TODO: Refactor / Rename guessingANumber to calculateMessage
    public static String guessingANumber(int userAnswer, int secretNumber, int count) {
        // TODO: Instead of "Try Number" which sounds like we should try that as a guess...
        // Say "You've used " + count + guesses.
        // If count is one, use "guess", else use "guesses" HINT: Ternary operator
        if (userAnswer <= 0 || userAnswer > 100) {
            return "Your guess is invalid";
        } else if (userAnswer == secretNumber) {
            return "Correct!\nTotal Guesses: " + count;
        } else if (userAnswer > secretNumber) {
            return "Your guess is too high, try again.\nNumber Of Tries: " + count;
        } else if (userAnswer < secretNumber) {
            return "Your guess is too low, try again.\nNumber Of Tries: " + count;
        } else {
            return "Your guess is incorrect\nNumber Of Tries: " + count;
        }
    }
}
