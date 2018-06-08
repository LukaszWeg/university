package pl.lukasz.university.service;

import pl.lukasz.university.entity.Role;

public interface RoleService {

    Role findByName(String name);
}
