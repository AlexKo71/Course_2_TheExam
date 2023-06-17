package pro.sky.course_2_theexam;

import java.util.Collection;

public interface QuestionService {
    public Question add(String question, String answer);

    public Question add(Question question);

    public Question remove(Question question);

    public Collection<Question> getAll();

    Question getRandomQuestion();
}
