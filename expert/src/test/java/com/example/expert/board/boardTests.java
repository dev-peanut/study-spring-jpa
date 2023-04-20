package com.example.expert.board;

import com.example.expert.repository.board.BoardDAO;
import com.example.expert.repository.board.LikeDAO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Slf4j
@Transactional
@Rollback(false)
public class boardTests {
    @Autowired
    private BoardDAO boardDAO;

    @Autowired
    private LikeDAO likeDAO;

    @Test
    public void saveTest(){
        Board board = new Board();
        Like like = new Like();
//        *********************************
//        board.setBoardTitle("게시글 제목");
//        board.setBoardContent("게시글 내용");
//        boardDAO.save(board);
//
//        like.setBoard(board);
//        boardDAO.save(like);
//        *********************************

//        편의 메소드 사용
//        *********************************
        like.setBoard(board);
        boardDAO.save(like);

        board.setBoardTitle("게시글 제목");
        board.setBoardContent("게시글 내용");
        boardDAO.save(board);
//        *********************************
    }





}
