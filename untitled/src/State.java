import java.util.HashMap;
import java.util.Optional;

public class State {

    private HashMap<Character, State> acceptStates;
    private boolean startState;
    private boolean finishState;

    public State(HashMap<Character, State> acceptStates) {
        startState = false;
        finishState = false;
        this.acceptStates = acceptStates;
    }

    public State(boolean startState, boolean finishState, HashMap<Character, State> acceptStates) {
        this.startState = startState;
        this.finishState = finishState;
        this.acceptStates = acceptStates;
    }

    public Optional<State> acceptState(char c) {
        if (!acceptStates.containsKey(c)) {
            return Optional.empty();
        }
        return Optional.of(acceptStates.get(c));
    }

    public boolean isStartState() {
        return startState;
    }

    public boolean isFinishState() {
        return finishState;
    }

}
