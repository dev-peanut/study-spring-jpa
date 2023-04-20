package com.example.expert.inquire;

import com.example.expert.repository.inquire.AnswerDAO;
import com.example.expert.repository.inquire.QuestionDAO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@SpringBootTest
@Transactional
@Rollback(false)
@Slf4j
public class InquireTests {

    @Autowired private QuestionDAO questionDAO;
    @Autowired private AnswerDAO answerDAO;

    @Test
    public void saveTest(){
//        단방향 관계에서는
//        INSERT 실행 시, @JoinColumn으로 설정된 객체로만 FK를 추가할 수 있다.
//        @JoinColumn이 설정되지 않은 연관객체로는 FK를 추가할 수 없다.
//        하지만, 양방향 관계에서는
//        @JoinColumn뿐먼 아니라 mappedBy로 FK를 설정한다.
//        mappedBy를 생략하면 모든 테이블에 FK가 생긴다.
//        (왜? 주인이 없기 때문에, 둘 중 하나에서 할 수 있게끔 결정해줘야 한다.)
//        RDB에서 설계 할 때 N쪽에 FK를 두기 때문에
//        FK를 필드로 가지고 있는 엔티티가 연관관계의 주인이 되어야 한다.

//        ※ 문제 발생
//        mappedBy를 question으로 설정했기 때문에,
//        question_id는 Question엔티티에서 관리하게 된다.
//        따라서 Answer엔티티에 question_id를 추가하고 싶다면,
//        answer에 question을 넣어주어야 한다.
//        서비스 순서대로 진행함.
//        *********************************************
        Answer answer = new Answer();
        Question question = new Question();

        answer.setAnswerContents("답변 내용1");
        questionDAO.save(answer); //insert

        question.setQuestionTitle("문의 제목1");
        question.setQuestionContents("문의 내용1");
        question.setAnswer(answer); //update

        questionDAO.save(question); //insert
//        *********************************************
//        *********************************************
//        ※ 문제 해결
//        Answer answer = new Answer();
//        Question question = new Question();
//
//        question.setQuestionTitle("문의 제목1");
//        question.setQuestionContents("문의 내용1");
//        questionDAO.save(question);
//
//        answer.setAnswerContents("답변 내용1");
//        answer.setQuestion(question);
//
//        questionDAO.save(answer);
//        *********************************************
    }





}



















