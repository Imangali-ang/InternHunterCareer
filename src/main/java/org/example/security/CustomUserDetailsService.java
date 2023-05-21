package org.example.security;

import org.example.model.User;
import org.example.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userNumber) throws UsernameNotFoundException {
        User user = userRepository.findByUserNumber(userNumber)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + userNumber));
        return new CustomUserDetails(user);
    }
}
