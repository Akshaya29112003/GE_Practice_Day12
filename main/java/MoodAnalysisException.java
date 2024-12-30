public class MoodAnalysisException extends Exception{

    public enum ExceptionType {
        EMPTY_OR_NULL_MESSAGE
    }

    private ExceptionType type;
    public MoodAnalysisException(String message, ExceptionType type){
        super(message);
        this.type = type;
    }

    public ExceptionType getType() {
        return type;
    }
}
