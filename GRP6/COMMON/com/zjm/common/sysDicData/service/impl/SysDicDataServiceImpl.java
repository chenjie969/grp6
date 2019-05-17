package com.zjm.common.sysDicData.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.db.map.SysDicDataMapper;
import com.zjm.common.db.model.SysDicData;
import com.zjm.common.sysDicData.service.SysDicDataService;
import com.zjm.util.SystemSession;
import com.zjm.util.Tool;
/**
 * 系统字典数据
 * @author mashuo add 20170512
 *
 */
@Service("sysDicDataService")
@Transactional
public class SysDicDataServiceImpl implements SysDicDataService {
	@Resource 
	private SysDicDataMapper sysDicDataMapper;//公用字典



	//=======================================一级字典  begin==================================
	/**
	 * 一级字典List 包含禁用
	 * @return
	 */
	public List<SysDicData> selectDicTypeDicList(String wheresql,String dicTypeID){
		String basicsql="SELECT unit_uid,dicTypeID as id,dicTypePID as pid,dicTypeName as name,remark FROM c_dictype where 1=1 ";
		return sysDicDataMapper.selectAllSysDicDataList(basicsql+wheresql+"   and dicTypePID=\'"+dicTypeID+"\' ORDER BY order_id");
	}
	/**
	 * 一级字典List 不包含禁用
	 * @return
	 */
	public List<SysDicData> selectDicTypeDicNoEableList(String wheresql,String dicTypeID){
		String basicsql="SELECT unit_uid,dicTypeID as id,dicTypePID as pid,dicTypeName as name,remark FROM c_dictype where 1=1 ";
		return sysDicDataMapper.selectAllSysDicDataList(basicsql+wheresql+"   and dicTypePID=\'"+dicTypeID+"\'  and isEable IS FALSE  ORDER BY order_id");
	}
	/**
	 * 一级字典List 包含禁用
	 * @return
	 */
	public Map<String,String> selectDicTypeDicMap(String wheresql,String dicTypeID){
		return Tool.parseSStrDict(selectDicTypeDicList(wheresql,dicTypeID), "id", "name");
	}
	/**
	 * 一级字典List 不包含禁用
	 * @return
	 */
	public Map<String,String> selectDicTypeDicNoEableMap(String wheresql,String dicTypeID){
		return Tool.parseSStrDict(selectDicTypeDicNoEableList(wheresql,dicTypeID), "id", "name");
	}
	//=======================================一级字典  end==================================





	//=======================================多级字典  begin==================================
	/**
	 * 多级字典List 包含禁用
	 * @return
	 */
	public List<SysDicData> selectMultiLevelSortDicList(String wheresql,String id){
		String basicsql="select multiLevelSortID as id, unit_uid, pmultiLevelSortID as pid, multiLevelSortName as name, multiLevelSortFullCode as fullCode ,isDefault  from c_multilevelsort where 1=1 ";
		if(id!=null && !id.equals("")){
			return sysDicDataMapper.selectAllSysDicDataList(basicsql+wheresql+"  and multilevelsortfullcode like \'"+id+"%\'  ORDER BY order_id");
		}else{
			return sysDicDataMapper.selectAllSysDicDataList(basicsql+wheresql+"   ORDER BY order_id");
		}
	}
	/**
	 * 多级字典List 不包含禁用
	 * @return
	 */
	public List<SysDicData> selectMultiLevelSortDicNoEableList(String wheresql,String id){
		String basicsql="select multiLevelSortID as id, unit_uid, pmultiLevelSortID as pid, multiLevelSortName as name, multiLevelSortFullCode as fullCode from c_multilevelsort where 1=1 ";
		if(id!=null && !id.equals("")){
			return sysDicDataMapper.selectAllSysDicDataList(basicsql+wheresql+"  and multilevelsortfullcode like \'"+id+"%\'  and isEable IS FALSE  ORDER BY order_id");
		}else{
			return sysDicDataMapper.selectAllSysDicDataList(basicsql+wheresql+"   and isEable IS FALSE  ORDER BY order_id");
		}
	}
	/**
	 * 多级字典List 包含禁用
	 * @return
	 */
	public Map<String,String> selectMultiLevelSortDicMap(String wheresql,String id){
		return Tool.parseSStrDict(selectMultiLevelSortDicList(wheresql,id), "id", "name");
	}
	/**
	 * 多级字典List 不包含禁用
	 * @return
	 */
	public Map<String,String> selectMultiLevelSortDicNoEableMap(String wheresql,String id){
		return Tool.parseSStrDict(selectMultiLevelSortDicNoEableList(wheresql,id), "id", "name");
	}
	//=======================================多级字典  end==================================



