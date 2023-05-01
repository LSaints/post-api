package br.com.lsant.postApi.data.controllers;

import br.com.lsant.postApi.data.mappers.PostMapper;
import br.com.lsant.postApi.data.requests.PostRequestBody;
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
    public ResponseEntity<List<PostRequestBody>> findAll() {
        return new ResponseEntity<>(mapper.toPostRequestBodyList(services.findAll()), HttpStatus.OK);
    }

    @GetMapping("/author/{id}")
    public ResponseEntity<List<PostRequestBody>> findByAuthorId(@PathVariable Long id) {
        return new ResponseEntity<>(mapper.toPostRequestBodyList(services.findByAuthorId(id)), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostRequestBody> findById(@PathVariable Long id) {
        return new ResponseEntity<>(mapper.toPostRequestBody(services.findById(id)), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Post> save(@RequestBody PostRequestBody postRequestBody) {
        return new ResponseEntity<>(services.save(mapper.toPost(postRequestBody)), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> update(@RequestBody PostRequestBody postRequestBody, @PathVariable Long id) {
        postRequestBody.setId(id);
        postRequestBody.setDateUpdate(new Date());
        return new ResponseEntity<>(services.update(mapper.toPost(postRequestBody)), HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(Long id) {
       PostRequestBody postRequestBody = mapper.toPostRequestBody(services.findById(id));
       services.delete(postRequestBody.getId());
       return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
