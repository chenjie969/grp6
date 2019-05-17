package com.zjm.sys.db.map;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.sys.db.model.Sys_post;
import com.zjm.sys.db.model.Sys_units;
/**
 * 岗位
 * @author zky add 20170504
 */
public interface Sys_postMapper {
    /**
	 * 查询同级节点下共有多少岗位
	 * @return
	 */
    public Integer selectPostOrderId(Sys_post sys_post);
	/**
	 * 插入一个岗位
	 * @param sys_post
	 * @return
	 */
	public Integer insertOnePostInfo(Sys_post sys_post);
	/**
	 * 查询所有岗位
	 * @param wheresql
	 * @return
	 */
	public List<Sys_post> selectAllPostList(String wheresql);
	/**
	 * 查询岗位列表数据
	 * @param pageTable
	 * @return
	 */
	public List<Sys_post> selectPostPageTables(PageTable pageTable);
	/**
	 * 查询岗位列表行数
	 * @param pageTable
	 * @return
	 */
	public Long selectPostPageTables_Count(PageTable pageTable);
	/**
	 * 查询一个岗位
	 * @param sys_post
	 * @return
	 */
	public Sys_post selectOnePostInfo(Sys_post sys_post);
	/**
	 * 查询一个岗位的父岗位
	 * @param sys_post
	 * @return
	 */
	public Sys_post selectParentPostInfo(Sys_post sys_post);
	/**
	 * 更新一个岗位
	 * @param sys_post
	 * @return
	 */
	public Integer updateOnePostInfo(Sys_post sys_post);
	/**
	 * 删除一个机构
	 * @param sys_post
	 */
	public Integer deleteOnePostInfo(Sys_post sys_post);
	/**
	 * 查看岗位名称是否存在
	 * @param wheresql
	 * @return
	 */
	public Integer selectPostIsExist(String wheresql);
}