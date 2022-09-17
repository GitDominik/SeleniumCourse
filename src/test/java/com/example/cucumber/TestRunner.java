package com.example.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin  = "html:target/report.html",
        features = "classpath:features",
        glue = "com.example.cucumber.step"
//     ,dryRun = true
)
public class TestRunner {


}
