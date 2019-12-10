package com.example.demo.util;

import org.activiti.engine.*;

/**
 * ActivitiUtils
 *
 * @author mawengang
 * @date 2019/12/10 10:02
 */
public class ActivitiUtils {
    private static ProcessEngine getProcessEngine() {
        return ProcessEngines.getDefaultProcessEngine();
    }

    private static RepositoryService getRepositoryService() {
        return getProcessEngine().getRepositoryService();
    }

    private static TaskService getTaskService() {
        return getProcessEngine().getTaskService();
    }

    private static RuntimeService getRuntimeService() {
        return getProcessEngine().getRuntimeService();
    }

    private static HistoryService getHistoryService() {
        return getProcessEngine().getHistoryService();
    }

    private static IdentityService getIdentityService(){
        return getProcessEngine().getIdentityService();
    }
}
