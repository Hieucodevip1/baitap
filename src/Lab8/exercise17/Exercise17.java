package Lab8.exercise17;

import Lab8.exercise17.Program3.Day;

public class Exercise17 {
    public static void main(String[] args) {
        Program3 program = new Program3();
        CommandProcessor2 processor = new CommandProcessor2();

        processor.consume(program.createAddCommand(new Movie("Movie 1", 2000, 120), Day.MONDAY));
        processor.consume(program.createAddCommand(new Movie("Movie 2", 2010, 90), Day.FRIDAY));

        processor.undoLast();
        System.out.println("--- Sau khi Undo (mất Movie 2) ---\n" + program);

        processor.redoLast();
        System.out.println("--- Sau khi Redo (khôi phục Movie 2) ---\n" + program);
    }
}