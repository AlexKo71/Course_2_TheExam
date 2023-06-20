package pro.sky.course_2_theexam;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class JavaQuestionServiceTest {

    private final JavaQuestionService javaQuestionServiceMock = mock(JavaQuestionService.class);

    @Spy
    private JavaQuestionService javaQuestionService;


    @Test
    void add() {
        when(javaQuestionServiceMock.add(anyString(), anyString())).thenReturn(new Question("Q1", "A1"));
        var actual = new Question("Q1", "A1");
        var expected = javaQuestionService.add("Q1", "A1");
        assertEquals(expected, actual);

    }

    @Test
    void remove() {
        javaQuestionService.remove(new Question("Q1", "A1"));
        assertEquals(0, javaQuestionService.getAll().size());
        when(javaQuestionServiceMock.add(anyString(), anyString())).thenReturn(new Question("Q1", "A1"));
    }

    @Test
    void getAll() {
        when(javaQuestionService.getAll()).thenReturn(List.of(new Question("Q1", "A1")));
        javaQuestionService.add("Q1", "A1");
        assertEquals(1, javaQuestionService.getAll().size());

    }
    @Test
    void getRandomQuestion() {
        when(javaQuestionServiceMock.getRandomQuestion()).thenReturn(new Question("Q1","A1"));
    }
}