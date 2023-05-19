package br.com.lsant.postApi.domain.services;

import br.com.lsant.postApi.core.security.UserDetailsImpl;
import br.com.lsant.postApi.domain.models.User;
import br.com.lsant.postApi.domain.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsImplServices implements UserDetailsService {

    private final UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("username not found: " + username);
        }
        return new UserDetailsImpl(user.getId(), user.getUsername(), user.getPassword(), user.getProfiles());
    }
}
