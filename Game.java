import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Game{
    static String fileName;
    static FileReader myFile;
    //Above is declaring variables.

    public static void game(String[] args) {

        String question = "";
        String optionA = "";
        String optionB = "";
        String optionC = "";
        String optionD = "";

        try{
            FileWriter toWriteFile;
            toWriteFile = new FileWriter("trivia.txt");
            //Above is initalizing FileWriter.

            BufferedWriter output = new BufferedWriter(toWriteFile);
            //Above is initalizing BufferedWriter.
        }

        try{
            FileReader toReadFile;
            toReadFile = new FileReader("trivia.txt");

            BufferedReader reader = new BufferedReader(toReadFile);

            while (reader.ready()){
                question = reader.readLine();
                optionA = reader.readLine();
                optionB = reader.readLine();
                optionC = reader.readLine();
                optionD = reader.readLine();

                System.out.printf(question, optionA, optionB, optionC, optionD);
                
            }
            reader.close();
        } catch (IOException excpt){
            excpt.printStackTrace();
        }
    }
}
//Note: This looks very similar to Main.java in Lab 9.