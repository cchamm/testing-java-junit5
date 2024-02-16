package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.ControllerTests;
import jdk.jfr.Enabled;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

class IndexControllerTest implements ControllerTests {

    IndexController controller;

    @BeforeEach
    void setUp() {
        controller = new IndexController();
    }

    @DisplayName("Test Proper View is returned for index page")
    @Test
    void index() {
        assertEquals("index", controller.index());
        assertEquals("index", controller.index(), "Wrong View Returned");

        assertEquals("index", controller.index(), () -> "Another expensive message " +
                "Make me only if you have to");

        assertThat(controller.index()).isEqualTo("index");
    }

    @DisplayName("Test exception")
    @Test
    void oupsHandler() {

        assertThrows(ValueNotFoundException.class, () -> {
            controller.oppsHandler();
        });
//        assertTrue("notimplemented".equals(controller.oppsHandler()), () -> "This is some expensive message to build");
    }

    @Disabled("Demo of timeout")
    @Test
    void testTimeout() {
        assertTimeout(Duration.ofMillis(100), () -> {
            Thread.sleep(2000);
            System.out.println("I got here");
        });
    }


    @Disabled("Demo of time out")
    @Test
    void testTimeoutPreemptively() {
        assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
            Thread.sleep(2000);
            System.out.println("I got here 23434 ");
        });
    }

    @Test
    void testAssumptions() {
        assumeTrue("GURU".equals(System.getenv("GURU_RUNTIME")));
    }

    @Test
    void testAssumptionsTrueAssumptionIsTrue() {
        assumeTrue("GURU".equals("GURU"));
    }

    @Test
    @EnabledOnOs(OS.MAC)
    void testMeOnMacOS() {
    }

    @Test
    @EnabledOnOs(OS.LINUX)
    void testMeOnLinux() {
    }

    @Test
    @EnabledOnOs(OS.WINDOWS)
    void testMeOnWindows() {
    }

    @EnabledOnJre(JRE.JAVA_8)
    @Test
    void testMeOnJava8() {

    }

    @EnabledOnJre(JRE.OTHER)
    @Test
    void testMeOnJavaOther() {

    }

    @EnabledIfEnvironmentVariable(named = "USER", matches = "jt")
    @Test
    void testIfUserJT() {

    }

    @EnabledIfEnvironmentVariable(named = "USER", matches = "fred")
    @Test
    void testIfUserFred() {

    }


}