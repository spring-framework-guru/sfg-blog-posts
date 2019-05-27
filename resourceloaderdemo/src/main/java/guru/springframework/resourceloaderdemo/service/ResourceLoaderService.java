package guru.springframework.resourceloaderdemo.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

@Component("resourceLoaderService")
public class ResourceLoaderService implements ResourceLoaderAware {
	private ResourceLoader resourceLoader;

	public void setResourceLoader(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}

	/*
	 * This method reads the resource from root path. The method getResource()
	 * accepts string value. In "file:pom.xml", no path is given so it considers the
	 * root as path.
	 * @throws IOException
	 */
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

	/*
	 * This method reads the resource from file path. As we have given the absolute
	 * path the ResourceLoader loads the file from that location. 
	 * Ensure to modify the path "file:d:/test.txt" according to your local storage
	 * @throws IOException
	 */
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

	/*
	 * This method reads the resource from class path. Using "classpath"
	 * ResourceLoader loads the file from the thread context having resources
	 * folder.
	 * @throws IOException
	 */
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

	/*
	 * This method reads the resource from URL. ResourceLoader loads file via URL such
	 * as file, an HTTP target, an FTP target, etc.
	 * @throws IOException
	 */
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
