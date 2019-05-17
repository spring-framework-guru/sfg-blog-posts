package howto.ResourceLoaderExample;

import org.springframework.core.io.DefaultResourceLoader;

import howto.service.ResourceLoaderService;

public class App {
	public static void main(String[] args) {
		final DefaultResourceLoader resourceLoader = new DefaultResourceLoader();
		ResourceLoaderService loader = new ResourceLoaderService();

		System.out.println("*** Resource loader using root ***");

		try {
			loader.setResourceLoader(resourceLoader);
			loader.showResourceDataUsingRoot();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("*** Resource loader using file path ***");

		try {
			loader.setResourceLoader(resourceLoader);
			loader.showResourceDataUsingFilePath();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("*** Resource loader using class path ***");

		try {
			loader.setResourceLoader(resourceLoader);
			loader.showResourceDataUsingClassPath();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("*** Resource loader using URL ***");

		try {
			loader.setResourceLoader(resourceLoader);
			loader.showResourceDataUsingURL();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