	//=======================================业务品种字典  begin==================================
	/**
	 * 业务品种字典List 包含禁用
	 * @return
	 */
	public List<SysDicData> selectBusiSortDicList(String wheresql){
		String basicsql="select busiSortID as id, unit_uid, pbusiSortID as pid, busiSortName as name, busiSortFullCode as fullCode from c_busisort where 1=1 ";
		return sysDicDataMapper.selectAllSysDicDataList(basicsql+wheresql+"  ORDER BY order_id");
	}
	/**
	 * 业务品种字典List 不包含禁用
	 * @return
	 */
	public List<SysDicData> selectBusiSortDicNoEableList(String wheresql){
		String basicsql="select busiSortID as id, unit_uid, pbusiSortID as pid, busiSortName as name, busiSortFullCode as fullCode from c_busisort where 1=1 ";
		return sysDicDataMapper.selectAllSysDicDataList(basicsql+wheresql+"   and isEable IS FALSE ORDER BY order_id");
	}
	/**
	 * 业务品种字典List 包含禁用
	 * @return
	 */
	public Map<String,String> selectBusiSortDicMap(String wheresql){
		return Tool.parseSStrDict(selectBusiSortDicList(wheresql), "id", "name");
	}
	/**
	 * 业务品种字典List 不包含禁用
	 * @return
	 */
	public Map<String,String> selectBusiSortDicNoEableMap(String wheresql){
		return Tool.parseSStrDict(selectBusiSortDicNoEableList(wheresql), "id", "name");
	}
	//=======================================业务品种字典  end==================================


	//=======================================银行字典  begin==================================
	/**
	 * 银行字典List 包含禁用
	 * @return
	 */
	public List<SysDicData> selectBankSortDicList(String wheresql){
		String basicsql="select bankSortID as id, unit_uid, pbankSortID as pid, bankSortName as name, bankFullCode as fullCode from c_banksort where 1=1 ";
		return sysDicDataMapper.selectAllSysDicDataList(basicsql+wheresql+"  ORDER BY order_id");
	}
	/**
	 * 银行字典List 不包含禁用
	 * @return
	 */
	public List<SysDicData> selectBankSortDicNoEableList(String wheresql){
		String basicsql="select bankSortID as id, unit_uid, pbankSortID as pid, bankSortName as name, bankFullCode as fullCode from c_banksort where 1=1 ";
		return sysDicDataMapper.selectAllSysDicDataList(basicsql+wheresql+"   and isEable IS FALSE ORDER BY order_id");
	}
	/**
	 * 银行字典List 包含禁用
	 * @return
	 */
	public Map<String,String> selectBankSortDicMap(String wheresql){
		return Tool.parseSStrDict(selectBankSortDicList(wheresql), "id", "name");
	}
	/**
	 * 银行字典List 不包含禁用
	 * @return
	 */
	public Map<String,String> selectBankSortDicNoEableMap(String wheresql){
		return Tool.parseSStrDict(selectBankSortDicNoEableList(wheresql), "id", "name");
	}
	//=======================================银行字典  end==================================

