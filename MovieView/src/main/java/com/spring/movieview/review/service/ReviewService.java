package com.spring.movieview.review.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.movieview.review.common.paging.Criteria;
import com.spring.movieview.review.common.paging.SearchCriteria;
import com.spring.movieview.review.model.ReviewVO;
import com.spring.movieview.review.repository.IReviewDAO;


@Service
public class ReviewService implements IReviewService{

	@Autowired
	private IReviewDAO reviewDao;
	
	
	@Override
	public void insert(ReviewVO review) throws Exception {
	
		reviewDao.insert(review);
	}


	@Override
	public List<ReviewVO> list() throws Exception {
		return reviewDao.list();
	}


	@Override
	public ReviewVO content(int reviewNo) throws Exception {
		ReviewVO review = reviewDao.content(reviewNo);
		
		//게시물조회 추가할것
		reviewDao.updateViewCnt(reviewNo);
		
		
		return review;
	}


	@Override
	public void modify(ReviewVO review) throws Exception {
		reviewDao.modify(review);
	}


	@Override
	public void delete(int reviewNo) throws Exception {
		reviewDao.delete(reviewNo);
		
	}


	@Override
	public List<ReviewVO> listPaging(Criteria cri) throws Exception {
		return reviewDao.listPaging(cri);
	}


	@Override
	public int countArticles() throws Exception {
		return reviewDao.countArticles();
	}


	@Override
	public List<ReviewVO> listSearch(SearchCriteria cri) throws Exception {
		List<ReviewVO> list = reviewDao.listSearch(cri);
		return list;
	}


	@Override
	public int countSearchArticles(SearchCriteria cri) throws Exception {
		return reviewDao.countSearchArticles(cri);
	}

}
