package com.spring.movieview.movieboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.movieview.commons.Criteria;
import com.spring.movieview.commons.PageCriteria;
import com.spring.movieview.movieboard.model.MovieVO;
import com.spring.movieview.movieboard.service.MovieService;

@Controller
@RequestMapping(value="/movieboard")
public class MovieController {
	
	@Autowired
	private MovieService service;

	//목록조회
	/*@RequestMapping(value="/list", method=RequestMethod.GET)
	public String movieList(Model model) throws Exception {
		model.addAttribute("movielist", service.getAllList());
		return "/movieboard/list";
	}*/
	//목록조회(paging 처리)
	@RequestMapping(value="list", method=RequestMethod.GET)
	public String movieList(Model model, Criteria cri) throws Exception{
		PageCriteria pc = new PageCriteria();
		pc.setCriteria(cri);
		pc.setArticleTotalCount(service.countAll());
		model.addAttribute("movielist", service.getListPaging(cri));
		model.addAttribute("pageCri", pc);
		return "/movieboard/list";
	}
	
	
	//한가지 게시물 조회
	@RequestMapping(value="/content", method=RequestMethod.GET)
	public String oneList(Model model, int movieNo) throws Exception {
		model.addAttribute("movie", service.getOneList(movieNo));
		return "/movieboard/content";
	}
	
	//작성폼
	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public String insertForm() {
		return "/movieboard/insert";
	}
	//작성
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String movieInsert(MovieVO movie, RedirectAttributes redirectAttr) throws Exception {
		service.insertMovie(movie);
		redirectAttr.addFlashAttribute("message", "insertSuccess");
		return "redirect:/movieboard/list";
	}
	//삭제
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String movieDelete(int movieNo, RedirectAttributes redirectAttr) throws Exception{
		service.deleteMovie(movieNo);
		redirectAttr.addFlashAttribute("message", "delSuccess");
		return "redirect:/movieboard/list";
	}
	//수정폼
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String updateform(Model model, int movieNo) throws Exception{
		model.addAttribute("movie", service.getOneList(movieNo));
		return "/movieboard/update";
	}
	//수정
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String movieUpdate(MovieVO movie, RedirectAttributes redirectAttr) throws Exception{
		service.updateMovie(movie);
		redirectAttr.addFlashAttribute("message", "updateSuccess");
		return "redirect:/movieboard/list";
	}
}
