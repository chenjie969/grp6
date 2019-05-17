package com.zjm.sys.util;

import java.util.List;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.zjm.sys.db.model.Sys_departs;
import com.zjm.sys.db.model.Sys_role_data;
import com.zjm.sys.departs.service.DepartsService;
import com.zjm.sys.rolesData.RolesDataService;
import com.zjm.sys.users.service.UsersService;

public class RolesDataAccreditUtil {
	
	private static RolesDataService rolesDataService ;
	
	private static UsersService usersService;
	
	private static DepartsService departsService; 
	
	static{
		WebApplicationContext ctx = ContextLoader.getCurrentWebApplicationContext();
		rolesDataService = (RolesDataService) ctx.getBean("rolesDataService");
		usersService = (UsersService) ctx.getBean("usersService");
		departsService = (DepartsService) ctx.getBean("departsService");
	}


	/**
	 * @param userId 登录用户id
	 * @param tableNick 表别名
	 * @return
	 */
	public static String appendClientSqlByRole(String userId,String tableNick){
	/*	String sql =null;
		//1.用户对应角色的数据权限
		List<Sys_role_data> list = rolesDataService.selectClientDataByUserId(userId);
		
		if( null == list || 0 == list.size()){//无角色限定默认只能查看自己的
			sql = "and "+tableNick+"createUserID = '"+userId+"'";
			return sql;
		}
		
		//查出最大权限
		int dataRoleMax = findMaxAccreditType(list);
		
		if(1 == dataRoleMax){//限看本人创建数据
			sql = "and "+tableNick+"createUserID = '"+userId+"'";
		}
		if(2 == dataRoleMax){//限看部门创建的数据
			sql = "and	"+tableNick+"createUserID IN ( "+
					"select sys_dep_user.user_uid  from 	sys_dep_user "+
					"where sys_dep_user.depart_uid =  "+
					"(select d.depart_uid from sys_departs as d "+
							"LEFT JOIN sys_dep_user as d_u on d.depart_uid = d_u.depart_uid "+
							"LEFT JOIN sys_users as u ON u.user_uid = d_u.user_uid "+
							"where u.user_uid = '"+userId+"') "+
				") ";
		} 
		if(3 == dataRoleMax){//全公司的数据都可以看
			String subsidiaryCode = subsidiaryCode(userId);//子公司depart_uid
			sql = "and  "+tableNick+"createUserID IN ( "+
				  "  select user_uid from sys_dep_user  "+
				  "  where sys_dep_user.depart_uid IN (  "+
				  	"  select d.depart_uid from sys_departs as d  "+
				  	"  where d.depart_fullcode LIKE CONCAT('%', '"+subsidiaryCode+"' ,'%') "+
				  	") "+
				  ") ";

		}
		return sql;*/
		return "";
	}
	
	/**
	 * 申请项目查询的 sql拼接字段  用户咨询   接待人ID
	 */
	public static final String PRO_APPLY_RECEIVE_SQL_STR = "receiveUserID";
	
	/**
	 * 项目申请后查询sql拼接字段  受理申请和和业务跟踪     创建人ID
	 */
	public static final String PRO_CREATE_SQL_STR = "createManID";
	
	/**
	 * 项目a角id sql 拼接字段 
	 */
	public static final String PRO_AMAN_SQL_STR = "amanID";
	
