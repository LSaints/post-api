package br.com.lsant.postApi.domain.repositories;

import br.com.lsant.postApi.domain.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}
