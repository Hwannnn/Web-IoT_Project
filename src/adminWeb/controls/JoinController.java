package adminWeb.controls;

import java.util.Map;

import adminWeb.annotation.Component;
import adminWeb.bind.DataBinding;
import adminWeb.dao.AuthDao;
import adminWeb.vo.Auth;

@Component("/auth/join.do")
public class JoinController implements Controller, DataBinding {
  AuthDao authDao;
  
  public JoinController setDao(AuthDao authDao) {
    this.authDao = authDao;
    return this;
  }
  @Override
  public Object[] getDataBinders() {
      return new Object[]{
              "auth", adminWeb.vo.Auth.class
          };
  }
  @Override
  public String execute(Map<String, Object> model) throws Exception {
	  Auth auth = (Auth)model.get("auth");
   
	  if (auth.getAuth_id() == null) {
          return "/auth/authJoin.jsp";
      
      } else { 
    	  String temp = authDao.idCheck(auth);
    	  
    	  if (temp == "id" || temp == "num") {
    		  return "redirect:../auth/joinFail.jsp?val=" + temp;
    	  } else {
    		  authDao.insert(auth);
    		  return "../index.jsp?check=join";
    	  }
      }
  }



}
