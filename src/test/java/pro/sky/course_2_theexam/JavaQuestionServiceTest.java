package pro.sky.course_2_theexam;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class JavaQuestionServiceTest {

    @Mock
    private JavaQuestionService javaQuestionService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

    }

    @Test
    void add() {
        when(javaQuestionService.add(anyString(), anyString())).thenReturn(new Question("Q1", "A1"));
        var actual = new Question("Q1", "A1");
        var expected = javaQuestionService.add("Q1", "A1");
        assertEquals(expected, actual);

    }

    @Test
    void remove() {
        javaQuestionService.add(new Question("Q1", "A1"));
        javaQuestionService.remove(new Question("Q1", "A1"));
        assertEquals(0, javaQuestionService.getAll().size());

    }

    @Test
    void getAll() {
        when(javaQuestionService.getAll()).thenReturn(List.of(new Question("Q1", "A1")));
        javaQuestionService.add("Q1", "A1");
        assertEquals(1, javaQuestionService.getAll().size());

    }

}