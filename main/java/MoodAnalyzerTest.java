import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class MoodAnalyzerTest {

    //UC1
    @Test       //TC 1.1
    public void givenAMood_WhenSad_ShouldReturnSad(){
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer("I am in Sad Mood");
        String mood = moodAnalyzer.analyzeMood();
        System.out.println("Current Mood : " + mood);
        Assert.assertEquals("SAD", mood);
    }

    @Test      //TC 1.2
    public void givenAMood_WhenHappy_ShouldReturnHappy(){
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer("I am in Any Mood");
        String mood = moodAnalyzer.analyzeMood();
        System.out.println("Current Mood : " + mood);
        Assert.assertEquals("HAPPY", mood);
    }

    @Test           //Refactor 1.1 & 1.2
    public void givenMessageUsingDefaultConstructor_ShouldReturnMood() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer();

        moodAnalyzer.setMessage("I am in Sad Mood");
        String mood1 = moodAnalyzer.analyzeMood();
        System.out.println("Current Mood : " + mood1);
        assertEquals("SAD", mood1);

        moodAnalyzer.setMessage("I am in Any mood");
        String mood2 = moodAnalyzer.analyzeMood();
        System.out.println("Current Mood : " + mood2);
        assertEquals("HAPPY", mood2);
    }

    //UC2
    @Test           //TC 2.1
    public void givenNullMoodShouldReturnHappy() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer(null);
        String mood = moodAnalyzer.analyzeMood();
        System.out.println("Current Mood : " + mood);
        Assert.assertEquals("HAPPY", mood);
    }

    //UC3
    @Test           //TC 3.1
    public void givenNullMessage_ShouldThrowException() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer(null);
        Exception exception = assertThrows(MoodAnalysisException.class, () -> {
            moodAnalyzer.analyzeMoodUsingException();
        });
        System.out.println("String Exception : " + exception);
        System.out.println("Exception Type : " + ((MoodAnalysisException) exception).getType());
        assertEquals(MoodAnalysisException.ExceptionType.EMPTY_OR_NULL_MESSAGE, ((MoodAnalysisException) exception).getType());
    }

    @Test           //TC 3.2
    public void givenEmptyMessage_ShouldThrowException() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer("");
        Exception exception = assertThrows(MoodAnalysisException.class, () -> {
            moodAnalyzer.analyzeMoodUsingException();
        });
        System.out.println("String Exception : " + exception);
        System.out.println("Exception Type : " + ((MoodAnalysisException) exception).getType());
        assertEquals(MoodAnalysisException.ExceptionType.EMPTY_OR_NULL_MESSAGE, ((MoodAnalysisException) exception).getType());
    }

}

