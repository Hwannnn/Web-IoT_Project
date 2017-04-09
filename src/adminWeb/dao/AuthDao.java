package adminWeb.dao;

import adminWeb.vo.Auth;

public interface AuthDao {
    Auth exist(String auth_id, String password) throws Exception;
	String idCheck(Auth auth) throws Exception;
	int insert(Auth auth) throws Exception;
	Auth selectOne(int no) throws Exception;
	Auth selectOne(String auth_id) throws Exception;
	int update(Auth auth, String new_password)throws Exception;
}
