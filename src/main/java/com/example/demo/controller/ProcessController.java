package com.example.demo.controller;

import com.example.demo.config.WebSecurityConfig;
import com.example.demo.service.ProcessService;
import com.example.demo.util.ActivitiUtils;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.impl.persistence.entity.DeploymentEntityImpl;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * ProcessController
 *
 * @author mawengang
 * @date 2019/12/10 15:38
 */
@Controller
@RequestMapping("/process")
public class ProcessController {

    @Autowired
    private ProcessService processService;

    @ResponseBody
    @RequestMapping("/list")
    public String list(){
//        return repositoryService.createDeploymentQuery().list().size();
        return processService.list().toString();
    }

    @ResponseBody
    @RequestMapping("/start")
    public String startTask(){
        ProcessInstance p = ActivitiUtils.runtimeService.startProcessInstanceByKey("demo1");
        return p.getProcessDefinitionKey();
    }

    @ResponseBody
    @RequestMapping("/count")
    public String count(){
        List<Task> list = ActivitiUtils.taskService.createTaskQuery().list();
        List<String> a = new ArrayList<>();
        list.stream().forEach(l -> a.add(l.getName()));
//        return String.valueOf(list.size());
        return a.toString();
    }

    @ResponseBody
    @RequestMapping("/todo")
    public String next(HttpSession session){
        String userId = session.getAttribute(WebSecurityConfig.SESSION_KEY)==null?"":session.getAttribute(WebSecurityConfig.SESSION_KEY).toString();
        List<Task> list = ActivitiUtils.taskService.createTaskQuery().taskCandidateOrAssigned(userId).list();
        List<String> result = new ArrayList<>();
        list.stream().forEach(l -> result.add(l.getName()));
        return result.toString();
    }
}