	//=======================================部门字典  begin==================================
	/**
	 * 部门字典List 包含禁用
	 * @return
	 */
	public List<SysDicData> selectDepartsDicList(String wheresql){
		String basicsql="SELECT depart_uid as id,unit_uid,pdepart_id as pid,depart_name as name,leve1_user_id,leve2_user_id,leve3_user_id,depart_fullcode as fullCode,isRoot FROM sys_departs where 1=1 ";
		return sysDicDataMapper.selectAllSysDicDataList(basicsql+wheresql+" and unit_uid=\'"+SystemSession.getUserSession().getUnit_uid()+"\' ORDER BY order_id");
	}
	/**
	 * 部门字典List 不包含禁用
	 * @return
	 */
	public List<SysDicData> selectDepartsDicNoEableList(String wheresql){
		String basicsql="SELECT depart_uid as id,unit_uid,pdepart_id as pid,depart_name as name,leve1_user_id,leve2_user_id,leve3_user_id,depart_fullcode as fullCode,isRoot FROM sys_departs where 1=1 ";
		return sysDicDataMapper.selectAllSysDicDataList(basicsql+wheresql+" and unit_uid=\'"+SystemSession.getUserSession().getUnit_uid()+"\'  and isEable IS FALSE ORDER BY order_id");
	}
	/**
	 * 部门字典List 包含禁用
	 * @return
	 */
	public Map<String,String> selectDepartsDicMap(String wheresql){
		return Tool.parseSStrDict(selectDepartsDicList(wheresql), "id", "name");
	}
	/**
	 * 部门字典List 不包含禁用
	 * @return
	 */
	public Map<String,String> selectDepartsDicNoEableMap(String wheresql){
		return Tool.parseSStrDict(selectDepartsDicNoEableList(wheresql), "id", "name");
	}
	//=======================================部门字典  end==================================
	
	
	//=======================================用户字典  begin==================================
	/**
	 * 用户字典List 包含禁用
	 * @return
	 */
	public List<SysDicData> selectUsersDicList(String wheresql){
		String basicsql="SELECT user_uid as id,unit_uid,user_id,user_name as name FROM sys_users where 1=1 ";
		return sysDicDataMapper.selectAllSysDicDataList(basicsql+wheresql+" and unit_uid=\'"+SystemSession.getUserSession().getUnit_uid()+"\' ORDER BY order_id");
	}
	/**
	 * 用户字典List 不包含禁用
	 * @return
	 */
	public List<SysDicData> selectUsersDicNoEableList(String wheresql){
		String basicsql="SELECT user_uid as id,unit_uid,user_id,user_name as name FROM sys_users where 1=1 ";
		return sysDicDataMapper.selectAllSysDicDataList(basicsql+wheresql+" and unit_uid=\'"+SystemSession.getUserSession().getUnit_uid()+"\'  and isEable IS FALSE ORDER BY order_id");
	}
	/**
	 * 用户字典List 包含禁用
	 * @return
	 */
	public Map<String,String> selectUsersDicMap(String wheresql){
		return Tool.parseSStrDict(selectUsersDicList(wheresql), "id", "name");
	}
	/**
	 * 用户字典List 不包含禁用
	 * @return
	 */
	public Map<String,String> selectUsersDicNoEableMap(String wheresql){
		return Tool.parseSStrDict(selectUsersDicNoEableList(wheresql), "id", "name");
	}
	//=======================================用户字典  end==================================
	
	//=======================================部门树  begin==================================
	/**
	 * 用户字典List 不包含禁用
	 * @return
	 */
	public List<Map<String, Object>> selectAllDepartsTree (String wheresql){
		List<Map<String, Object>> mapList = new ArrayList<Map<String,Object>>();
		List<SysDicData> departsList = selectDepartsDicNoEableList("");
	    for (int i = 0; i < departsList.size(); i++) {
	    	Map<String,Object> map =new HashMap<String,Object>();
	    	SysDicData thisDeparts = departsList.get(i);
			map =new HashMap<String,Object>();
			map.put("id", thisDeparts.getId());
			map.put("pId", thisDeparts.getPid());
			map.put("name", thisDeparts.getName());
			mapList.add(map);
		}
	    return mapList;
	}
	//=======================================部门树  end==================================

