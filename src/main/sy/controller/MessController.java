package sy.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.alibaba.fastjson.JSON;

import sy.model.MessageLeave;
import sy.model.User;
import sy.service.MessageLeaveService;
import sy.service.UserServiceI;

@Controller
@RequestMapping("/mess")
public class MessController extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	private MessageLeaveService messService;

	public MessageLeaveService getMessService() {
		return messService;
	}

	@Autowired
	public void setMessService(MessageLeaveService messService) {
		this.messService = messService;
	}


	@RequestMapping("/index")
	public ModelAndView index(@ModelAttribute("form") MessageLeave messageLeave,HttpServletRequest request) {
		Map<String,Object> model = new HashMap<String,Object>();  
        model.put("webRoot", request.getContextPath());
        List<MessageLeave> list = messService.getMessage(messageLeave);
        model.put("list", list);
        return new ModelAndView("message/messIndex",model);
	}
	
	@RequestMapping(value="/insert",method = RequestMethod.POST)
	public ModelAndView insert(@ModelAttribute("form") MessageLeave messageLeave,HttpServletRequest request) {
		Map<String,Object> model = new HashMap<String,Object>();  
        model.put("webRoot", request.getContextPath());
        messageLeave.setMessId(Hander.getUuid());
        messageLeave.setStatus("Y");
        messageLeave.setLeaveDatetime(new Date());
        messService.insert(messageLeave);
        return new ModelAndView("index",model);
	}
	
	@RequestMapping(value="/delete",method = RequestMethod.POST)
	public ModelAndView index(String messId,HttpServletRequest request,HttpServletResponse response) {
		Map<String,Object> model = new HashMap<String,Object>();  
        model.put("webRoot", request.getContextPath());
        MessageLeave messageLeave = new  MessageLeave();
        messageLeave.setMessId(messId);
        messageLeave.setStatus("N");
        int i = messService.delete(messageLeave);
        model.put("success", true);
        Hander.responseText(response,model);
        return null;
	}
	
	
	
	
}
