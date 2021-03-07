package org.springframework.guru.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.guru.domain.Blog;
import org.springframework.guru.repository.BlogRepository;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {
    private BlogRepository blogRepository;
    @Autowired
    public BootstrapData(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        blogRepository.save(new Blog("Blog 5",1999));
        blogRepository.save(new Blog("Blog 1",2006));
        blogRepository.save(new Blog("Blog 1",2021));
        blogRepository.save(new Blog("Blog 1",2020));
        blogRepository.save(new Blog("Blog 3",2020));
    }


}
