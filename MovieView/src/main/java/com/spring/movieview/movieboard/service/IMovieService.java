package com.spring.movieview.movieboard.service;

import java.util.List;

import com.spring.movieview.commons.SearchCriteria;
import com.spring.movieview.movieboard.model.MovieVO;

public interface IMovieService{
	public List<MovieVO> getAllList() throws Exception;
	public void insertMovie(MovieVO movie) throws Exception;
	public void deleteMovie(int movieNo) throws Exception;
	public MovieVO getOneList(int movieNo) throws Exception;
	public void updateMovie(MovieVO movie) throws Exception;
	public List<MovieVO> getListPaging(SearchCriteria cri) throws Exception;
	
	public int countAll(SearchCriteria cri) throws Exception;
	
}
