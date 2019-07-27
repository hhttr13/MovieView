package com.spring.movieview.review.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.movieview.commons.PageCriteria;
import com.spring.movieview.commons.SearchCriteria;
import com.spring.movieview.review.model.ReviewVO;
import com.spring.movieview.review.service.IReviewService;







@Controller
@RequestMapping("/review")
public class ReviewController {
	private static final Logger logger = LoggerFactory.getLogger(ReviewController.class);

	@Autowired
	private IReviewService service;
	
	
	//페이징 처리 전
/*		@RequestMapping(value="/list", method=RequestMethod.GET)
		public String list(Model model) throws Exception {
			logger.info("a"); 
			model.addAttribute("reviews", service.list());
			return "/review/list";
		}
*/
	//페이징 처리 후
/*	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String list(Criteria cri, Model model) throws Exception {
		logger.info("GET요청발생, list 목록 불러오기"); 
		PageCreator pc = new PageCreator();
		pc.setCriteria(cri);
		pc.setArticleTotalCount(service.countArticles());
		
		model.addAttribute("reviews", service.listPaging(cri));
		model.addAttribute("pageCreator", pc);
		
		return "/review/list";
	}
*/	
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String list(SearchCriteria cri, Model model, int movieNo) throws Exception {
		logger.info("GET요청발생, list 목록 불러오기"); 
		PageCriteria pc = new PageCriteria();
		pc.setCriteria(cri);
		pc.setArticleTotalCount(service.countArticles());
		
		model.addAttribute("reviews", service.listSearch(cri, movieNo));
		model.addAttribute("pageCreator", pc);
		
		logger.info("cri : " + cri.toString()); 
		
		return "/review/list";
	}
	
	
	
		//게시글 작성화면 열람 요청
		@RequestMapping(value="/write", method=RequestMethod.GET)
		public String write(int movieNo, Model model) throws Exception{
			logger.info("method:get > board/write");
			System.out.println("테스트무번: "+movieNo);
			model.addAttribute("movie", movieNo);
			return "/review/write";
		}
		
		//게시글 등록 요청
		@RequestMapping(value="/write", method=RequestMethod.POST)
		public String write(ReviewVO review, RedirectAttributes redirectAttr, int movieNo) throws Exception{
			logger.info("method: post > review/write");
			System.out.println("무번텟1: "+ movieNo);
			logger.info(review.toString());
			service.insert(review);
			logger.info(review.toString());
			redirectAttr.addFlashAttribute("message", "regSuccess");
			System.out.println("무번텟2!: "+ review.getMovieNo());
			return "redirect:/movieboard/content?movieNo="+movieNo;
		}
		
		//게시물 조회페이지 요청
		@RequestMapping(value="/content", method= RequestMethod.GET)
		public String content(@RequestParam("reviewNo") int reviewNo, Model model)throws Exception{
			logger.info("method : get > /review/content/");
			logger.info("컨트롤러/리뷰번호 : "+ reviewNo);
			model.addAttribute("review", service.content(reviewNo));
			
			return "review/content";
		}
		
		//게시물 수정페이지 요청
		@RequestMapping(value="/modify", method= RequestMethod.GET)
		public String modify(@RequestParam("reviewNo") int reviewNo, Model model)throws Exception{
			logger.info("method : get > /review/modify/");
		
			model.addAttribute("review", service.content(reviewNo));
			
			return "/review/modify";
		}
		//수정폼
		@RequestMapping(value="/modify", method=RequestMethod.POST)
		public String modify(ReviewVO review, RedirectAttributes redirectAttr,int movieNo) throws Exception {

			logger.info("method: post > /review/modify");
			service.modify(review);
			System.out.println("번호 : " + review.getReviewNo());
			System.out.println("제목: " + review.getReviewTitle());
			System.out.println("내용: " + review.getReviewContent());
			
			redirectAttr.addFlashAttribute("message", "modSuccess");
			
			return "redirect:/movieboard/content?movieNo="+movieNo;
		}
		
		@RequestMapping(value="/delete", method = RequestMethod.GET)
		public String delete(@RequestParam("reviewNo") int reviewNo,
				RedirectAttributes redirectAttributes, int movieNo) throws Exception {

			logger.info("method: post > /review/delete");
			service.delete(reviewNo);
			
			redirectAttributes.addFlashAttribute("message", "delSuccess");

			return "redirect:/movieboard/content?movieNo="+movieNo;
		}

		

}





