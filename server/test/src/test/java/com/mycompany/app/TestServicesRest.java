package com.mycompany.app;

import junit.framework.TestCase;
import com.eviware.soapui.tools.SoapUITestCaseRunner;

public class TestServicesRest extends TestCase {
	
private SoapUITestCaseRunner runner = null;
	
	public void setUp() throws Exception {

		runner = new SoapUITestCaseRunner();
		runner.setProjectFile("./src/test/resources/ServicesRest-soapui-project.xml");
		runner.setExportAll(true);
		runner.setPrintReport(true);
		runner.setOutputFolder("target/soapui-output/log");

	}
	
	public void test() throws Exception {
		runner.run();
	}

}
