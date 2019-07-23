package com.spring.movieview.movieboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.movieview.commons.SearchCriteria;
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
	public List<MovieVO> getListPaging(SearchCriteria cri) throws Exception {
		List<MovieVO> list = dao.getListPaging(cri);
		for (MovieVO movie : list) {
			if(movie.getGenre().equals("1")) {
				movie.setGenre("액션");
			}else if(movie.getGenre().equals("2")) {
				movie.setGenre("판타지");
			}else if(movie.getGenre().equals("3")) {
				movie.setGenre("SF");
			}else if(movie.getGenre().equals("4")) {
				movie.setGenre("로맨스");
			}
		}
		
		return list;
	}

	@Override
	public int countAll(SearchCriteria cri) throws Exception {
		return dao.countAll(cri);
	}


}