	//=======================================用户部门树  begin==================================
	
	
	/**
	 * 用户字典List 不包含禁用
	 * @return
	 */
	public List<Map<String, Object>> selectDepartsUserTree (String wheresql){
		List<Map<String, Object>> mapList = new ArrayList<Map<String,Object>>();
		List<SysDicData> departsList = selectDepartsDicNoEableList("");
	    for (int i = 0; i < departsList.size(); i++) {
	    	Map<String,Object> map =new HashMap<String,Object>();
	    	SysDicData thisDeparts = departsList.get(i);
	    	thisDeparts.setUnit_uid(SystemSession.getUserSession().getUnit_uid());//获取机构
			map =new HashMap<String,Object>();
			map.put("id", thisDeparts.getId());
			map.put("pId", thisDeparts.getPid());
			map.put("name", thisDeparts.getName());
			map.put("type", "depart");
			mapList.add(map);
			String basicsql ="SELECT A.depart_uid as pid,A.user_uid id,C.user_name as name FROM sys_dep_user A "
					+ " LEFT JOIN sys_users  C  ON  C.user_uid  = A.user_uid "
					+ " LEFT JOIN sys_departs D ON D.depart_uid = A.depart_uid "
					+ " where    C.isEable = false AND A.depart_uid =\'"+thisDeparts.getId()+"\' AND A.is_otherdep=0  AND A.unit_uid = \'"+thisDeparts.getUnit_uid()+"\' ";
			List<SysDicData> departOfUser = sysDicDataMapper.selectAllSysDicDataList(basicsql+wheresql+" ORDER BY C.order_id");
			for (SysDicData departsUser : departOfUser) {
				map =new HashMap<String,Object>();
				map.put("id", departsUser.getId());
				map.put("pId", departsUser.getPid());
				map.put("name", departsUser.getName());
				map.put("type", "user");
				mapList.add(map);
			}
		}
	    return mapList;
	}
	/**
	 * 用户字典List 授权共享用
	 * @return
	 */
	public List<Map<String, Object>> selectDepartsUserTreeTwo (String wheresql){
		List<Map<String, Object>> mapList = new ArrayList<Map<String,Object>>();
		List<SysDicData> departsList = selectDepartsDicNoEableList("");
		for (int i = 0; i < departsList.size(); i++) {
			Map<String,Object> map =new HashMap<String,Object>();
			SysDicData thisDeparts = departsList.get(i);
			thisDeparts.setUnit_uid(SystemSession.getUserSession().getUnit_uid());//获取机构
			map =new HashMap<String,Object>();
			map.put("id", thisDeparts.getId());
			map.put("pId", thisDeparts.getPid());
			map.put("name", thisDeparts.getName());
			map.put("type", "depart");
			mapList.add(map);
			String basicsql ="SELECT A.depart_uid as pid,A.user_uid id,C.user_name as name FROM sys_dep_user A "
					+ " LEFT JOIN sys_users  C  ON  C.user_uid  = A.user_uid "
					+ " LEFT JOIN sys_departs D ON D.depart_uid = A.depart_uid "
					+ " where    C.isEable = false AND A.depart_uid =\'"+thisDeparts.getId()+"\' AND A.is_otherdep=0  AND A.unit_uid = \'"+thisDeparts.getUnit_uid()+"\' ";
			List<SysDicData> departOfUser = sysDicDataMapper.selectAllSysDicDataList(basicsql+wheresql+" ORDER BY C.order_id");
			for (SysDicData departsUser : departOfUser) {
				map =new HashMap<String,Object>();
				map.put("id", departsUser.getId());
				map.put("pId", departsUser.getPid());
				map.put("name", departsUser.getName());
				map.put("type", "user");
				mapList.add(map);
			}
		}
		return mapList;
	}
	//=======================================用户部门树  end==================================

