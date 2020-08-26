package quiztastic.domain;

import quiztastic.core.Category;
import quiztastic.core.Question;

import java.util.List;

public interface QuestionRepository {

    /**
     * Get the question with an id from the repository. Can throw an
     * IndexOutOfBoundsException.
     *
     * @param id the index of the question
     *
     * @throws IndexOutOfBoundsException thrown if id does not exist.
     *
     * @return the question with id
     */
    Question getQuestion(int id);


    /**
     *
     * @return a list of categories available
     */
    List<Category> getCategories();

    /**
     *
     * @return a list of questions for a given category.
     */
    List<Question> getQuestionsWithCategory(Category category);

}
