package com.ex.ex.unknown.controller;

import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ex.ex.unknown.domain.UnknownDTO;
import com.ex.ex.unknown.domain.UnknownReplyDTO;
import com.ex.ex.unknown.service.UnknownPagination;
import com.ex.ex.unknown.service.UnknownReplyService;
import com.ex.ex.unknown.service.UnknownService;

@Controller
@RequestMapping("/unknown")
public class UnknownController {
	private static final Logger logger = LoggerFactory.getLogger(UnknownController.class);
	
	@Inject
	UnknownService service;
	@Inject
	UnknownReplyService rService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String boardList(Locale locale, Model model) {
		logger.info("Welcome boardListView! The client locale is {}.", locale);
		List<UnknownDTO> list = service.listAll();
		model.addAttribute("unknownList", list);
		return "main/unknown/boardListView.lay";
	}
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String boardForm(Locale locale, Model model) {
		logger.info("Welcome boardForm! The client locale is {}.", locale);
		return "main/unknown/boardForm.lay";
	}
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String boardModify(Locale locale, Model model,@RequestParam("articleNo") int articleNo) {
		logger.info("Welcome modify! The client locale is {}.", locale);
		UnknownDTO unknown=service.detail(articleNo);
		model.addAttribute("unknown", unknown);
		return "main/unknown/boardModify.lay";
	}
	
	@RequestMapping(value = "/writeComment", method = RequestMethod.GET)
	public String writeComment(Locale locale, Model model,@RequestParam("articleNo") int articleNo) {
		logger.info("Welcome writeComment! The client locale is {}.", locale);
		UnknownDTO unknown=service.detail(articleNo);
		model.addAttribute("unknown", unknown);
		return "main/unknown/boardComment.lay";
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String boardDetail(Locale locale, Model model,@RequestParam("articleNo") int articleNo) {
		logger.info("Welcome boardForm! The client locale is {}.", locale);
		service.upCount(articleNo);
		List<UnknownReplyDTO> list = rService.listAll(articleNo);
		UnknownDTO unknown=service.detail(articleNo);
		model.addAttribute("unknown", unknown);
		model.addAttribute("replyList", list);
		return "main/unknown/boardDetail.lay";
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(UnknownDTO unknown,RedirectAttributes rttr) {
		logger.info("insert");
		service.insert(unknown);
		rttr.addFlashAttribute("result_massage", "createsuccess");
		return "redirect:/unknown/listSearch?searchType=a&keyword=";
	}
	
	@RequestMapping(value = "/insertComment", method = RequestMethod.POST)
	public String insertComment(UnknownDTO unknown,RedirectAttributes rttr) {
		logger.info("insertComment");
		service.updateOrder(unknown.getGroup(), unknown.getOrder());
		service.insertComment(unknown);
		rttr.addFlashAttribute("result_massage", "createsuccess");
		return "redirect:/unknown/listSearch?searchType=a&keyword=";
	}
	
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(UnknownDTO unknown,RedirectAttributes rttr) {
		logger.info("update");
		service.modify(unknown);
		rttr.addFlashAttribute("result_massage", "updatesuccess");
		return "redirect:/unknown/listSearch?searchType=a&keyword=";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(UnknownDTO unknown,RedirectAttributes rttr) {
		logger.info("delete");
		service.deleteModify(unknown.getArticleNo());
		rttr.addFlashAttribute("result_massage", "deletesuccess");
		return "redirect:/unknown/listSearch?searchType=a&keyword=";
	}
	
	@RequestMapping(value = "/listSearch", method = RequestMethod.GET)
	public String listSearch(@RequestParam("searchType") String searchType,@RequestParam("keyword") String keyword,@RequestParam(defaultValue="1") int curPage,Model model) {
		logger.info("listSearch");
		if(keyword.equals("")) keyword="";
		int articleCnt=service.cntAtricle(searchType, keyword);
		UnknownPagination p = new UnknownPagination(articleCnt, curPage);
		List<UnknownDTO> list = service.listSearch(searchType, keyword,p.getStartIndex(),p.getPageSize());
		model.addAttribute("page", p);
		model.addAttribute("unknownList", list);
		return "main/unknown/boardListView.lay";
	}
	
	@RequestMapping(value = "/insertReply", method = RequestMethod.POST)
	public String insertReply(UnknownReplyDTO reply,RedirectAttributes rttr) {
		logger.info("insertReply");
		logger.info(reply.toString());
		rService.insert(reply);
		rttr.addFlashAttribute("result_massage", "createsuccess");
		return "redirect:/unknown/detail?articleNo="+reply.getArticleNo();
	}
	

}
