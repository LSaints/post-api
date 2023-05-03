package br.com.lsant.postApi.data.controllers;

import br.com.lsant.postApi.data.mappers.CommentMapper;
import br.com.lsant.postApi.data.requests.CommentPostRequestBody;
import br.com.lsant.postApi.data.requests.CommentPutRequestBody;
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
    public ResponseEntity<List<CommentPostRequestBody>> findAll() {
        return new ResponseEntity<>(mapper.toCommentRequestBodyList(services.findAll()), HttpStatus.OK);
    }

    @GetMapping("/author/{id}")
    public ResponseEntity<List<CommentPostRequestBody>> findByAuthorId(@PathVariable Long id){
        return new ResponseEntity<>(mapper.toCommentRequestBodyList(services.findByAuthorId(id)), HttpStatus.OK);
    }

    @GetMapping("/post/{id}")
    public ResponseEntity<List<CommentPostRequestBody>> findByPostId(@PathVariable Long id) {
        return new ResponseEntity<>(mapper.toCommentRequestBodyList(services.findByPostId(id)), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommentPostRequestBody> findById(@PathVariable Long id) {
        return new ResponseEntity<>(mapper.toCommentBodyRequst(services.findById(id)), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Comment> save(@RequestBody CommentPostRequestBody commentPostRequestBody) {
        return new ResponseEntity<>(services.save(mapper.toComment(commentPostRequestBody)), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comment> update(
            @RequestBody CommentPutRequestBody commentPutRequestBody, @PathVariable Long id) {
        commentPutRequestBody.setId(id);
        commentPutRequestBody.setDateUpdate(new Date());
        return new ResponseEntity<>(services.update(mapper.toComment(commentPutRequestBody)), HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        CommentPostRequestBody commentPostRequestBody = mapper.toCommentBodyRequst(services.findById(id));
        services.delete(commentPostRequestBody.getId());
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
