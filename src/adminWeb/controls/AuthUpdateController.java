package adminWeb.controls;

import java.util.Map;

import adminWeb.annotation.Component;
import adminWeb.bind.DataBinding;
import adminWeb.dao.AuthDao;
import adminWeb.vo.Auth;


@Component("/auth/authupdate.do")
public class AuthUpdateController implements Controller, DataBinding {
	AuthDao authDao;

	public AuthUpdateController setProjectDao(AuthDao authDao) {
		this.authDao = authDao;
		return this;
	}
	
	@Override
	public Object[] getDataBinders() {
	    return new Object[]{
	            "auth_no", Integer.class,
	            "new_password", String.class,
	            "auth", adminWeb.vo.Auth.class
	        };
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		  
		Auth auth = (Auth) model.get("auth");
		
		if (auth.getAuth_id() == null) {
			Integer no = (Integer) model.get("auth_no");
			Auth detailInfo = authDao.selectOne(no);
			model.put("auth", detailInfo);
			
			return "/auth/authUpdate.jsp";
		} else {
			String new_password = (String) model.get("new_password");
			int result = authDao.update(auth, new_password);
			
			return "redirect:../index.jsp?check=authupdate&r=" + result;
		}
		
	}
	
}
