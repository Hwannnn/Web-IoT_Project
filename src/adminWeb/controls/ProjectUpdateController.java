package adminWeb.controls;

import java.util.Map;

import adminWeb.annotation.Component;
import adminWeb.bind.DataBinding;
import adminWeb.dao.ProjectDao;
import adminWeb.vo.Project;

@Component("/project/projectupdate.do")
public class ProjectUpdateController implements Controller, DataBinding {
	ProjectDao projectDao;
	
	public ProjectUpdateController setProjectDao(ProjectDao projectDao) {
		this.projectDao = projectDao;
		return this;
	}
	
	@Override
	public Object[] getDataBinders() {
	    return new Object[]{
	            "project_no", Integer.class,
	            "project", adminWeb.vo.Project.class
	        };
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		Project project = (Project) model.get("project");
		
		if (project.getName() == null) {
			Integer no = (Integer) model.get("project_no");
			Project detailInfo = projectDao.selectOne(no);
			model.put("project", detailInfo);
			
			return "/project/projectUpdate.jsp";
		} else {
			projectDao.update(project);	
			return "redirect:projectlist.do?pageNo=1";
		}
	}
	
	
	
}
