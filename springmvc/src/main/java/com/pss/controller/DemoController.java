package com.pss.controller;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.jms.JMSException;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pss.domain.JmsMessage;
import com.pss.domain.User;
import com.pss.mapper.UserMapper;
import com.pss.repository.UserRepository;
import com.pss.service.SendMessageByGateWayService;
import com.pss.service.UserService;
import com.pss.utils.ActiveMqProducer;
import com.pss.utils.RestTemplateUtils;

@Controller
@RequestMapping("/login")
public class DemoController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DemoController.class);
	
	@Value("${version}")
	private String version;
	
	@Value("${version}")
	private String name;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ActiveMqProducer activeMqProducer;
	
	@Autowired
	private SendMessageByGateWayService sendMessageByGateWayService;
	
	@Autowired
	private RestTemplateUtils restTemplateUtils;
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String index(Model model) {
		
		model.addAttribute("opp", "Hello springmvc."+this.version);
		LOGGER.info("test");
		return "login";
	}
	
	@RequestMapping(value="/hello", method = RequestMethod.GET)
	public String gotoHello(Model model) {
		model.addAttribute("name", "pengs1"+version+"="+name);
		return "hello";
	}
	
	@RequestMapping(value="/allUser", method = RequestMethod.GET)
	public String getAllUsers(Map<String,Object> map) {
		List<User> userList = userService.findAllUsers();
		for (User user : userList) {
			System.out.println(user.getName());
		}
		Map<String, String> userMap = new HashMap<String, String>();
		for (User user : userList) {
			userMap.put(user.getId().toString(), user.getName());
		}
		map.put("users", userList);
		map.put("userMap", userMap);
		//map.put("content", contentDirective);
		map.put("booleanVar", Boolean.FALSE);
		map.put("dateVar", new Date());
		map.put("nullVar", "having value");
		//map.put("sortInt", new SortMethod());
		//map.put("sortUser", new SortUser());
		//map.put("pengs", pengsDirective);
		return "user";
	}
	
	@RequestMapping(value="/common", method = RequestMethod.GET)
	public String testMacro() {
		return "macroTest";
	}
	
	@RequestMapping(value="/media", method = RequestMethod.GET)
	public String media() {
		return "media";
	}
	
	@RequestMapping(value="/send", method = RequestMethod.GET)
	@ResponseBody
	public String sendMessageByJms() throws JMSException {
		return activeMqProducer.sendMessageToQueue();
	}
	
	@RequestMapping(value="/send2", method = RequestMethod.GET)
	@ResponseBody
	private String sendMessageUsingGateWay() {
		JmsMessage jmsMessage = new JmsMessage("headMSG", "bodyMsg");
		String correlationId = UUID.randomUUID().toString();
		String uniqueName = "_pengs1";
		sendMessageByGateWayService.sendMessageThroughGateway(jmsMessage, correlationId, uniqueName);
		return "success2";
	}
	
	@RequestMapping(value="/weather", method=RequestMethod.GET)
	@ResponseBody
	private String getCurrentWeather() {
		return restTemplateUtils.getWeather("上海").toString();
	}
	
	@RequestMapping(value="/myUser", method=RequestMethod.GET)
	@ResponseBody
	private String getUserThroughMybatis() {
		User user = userService.selectUser(4);
		return user.getName();
	}
	
	@RequestMapping(value="/myUsers", method=RequestMethod.GET)
	@ResponseBody
	private List<User> getAllUserMybatis() {
		List<User> users = userService.listUsers();
		return users;
	}
}