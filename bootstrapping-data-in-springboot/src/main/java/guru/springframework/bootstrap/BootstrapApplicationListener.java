package guru.springframework.bootstrap;

import guru.springframework.model.MemeMaker;
import guru.springframework.repository.MemeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class BootstrapApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

    private MemeRepository memeRepository;

    @Autowired
    public BootstrapApplicationListener(MemeRepository memeRepository) {
        this.memeRepository = memeRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        memeRepository.save(new MemeMaker("Bob","Noobie", "Horror"));
        memeRepository.save(new MemeMaker("Hitman","OG", "Global"));

    }
}


