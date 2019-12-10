//package com.example.demo.config;
//
//import com.example.demo.util.ActivitiUtils;
//import lombok.extern.slf4j.Slf4j;
//import org.activiti.engine.ProcessEngine;
//import org.activiti.engine.ProcessEngines;
//import org.activiti.engine.RepositoryService;
//import org.activiti.engine.repository.Deployment;
//import org.activiti.engine.repository.DeploymentBuilder;
//import org.activiti.engine.repository.ProcessDefinition;
//import org.activiti.engine.repository.ProcessDefinitionQuery;
//import org.activiti.engine.runtime.ProcessInstance;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import static sun.misc.PostVMInitHook.run;
//
///**
// * AutoConfigurationProcess
// *
// * @author mawengang
// * @date 2019/12/10 17:58
// */
//@Configuration
//@Slf4j
//public class AutoConfigurationProcess implements CommandLineRunner {
//    @Override
//    public void run(String... args) throws Exception {
////        DeploymentBuilder createDeployment = ActivitiUtils.repositoryService.createDeployment();
////        DeploymentBuilder addClasspathResource = createDeployment.addClasspathResource("demo1.bpmn");
////        Deployment deploy = addClasspathResource.deploy();
////
////        //获取流程实例信息
////        ProcessDefinitionQuery createProcessDefinitionQuery = ActivitiUtils.repositoryService.createProcessDefinitionQuery();
////        ProcessDefinitionQuery deploymentId = createProcessDefinitionQuery.deploymentId(deploy.getId());
////
////        ProcessDefinition singleResult = deploymentId.singleResult();
////
////        //流程开始
////        ProcessInstance startProcessInstanceById = ActivitiUtils.runtimeService.startProcessInstanceById(singleResult.getId());
//        Deployment deploy = ActivitiUtils.repositoryService.createDeployment()
//                // 给流程起一个名字
//                .name("站区长吹哨")
//                // 添加流程图资源文件
//                .addClasspathResource("demo1.bpmn20.xml")
//                // 部署
//                .deploy();
//        ActivitiUtils.runtimeService.startProcessInstanceById("demo1");
//    }
//}
