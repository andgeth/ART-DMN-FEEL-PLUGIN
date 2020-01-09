package com.artezio.camunda.plugin;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.camunda.bpm.dmn.engine.DmnDecisionResult;
import org.camunda.bpm.engine.DecisionService;
import org.camunda.bpm.engine.test.Deployment;
import org.camunda.bpm.engine.test.ProcessEngineRule;
import org.camunda.bpm.engine.variable.VariableMap;
import org.camunda.bpm.engine.variable.Variables;
import org.junit.Rule;
import org.junit.Test;

@Deployment(resources = "feelExtensionPluginTest.dmn")
public class FeelExtensionPluginTest {
    
    @Rule
    public ProcessEngineRule processEngineRule = new ProcessEngineRule();

    @Test
    public void testPreInitProcessEngineConfigurationImpl() {
        
        DecisionService decisionService = processEngineRule.getDecisionService();
        VariableMap variables = Variables.createVariables()
                .putValue("input", Arrays.asList("text1", "text2"));
        
        DmnDecisionResult decisionResult = decisionService
                .evaluateDecisionByKey("decision1")
                .variables(variables)
                .evaluate();
        
        assertTrue((Boolean) decisionResult.get(0).getEntry("result"));
    }

}
