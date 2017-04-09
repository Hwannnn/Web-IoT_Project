package adminWeb.controls;

import java.util.Map;

import adminWeb.annotation.Component;
import adminWeb.bind.DataBinding;
import adminWeb.dao.AuthDao;


@Component("/auth/authinfo.do")
public class AuthInfoController implements Controller, DataBinding {
	AuthDao authDao;

	public AuthInfoController setProjectDao(AuthDao authDao) {
		this.authDao = authDao;
		return this;
	}
	
	@Override
	public Object[] getDataBinders() {
	    return new Object[]{
	            "auth_no", Integer.class,
	        };
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		  
		int no = (Integer) model.get("auth_no");
		  
		model.put("auth", authDao.selectOne(no));
		  
		return "/auth/authInfo.jsp";
		
	}
	
}
