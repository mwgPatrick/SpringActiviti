package com.example.demo.controller;

import com.example.demo.config.WebSecurityConfig;
import com.example.demo.service.WorkFlowTaskService;
import com.example.demo.util.ActivitiUtils;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * TaskController
 *
 * @author mawengang
 * @date 2019/12/11 15:14
 */
@Controller
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private WorkFlowTaskService workFlowTaskService;

    @ResponseBody
    @RequestMapping("/list")
    public String list(){
        List<Task> list = ActivitiUtils.taskService.createTaskQuery().list();
        List<String> a = new ArrayList<>();
        list.stream().forEach(l -> a.add(l.getName()));
//        return String.valueOf(list.size());
        return a.toString();
    }

    @ResponseBody
    @RequestMapping("/todo")
    public String toDoTasks(HttpSession session){
        String userId = session.getAttribute(WebSecurityConfig.SESSION_KEY)==null?"":session.getAttribute(WebSecurityConfig.SESSION_KEY).toString();
        List<Task> list = ActivitiUtils.taskService.createTaskQuery().taskCandidateOrAssigned(userId).list();
        List<String> result = new ArrayList<>();
        list.stream().forEach(l -> result.add(l.getName().concat("  ").concat(l.getId())));
        return result.toString();
    }

    @ResponseBody
    @RequestMapping("/complete")
    public String completeCurrentTask(HttpSession session, String taskId){
        String userId = session.getAttribute(WebSecurityConfig.SESSION_KEY)==null?"":session.getAttribute(WebSecurityConfig.SESSION_KEY).toString();
        String name = ActivitiUtils.taskService.createTaskQuery().taskId(taskId).singleResult().getName();
        if("1".equals(workFlowTaskService.claimTask(taskId, userId))){
            workFlowTaskService.completeTask(taskId,userId);
        } else {
            return " 任务认领失败，请检查是否属于当前任务节点的用户组。";
        }
        return name.concat("已完成。");
    }
}
