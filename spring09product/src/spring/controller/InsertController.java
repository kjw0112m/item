package spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import spring.entity.ItemDto;
import spring.repository.ItemDao;
import spring.repository.ItemDaoImpl;

public class InsertController implements Controller {
	private ItemDao itemDao = new ItemDaoImpl();

	public void setItemDao(ItemDao itemDao) {
		this.itemDao = itemDao;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		if (req.getMethod().equals("GET")) {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("/WEB-INF/view/insert.jsp");
			return mv;
		} else if (req.getMethod().equals("POST")) {
			ItemDto itemDto = ItemDto.builder().name(req.getParameter("name")).type(req.getParameter("type"))
					.price(Integer.parseInt(req.getParameter("price"))).build();
			itemDao.insert(itemDto);

			ModelAndView mv = new ModelAndView();
			mv.setViewName("redirect:/");
			return mv;
		}
		return null;
	}

}
