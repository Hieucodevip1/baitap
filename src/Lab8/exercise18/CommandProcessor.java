package Lab8.exercise18;

public interface CommandProcessor {
    void consume(UndoableCommand pCommand);
    void undoLast();
    void redoLast();
}