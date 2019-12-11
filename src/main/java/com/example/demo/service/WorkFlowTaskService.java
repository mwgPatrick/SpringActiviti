package com.example.demo.service;

/**
 * TaskService
 *
 * @author mawengang
 * @date 2019/12/11 15:16
 */
public interface WorkFlowTaskService {
    void completeTask(String taskId, String userId);

    String claimTask(String taskId, String userId);
}
