class Question {
    String question;
    String optionA;
    String optionB;
    String optionC;
    String optionD;
    int answer;
    int points;
    //Above is declaring variables.

    Question(String theQuestion, String theOptionA, String theOptionB, String theOptionC, String theOptionD, int theAnswer, int thePoints){
        question = theQuestion;
        optionA = theOptionA;
        optionB = theOptionB;
        optionC = theOptionC;
        optionD = theOptionD;
        answer = theAnswer;
        points = thePoints;
    }
    //Above is contructor menthod.

    String getQuestion(){
        return question;
    }

    String getOptionA(){
        return optionA;
    }

    String getOptionB(){
        return optionB;
    }

    String getOptionC(){
        return optionC;
    }

    String getOptionD(){
        return optionD;
    }

    int getAnswer(){
        return answer;
    }

    int getPoints(){
        return points;
    }
    //Above are accessor methods.

}
//NOTE: This looks very similar to Person.java from Lab 9.