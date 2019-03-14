package pl.borowik.akademia.dao;

import pl.borowik.akademia.entity.Role;

public interface RoleDao {

    Role findRoleByName(String theRoleName);
}
