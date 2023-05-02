package br.com.lsant.postApi.data.controllers;

import br.com.lsant.postApi.data.mappers.CommentMapper;
import br.com.lsant.postApi.data.requests.CommentRequestBody;
import br.com.lsant.postApi.domain.models.Comment;
import br.com.lsant.postApi.domain.services.CommentServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {
    private final CommentServices services;
    private final CommentMapper mapper;


    @GetMapping
    public ResponseEntity<List<CommentRequestBody>> findAll() {
        return new ResponseEntity<>(mapper.toCommentRequestBodyList(services.findAll()), HttpStatus.OK);
    }

    @GetMapping("/author/{id}")
    public ResponseEntity<List<CommentRequestBody>> findByAuthorId(@PathVariable Long id){
        return new ResponseEntity<>(mapper.toCommentRequestBodyList(services.findByAuthorId(id)), HttpStatus.OK);
    }

    @GetMapping("/post/{id}")
    public ResponseEntity<List<CommentRequestBody>> findByPostId(@PathVariable Long id) {
        return new ResponseEntity<>(mapper.toCommentRequestBodyList(services.findByPostId(id)), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommentRequestBody> findById(@PathVariable Long id) {
        return new ResponseEntity<>(mapper.toCommentBodyRequst(services.findById(id)), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Comment> save(@RequestBody CommentRequestBody commentRequestBody) {
        return new ResponseEntity<>(services.save(mapper.toComment(commentRequestBody)), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comment> update(@RequestBody CommentRequestBody commentRequestBody, @PathVariable Long id) {
        commentRequestBody.setId(id);
        commentRequestBody.setDateUpdate(new Date());
        return new ResponseEntity<>(services.update(mapper.toComment(commentRequestBody)), HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        CommentRequestBody commentRequestBody = mapper.toCommentBodyRequst(services.findById(id));
        services.delete(commentRequestBody.getId());
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
