package pro.sky.course_2_theexam;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.HashSet;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {
    private QuestionService questionService;

    public JavaQuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/add")
    public Question add(@RequestParam(value = "question", required = false) String question,
                        @RequestParam(value = "answer", required = false) String answer) {
        return questionService.add(question, answer);
    }

    @GetMapping("/remove")
    public Question remove(@RequestParam(value = "question", required = false) String question,
                           @RequestParam(value = "answer", required = false) String answer) {
        return questionService.remove(new Question(question,answer));
    }

    @GetMapping("")
    public Collection<Question> getQuestions() {
        return questionService.getAll();
    }
}
