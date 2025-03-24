import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Class representing a Quiz Question
class Question {
    String questionText;
    String[] options;
    int correctAnswerIndex;

    // Constructor
    public Question(String questionText, String[] options, int correctAnswerIndex) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
    }
}

// Main Quiz Application
public class QuizApplication {
    private List<Question> questions;
    private int score;
    private Scanner scanner;

    public QuizApplication() {
        questions = new ArrayList<>();
        scanner = new Scanner(System.in);
        score = 0;
        loadQuestions(); // Load quiz questions
    }

    // Method to load questions into the quiz
    private void loadQuestions() {
        questions.add(new Question("What is the capital of France?", new String[]{"Berlin", "Madrid", "Paris", "Rome"}, 2));
        questions.add(new Question("Which planet is known as the Red Planet?", new String[]{"Earth", "Mars", "Jupiter", "Venus"}, 1));
        questions.add(new Question("What is 5 + 3?", new String[]{"5", "8", "9", "7"}, 1));
        questions.add(new Question("Who developed Java?", new String[]{"Microsoft", "Apple", "Sun Microsystems", "Google"}, 2));
        questions.add(new Question("Which is the largest ocean on Earth?", new String[]{"Atlantic", "Indian", "Arctic", "Pacific"}, 3));
    }

    // Method to start the quiz
    public void startQuiz() {
        System.out.println("Welcome to the Quiz! Answer the following questions:");
        
        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);
            System.out.println("\nQuestion " + (i + 1) + ": " + q.questionText);
            
            // Display options
            for (int j = 0; j < q.options.length; j++) {
                System.out.println((j + 1) + ". " + q.options[j]);
            }
            
            // Get user input
            System.out.print("Your answer (1-4): ");
            int userAnswer = scanner.nextInt() - 1; // Convert to 0-based index
            
            // Validate answer
            if (userAnswer == q.correctAnswerIndex) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong! The correct answer is: " + q.options[q.correctAnswerIndex]);
            }
        }
        
        // Display final score
        System.out.println("\nQuiz Over! Your final score is: " + score + "/" + questions.size());
    }

    public static void main(String[] args) {
        QuizApplication quiz = new QuizApplication();
        quiz.startQuiz();
    }
}