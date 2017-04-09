package adminWeb.controls;

import java.util.Map;

import javax.servlet.http.HttpSession;

import adminWeb.annotation.Component;
import adminWeb.bind.DataBinding;
import adminWeb.dao.AuthDao;
import adminWeb.vo.Auth;

@Component("/auth/login.do")
public class LogInController implements Controller, DataBinding {
    AuthDao authDao;
  
    public LogInController setAuthDao(AuthDao authDao) {
        this.authDao = authDao;
        return this;
    }
  
    public Object[] getDataBinders() {
        return new Object[]{
            "loginInfo", adminWeb.vo.Auth.class
        };
    }
  
    @Override
    public String execute(Map<String, Object> model) throws Exception {
        Auth loginInfo = (Auth)model.get("loginInfo");
        
        
        if(((HttpSession) model.get("session")).getAttribute("auth") != null){
        	return "redirect:/adminWeb/index.jsp";
        }

        if (loginInfo.getAuth_id() == null) {
            return "/auth/loginForm.jsp";
        } else {
    	    Auth auth = authDao.exist(
                loginInfo.getAuth_id(), 
                loginInfo.getPassword()); 
            if (auth != null) {
            	HttpSession session = (HttpSession)model.get("session");
                session.setAttribute("auth", auth);
                return "redirect:../index.jsp";
            } else {
                return "./loginFail.jsp";
            }
        }
    }
}
