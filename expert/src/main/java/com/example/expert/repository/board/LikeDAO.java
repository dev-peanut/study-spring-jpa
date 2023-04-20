package com.example.expert.repository.board;

import com.example.expert.board.Like;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public class LikeDAO {
    @PersistenceContext
    private EntityManager entityManager;

//    추가
    public Like save(Like like){
        return like;
    }

//    조회
    public Optional<Like> findById(Long id){
         String query = "select l from Like l";
         return Optional.ofNullable(entityManager.createQuery(query, Like.class).getSingleResult());
    }

//    전체 조회
    public List<Like> findAll(){
        String query = "select l from Like l";
        return entityManager.createQuery(query, Like.class).getResultList();
    }

//    삭제
    public void delete(Like like){
        entityManager.remove(like);
    }
}
