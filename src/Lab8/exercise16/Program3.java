package Lab8.exercise16;

import java.util.EnumMap;

public class Program3 {
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
            @Override
            public int hashCode() { return 0; }
            @Override
            public boolean equals(Object pObject) {
                return pObject != null && pObject.getClass() == this.getClass();
            }
        };
    }

    private final EnumMap<Day, Show> aShows = new EnumMap<>(Day.class);

    public Program3() {
        clear();
    }

    public UndoableCommand createAddCommand(Show pShow, Day pDay) {
        return new UndoableCommand() {
            @Override
            public void execute() {
                add(pShow, pDay);
            }

            @Override
            public void undo() {
                remove(pDay);
            }
        };
    }

    public UndoableCommand createRemoveCommand(Day pDay) {
        return new UndoableCommand() {
            Show show = aShows.get(pDay);

            @Override
            public void execute() {
                show = aShows.get(pDay);
                remove(pDay);
            }

            @Override
            public void undo() {
                add(show, pDay);
            }
        };
    }

    public UndoableCommand createClearCommand() {
        return new UndoableCommand() {
            EnumMap<Day, Show> previousShows = new EnumMap<>(aShows);

            @Override
            public void execute() {
                previousShows = new EnumMap<>(aShows);
                clear();
            }

            @Override
            public void undo() {
                aShows.putAll(previousShows);
            }
        };
    }

    private void clear() {
        for (Day day : Day.values()) {
            aShows.put(day, NULL_SHOW);
        }
    }

    private void add(Show pShow, Day pDay) {
        assert pShow != null && pDay != null;
        aShows.put(pDay, pShow);
    }

    private void remove(Day pDay) {
        assert pDay != null;
        aShows.put(pDay, NULL_SHOW);
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