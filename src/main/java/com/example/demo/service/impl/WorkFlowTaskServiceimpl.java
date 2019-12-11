package com.example.demo.service.impl;

import com.example.demo.service.WorkFlowTaskService;
import com.example.demo.util.ActivitiUtils;
import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.task.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * WorkFlowTaskServiceimpl
 *
 * @author mawengang
 * @date 2019/12/11 15:16
 */
@Slf4j
@Service
public class WorkFlowTaskServiceimpl implements WorkFlowTaskService {

    @Override
    public void completeTask(String taskId, String userId){
            ActivitiUtils.taskService.complete(taskId);
    }

    @Override
    public String claimTask(String taskId, String userId){
        List<Task> list = ActivitiUtils.taskService.createTaskQuery().taskCandidateOrAssigned(userId).list();
        Task task = ActivitiUtils.taskService.createTaskQuery().taskId(taskId).singleResult();
        List<String> tasks = new ArrayList<>();
        list.stream().forEach(l -> tasks.add(l.getId()));
        if(tasks.contains(task.getId())){
            ActivitiUtils.taskService.claim(taskId, userId);
            log.info("任务 {} 认领成功。",taskId);
            return "1";
        } else {
            log.info("任务 {} 认领失败。", taskId);
            return "0";
        }
    }
}
