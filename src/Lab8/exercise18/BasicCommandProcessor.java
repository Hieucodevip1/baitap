package Lab8.exercise18;

import java.util.ArrayList;
import java.util.List;

public class BasicCommandProcessor implements CommandProcessor {
    private final List<UndoableCommand> aExecutedCommands = new ArrayList<>();
    private final List<UndoableCommand> aUndoneCommands = new ArrayList<>();

    @Override
    public void consume(UndoableCommand pCommand) {
        pCommand.execute();
        aExecutedCommands.add(pCommand);
    }

    @Override
    public void undoLast() {
        assert !aExecutedCommands.isEmpty();
        UndoableCommand command = aExecutedCommands.removeLast();
        command.undo();
        aUndoneCommands.add(command);
    }

    @Override
    public void redoLast() {
        assert !aUndoneCommands.isEmpty();
        UndoableCommand command = aUndoneCommands.removeLast();
        consume(command);
    }
}