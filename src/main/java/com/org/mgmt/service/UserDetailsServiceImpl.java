package com.org.mgmt.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.org.mgmt.entity.User;
import com.org.mgmt.mapper.UserMapper;
import com.org.mgmt.repo.UserRepository;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException("User NOT Found"));
        return UserMapper.userToPrincipal(user);
    }

}
