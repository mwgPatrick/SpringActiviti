package com.example.demo.config;

import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.spring.ProcessEngineFactoryBean;
import org.activiti.spring.SpringProcessEngineConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * ActivitiConfiguration
 *
 * @author Mwg
 * @date 2019/12/10 21:27
 */
@Configuration

public class ActivitiConfiguration {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private PlatformTransactionManager platformTransactionManager;

    @Bean
    public SpringProcessEngineConfiguration springProcessEngineConfiguration() {

        SpringProcessEngineConfiguration spec = new SpringProcessEngineConfiguration();

        spec.setDataSource(dataSource);

        spec.setTransactionManager(platformTransactionManager);

        spec.setDatabaseSchemaUpdate("true");

        Resource[] resources = null;

// 启动自动部署流程

        try {

            resources = new PathMatchingResourcePatternResolver().getResources("classpath*:/processes/demo1.bpmn20.xml");

        } catch (IOException e) {

            e.printStackTrace();

        }

        spec.setDeploymentResources(resources);

        return spec;

    }

}