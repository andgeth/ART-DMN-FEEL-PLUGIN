package com.artezio.camunda.plugin;

import org.camunda.bpm.dmn.engine.impl.DmnExpressionImpl;
import org.camunda.bpm.dmn.engine.impl.spi.transform.DmnElementTransformContext;
import org.camunda.bpm.dmn.engine.impl.transform.DmnDecisionTableConditionTransformHandler;
import org.camunda.bpm.model.dmn.instance.InputEntry;

public class ListContainsExpressionHandler extends DmnDecisionTableConditionTransformHandler {

    private static final String COLLECTION_CONTAINS_EXPRESSION = "list contains(?, %s)";

    @Override
    protected DmnExpressionImpl createFromInputEntry(DmnElementTransformContext context, InputEntry inputEntry) {
        DmnExpressionImpl result = super.createFromInputEntry(context, inputEntry);
        
        String expression = result.getExpression();
        if (expression != null && expression.startsWith("~")) {
            result.setExpression(String.format(COLLECTION_CONTAINS_EXPRESSION, expression.substring(1).trim()));
        }
        return result;
    }

   

}