	/**
	 * @param userId 登录用户id
	 * @param proStateStr 查询项目拼接String
	 * @param tableNick	表别名
	 * @return
	 */
	public static String appendProSqlByRole(String userId ,String proStateStr ,String tableNick){
		/*String sql =null;
		//1.用户对应角色的数据权限
		List<Sys_role_data> list = rolesDataService.selectProDataByUserId(userId);
		if( null == list || 0 == list.size()){
			sql = "and "+tableNick+proStateStr+" = '"+userId+"'";
			return sql;
		}
		
		//查出最大权限
		int dataRoleMax = findMaxAccreditType(list);
		
		if(1 == dataRoleMax){//限看本人创建数据
			sql = "and "+tableNick+proStateStr+" = '"+userId+"'";
		}
		
		if(2 == dataRoleMax){//限看部门创建的数据
			sql = "and	"+tableNick+proStateStr+" IN ( "+
					"select sys_dep_user.user_uid  from 	sys_dep_user "+
					"where sys_dep_user.depart_uid =  "+
					"(select d.depart_uid from sys_departs as d "+
							"LEFT JOIN sys_dep_user as d_u on d.depart_uid = d_u.depart_uid "+
							"LEFT JOIN sys_users as u ON u.user_uid = d_u.user_uid "+
							"where u.user_uid = '"+userId+"') "+
				") ";
		} 
		
		if(3 == dataRoleMax){//全公司的数据都可以看
			String subsidiaryCode = subsidiaryCode(userId);//子公司depart_uid
			sql = "and  "+tableNick+proStateStr+" IN ( "+
				  "  select user_uid from sys_dep_user  "+
				  "  where sys_dep_user.depart_uid IN (  "+
				  	"  select d.depart_uid from sys_departs as d  "+
				  	"  where d.depart_fullcode LIKE CONCAT('%', '"+subsidiaryCode+"' ,'%') "+
				  	") "+
				  ") ";
			
		}
		return sql;*/
		return "";
	}
	
	
	/** 
	 * 根据登录用户是否为abc角以及其对应数据权限查看
	 * @param userId
	 * @param tableNick
	 * @return
	 */
	public static String appendProSqlByABC(String userId,String tableNick){
		/*String sql = null;
		List<Sys_role_data> list = rolesDataService.selectProDataByUserId(userId);
		
		if( null == list || 0 == list.size()){//默认
			sql =" AND ("+tableNick+" amanID =  '"+userId+"' OR "+tableNick+" bmanID = '"+userId+"' OR  "+tableNick+" reviewManID = '"+userId+"' )";
			return sql;
		}
		int dataRoleMax = findMaxAccreditType(list);//查出最大权限
		if( 1 == dataRoleMax ){//限看本人创建数据
			sql =" AND ("+tableNick+" amanID =  '"+userId+"' OR "+tableNick+" bmanID = '"+userId+"' OR  "+tableNick+" reviewManID = '"+userId+"' )";
		}
		
		if(2 == dataRoleMax){ //限看部门创建的数据
			sql = " "+
			"AND ( "+
				tableNick+"amanID IN (  "+
								"select sys_dep_user.user_uid from sys_dep_user "+ 
								"where "+
								"sys_dep_user.depart_uid = "+
								"(select d.depart_uid from sys_departs as d "+
								"LEFT JOIN sys_dep_user as d_u on d.depart_uid = d_u.depart_uid "+
								"LEFT JOIN sys_users as u ON u.user_uid = d_u.user_uid "+
								"where u.user_uid = '"+userId+"' ) "+
								") "+
			" OR "+tableNick+"bmanID IN ( "+
								"select sys_dep_user.user_uid from sys_dep_user "+ 
								"where "+
								"sys_dep_user.depart_uid = "+
								"(select d.depart_uid from sys_departs as d "+
								"LEFT JOIN sys_dep_user as d_u on d.depart_uid = d_u.depart_uid "+
								"LEFT JOIN sys_users as u ON u.user_uid = d_u.user_uid "+
								"where u.user_uid = '"+userId+"' ) "+
								") "+
			" OR "+tableNick+"reviewManID IN ( "+
								"select sys_dep_user.user_uid from sys_dep_user "+ 
								"where "+
								"sys_dep_user.depart_uid = "+
								"(select d.depart_uid from sys_departs as d "+
								"LEFT JOIN sys_dep_user as d_u on d.depart_uid = d_u.depart_uid "+
								"LEFT JOIN sys_users as u ON u.user_uid = d_u.user_uid "+
								"where u.user_uid = '"+userId+"' ) "+
								") "+
						" ) ";
			
		}
		
		if(3 == dataRoleMax){//全公司的数据都可以看
			String subsidiaryCode = subsidiaryCode(userId);//子公司depart_uid
			sql = " "+
			"AND ( "+
				tableNick+" amanID IN ( "+
						  "  select user_uid from sys_dep_user  "+
						  "  where sys_dep_user.depart_uid IN (  "+
						  	 "  select d.depart_uid from sys_departs as d  "+
						  	 "  where d.depart_fullcode LIKE CONCAT('%', '"+subsidiaryCode+"' ,'%') "+
						  	 ") "+
						  ") " +
			" OR "+tableNick+"bmanID IN ( "+
						  "  select user_uid from sys_dep_user  "+
						  "  where sys_dep_user.depart_uid IN (  "+
						  	 "  select d.depart_uid from sys_departs as d  "+
						  	 "  where d.depart_fullcode LIKE CONCAT('%', '"+subsidiaryCode+"' ,'%') "+
						  	 ") "+
						  ") " +
			" OR "+tableNick+"reviewManID IN ( "+
						  "  select user_uid from sys_dep_user  "+
						  "  where sys_dep_user.depart_uid IN (  "+
						  	 "  select d.depart_uid from sys_departs as d  "+
						  	 "  where d.depart_fullcode LIKE CONCAT('%', '"+subsidiaryCode+"' ,'%') "+
						  	 ") "+
						  ") "+
					" ) ";
		}
		return sql;*/
		return "";
	}
	
	
	/**
	 * 根据登录用户是否为abc角以及创建人    用其对应的数据权限查看
	 * @param userId
	 * @param tableNick
	 */
	public static String appendProSqlByABCCreate(String userId,String tableNick){
		/*String sql = null;
		List<Sys_role_data> list = rolesDataService.selectProDataByUserId(userId);
		
		if( null == list || 0 == list.size()){//默认
			sql =" AND ("+tableNick+" amanID =  '"+userId+"' OR "+tableNick+" bmanID = '"+userId+"' OR  "+tableNick+" reviewManID = '"+userId+"' OR  "+tableNick+" createManID = '"+userId+"' )";
			return sql;
		}
		int dataRoleMax = findMaxAccreditType(list);//查出最大权限
		if( 1 == dataRoleMax ){//限看本人创建数据
			sql =" AND ("+tableNick+" amanID =  '"+userId+"' OR "+tableNick+" bmanID = '"+userId+"' OR  "+tableNick+" reviewManID = '"+userId+"' OR  "+tableNick+" createManID = '"+userId+"' )";
		}
		
		if(2 == dataRoleMax){ //限看部门创建的数据
			sql = " "+
			"AND ( "+
				tableNick+"amanID IN (  "+
								"select sys_dep_user.user_uid from sys_dep_user "+ 
								"where "+
								"sys_dep_user.depart_uid = "+
								"(select d.depart_uid from sys_departs as d "+
								"LEFT JOIN sys_dep_user as d_u on d.depart_uid = d_u.depart_uid "+
								"LEFT JOIN sys_users as u ON u.user_uid = d_u.user_uid "+
								"where u.user_uid = '"+userId+"' ) "+
								") "+
			" OR "+tableNick+"bmanID IN ( "+
								"select sys_dep_user.user_uid from sys_dep_user "+ 
								"where "+
								"sys_dep_user.depart_uid = "+
								"(select d.depart_uid from sys_departs as d "+
								"LEFT JOIN sys_dep_user as d_u on d.depart_uid = d_u.depart_uid "+
								"LEFT JOIN sys_users as u ON u.user_uid = d_u.user_uid "+
								"where u.user_uid = '"+userId+"' ) "+
								") "+

			" OR "+tableNick+"reviewManID IN ( "+
								"select sys_dep_user.user_uid from sys_dep_user "+ 
								"where "+
								"sys_dep_user.depart_uid = "+
								"(select d.depart_uid from sys_departs as d "+
								"LEFT JOIN sys_dep_user as d_u on d.depart_uid = d_u.depart_uid "+
								"LEFT JOIN sys_users as u ON u.user_uid = d_u.user_uid "+
								"where u.user_uid = '"+userId+"' ) "+
								") "+
			" OR "+tableNick+"createManID IN ( "+
								"select sys_dep_user.user_uid from sys_dep_user "+ 
								"where "+
								"sys_dep_user.depart_uid = "+
								"(select d.depart_uid from sys_departs as d "+
								"LEFT JOIN sys_dep_user as d_u on d.depart_uid = d_u.depart_uid "+
								"LEFT JOIN sys_users as u ON u.user_uid = d_u.user_uid "+
								"where u.user_uid = '"+userId+"' ) "+
								") "+
				" ) ";
		}
		
		if(3 == dataRoleMax){//全公司的数据都可以看
			String subsidiaryCode = subsidiaryCode(userId);//子公司depart_uid
			sql = " "+
			"AND ( "+
				tableNick+"amanID IN (  "+
								  "  select user_uid from sys_dep_user  "+
								  "  where sys_dep_user.depart_uid IN (  "+
								  	 "  select d.depart_uid from sys_departs as d  "+
								  	 "  where d.depart_fullcode LIKE CONCAT('%', '"+subsidiaryCode+"' ,'%') "+
								  	 ") "+
								") "+
			" OR "+tableNick+"bmanID IN ( "+
								  "  select user_uid from sys_dep_user  "+
								  "  where sys_dep_user.depart_uid IN (  "+
								  	 "  select d.depart_uid from sys_departs as d  "+
								  	 "  where d.depart_fullcode LIKE CONCAT('%', '"+subsidiaryCode+"' ,'%') "+
								  	 ") "+
								") "+

			" OR "+tableNick+"reviewManID IN ( "+
								  "  select user_uid from sys_dep_user  "+
								  "  where sys_dep_user.depart_uid IN (  "+
								  	 "  select d.depart_uid from sys_departs as d  "+
								  	 "  where d.depart_fullcode LIKE CONCAT('%', '"+subsidiaryCode+"' ,'%') "+
								  	 ") "+
								") "+
			" OR "+tableNick+"createManID IN ( "+
								  "  select user_uid from sys_dep_user  "+
								  "  where sys_dep_user.depart_uid IN (  "+
								  	 "  select d.depart_uid from sys_departs as d  "+
								  	 "  where d.depart_fullcode LIKE CONCAT('%', '"+subsidiaryCode+"' ,'%') "+
								  	 ") "+
								") "+
				" ) ";
		}
		return sql;*/
		return "";
	}
	
