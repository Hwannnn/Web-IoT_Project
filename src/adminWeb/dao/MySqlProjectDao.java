package adminWeb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import adminWeb.annotation.Component;
import adminWeb.vo.Paging;
import adminWeb.vo.Project;

@Component("ProjectDao")
public class MySqlProjectDao implements ProjectDao {
    DataSource ds;

    public void setDataSource(DataSource ds) {
      this.ds = ds;
    }

    public List<Project> selectList(Paging paging, String id) throws Exception {
      Connection connection = null;
      Statement stmt = null;
      ResultSet rs = null; 
      int n1, n2;      
      
      try {
        connection = ds.getConnection();
        stmt = connection.createStatement();
        
        n1 = paging.getN1();
        n2 = paging.getPageSize();        
        if (id.equals("admin01")) {
	        rs = stmt.executeQuery(
	            "SELECT project_no,roadFullAddr,lot,auth_id" + 
	                " FROM project" +
				        " ORDER BY project_no DESC" + 
				            " LIMIT " + (n1-1) + ", " + n2);
        } else {
        	rs = stmt.executeQuery(
    	        "SELECT project_no,roadFullAddr,lot,auth_id" + 
    	            " FROM project" +
    	        		" WHERE auth_id='" + id + "'" +
    			            " ORDER BY project_no DESC" + 
    				            " LIMIT " + (n1-1) + ", " + n2);
        }
        
        ArrayList<Project> Projects = new ArrayList<Project>();
        
        while(rs.next()) {
          Projects.add((Project) new Project()
          .setProject_no(rs.getInt("project_no"))
          .setRoadFullAddr(rs.getString("roadFullAddr"))
          .setLot(rs.getString("lot"))
          .setAuth_id(rs.getString("auth_id")));
        }
        return Projects;

      } catch (Exception e) {
    	  throw new Exception("project list 예외발생.");

      } finally {
        try {if (rs != null) rs.close();} catch(Exception e) {}
        try {if (stmt != null) stmt.close();} catch(Exception e) {}
        try {if (connection != null) connection.close();} catch(Exception e) {}
      }
    }
    
	@Override
	public int insert(Project Project) throws Exception {
		Connection connection = null;
	    PreparedStatement stmt = null;
	  
	    try {
	      connection = ds.getConnection();      
	      stmt = connection.prepareStatement(
	          "INSERT INTO project(auth_id,lot,roadFullAddr,roadAddrPart1,addrDetail,startTime,endTime,cam,camnum,message)"
	              + " VALUES (?,?,?,?,?,?,?,?,?,?)");
	      stmt.setString(1,Project.getAuth_id());
	      stmt.setString(2, Project.getLot());
	      stmt.setString(3, Project.getRoadFullAddr());
	      stmt.setString(4, Project.getRoadAddrPart1());
	      stmt.setString(5, Project.getAddrDetail());
	      stmt.setString(6, Project.getStartTime());
	      stmt.setString(7, Project.getEndTime());
	      stmt.setString(8, Project.getCam());
	      stmt.setString(9, Project.getCamnum());
	      stmt.setString(10, Project.getMessage());
	      
	      return stmt.executeUpdate();

	    } catch (Exception e) {
	    	throw new Exception("project insert 예외발생.");

	    } finally {
	      try {if (stmt != null) stmt.close();} catch(Exception e) {}
	      try {if (connection != null) connection.close();} catch(Exception e) {}
	    }
	}
	
	@Override
	public int delete(int no) throws Exception {
		Connection connection = null;
		Statement stmt = null;
		
		try {
			connection = ds.getConnection();
			stmt = connection.createStatement();
			
			return stmt.executeUpdate(
					"DELETE FROM project WHERE project_no=" + no);

		} catch (Exception e) {
			throw new Exception("project delete 예외발생.");
		} finally {
		    try {if (stmt != null) stmt.close();} catch(Exception e) {}
		    try {if (connection != null) connection.close();} catch(Exception e) {}
		}
	}
	
