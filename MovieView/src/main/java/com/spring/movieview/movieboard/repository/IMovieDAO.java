package com.spring.movieview.movieboard.repository;

import java.util.List;

import com.spring.movieview.commons.Criteria;
import com.spring.movieview.movieboard.model.MovieVO;

public interface IMovieDAO {
	public List<MovieVO> getAllList() throws Exception;
	public MovieVO getOneList(int movieNo) throws Exception;
	public void insertMovie(MovieVO movie) throws Exception;
	public void deleteMovie(int movieNo) throws Exception;
	public void updateMovie(MovieVO movie) throws Exception;
	public List<MovieVO> getListPaging(Criteria cri) throws Exception;
	
	public int countAll() throws Exception;
}
