import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Speech {

    private final String name;
    private final ArrayList<State> states;
    private State currentState;

    public Speech(String name, ArrayList<State> states) {
        this.name = name;
        this.states = states;
        setStartState();
    }

    public boolean isValidString(String string) {
        if (string == null || string.isEmpty()) {
            return false;
        }

        for (char c : string.toCharArray()) {
            Optional<State> nextState = currentState.acceptState(c);
            if (nextState.isEmpty()) {
                return false;
            }
            currentState = nextState.get();
        }

        return currentState.isFinishState();
    }

    private void setStartState() {
        List<State> startStates = states.stream().filter(State::isStartState).collect(Collectors.toList());
        if (startStates.isEmpty()) {
            throw new IllegalArgumentException("No Start State set!");
        }
        if (startStates.size() > 1) {
            throw new IllegalArgumentException("There can only be one Start State!");
        }
        currentState = startStates.get(0);
    }
}