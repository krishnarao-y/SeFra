package com.cucumber.tests;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(features = "src/test/java/features",
				plugin = "json:target/cucumber.json",
				format = {"pretty", "html:target/cucumber_html_report"}
				)
public class RunCukesTest extends AbstractTestNGCucumberTests {

}