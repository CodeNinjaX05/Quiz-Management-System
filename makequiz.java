import java.util.ArrayList;
import java.util.HashMap;

public class Quiz {
    private String name;
    private String description;
    private ArrayList<Question> questions;

    public Quiz(String name, String description, ArrayList<Question> questions) {
        this.name = name;
        this.description = description;
        this.questions = questions;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public int getTotalMarks() {
        int totalMarks = 0;
        for (Question question : questions) {
            totalMarks += question.getMarks();
        }
        return totalMarks;
    }

    public HashMap<Student, Integer> getStudentMarks(ArrayList<Student> students) {
        HashMap<Student, Integer> studentMarks = new HashMap<>();
        for (Student student : students) {
            int studentMark = 0;
            for (Question question : questions) {
                studentMark += question.getStudentMark(student);
            }
            studentMarks.put(student, studentMark);
        }
        return studentMarks;
    }
}

public class Question {
    private String text;
    private ArrayList<String> options;
    private String answer;
    private int marks;

    public Question(String text, ArrayList<String> options, String answer, int marks) {
        this.text = text;
        this.options = options;
        this.answer = answer;
        this.marks = marks;
    }

    public String getText() {
        return text;
    }

    public ArrayList<String> getOptions() {
        return options;
    }

    public String getAnswer() {
        return answer;
    }

    public int getMarks() {
        return marks;
    }

    public int getStudentMark(Student student) {
        // Get the student's answer to the question
        String studentAnswer = student.getAnswer(this);

        // If the student's answer is correct, return the marks for the question
        if (studentAnswer.equals(answer)) {
            return marks;
        } else {
            return 0;
        }
    }
}

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
}
