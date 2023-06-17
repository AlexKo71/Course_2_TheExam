package pro.sky.course_2_theexam;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {


    private final ExaminerServiceImpl examinerServiceMock = mock(ExaminerServiceImpl.class);
    @Mock
    JavaQuestionService javaQuestionService = new JavaQuestionService();
    ExaminerServiceImpl examinerService;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

    }

    @Test
    void getQuestions() {


        when(examinerServiceMock.getQuestions(eq(1))).thenReturn(anySet());

    }
}