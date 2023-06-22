package pro.sky.course_2_theexam;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class MoreQuestionsException extends RuntimeException {
    public MoreQuestionsException(String message) {
        super(message);
    }
}
