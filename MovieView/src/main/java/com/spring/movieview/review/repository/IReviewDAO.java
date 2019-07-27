package com.spring.movieview.review.repository;

import java.util.List;

import com.spring.movieview.commons.Criteria;
import com.spring.movieview.commons.SearchCriteria;
import com.spring.movieview.review.model.ReviewVO;



public interface IReviewDAO {

	
	//리뷰 내용 보여주기
	 ReviewVO content(int reviewNo) throws Exception;
	 
	 //리뷰 작성
	 void insert(ReviewVO review) throws Exception;
	 
	 //리뷰 수정
	 void modify(ReviewVO review) throws Exception;
	 
	 //리뷰 삭제
	 void delete(int reviewNo) throws Exception;
	 
	 //목록보기
	 List<ReviewVO> list(int movieNo) throws Exception; 
	
	 
	 //게시글 페이지별로 불러오기
	 List<ReviewVO> listPaging(Criteria cri) throws Exception;
	 //총 게시물 수를 불러오기
	 int countArticles() throws Exception;
	 
	 
	//검색 동적 SQL처리
	List<ReviewVO> listSearch(SearchCriteria cri, int movieNo) throws Exception;
	//검색후 총 리뷰 수 
	int countSearchArticles(SearchCriteria cri) throws Exception;
			 
	//조회수 상승
	void updateViewCnt(int reviewNo) throws Exception;
	
	/*
	//회원가입 처리
		void register(UserVO user) throws Exception;
		
		//아이디 중복확인 처리
		int isDuplicateId(String userId) throws Exception;
		
		//로그인 시도 회원정보 조회처리
		UserVO login(LoginVO login) throws Exception;
		
		//자동 로그인 유지 처리
		void keepLogin(Map<String, Object> datas) throws Exception;
		
		//세션아이디 검증 후 회원정보 불러오는 처리
		UserVO getUserWithSessionId(String sessionId) throws Exception;
		*/
		
}
