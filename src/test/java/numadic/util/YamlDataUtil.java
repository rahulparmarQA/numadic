package numadic.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.yaml.snakeyaml.Yaml;

import numadic.base.BaseClass;

public class YamlDataUtil extends BaseClass {

	@DataProvider
	public static Object[][] applcationFill() {
		return readYAML("src/test/resources/yaml/testData.yaml", "applcationFill");
	}

	@DataProvider
	public static Object[][] verifyValidation() {
		return readYAML("src/test/resources/yaml/testData.yaml", "verifyValidation");
	}

	@DataProvider
	public static Object[][] clickInterested() {
		return readYAML("src/test/resources/yaml/testData.yaml", "clickInterested");
	}

	@DataProvider
	public static Object[][] verifyPageTitle() {
		return readYAML("src/test/resources/yaml/testData.yaml", "verifyPageTitle");
	}

	@DataProvider
	public static Object[][] filterQA() {
		return readYAML("src/test/resources/yaml/testData.yaml", "filterQA");
	}

	@DataProvider
	public static Object[][] verifyHeader() {
		return readYAML("src/test/resources/yaml/testData.yaml", "verifyHeader");
	}

	private static Object[][] readYAML(String fileName, String yamlObj) {
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(fileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Yaml yaml = new Yaml();
		Map<String, String> data = yaml.load(inputStream);

		Object[][] testData = new Object[1][1];
		testData[0][0] = data.get(yamlObj);
		return testData;
	}

}
