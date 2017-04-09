package adminWeb.dao;

import java.util.List;

import org.json.simple.JSONArray;

import adminWeb.vo.Paging;
import adminWeb.vo.Project;

public interface ProjectDao {
  List<Project> searchList(Paging paging, String id) throws Exception;
  List<Project> selectList(Paging paging, String id) throws Exception;
  int insert(Project Project) throws Exception;
  int delete(int no) throws Exception;
  Project selectOne(int no) throws Exception;
  int update(Project Project) throws Exception;
  int count() throws Exception;
  int count(String search, String con) throws Exception;
  JSONArray searchMapList(double lat, double lng) throws Exception;
  JSONArray selectMap(int no) throws Exception;
}