	//=======================================菜单模块  begin==================================
	/**
	 * 查询左侧菜单列表
	 * @return
	 */
	public List<SysDicData> selectCommonModulesList(String wheresql) {
		
		String unit_uid = SystemSession.getUserSession().getUnit_uid();
		if(unit_uid!=null && !unit_uid.equals("") && !unit_uid.equals("cbeb758e3d824626a31aabb2a9587b0a")){
			wheresql=wheresql+" and mod_name !=\'机构设置\'";
		}
		
		if(SystemSession.getUserSession().getIsAdmin()!=null && SystemSession.getUserSession().getIsAdmin()==1){
			String basicSql="SELECT mod_uid as id,pmod_id as pid,mod_name as name,url,icon,mod_type,isReload FROM sys_modules where 1=1 "+wheresql+"  ORDER BY order_id";
			return sysDicDataMapper.selectAllSysDicDataList(basicSql);
		}else{
			String basicSql="SELECT DISTINCT a.mod_uid as id,a.pmod_id as pid,a.mod_name as name,a.url,a.icon,a.mod_type,a.isReload "
					+ "FROM sys_modules a "
					+ "left join sys_roles_module b on a.mod_uid=b.mod_uid "
					+ "left join sys_roles c on c.role_uid=b.role_uid "
					+ "left join sys_roles_user d on d.role_uid=c.role_uid "
					+ "where  d.user_uid=\'"+SystemSession.getUserSession().getUser_uid()+"\' "
					+ ""+wheresql+"  ORDER BY a.order_id";
			return sysDicDataMapper.selectAllSysDicDataList(basicSql);
		}
	}
	//=======================================菜单模块  end==================================
	/**
	 * 岗位Lit
	 * @return
	 */
	public List<SysDicData> selectPostDicList(String wheresql) {
		String basicSql="SELECT post_ID as id,parentPostID as pid,postName as name FROM sys_post where unit_uid=\'"+SystemSession.getUserSession().getUnit_uid()+"\' "+wheresql+"  ORDER BY order_id";
		return sysDicDataMapper.selectAllSysDicDataList(basicSql);
	}
	/**
	 * 项目组Lit
	 * @return
	 */
	public List<SysDicData> selectUserGroupDicList(String wheresql) {
		String basicSql="SELECT userGroup_uuid as id,userGroupName as name FROM sys_usergroup where unit_uid=\'"+SystemSession.getUserSession().getUnit_uid()+"\' "+wheresql+"  ORDER BY order_id";
		return sysDicDataMapper.selectAllSysDicDataList(basicSql);
	}
	/**
	 * 菜单List
	 * @return
	 */
	public List<SysDicData> selectModulesDicList(String wheresql) {
		String basicSql="SELECT mod_uid as id,pmod_id as pid,mod_name as name FROM sys_modules where 1=1 "+wheresql+"  ORDER BY order_id";
		return sysDicDataMapper.selectAllSysDicDataList(basicSql);
	}
	/**
	 * 查询功能权限List
	 * @return
	 */
	public List<SysDicData> selectFunctionsDicList(String wheresql) {
		String basicSql="SELECT fun_id as id,fun_type as fun_type,fun_name as name FROM sys_functions where 1=1 "+wheresql+"  ORDER BY order_id";
		return sysDicDataMapper.selectAllSysDicDataList(basicSql);
	}
	/**
	 * 查询功能权限List
	 * @return
	 */
	public List<SysDicData> selectFunctionsTypeDicList(String wheresql) {
		String basicSql="SELECT fun_type as fun_type FROM sys_functions where 1=1 "+wheresql+" GROUP BY fun_type ORDER BY order_id";
		return sysDicDataMapper.selectAllSysDicDataList(basicSql);
	}









	//=======================================角色字典  begin==================================
	/**
	 * 角色字典List
	 * @return
	 */
	public List<SysDicData> selectRoleDicList(String wheresql){
		String basicsql="SELECT role_uid as id,unit_uid,role_name as name FROM sys_roles where 1=1 ";
		return sysDicDataMapper.selectAllSysDicDataList(basicsql+wheresql+" and unit_uid=\'"+SystemSession.getUserSession().getUnit_uid()+"\' ORDER BY order_id");
	}
	/**
	 * 角色字典Map
	 * @return
	 */
	public Map<String,String> selectRoleDicMap(String wheresql){
		return Tool.parseSStrDict(selectRoleDicList(wheresql), "id", "name");
	}
	/**
	 * 角色下用户字典List
	 * @return
	 */
	public List<SysDicData> selectRoleUserDicList(String wheresql,String roleID){
		String basicsql="SELECT a.user_uid as id,a.unit_uid,a.user_id,a.user_name as name FROM sys_users a "+
			"left join sys_roles_user b on b.user_uid=a.user_uid and a.unit_uid=b.unit_uid "+
			"left join sys_roles c on c.role_uid=b.role_uid and c.unit_uid=b.unit_uid where 1=1 ";
		return sysDicDataMapper.selectAllSysDicDataList(basicsql+wheresql+" and c.role_uid=\'"+roleID+"\' and a.unit_uid=\'"+SystemSession.getUserSession().getUnit_uid()+"\'   and a.isEable IS FALSE  ORDER BY a.order_id");
	}
	
	/**
	 * 角色下用户字典Map
	 * @return
	 */
	public Map<String,String> selectRoleUserDicMap(String wheresql,String roleID){
		return Tool.parseSStrDict(selectRoleUserDicList(wheresql,roleID), "id", "name");
	}
	//=======================================角色字典  end==================================



}
