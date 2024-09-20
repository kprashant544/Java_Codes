package com.quiz.app;

import java.util.*;

public class Quiz {
    Scanner sc = new Scanner(System.in);
    Scanner scString = new Scanner(System.in);
    List<Question> questionList = new ArrayList<>();

    public void setQuestion() {
        Question q1 = new Question("Which is the biggest river of Nepal?", Arrays.asList("1.Koshi", "2.Karnali", "3.Narayani", "4.Mahakali"), 1);
        Question q2 = new Question("Which is the biggest lake of Nepal?", Arrays.asList("1.Phewa", "2.Rara", "3.Tilicho", "4.She-Phoksundo"), 2);
        Question q3 = new Question("Who is known as the father of computer?", Arrays.asList("1.Steve Jobs", "2.Ram Kc", "3.Prachanda", "4.Charles Babbage"), 4);
        questionList.add(q1);
        questionList.add(q2);
        questionList.add(q3);
        // Set more questions...
        
        Collections.shuffle(questionList);
    }

    public void play() {
        questionList.clear();
        setQuestion();

        System.out.println("Enter the name of player:");
        String name = scString.nextLine();
        int score = 0;

        for (Question q : questionList) {
            System.out.println(q.question);
            System.out.println(q.optionList);
            int userChoice = sc.nextInt();
            if (userChoice == q.correctAnswer) {
                System.out.println("Correct answer");
                score += 10;
            } else {
                System.out.println("Incorrect answer");
                System.out.println("Correct answer is: " + q.optionList.get(q.correctAnswer - 1));
            }
        }

        System.out.println(name + " your score is " + score);
    }

    public static void main(String[] args) {
        Quiz quiz = new Quiz();
        quiz.play();
    }
}

