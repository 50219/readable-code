package cleancode.studycafe.tobe.io;

import cleancode.studycafe.tobe.exception.AppException;
import cleancode.studycafe.tobe.model.pass.StudyCafePassType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class InputHandlerTest {

    private void setSystemInput(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    @Test
    @DisplayName("1을 입력 시 시간권 선택")
    void shouldReturnHourlyPassWhenInputIs1() {
        // Given
        setSystemInput("1\n");
        InputHandler inputHandler = new InputHandler();

        // When
        StudyCafePassType result = inputHandler.getPassTypeSelectingUserAction();

        // Then
        assertEquals(StudyCafePassType.HOURLY, result);
    }

    @Test
    @DisplayName("2를 입력 시 주간권 선택")
    void shouldReturnWeeklyPassWhenInputIs2() {
        // Given
        setSystemInput("2\n");
        InputHandler inputHandler = new InputHandler();

        // When
        StudyCafePassType result = inputHandler.getPassTypeSelectingUserAction();

        // Then
        assertEquals(StudyCafePassType.WEEKLY, result);
    }

    @Test
    @DisplayName("3을 입력 시 고정권 선택")
    void shouldReturnFixedPassWhenInputIs3() {
        // Given
        setSystemInput("3\n");
        InputHandler inputHandler = new InputHandler();

        // When
        StudyCafePassType result = inputHandler.getPassTypeSelectingUserAction();

        // Then
        assertEquals(StudyCafePassType.FIXED, result);
    }

    @Test
    @DisplayName("1, 2, 3 이외의 값을 입력 시 예외 발생")
    void shouldThrowExceptionWhenInputIsInvalid() {
        // Given
        setSystemInput("4\n");
        InputHandler inputHandler = new InputHandler();

        // When
        Executable executable = inputHandler::getPassTypeSelectingUserAction;

        // Then
        assertThrows(AppException.class, executable);
    }
}
