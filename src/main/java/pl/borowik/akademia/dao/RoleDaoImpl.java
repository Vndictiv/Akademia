package pl.borowik.akademia.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.borowik.akademia.entity.Role;

import javax.persistence.EntityManagerFactory;

@Repository
public class RoleDaoImpl implements RoleDao {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Override
    public Role findRoleByName(String theRoleName) {

        Session currentSession = entityManagerFactory.unwrap(Session.class);

        // now retrieve/read from database using name
        Query<Role> theQuery = currentSession.createQuery("FROM role where name=:roleName", Role.class);
        theQuery.setParameter("roleName", theRoleName);

        Role theRole = null;

        try {
            theRole = theQuery.getSingleResult();
        } catch (Exception e) {
            theRole = null;
        }

        return theRole;
    }
}
