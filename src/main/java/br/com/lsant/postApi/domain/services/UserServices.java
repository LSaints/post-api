package br.com.lsant.postApi.domain.services;

import br.com.lsant.postApi.domain.models.User;
import br.com.lsant.postApi.domain.repositories.UserRepository;
import br.com.lsant.postApi.domain.services.exceptions.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServices {
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(
                "User not found ID:" + id + ", Type: " + User.class.getName()
        ));
    }

    public User save(User user) {
        user.setDateIssue(new Date());
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return repository.save(user);
    }

    public User update(User user) {
        User updatedUser = findById(user.getId());
        updatedUser.setDateUpdate(new Date());
        updatedUser.setUsername(user.getUsername());
        updatedUser.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return repository.save(updatedUser);
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            throw new EntityNotFoundException("Cannot delete this entity in application");
        }
    }
}
