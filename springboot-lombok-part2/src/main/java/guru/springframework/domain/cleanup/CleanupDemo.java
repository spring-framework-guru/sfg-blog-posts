package guru.springframework.domain.cleanup;

import lombok.Cleanup;

import java.io.*;

public class CleanupDemo {
    public void performIO() throws FileNotFoundException , IOException{
        @Cleanup InputStream is = new FileInputStream(new File("/Users/guru/data.txt"));
    }
}
