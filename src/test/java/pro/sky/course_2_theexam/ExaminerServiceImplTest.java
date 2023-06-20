package pro.sky.course_2_theexam;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    private final ExaminerServiceImpl examinerServiceMock = mock(ExaminerServiceImpl.class);
    private final JavaQuestionService javaQuestionServiceMock = mock(JavaQuestionService.class);

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @Test
    void getQuestions() {
        Set<Question> questions = new HashSet<>();
        questions.add(new Question("Q1", "A1"));
        questions.add(new Question("Q2", "A2"));
        questions.add(new Question("Q3", "A3"));
        when(javaQuestionServiceMock.getAll()).thenReturn(questions);
        when(examinerServiceMock.getQuestions(4)).thenThrow(MoreQuestionsException.class);
        when(javaQuestionServiceMock.getRandomQuestion()).thenReturn(new Question("Q1", "A1"),
                        new Question("Q2", "A2"));
        assertEquals(2,examinerService.getQuestions(2).size());

    }
}