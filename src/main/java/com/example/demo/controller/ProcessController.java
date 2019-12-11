package com.example.demo.controller;

import com.example.demo.service.ProcessService;
import com.example.demo.util.ActivitiUtils;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;

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


    @RequestMapping("/diagram")
    public void queryProPlan(HttpServletRequest request, HttpServletResponse response, String proId) throws Exception {
        InputStream inputStream = processService.getDiagram(proId);
        byte[] b = new byte[1024];
        int len;
        while ((len = inputStream.read(b, 0, 1024)) != -1) {
            response.getOutputStream().write(b, 0, len);
        }
    }

}
