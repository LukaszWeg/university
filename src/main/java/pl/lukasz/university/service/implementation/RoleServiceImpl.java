package pl.lukasz.university.service.implementation;

import org.springframework.stereotype.Service;
import pl.lukasz.university.entity.Role;
import pl.lukasz.university.repository.RoleRepository;
import pl.lukasz.university.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role findByName(String name) {
        return roleRepository.findByName(name);
    }
}
