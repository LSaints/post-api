package br.com.lsant.postApi.domain.services;

import br.com.lsant.postApi.domain.models.Post;
import br.com.lsant.postApi.domain.repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServices {
    private final PostRepository repository;

    public List<Post> findAll() {
        return repository.findAll();
    }

    public List<Post> findByAuthorId(Long id) {
        return repository.findByAuthorId(id);
    }

    public Post findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException(
                "Post not found ID:" + id + ", Type: " + Post.class.getName()
        ));
    }

    public Post save(Post post) {
        post.setDateIssue(new Date());
        return repository.save(post);
    }

    public Post update(Post post) {
        Post updatedPost = findById(post.getId());
        updatedPost.setDateUpdate(new Date());
        updatedPost.setTitle(post.getTitle());
        updatedPost.setContent(post.getContent());
        return repository.save(updatedPost);
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Cannot delete this entity in application");
        }
    }

}
