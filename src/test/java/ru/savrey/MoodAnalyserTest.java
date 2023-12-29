package ru.savrey;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class MoodAnalyserTest {

    MoodAnalyser moodAnalyser;

    @BeforeEach
    void setUp() {
        moodAnalyser = new MoodAnalyser();
    }

    @Test
    void goodMoodTest() {
        assertEquals("Good Mood", moodAnalyser.analyseMood("Хорошо покушали!"));
    }

    @Test
    void badMoodTest() {
        assertEquals("Bad Mood", moodAnalyser.analyseMood("Это была плохая идея"));
    }

    @Test
    void normalMoodTest() {
        assertEquals("Normal Mood", moodAnalyser.analyseMood("Ни то, ни сё!"));
    }

}
