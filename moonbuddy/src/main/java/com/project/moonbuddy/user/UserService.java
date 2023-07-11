package com.project.moonbuddy.user;

import com.project.moonbuddy.user.config.oauth.dto.SessionUser;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;
    public User findUser(SessionUser sessionUser) {
        User user = userRepository.findByEmail(sessionUser.getEmail())
                .orElseThrow(()-> new UsernameNotFoundException("존재하지 않는 사용자입니다."));
        return user;
    }
}
