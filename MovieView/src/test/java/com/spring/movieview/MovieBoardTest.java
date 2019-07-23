package com.spring.movieview;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.movieview.movieboard.model.MovieVO;
import com.spring.movieview.movieboard.repository.IMovieDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:/spring/mvc-config.xml"})
public class MovieBoardTest {
	private static final Logger logger = LoggerFactory.getLogger(MovieBoardTest.class);

	@Inject
	private IMovieDAO movieDAO;
	
@Test
	public void insertTest() throws Exception {
	for(int i=263; i<412; i++) {
		MovieVO vo = new MovieVO();
		int result = i+1;
		vo.setTitle((i+1)+"번째 영화");
		vo.setGenre("3");
		vo.setNation("국가"+(i+1));
		vo.setOpenDate("2000.03.12");
		vo.setDirector("감독 "+result);
		vo.setActor("배우 "+result);
		vo.setSynoposis("고라니~"+result);
		
		movieDAO.insertMovie(vo);
		}
	}
	
	/*@Test
	public void getListTest() throws Exception{
		List<MovieVO> lists = movieDAO.getAllList();
		for(MovieVO list : lists) {
			logger.info(list.toString());
		}
	}*/
	
}
