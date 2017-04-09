package adminWeb.controls;

import java.util.Map;

import adminWeb.annotation.Component;
import adminWeb.bind.DataBinding;
import adminWeb.dao.ProjectDao;


@Component("/project/projectdelete.do")
public class ProjectDeleteController implements Controller,DataBinding {
	ProjectDao projectDao;
	
	public ProjectDeleteController setProjectDao(ProjectDao projectDao){
		this.projectDao = projectDao;
		return this;
	}
	
	@Override
	public Object[] getDataBinders() {
		return new Object[]{
			"project_no", Integer.class
		};
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		Integer no = (Integer) model.get("project_no");
		projectDao.delete(no);
		
		return "redirect:projectlist.do";
	}

}
