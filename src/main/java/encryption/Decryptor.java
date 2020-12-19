package encryption;

public class Decryptor {
    private final String originalText;
    private final String encryptedText;
    private final String question;
    private final String answer;

    public Decryptor(String originalText, String encryptedText, String question, String answer) {
        this.originalText = originalText;
        this.encryptedText = encryptedText;
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion(){
        return question;
    }

    public String getEncryptedText(){
        return encryptedText;
    }

    public String answerTheQuestion(String answer){
        return answer.equals(this.answer) && this.question != null ? originalText : null;
    }
}
