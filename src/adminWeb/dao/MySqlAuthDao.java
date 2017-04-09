package adminWeb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.sql.DataSource;

import adminWeb.annotation.Component;
import adminWeb.vo.Auth;


@Component("AdminDao")
public class MySqlAuthDao implements AuthDao {
    DataSource ds;

    public void setDataSource(DataSource ds) {
        this.ds = ds;
    }
  
    public Auth exist(String auth_id, String password) throws Exception {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            connection = ds.getConnection();
      
            stmt = connection.prepareStatement(
            	"SELECT * FROM auth"
            		+ " WHERE auth_id=? AND password=?");
      
	        stmt.setString(1, auth_id);
	        stmt.setString(2, password);
	        rs = stmt.executeQuery();
      
	        if (rs.next()) {
	        	return new Auth()
	        		.setAuth_no(rs.getInt("auth_no"))
	        		.setAuth_id(rs.getString("auth_id"))
	        		.setResident_num(rs.getString("resident_num"))
	        		.setName(rs.getString("name"))
	        		.setPhone(rs.getString("phone"));
	        } else {
	        	return null;
	        }
        } catch (Exception e) {
        	throw new Exception("auth exist 예외발생.");

        } finally {
        	try {if (rs != null) rs.close();} catch (Exception e) {}
		    try {if (stmt != null) stmt.close();} catch (Exception e) {}
		    try {if (connection != null) connection.close();} catch(Exception e) {}
        }
    }

	@Override
	public String idCheck(Auth auth) throws Exception {
	 	Connection connection = null;
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
		try{
	      connection = ds.getConnection();
		  stmt = connection.prepareStatement(
		      "SELECT auth_id FROM auth"
		          + " WHERE auth_id=? or resident_num=?;");
		  stmt.setString(1, auth.getAuth_id());
		  stmt.setString(2, auth.getResident_num());
		  rs = stmt.executeQuery();
		  if(rs.next()){
			if(rs.getString("auth_id").equals(auth.getAuth_id())){
				return "id";
			} else{
				return "num";
			}
		  } else {
			  return "pass";
		  }
		} catch (Exception e) {
		      throw e;
	    } finally{
		    try {if (rs != null) rs.close();} catch (Exception e) {}
		    try {if (stmt != null) stmt.close();} catch (Exception e) {}
		    try {if (connection != null) connection.close();} catch(Exception e) {}
		}
	}

	@Override
	public int insert(Auth auth) throws Exception {
		Connection connection = null;
	    PreparedStatement stmt = null;
	  
	    try {
	      connection = ds.getConnection();      
	      stmt = connection.prepareStatement(
	          "INSERT INTO auth(auth_no,auth_id,password,name,resident_num,phone,email)"
	              + " VALUES (?,?,?,?,?,?,?)");
	      stmt.setInt(1, auth.getAuth_no());
	      stmt.setString(2, auth.getAuth_id());
	      stmt.setString(3, auth.getPassword());
	      stmt.setString(4, auth.getName());
	      stmt.setString(5, auth.getResident_num());
	      stmt.setString(6, auth.getPhone());
	      stmt.setString(7, auth.getEmail());
	      
	      return stmt.executeUpdate();

	    } catch (Exception e) {
	    	throw new Exception("auth insert 예외발생.");

	    } finally {
	      try {if (stmt != null) stmt.close();} catch(Exception e) {}
	      try {if (connection != null) connection.close();} catch(Exception e) {}
	    }
		
	}

	@Override
	public Auth selectOne(int no) throws Exception {
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			connection = ds.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery(
					"SELECT *"
						+ " FROM auth WHERE auth_no=" + no);
			if(rs.next()){
				return new Auth()
						.setAuth_no(rs.getInt("auth_no"))
						.setAuth_id(rs.getString("auth_id"))
						.setName(rs.getString("name"))
						.setPhone(rs.getString("phone"))
						.setEmail(rs.getString("email"))
						.setResident_num(rs.getString("resident_num"));
			}
		} catch (Exception e) {
			throw new Exception("auth selectone 예외발생.");
		} finally {
			try {if (rs != null) rs.close();} catch(Exception e) {}
		    try {if (stmt != null) stmt.close();} catch(Exception e) {}
		    try {if (connection != null) connection.close();} catch(Exception e) {}
		}
		return null;
	}

	@Override
	public int update(Auth auth, String new_password) throws Exception {
		Connection connection = null;
		PreparedStatement stmt = null;
		
		try {
			connection = ds.getConnection();
			stmt = connection.prepareStatement(
					"UPDATE auth SET password=?, phone=?, email=?"
						+ " WHERE auth_no = ? and password = ?" );
		    stmt.setString(1, new_password);
		    stmt.setString(2, auth.getPhone());
		    stmt.setString(3, auth.getEmail());
		    stmt.setInt(4, auth.getAuth_no());
		    stmt.setString(5, auth.getPassword());
			
		    return stmt.executeUpdate();
		    
		}  catch (Exception e) {
			throw new Exception("auth update 예외발생.");
		} finally {
			try {if (stmt != null) stmt.close();} catch(Exception e) {}
			try {if (connection != null) connection.close();} catch(Exception e) {}			
		}

		
	}

	@Override
	public Auth selectOne(String auth_id) throws Exception {
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			connection = ds.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery(
					"SELECT *"
						+ " FROM auth WHERE auth_id=" + "'" + auth_id + "'");
			if(rs.next()){
				return new Auth()
						.setAuth_no(rs.getInt("auth_no"))
						.setAuth_id(rs.getString("auth_id"))
						.setName(rs.getString("name"))
						.setPhone(rs.getString("phone"))
						.setEmail(rs.getString("email"))
						.setResident_num(rs.getString("resident_num"));
			}
		} catch (Exception e) {
			throw new Exception("auth selectone 예외발생.");
		} finally {
			try {if (rs != null) rs.close();} catch(Exception e) {}
		    try {if (stmt != null) stmt.close();} catch(Exception e) {}
		    try {if (connection != null) connection.close();} catch(Exception e) {}
		}
		return null;
	}

}
