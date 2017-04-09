package adminWeb.controls;

import java.util.Map;

import javax.servlet.http.HttpSession;

import adminWeb.annotation.Component;
import adminWeb.bind.DataBinding;
import adminWeb.dao.ProjectDao;
import adminWeb.vo.Paging;
import adminWeb.vo.Auth;

@Component("/project/projectsearch.do")
public class ProjectSearchController implements Controller, DataBinding {
	ProjectDao projectDao;

	public ProjectSearchController setProjectDao(ProjectDao projectDao) {
		this.projectDao = projectDao;
		return this;
	}
	
	@Override
	public Object[] getDataBinders() {
	    return new Object[]{
	            "pageNo", Integer.class,
	            "search", String.class,
	            "con", String.class,
	            "paging", adminWeb.vo.Paging.class
	        };
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {

		Paging paging = (Paging) model.get("paging");		
		int pageNo = (int) model.get("pageNo");
		String id = ((Auth) ((HttpSession) model.get("session")).getAttribute("auth")).getAuth_id();
		
		paging.setPageNo(pageNo);
		paging.setSearch((String) model.get("search"));
		paging.setCon((String) model.get("con"));
		paging.setTotalCount(projectDao.count(paging.getSearch(), paging.getCon()));
	    
	    model.put("paging", paging);
	    model.put("projects", projectDao.searchList(paging, id));

	    return "/project/projectList.jsp";
	}
	
}