	/**
	 * 根据用户id及其数据权限，查看上会信息。
	 * @param userId
	 * @return
	 */
	public static String appendMeetingSql(String userId){
		/*String sql = null;
		
		List<Sys_role_data> list = rolesDataService.selectProDataByUserId(userId);
		
		if( null == list || 0 == list.size()){//默认
			sql =" and userIDList like \'%"+userId.trim()+"%\'"; 
			return sql;
		}
		int dataRoleMax = findMaxAccreditType(list);//查出最大权限
		
		if( 1 == dataRoleMax ){//本人
			sql =" and userIDList like \'%"+userId.trim()+"%\'"; 
		}
		
		if( 2 == dataRoleMax ){//本部门
			//查出本部的所有userId 
			List<String> userIds = departsService.selectUserListByCommonDepUser(userId);
			sql = appendUserIdSql(userIds);
		}
		
		if( 3== dataRoleMax ){//全公司
			//查出本公司的所有userId
			String subsidiaryCode = subsidiaryCode(userId);//子公司depart_uid
			List<String> userIds = departsService.selectfollowDepUserByDepart(subsidiaryCode);
			sql = appendUserIdSql(userIds);
		}
		
		return sql;*/
		return "";
	}
	
	
	private static String appendUserIdSql(List<String> list){
		StringBuffer sb = new StringBuffer();
		if(null != list && list.size()>0){
			sb.append("and ( ");
			for (int i = 0; i < list.size() -1; i++) {
				sb.append(" userIDList like \'%"+list.get(i)+"%\' or ");
			}
			sb.append(" userIDList like \'%"+list.get(list.size()-1)+"%\'  )");
		}
		return sb.toString();
	}
	
	
	/**
	 * 获取所有权限中最大的操作权限
	 * @param list
	 * @return 
	 */
	private static int findMaxAccreditType(List<Sys_role_data> list){
		int maxType = list.get(0).getAccredit_type();
		for (int i = 1; i < list.size() ; i++) {
			if(maxType<list.get(i).getAccredit_type()){
				maxType = list.get(i).getAccredit_type();
			}
		}
		return maxType;
	}
	
	/**
	 * 获取最近的一个子公司的depart_uid
	 * @param userId
	 * @return
	 */
	public static String subsidiaryCode(String userId){
		String subsidiaryCode = null;
		//查出部门fulldepart_code
		Sys_departs depart = usersService.getDepartByUserId(userId);
		//获取该部门的所有上级部门
		String[] upDeps =  depart.getDepart_fullcode().split("/");
		//遍历数组查看最近的子公司
		for (int i = upDeps.length-1; i >= 0; i--) {
			Sys_departs searchDep = new Sys_departs();
			searchDep.setDepart_uid(upDeps[i]);
			searchDep = departsService.selectOneDepartsInfo(searchDep);
			if( 1 == searchDep.getDepart_type()){
				return subsidiaryCode = searchDep.getDepart_uid();
			}
		}
		
		return subsidiaryCode;
	}
	
	
}
