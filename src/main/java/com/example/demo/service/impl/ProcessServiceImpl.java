package com.example.demo.service.impl;

import com.example.demo.service.ProcessService;
import com.example.demo.util.ActivitiUtils;
import org.activiti.engine.impl.persistence.entity.DeploymentEntityImpl;
import org.activiti.engine.repository.Deployment;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * ProcessServiceImpl
 *
 * @author mawengang
 * @date 2019/12/10 16:08
 */
@Service
public class ProcessServiceImpl implements ProcessService {
    @Override
    public List<DeploymentEntityImpl> list(){
        List<Deployment> deployments = ActivitiUtils.repositoryService.createDeploymentQuery().list();
        List<DeploymentEntityImpl> deploymentEntityList = new ArrayList<>();
        deployments.stream().forEach(d -> {
            deploymentEntityList.add(deploymentToEntity(d));
        });
        return deploymentEntityList;
    }

    private DeploymentEntityImpl deploymentToEntity(Deployment d){
        DeploymentEntityImpl deployment = new DeploymentEntityImpl();
        deployment.setName(d.getName());
        deployment.setCategory(d.getCategory());
        deployment.setId(d.getId());
        deployment.setDeploymentTime(d.getDeploymentTime());
        deployment.setTenantId(d.getTenantId());
        deployment.setKey(d.getKey());
        return deployment;
    }
}
