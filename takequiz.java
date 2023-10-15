import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Student {
    private String name;
    private HashMap<Question, String> answers;

    public Student(String name) {
        this.name = name;
        this.answers = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public HashMap<Question, String> getAnswers() {
        return answers;
    }

    public void setAnswer(Question question, String answer) {
        answers.put(question, answer);
    }

    public String getAnswer(Question question) {
        return answers.get(question);
    }

    public int takeQuiz(Quiz quiz) {
        // Get the questions from the quiz
        ArrayList<Question> questions = quiz.getQuestions();

        // Iterate over the questions and ask the student to answer them
        for (Question question : questions) {
            System.out.println(question.getText());

            for (String option : question.getOptions()) {
                System.out.println(option);
            }

            // Get the student's answer to the question
            Scanner scanner = new Scanner(System.in);
            String studentAnswer = scanner.nextLine();

            // Set the student's answer to the question
            setAnswer(question, studentAnswer);
        }

        // Calculate the student's marks for the quiz
        int studentMarks = 0;
        for (Question question : questions) {
            studentMarks += question.getStudentMark(this);
        }

        return studentMarks;
    }

    public void displayMarks(Quiz quiz) {
        int studentMarks = takeQuiz(quiz);

        System.out.println("Your marks for the quiz are: " + studentMarks);
    }
}
