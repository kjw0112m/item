package spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import spring.repository.ItemDao;
import spring.repository.ItemDaoImpl;

public class ContentController implements Controller {
	private ItemDao itemDao = new ItemDaoImpl();

	public void setItemDao(ItemDao itemDao) {
		this.itemDao = itemDao;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		ModelAndView mv = new ModelAndView();
		int no = Integer.parseInt(req.getParameter("no"));
		mv.setViewName("/WEB-INF/view/content.jsp?no=" + req.getParameter("no"));
		mv.addObject("dto", itemDao.get(no));
		return mv;
	}

}
