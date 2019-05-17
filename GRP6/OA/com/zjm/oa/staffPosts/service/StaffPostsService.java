package com.zjm.oa.staffPosts.service;

import java.util.List;
import com.zjm.oa.db.model.Hr_staffPosts;
import com.zjm.sys.db.model.Sys_roles;

public interface StaffPostsService {
	/* 查询列表    */	
	List<Hr_staffPosts> selectTransferListByCase_ID(String staffCase_ID);
	
	/*根据岗位ID查询*/
	public Hr_staffPosts selectOneByPostId(String postsID);
	
	/*增加*/
	public Boolean insertOnePostsInfo(Hr_staffPosts hrstaffPosts);
	
	/*修改*/
	public  Boolean  updateOnePostsInfo(Hr_staffPosts hrstaffPosts);

}
