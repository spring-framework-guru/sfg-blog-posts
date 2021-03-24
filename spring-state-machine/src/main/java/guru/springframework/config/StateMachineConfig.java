package guru.springframework.config;

import guru.springframework.Listener;
import guru.springframework.domain.BlogEvents;
import guru.springframework.domain.BlogStates;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;

import java.util.EnumSet;

@Configuration
@EnableStateMachine
public class StateMachineConfig extends EnumStateMachineConfigurerAdapter<BlogStates, BlogEvents> {

    @Override
    public void configure(StateMachineStateConfigurer<BlogStates, BlogEvents> states) throws Exception {
        states.withStates()
                .initial(BlogStates.UNEDITED_BLOG)
                .states(EnumSet.allOf(BlogStates.class));
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<BlogStates, BlogEvents> transitions) throws Exception {
        transitions
                .withExternal()
                .source(BlogStates.UNEDITED_BLOG)
                .target(BlogStates.EDITING_IN_PROGRESS)
                .event(BlogEvents.EDIT_BLOG)
                .and()
                .withExternal()
                .source(BlogStates.EDITING_IN_PROGRESS)
                .target(BlogStates.BLOG_EDITED)
                .event(BlogEvents.EDIT_BLOG)
                .and()
                .withExternal()
                .source(BlogStates.BLOG_EDITED)
                .target(BlogStates.BLOG_PUBLISHED)
                .event(BlogEvents.PUBLISH_BLOG)
                .and()
                .withExternal()
                .source(BlogStates.BLOG_PUBLISHED)
                .target(BlogStates.BLOG_EDITED)
                .event(BlogEvents.EDIT_BLOG);
    }

    @Override
    public void configure(StateMachineConfigurationConfigurer<BlogStates, BlogEvents> config) throws Exception {
        config.withConfiguration()
                .autoStartup(true)
                .listener(new Listener());
    }

}

