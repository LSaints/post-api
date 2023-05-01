package br.com.lsant.postApi.domain.services;

import br.com.lsant.postApi.domain.models.User;
import br.com.lsant.postApi.domain.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServices {
    private final UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException(
                "User not found ID:" + id + ", Type: " + User.class.getName()
        ));
    }

    public User save(User user) {
        user.setDateIssue(new Date());
        return repository.save(user);
    }

    public User update(User user) {
        User updatedUser = findById(user.getId());
        updatedUser.setDateUpdate(new Date());
        updatedUser.setUsername(user.getUsername());
        updatedUser.setPassword(user.getPassword());
        return repository.save(updatedUser);
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Cannot delete this entity in application");
        }
    }
}
