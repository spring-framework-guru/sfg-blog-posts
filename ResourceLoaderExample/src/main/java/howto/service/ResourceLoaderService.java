package howto.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

public class ResourceLoaderService implements ResourceLoaderAware {
	private ResourceLoader resourceLoader;

	public void setResourceLoader(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}

	// This method reads the resource from file path
	public void showResourceDataUsingRoot() throws IOException {
		Resource resource = resourceLoader.getResource("file:pom.xml");

		InputStream in = resource.getInputStream();

		BufferedReader reader = new BufferedReader(new InputStreamReader(in));

		while (true) {
			String line = reader.readLine();
			if (line == null)
				break;
			System.out.println(line);
		}
		reader.close();
	}

	// This method reads the resource from file path
	public void showResourceDataUsingFilePath() throws IOException {
		Resource resource = resourceLoader.getResource("file:d:/test.txt");

		InputStream in = resource.getInputStream();

		BufferedReader reader = new BufferedReader(new InputStreamReader(in));

		while (true) {
			String line = reader.readLine();
			if (line == null)
				break;
			System.out.println(line);
		}
		reader.close();
	}

	// This method reads the resource from class path
	public void showResourceDataUsingClassPath() throws IOException {
		Resource resource = resourceLoader.getResource("classpath:test.txt");

		InputStream in = resource.getInputStream();

		BufferedReader reader = new BufferedReader(new InputStreamReader(in));

		while (true) {
			String line = reader.readLine();
			if (line == null)
				break;
			System.out.println(line);
		}
		reader.close();
	}

	// This method reads the resource from URL
	public void showResourceDataUsingURL() throws IOException {
		Resource resource = resourceLoader.getResource("https://cdnjs.cloudflare.com/ajax/libs/crypto-js/3.1.2/rollups/sha1.js");

		InputStream in = resource.getInputStream();

		BufferedReader reader = new BufferedReader(new InputStreamReader(in));

		while (true) {
			String line = reader.readLine();
			if (line == null)
				break;
			System.out.println(line);
		}
		reader.close();
	}
}
