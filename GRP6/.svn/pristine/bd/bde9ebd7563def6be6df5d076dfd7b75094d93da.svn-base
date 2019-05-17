/*
 * Copyright (c) 2002-2003 by OpenSymphony
 * All rights reserved.
 */
package com.opensymphony.workflow.spi.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;


/**
 * @author Christopher Farnham
 * Created on Feb 27, 2004
 */
public class MySQLWorkflowStore extends JDBCWorkflowStore {
    //~ Instance fields ////////////////////////////////////////////////////////

    protected String entrySequenceIncrement = null;
    protected String entrySequenceRetrieve = null;
    protected String stepSequenceIncrement = null;
    protected String stepSequenceRetrieve = null;
    

    //~ Methods ////////////////////////////////////////////////////////////////
    
    /*zhongzk注释掉2012.04.07
    public void init(Map props) throws StoreException {
        super.init(props);
        stepSequenceIncrement = (String) props.get("step.sequence.increment");
        stepSequenceRetrieve = (String) props.get("step.sequence.retrieve");
        entrySequenceIncrement = (String) props.get("entry.sequence.increment");
        entrySequenceRetrieve = (String) props.get("entry.sequence.retrieve");
    }
    */

    protected long getNextEntrySequence(Connection c) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rset = null;

        try {
            stmt = c.prepareStatement(entrySequenceIncrement);
            stmt.executeUpdate();
            rset = stmt.executeQuery(entrySequenceRetrieve);

            rset.next();

            long id = rset.getLong(1);

            return id;
        } finally {
            cleanup(null, stmt, rset);
        }
    }

    protected long getNextStepSequence(Connection c) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rset = null;

        try {
            stmt = c.prepareStatement(stepSequenceIncrement);
            stmt.executeUpdate();
            rset = stmt.executeQuery(stepSequenceRetrieve);

            rset.next();

            long id = rset.getLong(1);

            return id;
        } finally {
            cleanup(null, stmt, rset);
        }
    }
    
    
    
    
    //*******************************begin以下内容为zhongzk添加2012.04.07
  //持久化工作流的参数

	  protected Properties jdbcTemplateProperties;

	  public Properties getJdbcTemplateProperties() {

	    return this.jdbcTemplateProperties;

	  }

	  public void setJdbcTemplateProperties(Properties jdbcTemplateProperties) {

	      this.jdbcTemplateProperties = jdbcTemplateProperties;

	  }

	  public void setDataSource(DataSource ds) {

	     this.ds = ds;

	  }

	  public void init()

	  {        
	   
	    entrySequence=jdbcTemplateProperties.getProperty("entry.sequence");

	    stepSequence=jdbcTemplateProperties.getProperty("step.sequence");
	    
	  

	    

	    entryTable=jdbcTemplateProperties.getProperty("entry.table", "OS_WFENTRY");

	    entryId=jdbcTemplateProperties.getProperty("entry.id", "ID");

	    entryName=jdbcTemplateProperties.getProperty("entry.name", "NAME");

	    entryState=jdbcTemplateProperties.getProperty("entry.state", "STATE");

	    historyTable=jdbcTemplateProperties.getProperty("history.table", "OS_HISTORYSTEP");

	    currentTable=jdbcTemplateProperties.getProperty("current.table", "OS_CURRENTSTEP");      

	     currentPrevTable=jdbcTemplateProperties.getProperty("currentPrev.table", "OS_CURRENTSTEP_PREV");

	    historyPrevTable=jdbcTemplateProperties.getProperty("historyPrev.table", "OS_HISTORYSTEP_PREV");

	    stepId=jdbcTemplateProperties.getProperty("step.id", "ID");

	    stepEntryId=jdbcTemplateProperties.getProperty("step.entryId", "ENTRY_ID");

	    stepStepId=jdbcTemplateProperties.getProperty("step.stepId", "STEP_ID");

	    stepActionId=jdbcTemplateProperties.getProperty("step.actionId", "ACTION_ID");

	    stepOwner=jdbcTemplateProperties.getProperty("step.owner", "OWNER");

	    stepCaller=jdbcTemplateProperties.getProperty("step.caller", "CALLER");

	    stepStartDate=jdbcTemplateProperties.getProperty("step.startDate", "START_DATE");

	    stepFinishDate=jdbcTemplateProperties.getProperty("step.finishDate", "FINISH_DATE");

	    stepDueDate=jdbcTemplateProperties.getProperty("step.dueDate", "DUE_DATE");

	    stepStatus=jdbcTemplateProperties.getProperty("step.status", "STATUS");

	    stepPreviousId=jdbcTemplateProperties.getProperty("step.previousId", "PREVIOUS_ID");
	    
	    //zhongzk 2012.04.22增加
	    stepStepName=jdbcTemplateProperties.getProperty("step.stepName", "stepName");
	    
	    //zhongzk
	    stepSequenceIncrement = (String) jdbcTemplateProperties.get("step.sequence.increment");
        stepSequenceRetrieve = (String) jdbcTemplateProperties.get("step.sequence.retrieve");
        entrySequenceIncrement = (String) jdbcTemplateProperties.get("entry.sequence.increment");
        entrySequenceRetrieve = (String) jdbcTemplateProperties.get("entry.sequence.retrieve");
        

	  }
    
    
    //*******************************end
	  
	//*******************************begin 一下内容由zhongzh添加，用以处理owner
	  
	  public boolean existUser(String userGID) {
		  try {
			  return existCommon("sys_user","UserGID",userGID);
		  } catch (Exception e) {
			  e.printStackTrace();
		  }
		  return false;
	  }
	  
	  public boolean existGroup(String groupID) {
		  try {
			 // return existCommon("sys_usergroups","groupID",groupID);修改前
			  
			  //zhongzk修改后
			  if (groupID.length()>5){
				  groupID=groupID.substring(5,groupID.length()-1); //去掉前面的4位，即role
				  System.out.println("groupID:"+groupID);
			      return existCommonNew("sys_usergroups","UserGroupsID",groupID);
			  }//end if
		  } catch (Exception e) {
			  e.printStackTrace();
		  }
		  return false;
	  }
	  
	  public boolean existRole(String roleCode) {
		  try {
			  //return existCommon("c_projrole","RoleCode",roleCode); //修改前
			  
			  //zhongzk作了修改后			
			  if (roleCode.length()>4){				  
				  roleCode=roleCode.substring(4,roleCode.length()); //去掉前面的4位，即role			  
				
				return existCommonNew("sys_role","RoleID",roleCode); //修改前	  
			  }//end if	  
			  } catch (Exception e) {
			  e.printStackTrace();
		  }
		  return false;
	  }
	  
	  public String roleUsers(String roleCode) {
		  Connection conn = null;
		  Statement stmt = null;
		  ResultSet rset = null;
		  
		  try {
	            conn = getConnection();

	            //String sql = "SELECT Users FROM c_projrole WHERE RoleCode = '"+roleCode+"'";修改前	            
	            
	            //zhongzk修改后：	            
	            
	            if (roleCode.length()>4){				  
					  roleCode=roleCode.substring(4,roleCode.length()); //去掉前面的4位，即role
	            }		  
	            String sql = "SELECT UserGID FROM sys_role_user WHERE RoleID = "+roleCode;;
	            
	            stmt = conn.createStatement();
	            rset = stmt.executeQuery(sql);
	            if(rset.next()) {
	            	String users = rset.getString(1);
	            	return users;
	            }
	            
		  } catch (SQLException e){
			  e.printStackTrace();
		  } finally {
	            cleanup(conn, stmt, rset);
	      }
		  return null;
	  }
	 
	 
	  public boolean existCommon(String tableName,String fieldName,String id) {
	        Connection conn = null;
	        Statement stmt = null;
	        ResultSet rset = null;
	        try {
	            conn = getConnection();

	            String sql = "SELECT * FROM "+tableName+" WHERE "+fieldName+" = '"+id+"'";
	            stmt = conn.createStatement();
	            rset = stmt.executeQuery(sql);
	            return rset.next();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            cleanup(conn, stmt, rset);
	        }
	        return false;
	  }
	  
	//zhongzk增加，主要是为了支持数字字段
	  public boolean existCommonNew(String tableName,String fieldName,String id) {
	        Connection conn = null;
	        Statement stmt = null;
	        ResultSet rset = null;
	        try {
	            conn = getConnection();
	            
	            String sql = "SELECT * FROM "+tableName+" WHERE "+fieldName+" = "+id ;  //zhongzk修改让其支持整型
	          
	            stmt = conn.createStatement();
	            rset = stmt.executeQuery(sql);
	            return rset.next();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            cleanup(conn, stmt, rset);
	        }
	        return false;
	  }
	  
	  //判断某角色是否有多个用户zhongzk
	  public boolean existManyUser(String roleid){
		   Connection conn = null;
	        Statement stmt = null;
	        ResultSet rset = null;
	        try {
	            conn = getConnection();
	            
	            
	            if (roleid.length()>4){				  
	            	roleid=roleid.substring(4,roleid.length()); //去掉前面的4位，即role
	            }	
	            String sql = "SELECT count(*) as recnum FROM sys_role_user where RoleID="+roleid;	            
	          
	            stmt = conn.createStatement();
	            rset = stmt.executeQuery(sql);
	            rset.next();
	            int reccount=0;
	            reccount=rset.getInt(1);
	            
	            if (reccount>1){	  	               
	               return true;
	            }else{
	               return false;}
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            cleanup(conn, stmt, rset);
	        }
	        return false;
	  }
	  
	  //取得流程实例中某角色当有多人时，需要人工选择，选择后存在此表中
	  public String getUserid(String roleid,long flowid){		  
		  Connection conn = null;
	        Statement stmt = null;
	        ResultSet rset = null;
	        try {
	            conn = getConnection();	            
	           
	            String sql = "SELECT userid  FROM os_gwork_flowroleuser where (roleid='"+roleid+"')"+" and (flowid='"+flowid+"')";	
	            
	            stmt = conn.createStatement();
	            rset = stmt.executeQuery(sql);
	            String userid="";
	            if(rset.next()) {	            
	                userid=rset.getString(1);
	            }	            
	            return userid;
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            cleanup(conn, stmt, rset);
	        }
	        return "";
	  }
	  
	  
	//取得流程的项目号
	  public String getProjectID(long  flowid){
		    Connection conn = null;
	        Statement stmt = null;
	        ResultSet rset = null;
	        try {
	            conn = getConnection();	            
	           
	            String sql = "SELECT  projectID FROM os_gworkflow_projidflowid where ENTRY_ID='"+flowid+"'";	
	           // System.out.println("sql:"+sql);
	            
	            stmt = conn.createStatement();
	            rset = stmt.executeQuery(sql);
	            String sprojectid="";
	            if(rset.next()) {	            
	            	sprojectid=rset.getString(1);
	            }	            
	            return sprojectid;
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            cleanup(conn, stmt, rset);
	        }
	        return "";
	  }
	  
	  
	  //取得项目的申请金额
	  public double getApplysum(String projectid){
		    Connection conn = null;
	        Statement stmt = null;
	        ResultSet rset = null;
	        try {
	            conn = getConnection();	            
	           
	            String sql = "SELECT  ApplySum FROM op_projects where ProjectID='"+projectid+"'";	
	           // System.out.println("sql:"+sql);
	            
	            stmt = conn.createStatement();
	            rset = stmt.executeQuery(sql);
	            double applysum=0;
	            if(rset.next()) {	            
	            	applysum=rset.getDouble(1);
	            }	            
	            return applysum;
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            cleanup(conn, stmt, rset);
	        }
	        return -1;
	  }
	  
	  //修改客户经理
	  public boolean updateUser(String projectid,String usergid){
		    Connection conn = null;
	        Statement stmt = null;
	        ResultSet rset = null;
	        try {
	            conn = getConnection();	            
	            String sql ="UPDATE op_projects SET UserGID='"+usergid+
	                        "',DepartmentGID=(SELECT DepartmentGID FROM sys_department_user WHERE UserGID='"+usergid+
	                        "') WHERE ProjectID='"+projectid+"' ";
	            stmt = conn.createStatement();
	            int id=stmt.executeUpdate(sql);
	            return true;
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            cleanup(conn, stmt, rset);
	        }
	        return false;
	  }
	  
	  //获取项目对应的客户编号  ADD GXL
	  public String getClientsID(String projectid){
		    Connection conn = null;
	        Statement stmt = null;
	        ResultSet rset = null;
	        try {
	            conn = getConnection();	            
	           
	            String sql = "SELECT  PClientID FROM op_clients WHERE ProjectID='"+projectid+"'";	
	            //System.out.println("sql:"+sql);
	            
	            stmt = conn.createStatement();
	            rset = stmt.executeQuery(sql);
	            String sprojectid="";
	            if(rset.next()) {	            
	            	sprojectid=rset.getString(1);
	            }	            
	            return sprojectid;
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            cleanup(conn, stmt, rset);
	        }
	        return "";
	  }
	  
	  
	  //取得项目的申请金额
	  public double getloadsum(String clientid,String projectid){
		    Connection conn = null;
	        Statement stmt = null;
	        ResultSet rset = null;
	        try {
	            conn = getConnection();	            
	           
	            String sql = "SELECT (ROUND(IFNULL(M.loadsum,0),4)-ROUND(IFNULL(N.freesum,0),4)) as loadsum "
	            	        +"FROM (SELECT SUM(ROUND(A.LoadSum,4))AS loadsum,B.PClientID FROM op_factloaddetail A "
                            +"LEFT JOIN op_clients B ON A.ProjectID=B.ProjectID "
                            +"LEFT JOIN op_projects E ON E.ProjectID=A.ProjectID "
                         //判断否决项目除外   
                            +"WHERE A.ProjectID<>'"+projectid+"' AND E.bStatues<>'03' GROUP BY B.PClientID) M "
                            +"LEFT JOIN (SELECT SUM(ROUND(C.FreeGuarSum,4))AS freesum, D.PClientID FROM op_freeguardetail C "
                            +"LEFT JOIN op_clients D ON C.ProjectID=D.ProjectID GROUP BY D.PClientID) N ON N.PClientID=M.PClientID "
                            +"WHERE M.PClientID='"+clientid+"'";	
	            //System.out.println("sql:"+sql);
	            
	            stmt = conn.createStatement();
	            rset = stmt.executeQuery(sql);
	            double loadsum=0;
	            if(rset.next()) {	            
	            	loadsum=rset.getDouble(1);
	            }	            
	            return loadsum;
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            cleanup(conn, stmt, rset);
	        }
	        return -1;
	  }
	  
	  //取得角色所有的用户 zhongzk 2013.1.1用于取评委
	  public String getroleAllUsers(String roleCode) {
		  Connection conn = null;
		  Statement stmt = null;
		  ResultSet rset = null;
		  
		  try {
	            conn = getConnection();
	            
	            if (roleCode.length()>4){				  
					  roleCode=roleCode.substring(4,roleCode.length()); //去掉前面的4位，即role
	            }		  
	            String sql = "SELECT UserGID FROM sys_role_user WHERE RoleID = "+roleCode;;
	            
	            stmt = conn.createStatement();
	            rset = stmt.executeQuery(sql);	    
	            String users ="";
	            while(rset.next()) {
	            	users =users+rset.getString(1)+",";
	            	
	             }
	            //去掉后面的逗号
	            if (users.length()>0)
	            	users=users.substring(0,users.length()-1);
	            return users;
	            
		  } catch (SQLException e){
			  e.printStackTrace();
		  } finally {
	            cleanup(conn, stmt, rset);
	      }
		  return null;
	  }
	
	  //删除某一个流程实例的角色与用户对应的临时表，即os_gwork_flowroleuser
	  public void delflowroleuser(long flowid){
		    Connection conn = null;
	        Statement stmt = null;
	        ResultSet rset = null;
	        try {
	            conn = getConnection();

	            String sql = "delete FROM os_gwork_flowroleuser WHERE flowid='"+flowid+"'";
	            stmt = conn.createStatement();
	            stmt.execute(sql);
	           
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            cleanup(conn, stmt, rset);
	        }
	       
	  }
	  
	  
	  //修改项目经理 B角
	  public boolean updateProjHeaderB(String projectid,String usergid){
		    Connection conn = null;
	        Statement stmt = null;
	        ResultSet rset = null;
	        try {
	            conn = getConnection();	            
	            String sql ="UPDATE op_projects SET ProjHeaderB='"+usergid+
	                        "' WHERE ProjectID='"+projectid+"' ";
	            stmt = conn.createStatement();
	            int id=stmt.executeUpdate(sql);
	            return true;
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            cleanup(conn, stmt, rset);
	        }
	        return false;
	  }
	//修改项目经理 C角
	  public boolean updateProjHeaderC(String projectid,String usergid){
		    Connection conn = null;
	        Statement stmt = null;
	        ResultSet rset = null;
	        try {
	            conn = getConnection();	            
	            String sql ="UPDATE op_projects SET ProjHeaderC='"+usergid+
	                        "' WHERE ProjectID='"+projectid+"' ";
	            stmt = conn.createStatement();
	            int id=stmt.executeUpdate(sql);
	            return true;
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            cleanup(conn, stmt, rset);
	        }
	        return false;
	  }
	  
	//获取项目对应的客户编号  ADD GXL
	  public String getFlowRoleUser(long flowid,String roleid){
		    Connection conn = null;
	        Statement stmt = null;
	        ResultSet rset = null;
	        try {
	            conn = getConnection();	            
	           
	            String sql = "SELECT userid FROM os_gwork_flowroleuser"+
	                         " WHERE flowid='"+flowid+"' AND roleid='"+roleid+"'";	
	            //System.out.println("sql:"+sql);
	            
	            stmt = conn.createStatement();
	            rset = stmt.executeQuery(sql);
	            String sprojectid="";
	            if(rset.next()) {	            
	            	sprojectid=rset.getString(1);
	            }	            
	            return sprojectid;
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            cleanup(conn, stmt, rset);
	        }
	        return "";
	  }
	  
	  //获取部门主管
	  public String getDepartmentManager(String usergid){
		    Connection conn = null;
	        Statement stmt = null;
	        ResultSet rset = null;
	        try {
	            conn = getConnection();	            
	           
	            String sql = "SELECT B.Director FROM sys_department_user A "+
	                         " LEFT JOIN sys_department B ON A.DepartmentGID=B.DepartmentGID "+
	                         " WHERE A.UserGID='"+usergid+"'";	
	            //System.out.println("sql:"+sql);
	            
	            stmt = conn.createStatement();
	            rset = stmt.executeQuery(sql);
	            String depuserid="";
	            if(rset.next()) {	            
	            	depuserid=rset.getString(1);
	            }	            
	            return depuserid;
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            cleanup(conn, stmt, rset);
	        }
	        return "";
	  }
}
