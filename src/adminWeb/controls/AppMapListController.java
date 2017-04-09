package adminWeb.controls;

import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import adminWeb.annotation.Component;
import adminWeb.bind.DataBinding;
import adminWeb.dao.ProjectDao;

@Component("/appmap/appmaplist.do")
public class AppMapListController implements Controller, DataBinding {
	ProjectDao projectDao;

	public AppMapListController setProjectDao(ProjectDao projectDao) {
		this.projectDao = projectDao;
		return this;
	}
	
	@Override
	public Object[] getDataBinders() {
	    return new Object[]{
	            "lat", Double.class,
	            "lng", Double.class
	        };
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		double lat = (double) model.get("lat");
		double lng = (double) model.get("lng");
		
		JSONObject jsonMain = new JSONObject();
		JSONArray jArray = projectDao.searchMapList(lat, lng);
		jsonMain.put("maplist",jArray);
		
		model.put("maplist", jsonMain);
		
	    return "/appmap/appmap.jsp";
	}
	
}