	@Override
	public Project selectOne(int project_no) throws Exception {
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			connection = ds.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery(
					"SELECT a.auth_id,a.name,a.phone,a.email,p.project_no,p.lot,p.roadFullAddr,p.roadAddrPart1,p.addrDetail,p.lat,p.lng,p.startTime,p.endTime,p.cam,p.camnum,p.message"
						+ " FROM project p INNER JOIN auth a WHERE p.auth_id=a.auth_id and p.project_no=" + project_no);
			if(rs.next()){
				return (Project) new Project()
						.setProject_no(rs.getInt("project_no"))
						.setLot(rs.getString("lot"))
						.setRoadFullAddr(rs.getString("roadFullAddr"))
						.setRoadAddrPart1(rs.getString("roadAddrPart1"))
						.setAddrDetail(rs.getString("addrDetail"))
						.setLat(rs.getDouble("lat"))
						.setLng(rs.getDouble("lng"))
						.setStartTime(rs.getString("startTime"))
						.setEndTime(rs.getString("endTime"))
						.setCam(rs.getString("cam"))
						.setCamnum(rs.getString("camnum"))
						.setMessage(rs.getString("message"))
						.setAuth_id(rs.getString("auth_id"))
						.setName(rs.getString("name"))
						.setEmail(rs.getString("email"))
						.setPhone(rs.getString("phone"));
				
			}
		} catch (Exception e) {
			throw new Exception("selectone 예외발생.");
		} finally {
			try {if (rs != null) rs.close();} catch(Exception e) {}
		    try {if (stmt != null) stmt.close();} catch(Exception e) {}
		    try {if (connection != null) connection.close();} catch(Exception e) {}
		}
		return null;
	}
	
	@Override
	public int update(Project Project) throws Exception {
		Connection connection = null;
		PreparedStatement stmt = null;
		
		try {
			connection = ds.getConnection();
			stmt = connection.prepareStatement(
					"UPDATE PROJECT SET lot=?,roadFullAddr=?,roadAddrPart1=?,addrDetail=?,lat=?,lng=?,startTime=?,endTime=?,cam=?,camnum=?,message=?"
						+ " WHERE project_no = ?");
		      stmt.setString(1, Project.getLot());
		      stmt.setString(2, Project.getRoadFullAddr());
		      stmt.setString(3, Project.getRoadAddrPart1());
		      stmt.setString(4, Project.getAddrDetail());
		      stmt.setDouble(5, Project.getLat());
		      stmt.setDouble(6, Project.getLng());
		      stmt.setString(7, Project.getStartTime());
		      stmt.setString(8, Project.getEndTime());
		      stmt.setString(9, Project.getCam());
		      stmt.setString(10, Project.getCamnum());
		      stmt.setString(11, Project.getMessage());
		      stmt.setInt(12, Project.getProject_no());
			
			return stmt.executeUpdate();
		}  catch (Exception e) {
			throw new Exception("project update 예외발생.");
		} finally {
			try {if (stmt != null) stmt.close();} catch(Exception e) {}
			try {if (connection != null) connection.close();} catch(Exception e) {}			
		}
	}

	@Override
	public int count() throws Exception {
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try{
			connection = ds.getConnection();
			stmt = connection.createStatement();
	        rs = stmt.executeQuery(
	                "SELECT count(*) AS TotalCount" + 
	                    " FROM project");
			if(rs.next()){
		        return rs.getInt("TotalCount");
			}
			
		} catch (Exception e) {
	        throw e;

	      } finally {
	        try {if (rs != null) rs.close();} catch(Exception e) {}
	        try {if (stmt != null) stmt.close();} catch(Exception e) {}
	        try {if (connection != null) connection.close();} catch(Exception e) {}
	      }
		return 0;
	}

	@Override
	public int count(String search, String con) throws Exception {
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try{
			connection = ds.getConnection();
			stmt = connection.createStatement();
	        rs = stmt.executeQuery(
	                "SELECT count(*) AS TotalCount" + 
	                		" FROM (SELECT project_no FROM project" +
	                			" WHERE " + search + " LIKE '%" + con + "%')SIN");
			if(rs.next()){
		        return rs.getInt("TotalCount");
			}
			
		} catch (Exception e) {
	        throw e;

	      } finally {
	        try {if (rs != null) rs.close();} catch(Exception e) {}
	        try {if (stmt != null) stmt.close();} catch(Exception e) {}
	        try {if (connection != null) connection.close();} catch(Exception e) {}
	      }
		return 0;
	}

	@Override
	public List<Project> searchList(Paging paging, String id) throws Exception {
	      Connection connection = null;
	      Statement stmt = null;
	      ResultSet rs = null;
	      String search, con;
	      int n1, n2;
	    
	      try {
	        connection = ds.getConnection();
	        stmt = connection.createStatement();
	        search = paging.getSearch();
	        con = paging.getCon();
	        n1 = paging.getN1();
	        n2 = paging.getPageSize();
	        
	        if (id.equals("admin01")){
		        rs = stmt.executeQuery(
		            "SELECT project_no,lot,roadFullAddr,auth_id" + 
		                " FROM project" +
		            		" WHERE " + search + " LIKE '%" + con + "%'" +
					            " ORDER BY project_no DESC" +
					                " LIMIT " + (n1-1) + ", " + n2);
	        } else {
		        rs = stmt.executeQuery(
			        "SELECT project_no,lot,roadFullAddr,auth_id" + 
			            " FROM project" +
			                " WHERE auth_id='" + id + "' and " + search + " LIKE '%" + con + "%'" +
						        " ORDER BY project_no DESC" +
						            " LIMIT " + (n1-1) + ", " + n2);
	        }
	        
	        ArrayList<Project> Projects = new ArrayList<Project>();

	        while(rs.next()) {
	            Projects.add((Project) new Project()
	                    .setProject_no(rs.getInt("project_no"))
	                    .setRoadFullAddr(rs.getString("roadFullAddr"))
	                    .setLot(rs.getString("lot"))
	                    .setAuth_id(rs.getString("auth_id")));
	        }

	        return Projects;

	      } catch (Exception e) {
	        throw e;

	      } finally {
	        try {if (rs != null) rs.close();} catch(Exception e) {}
	        try {if (stmt != null) stmt.close();} catch(Exception e) {}
	        try {if (connection != null) connection.close();} catch(Exception e) {}
	      }
	}

	@Override
	public JSONArray searchMapList(double lat, double lng) throws Exception {
		Connection connection = null;
	    Statement stmt = null;
	    ResultSet rs = null;
	    JSONArray jArray = new JSONArray();
		int n = 0;
	      
	      try {
		        connection = ds.getConnection();
		        stmt = connection.createStatement();
		        
			    rs = stmt.executeQuery(
			        "SELECT project_no, lat, lng, addrDetail, (6371*acos(cos(radians(" + lat + "))*cos(radians(lat))*cos(radians(lng)-radians("+lng+"))+sin(radians(" + lat + "))*sin(radians(lat)))) AS distance" +
			        	" FROM project"+
			        		" HAVING distance < 0.5" +
			        			" ORDER BY distance" +
			        		        " LIMIT 0 , 5");
		        
		        ArrayList<Project> Projects = new ArrayList<Project>();

		        while(rs.next()) {
		        	JSONObject jObject = new JSONObject();
		        	jObject.put("project_no", rs.getInt("project_no"));
		            jObject.put("lat", rs.getDouble("lat"));
		            jObject.put("lng", rs.getDouble("lng"));
		            jObject.put("addrDetail", rs.getString("addrDetail"));
		            jArray.add(n, jObject);
		            n++;
		            jObject = null;
					
		        }

		        return jArray;

		      } catch (Exception e) {
		        throw e;

		      } finally {
		        try {if (rs != null) rs.close();} catch(Exception e) {}
		        try {if (stmt != null) stmt.close();} catch(Exception e) {}
		        try {if (connection != null) connection.close();} catch(Exception e) {}
		      }
	}

	@Override
	public JSONArray selectMap(int no) throws Exception {
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;
		JSONArray jArray = new JSONArray();
		JSONObject jObject = new JSONObject();
		
		try {
			connection = ds.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery(
					"SELECT *"
						+ " FROM project WHERE project_no=" + no);
			if(rs.next()){
	            jObject.put("lot", rs.getString("lot"));
	            jObject.put("roadFullAddr", rs.getString("roadFullAddr"));
	            jObject.put("addrDetail", rs.getString("addrDetail"));
	            jObject.put("startTime", rs.getString("startTime"));
				jObject.put("endTime", rs.getString("endTime"));
	            jObject.put("cam", rs.getString("cam"));
	            jObject.put("camnum", rs.getString("camnum"));
	            jObject.put("message", rs.getString("message"));
	            jArray.add(0, jObject);
	            return jArray;
			}
		} catch (Exception e) {
			throw new Exception("selectone 예외발생.");
		} finally {
			try {if (rs != null) rs.close();} catch(Exception e) {}
		    try {if (stmt != null) stmt.close();} catch(Exception e) {}
		    try {if (connection != null) connection.close();} catch(Exception e) {}
		}
		return null;
	}

}
