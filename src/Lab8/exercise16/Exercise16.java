package Lab8.exercise16;

import Lab8.exercise16.Program3.Day;

public class Exercise16 {
    public static void main(String[] args) {
        Program3 program = new Program3();
        CommandProcessor processor = new CommandProcessor();

        processor.consume(program.createAddCommand(new Movie("Movie 1", 2000, 120), Day.MONDAY));
        processor.consume(program.createAddCommand(new Movie("Movie 2", 2010, 90), Day.WEDNESDAY));
        System.out.println("--- Sau khi thêm 2 phim ---\n" + program);

        processor.undoLast();
        System.out.println("--- Sau khi Undo lệnh cuối ---\n" + program);
    }
}