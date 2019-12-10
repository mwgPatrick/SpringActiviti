package com.example.demo.util;

import org.activiti.engine.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * ActivitiUtils
 *
 * @author mawengang
 * @date 2019/12/10 10:02
 */
@Component
public class ActivitiUtils {
    public static ProcessEngine processEngine;
    public static RepositoryService repositoryService;
    public static TaskService taskService;
    public static IdentityService identityService;
    public static HistoryService historyService;
    public static RuntimeService runtimeService;

    @Autowired
    public void setProcessEngine(ProcessEngine processEngine) {
        ActivitiUtils.processEngine = processEngine;
    }

    @Autowired
    public void setRepositoryService(RepositoryService repositoryService) {
        ActivitiUtils.repositoryService = repositoryService;
    }

    @Autowired
    public void setTaskService(TaskService taskService) {
        ActivitiUtils.taskService = taskService;
    }

    @Autowired
    public void setIdentityService(IdentityService identityService) {
        ActivitiUtils.identityService = identityService;
    }

    @Autowired
    public void setHistoryService(HistoryService historyService) {
        ActivitiUtils.historyService = historyService;
    }

    @Autowired
    public void setRuntimeService(RuntimeService runtimeService) {
        ActivitiUtils.runtimeService = runtimeService;
    }
}
