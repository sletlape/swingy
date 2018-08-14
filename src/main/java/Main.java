import java.util.*;

public class Main {

    public static String question;
    public static Scanner in = new Scanner (System.in);

    public static void main(String args[]){

        question = "o";

        while (true)
        {
            switch (question)
            {
                case "0":
                    System.out.println("Please enter your name:");
                    question = "1";

                case "1":
                     String usrName = in.next();
                    question = "1A";
                    break;

                case "1A":
                    System.out.println("\nYou are a prisoner trying to escape from prison...");
                    question = "2";
            }
        }
    }
}
