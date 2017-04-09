package adminWeb.controls;

import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import adminWeb.annotation.Component;
import adminWeb.bind.DataBinding;
import adminWeb.dao.ProjectDao;

@Component("/appmap/mapinfo.do")
public class AppMapInfoController implements Controller, DataBinding {
	ProjectDao projectDao;

	public AppMapInfoController setProjectDao(ProjectDao projectDao) {
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
		
		JSONObject jsonMain = new JSONObject();
		JSONArray jArray = projectDao.selectMap(no);
		jsonMain.put("mapinfo",jArray);
		
		model.put("mapinfo", jsonMain);
		  
		return "/appmap/mapinfo.jsp";
		
	}
	
}
