package com.example.demo.controller;

import com.example.demo.util.ActivitiUtils;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    private ProcessEngine processEngine;
    @Autowired
    private RepositoryService repositoryService;

    @ResponseBody
    @RequestMapping("/list")
    public int list(){
        return repositoryService.createDeploymentQuery().list().size();
    }
}
