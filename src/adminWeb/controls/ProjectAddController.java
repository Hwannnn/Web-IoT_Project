package adminWeb.controls;

import java.util.Map;

import adminWeb.annotation.Component;
import adminWeb.bind.DataBinding;
import adminWeb.dao.ProjectDao;
import adminWeb.vo.Project;

@Component("/project/projectadd.do")
public class ProjectAddController implements Controller, DataBinding{
	ProjectDao projectDao;
	
	public ProjectAddController setProjectDao(ProjectDao projectDao) {
		this.projectDao = projectDao;
		return this;
	}
	public Object[] getDataBinders() {
		return new Object[]{
			"project", adminWeb.vo.Project.class
		};
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		Project project = (Project) model.get("project");
		
		if(project.getLot() == null) {
			return "/project/projectAdd.jsp";
		} else {
			projectDao.insert(project);
			return "redirect:projectlist.do?pageNo=1";
		}
	}
	
}
