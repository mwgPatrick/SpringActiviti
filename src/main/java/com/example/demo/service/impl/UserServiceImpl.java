package com.example.demo.service.impl;

import com.example.demo.service.UserService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * UserServiceImpl
 *
 * @author mawengang
 * @date 2019/12/10 10:45
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private IdentityService identityService;
    @Override
    public void initUsersAndGroups(){
        createUser("shimin","市民");
        createUser("wanggeyuan","网格员");
        createUser("wanggezhang","网格长");
        createUser("zuoyebumen","作业部门");
        createUser("weibanju","委办局");
        createUser("zhanquzhang","站区长");
        createUser("root","root");

        createGroup("citizen","市民");
        createGroup("gridleader","网格长");
        createGroup("gridman","网格员");
        createGroup("workoffice","作业部门");
        createGroup("powerboard","委办局");
        createGroup("zhanquzhang","站区长");
        createGroup("admin","admin");

//        identityService.createMembership("shimin","citizen");
//        identityService.createMembership("wanggeyuan", "gridman");
//        identityService.createMembership("wanggezhang", "gridleader");
//        identityService.createMembership("weibanju", "powerboard");
//        identityService.createMembership("zuoyebumen", "workoffice");
//        identityService.createMembership("zhanquzhang", "zhanquzhang");
//        identityService.createMembership("root","citizen");
//        identityService.createMembership("root","gridman");
//        identityService.createMembership("root", "gridleader");
//        identityService.createMembership("root", "workoffice");
//        identityService.createMembership("root", "powerboard");
//        identityService.createMembership("root", "zhanquzhang");
    }

    private void createUser(String userId, String firstName){
        if(identityService.createUserQuery().userId(userId).singleResult()!=null) {
            return;
        }
        User user = identityService.newUser(userId);
        user.setEmail(userId.concat("@123.com"));
        user.setLastName("甲");
        user.setFirstName(firstName);
        user.setPassword("123456");
        user.setId(userId);

        identityService.saveUser(user);
    }

    private void createGroup(String groupId, String groupName){
        if (identityService.createGroupQuery().groupId(groupId).singleResult() != null) {
            return;
        }
        Group group = identityService.newGroup(groupId);
        group.setId(groupId);
        group.setName(groupName);
        identityService.saveGroup(group);
    }

}
