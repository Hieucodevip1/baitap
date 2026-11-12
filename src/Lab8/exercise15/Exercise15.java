package Lab8.exercise15;

import Lab8.exercise15.Program3.Day;

public class Exercise15 {
    public static void main(String[] args) {
        Program3 program = new Program3();

        UndoableCommand command = program.createAddCommand(new Movie("Movie 1", 2000, 120), Day.MONDAY);
        command.execute();
        command.undo();
        command.execute();

        command = program.createAddCommand(new Movie("Movie 2", 2010, 90), Day.WEDNESDAY);
        command.execute();

        command = program.createRemoveCommand(Day.MONDAY);
        command.execute();
        command.undo();

        command = program.createClearCommand();
        command.execute();
        command.undo();

        System.out.println("--- Lịch chiếu sau khi hoàn tất Exercise 15 ---");
        System.out.println(program);
    }
}