package quiztastic.app;

import quiztastic.core.Question;

import java.io.BufferedReader;
import java.io.Reader;

/**
 * The Question Reader should read the questions from a file.
 */
public class QuestionReader {
    private final BufferedReader reader;

    public QuestionReader(BufferedReader reader) {
        this.reader = reader;
    }

    public QuestionReader(Reader reader) {
        this(new BufferedReader(reader));
    }

    public Question readQuestion() {
       throw new UnsupportedOperationException("Not yet implemented");
    }

}
