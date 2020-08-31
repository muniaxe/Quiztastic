package quiztastic.core;

import java.util.ArrayList;
import java.util.List;

/** A Jeopardy Board
 *
 */
public class Board {

    private final List<Group> groups;

    public Board(List<Group> groups) {
        this.groups = new ArrayList<>(groups);
        if (groups.size() != 6)
            throw new IllegalArgumentException("Should be 6 groups, where " + groups.size());
    }

    public static class Group {
        private final Category category;
        private final List<Question> questions;

        public Group(Category category, List<Question> questions) {
            this.category = category;
            this.questions = questions;
            validate();
        }

            private void validate() {
            if (this.questions.size() != 5)
                throw new IllegalArgumentException("Should be 5 groups, where " + questions.size());
            for (Question q : questions){
                if (q.getCategory() != this.category)
                    throw new IllegalArgumentException("Expected all categories to be " + this.category + " but was " + q.getCategory());
            }
        }
    }
}
