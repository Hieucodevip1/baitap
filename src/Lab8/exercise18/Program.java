package Lab8.exercise18;

import java.util.EnumMap;

public class Program {
    public enum Day {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }

    private static final Show NULL_SHOW = createNullShow();

    private static Show createNullShow() {
        return new Show() {
            @Override
            public String description() { return ""; }
            @Override
            public int runningTime() { return 0; }
            @Override
            public Show copy() { return createNullShow(); }
        };
    }

    private final EnumMap<Day, Show> aShows = new EnumMap<>(Day.class);
    private final CommandProcessor aProcessor;

    // Dependency Injection qua constructor theo sơ đồ UML
    public Program(CommandProcessor pProcessor) {
        assert pProcessor != null;
        this.aProcessor = pProcessor;
        for (Day day : Day.values()) {
            aShows.put(day, NULL_SHOW);
        }
    }

    // Các phương thức public tự nhiên cho Client
    public void add(Show pShow, Day pDay) {
        aProcessor.consume(createAddCommand(pShow, pDay));
    }

    public void remove(Day pDay) {
        aProcessor.consume(createRemoveCommand(pDay));
    }

    public void clear() {
        aProcessor.consume(createClearCommand());
    }

    public void undo() {
        aProcessor.undoLast();
    }

    public void redo() {
        aProcessor.redoLast();
    }

    // Các Factory method tạo lệnh được ẩn thành private
    private UndoableCommand createAddCommand(Show pShow, Day pDay) {
        return new UndoableCommand() {
            final Show previousShow = aShows.get(pDay);

            @Override
            public void execute() {
                aShows.put(pDay, pShow);
            }

            @Override
            public void undo() {
                aShows.put(pDay, previousShow);
            }
        };
    }

    private UndoableCommand createRemoveCommand(Day pDay) {
        return new UndoableCommand() {
            final Show previousShow = aShows.get(pDay);

            @Override
            public void execute() {
                aShows.put(pDay, NULL_SHOW);
            }

            @Override
            public void undo() {
                aShows.put(pDay, previousShow);
            }
        };
    }

    private UndoableCommand createClearCommand() {
        return new UndoableCommand() {
            final EnumMap<Day, Show> previousShows = new EnumMap<>(aShows);

            @Override
            public void execute() {
                for (Day day : Day.values()) {
                    aShows.put(day, NULL_SHOW);
                }
            }

            @Override
            public void undo() {
                aShows.putAll(previousShows);
            }
        };
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Day day : aShows.keySet()) {
            result.append(String.format("%9s", day.name()))
                  .append(": ")
                  .append(aShows.get(day).description())
                  .append("\n");
        }
        return result.toString();
    }
}