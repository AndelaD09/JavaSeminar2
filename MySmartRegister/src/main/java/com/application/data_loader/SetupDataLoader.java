package com.application.data_loader;

import com.application.persistence.entities.Privilege;
import com.application.persistence.repositories.PrivilegeRepository;
import com.application.persistence.repositories.RoleRepository;
import com.application.persistence.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {
    boolean setup = false;

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PrivilegeRepository privilegeRepository;


    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (setup)
            return;

        var writePrivilege = createPriviledgeIfNotFound("READ");
        var readPrivilege = createPriviledgeIfNotFound("WRITE");
        var executePrivilege = createPriviledgeIfNotFound("EXECUTE");
    }

    @Transactional
    public Privilege createPriviledgeIfNotFound(String name){
        var privilege = privilegeRepository.findByName(name);
        if (privilege.equals(null)){
            privilege = new Privilege();
            privilege.setName(name);
            privilegeRepository.save(privilege);
        }
        return privilege;
    }


}
