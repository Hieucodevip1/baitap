package Lab8.exercise18;

import Lab8.exercise18.Program.Day;

public class Exercise18 {
    public static void main(String[] args) {
        // Khởi tạo Processor và tiêm (inject) vào Program
        CommandProcessor processor = new BasicCommandProcessor();
        Program program = new Program(processor);

        // Client gọi trực tiếp add, remove, clear, undo, redo một cách tự nhiên
        program.add(new Movie("Movie 1", 2000, 120), Day.MONDAY);
        program.add(new Movie("Movie 2", 2010, 90), Day.WEDNESDAY);
        System.out.println("--- Sau khi thêm 2 phim ---\n" + program);

        program.clear();
        System.out.println("--- Sau khi Clear ---\n" + program);

        program.undo();
        System.out.println("--- Sau khi Undo Clear ---\n" + program);

        program.redo();
        System.out.println("--- Sau khi Redo Clear ---\n" + program);
    }
}