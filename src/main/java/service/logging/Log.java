package service.logging;

public interface Log {

    void error(Message message);

    void warn(Message message);

    void info(Message message);

    void debug(Message message);

    void trace(Message message);
}
