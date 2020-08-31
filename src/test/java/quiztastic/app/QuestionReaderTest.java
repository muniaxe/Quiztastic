package quiztastic.app;

import org.junit.jupiter.api.Test;
import quiztastic.core.Category;
import quiztastic.core.Question;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

class QuestionReaderTest {


    @Test
    void shouldReadSingleQuestion() throws IOException, ParseException {
        String questionText = "100\tLAKES & RIVERS\tRiver mentioned most often in the Bible\tthe Jordan\n";
        QuestionReader reader = new QuestionReader(new StringReader(questionText));
        Question q = reader.readQuestion();
        assertNotNull(q);
        assertEquals(100, q.getScore());
        assertEquals(new Category("LAKES & RIVERS"), q.getCategory());
        assertEquals("River mentioned most often in the Bible", q.getQuestion());
        assertEquals("the Jordan", q.getAnswer());
        Question end = reader.readQuestion();
        assertNull(end);
    }

    @Test
    void shouldReadManyQuestions() throws IOException, ParseException {
        InputStream s = this.getClass()
                .getClassLoader()
                .getResourceAsStream("questions-small.tsv");
        if (s == null) fail();

        QuestionReader reader = new QuestionReader(new InputStreamReader(s));

        int count = 0;
        while (reader.readQuestion() != null) {
            count++;
        }

        assertEquals(13, count);
    }

    @Test
    void shouldSetBufferedReader() {
        BufferedReader x = new BufferedReader(new StringReader("Hello, World!\nOther Line"));
        QuestionReader a = new QuestionReader(x);
        assertEquals(x, a.getUnderlyingReader());
    }

    @Test
    void shouldThrowParseExceptionOnTooFewFields() {
        String questionText = "100\tLAKES & RIVERS\tthe Jordan";
        QuestionReader reader = new QuestionReader(new StringReader(questionText));
        ParseException e = assertThrows(ParseException.class, () -> {
            reader.readQuestion();
        });
        assertEquals("Expected 4 fields, got 3", e.getMessage());

    }


}