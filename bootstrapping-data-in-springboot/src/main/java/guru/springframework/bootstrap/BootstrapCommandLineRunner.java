package guru.springframework.bootstrap;

import guru.springframework.model.MemeMaker;
import guru.springframework.repository.MemeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapCommandLineRunner implements CommandLineRunner {

    private MemeRepository memeRepository;

    @Autowired
    public BootstrapCommandLineRunner(MemeRepository memeRepository) {
        this.memeRepository = memeRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        memeRepository.save(new MemeMaker("Alex","Novice", "Sports"));
        memeRepository.save(new MemeMaker("John","OG", "Wholesome"));
        memeRepository.findAll().forEach((meme) -> {
        });
    }
}