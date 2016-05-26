package project.irfananda.firebasechat.model;

/**
 * Created by irfananda on 26/05/16.
 */
public class Message {
    private String name;
    private String textMessage;

    public Message() {
    }

    public Message(String name, String textMessage) {
        this.name = name;
        this.textMessage = textMessage;
    }

    public String getName() {
        return name;
    }

    public String getTextMessage() {
        return textMessage;
    }
}
