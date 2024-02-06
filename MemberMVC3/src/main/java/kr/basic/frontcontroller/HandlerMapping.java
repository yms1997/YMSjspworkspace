package kr.basic.frontcontroller;

import java.util.HashMap;

import kr.basic.controller.Controller;
import kr.basic.controller.*;

public class HandlerMapping {
	private HashMap<String, Controller> mappings;
	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();
		mappings.put("/memberList.do", new MemberListController());
		mappings.put("/memberDelete.do", new MemberDeleteController());
		mappings.put("/memberLogin.do", new MemberLoginController());
	}
	public Controller getController(String key) { // key -> /memberList.do
		return mappings.get(key);
	}
}
