package service.logging;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Date;

public class Message {

    private static class LogMessage {
        private String message;
        private long time;

        public LogMessage(Message message) {
            this.message = message.getFormattedMessage();
            this.time = new Date().getTime();
        }

        public String getMessage() {
            return message;
        }

        public long getTime() {
            return time;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public void setTime(long time) {
            this.time = time;
        }

    }

    private String message;
    private Object[] messageParams;
    private Exception cause;

    public static Message msg(String message, Object... messageParams) {
        return msg(null, message, messageParams);
    }

    public static Message msg(Exception cause, String message, Object... messageParams) {
        Message myMessage = new Message();
        myMessage.setCause(cause);
        myMessage.setMessage(message);
        myMessage.setMessageParams(messageParams);
        return myMessage;
    }

    public String getFormattedMessage() {
        return String.format(message, messageParams);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object[] getMessageParams() {
        return messageParams;
    }

    public void setMessageParams(Object[] messageParams) {
        this.messageParams = messageParams;
    }

    public Exception getCause() {
        return cause;
    }

    public void setCause(Exception cause) {
        this.cause = cause;
    }

    public String toJson() {
        LogMessage logMessage = new LogMessage(this);
        try {
            return new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(logMessage);
        } catch (IOException e) {
            //todo
            return null;
        }

    }
}