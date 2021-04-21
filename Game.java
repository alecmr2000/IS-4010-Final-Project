import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.FontUIResource;


public class Game implements ActionListener {
    JLabel welcome;
    JTextField name;
    //For 1 point extra credit, add a JTextField that asks the user for their name, and then welcomes the user by name to the game.
    JLabel questionValue;
    JLabel currentQuestion;
    //Above to print out the question and how many points it is worth.
    JLabel score;
    //Above to display what the player's score is.

    JButton answerA;
    JButton answerB;
    JButton answerC;
    JButton answerD;
    JButton nextQuestion;
    //Above is initializing the various bunttons.

    ArrayList<Question>thequestions = new ArrayList<Question>();
    //Above is initalizing/creating ArrayList.

    String question;
    String optionA;
    String optionB;
    String optionC;
    String optionD;
    String correctOption;
    String points;
    //Above is initalzing the variables to be used with the Question class.

    static FileReader toReadFile;
    //Above is initialzing FileReader.

    int holder = 0;
    int answerVariable = 0;
    int playersScore = 0;
    //Above is intialzing variable.

    Game(){
        JFrame frame = new JFrame("Group 1's Trivia Game");
        frame.setLayout(new FlowLayout());
        frame.setSize(240, 120);
        //Above is setting up the GUI frame.

        try{
            toReadFile = new FileReader("trivia.txt");
            //Above is intitalizing a new FileReader.

            BufferedReader reader = new BufferedReader(toReadFile);
            //Above is intitalizing a new BufferedReader. 

            while (reader.ready()){
                question = reader.readLine();
                optionA = reader.readLine();
                optionB = reader.readLine();
                optionC = reader.readLine();
                optionD = reader.readLine();
                correctOption = reader.readLine();
                points = reader.readLine();
                //Abvoe is reading the .txt file. 

                Question theQuestion = new Question(question, optionA, optionB, optionC, optionD, Integer.parseInt(correctOption), Integer.parseInt(points));
                //Above is creating a new Question object with the questions from the .txt file. 

                thequestions.add(theQuestion);
                //Above is storing the question in the ArrayList.
            }
            reader.close();
        }
        catch (IOException excpt){
            excpt.printStackTrace();
        }

        welcome = new JLabel("Hi there! Welcome to the best trivia game. Type your name below.");
        //Aboce is creating welcome lable.
        //CHANGE-- We can customize this if we want but I think we already meet requirements.
        name = new JTextField(15);
        name.setActionCommand("");
        //Above is creating text feild for user to enter their name.

        questionValue = new JLabel("");
        questionValue.setText("This question is worth "+ String.valueOf(thequestions.get(holder).getPoints()) + " points.");
        //Above is displaying how many points the question is worth.

        currentQuestion = new JLabel("");
        currentQuestion.setText(thequestions.get(holder).getQuestion());
        currentQuestion.setFont(new FontUIResource("font", Font.BOLD, 16));
        //CHANGE-- When you get this to run play with the font setting because this might look weird.
        //Above is creating the question lable and setting it equal to the question in the Question object. Above is also altering lable display.

        answerA = new JButton(thequestions.get(holder).getOptionA());
        answerA.setBackground(Color.BLUE);
        answerB = new JButton(thequestions.get(holder).getOptionB());
        answerB.setBackground(Color.ORANGE);
        answerC = new JButton(thequestions.get(holder).getOptionC());
        answerC.setBackground(Color.GRAY);
        answerD = new JButton(thequestions.get(holder).getOptionD());
        answerD.setBackground(Color.CYAN);
        //Above is creating bunttons for the options and making them the options for the questions.
        //Also giving some modifers to change colors. 

        nextQuestion = new JButton("Next Question");
        //CHANGE-- Leaving this color plain?

        score = new JLabel("Your score is: " + playersScore);
        //CHANGE-- NEED TO FINISH THE ABOVE.

        name.addActionListener(this);
        nextQuestion.addActionListener(this);
        //Above is implementing actionlisteners.

        frame.add(welcome);
        frame.add(name);
        frame.add(currentQuestion);
        frame.add(questionValue);
        frame.add(answerA);
        frame.add(answerB);
        frame.add(answerC);
        frame.add(answerD);
        frame.add(nextQuestion);
        frame.add(score);
        //Above is adding GUI objects to the frame.

        frame.setVisible(true);
        //Above is making the frame visible.
    }

    public void actionPerformed(ActionEvent ae) {
        if (answerA.isSelected()){
            answerVariable = 1;
        }
        else if (answerB.isSelected()){
            answerVariable = 2;
        }
        else if (answerC.isSelected()){
            answerVariable = 3;
        }
        else if (answerD.isSelected()){
            answerVariable = 4;
        }

        if (answerVariable == thequestions.get(holder).getAnswer()){
            playersScore = playersScore + thequestions.get(holder).getPoints();
        }

        try{
            FileWriter toWriteFile;
            toWriteFile = new FileWriter("scores.txt");
            //Above is initalizing FileWriter.

            BufferedWriter output = new BufferedWriter(toWriteFile);
            //Above is initalizing BufferedWriter.
            
            String userName = name.getText();
            //Above is pulling the user's name.

            output.write(userName + "'s score is: " + Integer.toString(playersScore));
            //Above is writting user's score to .txt file.
            //CHECK-- If I did this correctly then we will get the user's name along with their score.

            output.flush();
        }
        catch (IOException excpt){
            excpt.printStackTrace();
        }

        if (ae.getActionCommand().equals("Next Question")){
            holder++;
        }
        //Above will move to next question if the buntton is pressed.

        if (holder == 0){
            currentQuestion.setText(thequestions.get(holder).getQuestion());
            answerA.setText(thequestions.get(holder).getOptionA());
            answerB.setText(thequestions.get(holder).getOptionB());
            answerC.setText(thequestions.get(holder).getOptionC());
            answerD.setText(thequestions.get(holder).getOptionD());
            questionValue.setText("This question is worth "+ String.valueOf(thequestions.get(holder).getPoints()) + " points.");

            score.setText("Your score is: " + playersScore);
            //idk about this last one.
        }
    }
}