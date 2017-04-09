package adminWeb.controls;

import java.util.Map;

import adminWeb.annotation.Component;
import adminWeb.bind.DataBinding;
import adminWeb.dao.ProjectDao;

@Component("/project/projectinfo.do")
public class ProjectInfoController implements Controller, DataBinding {
	ProjectDao projectDao;

	public ProjectInfoController setProjectDao(ProjectDao projectDao) {
		this.projectDao = projectDao;
		return this;
	}
	
	@Override
	public Object[] getDataBinders() {
	    return new Object[]{
	            "project_no", Integer.class,
	        };
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		int no = (Integer) model.get("project_no");
		
		model.put("project", projectDao.selectOne(no));
		  
		return "/project/projectInfo.jsp";
		
	}
	
}
