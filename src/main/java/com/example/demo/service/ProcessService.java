package com.example.demo.service;

import org.activiti.engine.impl.persistence.entity.DeploymentEntityImpl;

import java.util.List;

/**
 * ProcessService
 *
 * @author mawengang
 * @date 2019/12/10 16:08
 */
public interface ProcessService {
    List<DeploymentEntityImpl> list();
}
