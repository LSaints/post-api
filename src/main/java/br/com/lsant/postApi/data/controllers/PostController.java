package br.com.lsant.postApi.data.controllers;

import br.com.lsant.postApi.data.mappers.PostMapper;
import br.com.lsant.postApi.data.requests.PostPostRequestBody;
import br.com.lsant.postApi.data.requests.PostPutRequestBody;
import br.com.lsant.postApi.domain.models.Post;
import br.com.lsant.postApi.domain.services.PostServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {
    private final PostServices services;
    private final PostMapper mapper;

    @GetMapping
    public ResponseEntity<List<PostPostRequestBody>> findAll() {
        return new ResponseEntity<>(mapper.toPostRequestBodyList(services.findAll()), HttpStatus.OK);
    }

    @GetMapping("/author/{id}")
    public ResponseEntity<List<PostPostRequestBody>> findByAuthorId(@PathVariable Long id) {
        return new ResponseEntity<>(mapper.toPostRequestBodyList(services.findByAuthorId(id)), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostPostRequestBody> findById(@PathVariable Long id) {
        return new ResponseEntity<>(mapper.toPostRequestBody(services.findById(id)), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Post> save(@RequestBody PostPostRequestBody postPostRequestBody) {
        return new ResponseEntity<>(services.save(mapper.toPost(postPostRequestBody)), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> update(@RequestBody PostPutRequestBody postPutRequestBody, @PathVariable Long id) {
        postPutRequestBody.setId(id);
        postPutRequestBody.setDateUpdate(new Date());
        return new ResponseEntity<>(services.update(mapper.toPost(postPutRequestBody)), HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(Long id) {
       PostPostRequestBody postPostRequestBody = mapper.toPostRequestBody(services.findById(id));
       services.delete(postPostRequestBody.getId());
       return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
