package com.spring.movieview.review.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.movieview.review.common.paging.Criteria;
import com.spring.movieview.review.common.paging.SearchCriteria;
import com.spring.movieview.review.model.ReviewVO;


@Repository
public class ReviewDAO implements IReviewDAO {

	@Autowired
	private SqlSession sqlSession;
	
	private static final String NAMESPACE = "ReviewMapper";
	
	@Override
	public ReviewVO content(int reviewNo) throws Exception {
		System.out.println("리뷰 번호 : " + reviewNo);
		return sqlSession.selectOne(NAMESPACE+".content", reviewNo);
	}

	@Override
	public void insert(ReviewVO review) throws Exception {
		sqlSession.insert(NAMESPACE+".insert", review);
		

	}
	@Override
	public void modify(ReviewVO review) throws Exception {
		System.out.println("수정");
		sqlSession.update(NAMESPACE+".modify", review);
	}


	@Override
	public void delete(int reviewNo) throws Exception {
		sqlSession.delete(NAMESPACE+".delete", reviewNo);

	}

	@Override
	public List<ReviewVO> list() throws Exception {
		return sqlSession.selectList(NAMESPACE+".list");
	}

	@Override
	public List<ReviewVO> listPaging(Criteria cri) throws Exception {
		return sqlSession.selectList(NAMESPACE+".listPaging", cri);
	}

	@Override
	public int countArticles() throws Exception {
		return sqlSession.selectOne(NAMESPACE+".countArticles");
	}

	@Override
	public List<ReviewVO> listSearch(SearchCriteria cri) throws Exception {
		return sqlSession.selectList(NAMESPACE+".listSearch", cri);
	}

	@Override
	public int countSearchArticles(SearchCriteria cri) throws Exception {
		return sqlSession.selectOne(NAMESPACE+".countSearchArticles", cri);
	}

	@Override
	public void updateViewCnt(int reviewNo) throws Exception {
		sqlSession.update(NAMESPACE+".updateViewCnt", reviewNo);
		
	}



}
