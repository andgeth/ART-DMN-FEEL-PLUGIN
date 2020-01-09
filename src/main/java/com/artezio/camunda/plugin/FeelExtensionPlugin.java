package com.artezio.camunda.plugin;

import org.camunda.bpm.dmn.engine.impl.DefaultDmnEngineConfiguration;
import org.camunda.bpm.engine.impl.cfg.AbstractProcessEnginePlugin;
import org.camunda.bpm.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.camunda.bpm.model.dmn.instance.InputEntry;

public class FeelExtensionPlugin extends AbstractProcessEnginePlugin {

    @Override
    public void preInit(ProcessEngineConfigurationImpl processEngineConfiguration) {
        DefaultDmnEngineConfiguration dmnEngineConfiguration = processEngineConfiguration.getDmnEngineConfiguration();
        dmnEngineConfiguration.getTransformer()
                .getElementTransformHandlerRegistry()
                .addHandler(InputEntry.class, new ListContainsExpressionHandler());
    }

}
