package quiztastic.core;

/**
 * The Question Class.
 * <p>
 * Should contain information about the questions
 */
public class Question {

    //points, category, question, answer

    private final int score;
    private final String question;
    private final String category;
    private final String answer;


    public Question(int score, String category, String question, String answer) {
        this.score = score;
        this.question = question;
        this.category = category;
        this.answer = answer;
    }

    public int getScore() {
        return score;
    }

    public String getQuestion() {
        return question;
    }

    public String getCategory() {
        return category;
    }

    public String getAnswer() {
        return answer;
    }
}
