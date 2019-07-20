package com.spring.movieview.movieboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.movieview.commons.Criteria;
import com.spring.movieview.movieboard.model.MovieVO;
import com.spring.movieview.movieboard.repository.IMovieDAO;

@Service
public class MovieService implements IMovieService{
	
	@Autowired
	private IMovieDAO dao;

	@Override
	public List<MovieVO> getAllList() throws Exception {
		return dao.getAllList();
	}

	@Override
	public void insertMovie(MovieVO movie) throws Exception {
		dao.insertMovie(movie);
	}

	@Override
	public void deleteMovie(int movieNo) throws Exception{
		dao.deleteMovie(movieNo);
	}

	@Override
	public MovieVO getOneList(int movieNo) throws Exception {
		return dao.getOneList(movieNo);
	}

	@Override
	public void updateMovie(MovieVO movie) throws Exception {
		dao.updateMovie(movie);
		
	}

	@Override
	public List<MovieVO> getListPaging(Criteria cri) throws Exception {
		return dao.getListPaging(cri);
	}

	@Override
	public int countAll() throws Exception {
		return dao.countAll();
	}


}
