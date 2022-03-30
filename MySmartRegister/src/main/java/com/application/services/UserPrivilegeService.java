package com.application.services;

import com.application.persistence.entities.Privilege;
import com.application.persistence.entities.Role;
import com.application.persistence.repositories.PrivilegeRepository;
import com.application.persistence.repositories.RoleRepository;
import com.application.persistence.repositories.UserRepository;
import com.application.utils.enums.UserType;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Transactional
@Data
public class UserPrivilegeService {
    private boolean setup = false;
    @Autowired
    private final RoleRepository roleRepository;
    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final PrivilegeRepository privilegeRepository;

    public void setupAdmin(){
        if(setup)
            return;

        Privilege readPrivilege = createPrivilegeIfNotFound("ReadAdmin");
        Privilege writePrivilege = createPrivilegeIfNotFound("WriteAdmin");

        var adminRole = createRoleIfNotFound(UserType.ADMIN);
        var adminPrivileges = List.of(readPrivilege, writePrivilege);
        adminRole.setPrivileges(adminPrivileges);

        setup = true;
    }

    private Privilege createPrivilegeIfNotFound(String priv){
        var privilege = privilegeRepository.findByName(priv);

        if(privilege.equals(null)){
            privilege.setName(priv);
            privilegeRepository.save(privilege);
        }
        return privilege;
    }

    private Role createRoleIfNotFound(UserType userType){
        var role = roleRepository.findRoleByName(userType);

        if(role.equals(null)){
            role.setName(userType);
            roleRepository.save(role);
        }
        return role;
    }

    public Collection<? extends GrantedAuthority> getAuthorities(Collection<Role> roles){
        return getGrantedAuthority(getPrivileges(roles));
    }

    private ArrayList<GrantedAuthority> getGrantedAuthority(ArrayList<String> privileges){
        var granted = new ArrayList<GrantedAuthority>();

        privileges.forEach(privilege -> granted.add(new SimpleGrantedAuthority(privilege)));
        return granted;
    }

    private ArrayList<String> colllectFromCollection(ArrayList<Privilege> p, ArrayList<String> n){
        p.stream().forEach(priv -> n.add(priv.getName()));
        return n;
    }

    private ArrayList<String> getPrivileges(Collection<Role> roles){
        var privileges = new ArrayList<String>();
        var privilegeCollection = new ArrayList<Privilege>();

        roles.stream().forEach(role -> {
                    privileges.add(role.getName().toString());
                    privilegeCollection.addAll(role.getPrivileges());
                }
                );
        return colllectFromCollection(privilegeCollection, privileges);
    }
}
