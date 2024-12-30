public class MoodAnalyzer {
    private String message;

    public MoodAnalyzer(String message) {
        this.message = message;
    }

    // Default Constructor
    public MoodAnalyzer() {
    }
    public String analyzeMood() {
        try {
            if (message.contains("Sad"))
                return "SAD";
            else
                return "HAPPY";
        } catch (NullPointerException e) {
            return "HAPPY";
        }
    }

    public String analyzeMoodUsingException() throws MoodAnalysisException {
        try {
            if (message == null || message.trim().isEmpty()) {
                throw new MoodAnalysisException("Message is null or empty", MoodAnalysisException.ExceptionType.EMPTY_OR_NULL_MESSAGE);
            }
            if (message.contains("Sad"))
                return "SAD";
            else
                return "HAPPY";
        } catch (NullPointerException e) {
            throw new MoodAnalysisException("Message Is NULL", MoodAnalysisException.ExceptionType.EMPTY_OR_NULL_MESSAGE);
        }
    }

    public void setMessage(String message){
        this.message = message;
    }
}
