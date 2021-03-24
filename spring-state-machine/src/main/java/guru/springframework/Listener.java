package guru.springframework;

import guru.springframework.domain.BlogEvents;
import guru.springframework.domain.BlogStates;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.state.State;


public class Listener extends StateMachineListenerAdapter<BlogStates,BlogEvents> {
    @Override
    public void stateChanged(State<BlogStates, BlogEvents> from,     State<BlogStates, BlogEvents> to) {
        System.out.println("state changed from " + from.getId()+ " to "+ to.getId());
    }
}
