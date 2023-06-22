package pro.sky.course_2_theexam;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    private Set<Question> questions = new HashSet<>();

    @Override
    public Question add(String question, String answer) {
        var addQuestion = new Question(question, answer);
        if (!questions.add(new Question(question, answer))) {
            throw new RuntimeException("Такой вопрос уже есть в списке!");
        }
        return addQuestion;
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }


    @Override
    public Question remove(Question question) {
        if (questions.remove(question)) {
            return (Question) questions;
        }
        return null;
    }

    @Override
    public Collection<Question> getAll() {
        var list = questions.parallelStream().toList();
        return list;
    }

    @Override
    public Question getRandomQuestion() {
        List<Question> list = new ArrayList<>(questions);
        int size = questions.size();
        int count = 0;
        int random = new Random().nextInt(size);
        for (Question element : list) {
            if (count == random) {
                return element;
            }
            count++;
        }
        return null;
    }
}
