package xdptdr.ulhiunteco.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;

import xdptdr.ulhiunteco.test.AbstractTest.TableOutputType;

public class DocProducer {

	public static void main(String[] args) {

		String[] testCodes = new String[] { "AA", "AB", "BJ", "BE", "BF", "BX", "CC", "CD", "CE", "CF", "CG", "CH",
				"CI", "CJ", "CK", "CL", "CM", "CN", "CO", "CP", "CQ", "CR" };

		for (String testCode : testCodes) {
			try {
				Class<?> testClass = Class.forName("xdptdr.ulhiunteco." + testCode.toLowerCase() + ".Test" + testCode);
				AbstractTest instance = (AbstractTest) testClass.newInstance();
				try {
					instance.setHbm2ddlAuto("create-drop");
					instance.setUp();
					File file = new File("doc/tables/Tables" + testCode + ".md");
					PrintStream ps = new PrintStream(file);
					instance.setTableOutputStream(ps);
					instance.setTableOutputType(TableOutputType.MARKDOWN);
					instance.getClass().getMethod("dumpTables").invoke(instance);
				} finally {
					instance.tearDown();
				}
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | NoSuchMethodException | SecurityException | FileNotFoundException e) {
				e.printStackTrace();
			}
		}

	}

}
