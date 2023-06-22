package pro.sky.course_2_theexam;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    public ExaminerServiceImpl(JavaQuestionService questionService) {
        this.questionService = questionService;
    }

    private final JavaQuestionService questionService;




    @Override
    public Collection<Question> getQuestions(int amount) {
        Set<Question> examQuestion = new HashSet<>(amount);
        if (amount > questionService.getAll().size()) {
            throw new MoreQuestionsException("запрошено большее количество вопросов");
        }
            while (examQuestion.size() < amount) {
                examQuestion.add(questionService.getRandomQuestion());
            }
        return examQuestion;
        }

    }



