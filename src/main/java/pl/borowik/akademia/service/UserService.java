package pl.borowik.akademia.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import pl.borowik.akademia.entity.CrmUser;
import pl.borowik.akademia.entity.User;

public interface UserService extends UserDetailsService {

    User findByUserName(String userName);

    void save(CrmUser crmUser);

    @Override
    UserDetails loadUserByUsername(String s) throws UsernameNotFoundException;

}
