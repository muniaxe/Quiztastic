package quiztastic.app;

import org.junit.jupiter.api.Test;
import quiztastic.core.Question;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class QuestionReaderTest {


    @Test
    void shouldReadSingleQuestion() {
        String questionText = "100\tLAKES & RIVERS\tRiver mentioned most often in the Bible\tthe Jordan\n";
        QuestionReader reader = new QuestionReader(new StringReader(questionText));
        Question q = reader.readQuestion();
        assertNotNull(q);
        // Insert more tests
        Question end = reader.readQuestion();
        assertNull(end);
    }

    @Test
    void shouldReadManyQuestions() throws IOException {
        URL url = this.getClass()
                .getClassLoader()
                .getResource("questions-small.tsv");
        if (url == null) fail();
        Path smallQuestions = Path.of(url.getFile());

        QuestionReader reader = new QuestionReader(
                Files.newBufferedReader(smallQuestions));
        int count = 0;
        while (reader.readQuestion() != null) {
            count++;
        }

        assertEquals(13, count);
    }

    @Test
    void shouldSetBufferedReader(){
        BufferedReader x = new BufferedReader(new StringReader("Hello, World!\nOther Line"));
        QuestionReader a = new QuestionReader(x);
        assertEquals(x, a.getUnderlyingReader());
    }

}