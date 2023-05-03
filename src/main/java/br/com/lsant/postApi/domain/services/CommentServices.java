package br.com.lsant.postApi.domain.services;

import br.com.lsant.postApi.domain.models.Comment;
import br.com.lsant.postApi.domain.repositories.CommentRepository;
import br.com.lsant.postApi.domain.services.exceptions.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServices {
    private final CommentRepository repository;

    public List<Comment> findAll() {
        return repository.findAll();
    }

    public List<Comment> findByAuthorId(Long id) {
        return repository.findByAuthorId(id);
    }

    public List<Comment> findByPostId(Long id) {
        return repository.findByPostId(id);
    }

    public Comment findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(
                "Post not found ID:" + id + ", Type: " + Comment.class.getName()
        ));
    }

    public Comment save(Comment comment) {
        comment.setDateIssue(new Date());
        return repository.save(comment);
    }

    public Comment update(Comment comment) {
        Comment updatedComment = findById(comment.getId());
        updatedComment.setDateUpdate(new Date());
        updatedComment.setContent(comment.getContent());
        return repository.save(updatedComment);
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            throw new EntityNotFoundException("Cannot delete this entity in application");
        }
    }
}
