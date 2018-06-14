package pl.lukasz.university.service.implementation;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.lukasz.university.entity.Role;
import pl.lukasz.university.entity.User;
import pl.lukasz.university.repository.UserRepository;

import java.util.HashSet;
import java.util.Set;
@Service("userDetails")
public class UserDetailsServiceImpl implements UserDetailsService {
        private UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

        for(Role role: user.getRole()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        org.springframework.security.core.userdetails.User userDetails = new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),true,true,true,true, grantedAuthorities);
        return userDetails;
    }
}
