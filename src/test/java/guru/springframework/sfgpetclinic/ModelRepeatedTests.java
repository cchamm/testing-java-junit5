package guru.springframework.sfgpetclinic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestInfo;

public interface ModelRepeatedTests {
    @BeforeEach
    default void setUp(TestInfo testInfo, RepetitionInfo repetitionInfo) {
        System.out.println("Running Test - " + testInfo.getDisplayName() + " -- Repetition info - " + repetitionInfo.getCurrentRepetition() + "  | " + repetitionInfo.getTotalRepetitions());


    }
}