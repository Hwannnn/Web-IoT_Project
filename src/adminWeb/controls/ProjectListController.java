package adminWeb.controls;

import java.util.Map;

import javax.servlet.http.HttpSession;

import adminWeb.annotation.Component;
import adminWeb.bind.DataBinding;
import adminWeb.dao.ProjectDao;
import adminWeb.vo.Auth;
import adminWeb.vo.Paging;


@Component("/project/projectlist.do")
public class ProjectListController implements Controller, DataBinding {
	ProjectDao projectDao;

	public ProjectListController setProjectDao(ProjectDao projectDao) {
		this.projectDao = projectDao;
		return this;
	}
	
	@Override
	public Object[] getDataBinders() {
	    return new Object[]{
	            "pageNo", Integer.class,
	            "paging", adminWeb.vo.Paging.class
	        };
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		Paging paging = (Paging) model.get("paging");		
		int pageNo = (int) model.get("pageNo");
		String id = ((Auth) ((HttpSession) model.get("session")).getAttribute("auth")).getAuth_id();

		paging.setPageNo(pageNo);
	    paging.setTotalCount(projectDao.count());
	    
	    model.put("paging", paging);
	    model.put("projects", projectDao.selectList(paging, id));

        
	    
	    return "/project/projectList.jsp";
	}
	
}
