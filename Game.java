import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Game{
    static ArrayList<Question> thequestions;
    static String fileName;
    static FileReader myFile;
    //Above is declaring variables.

    public static void game(String[] args) {
        thequestions = new ArrayList<Question>();
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

            for (int i = 0; i < thequestions.size(); i++){
                output.write(thequestions.get(i).getQuestion());
                output.newLine();
                output.write(thequestions.get(i).getOptionA());
                output.newLine();
                output.write(thequestions.get(i).getOptionB());
                output.newLine();
                output.write(thequestions.get(i).getOptionC());
                output.newLine();
                output.write(thequestions.get(i).getOptionD());
                output.newLine();
                output.write(thequestions.get(i).getAnswer());
                output.newLine();
                output.write(thequestions.get(i).getPoints());
                output.newLine();

                output.flush();
            }
            output.close();
        }
        catch (IOException excpt){
            excpt.printStackTrace();
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
        }
        catch (IOException excpt){
            excpt.printStackTrace();
        }
    }
}
//Note: This looks very similar to Main.java in Lab 9.