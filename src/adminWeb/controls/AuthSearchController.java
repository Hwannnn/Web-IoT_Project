package adminWeb.controls;

import java.util.Map;

import adminWeb.annotation.Component;
import adminWeb.bind.DataBinding;
import adminWeb.dao.AuthDao;


@Component("/auth/authsearch.do")
public class AuthSearchController implements Controller, DataBinding {
	AuthDao authDao;

	public AuthSearchController setProjectDao(AuthDao authDao) {
		this.authDao = authDao;
		return this;
	}
	
	@Override
	public Object[] getDataBinders() {
	    return new Object[]{
	            "auth_id", String.class
	        };
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {

		String id = (String) model.get("auth_id");
		
		model.put("member", authDao.selectOne(id));
				
		return "/auth/authSearch.jsp";
		
	}
	
}
