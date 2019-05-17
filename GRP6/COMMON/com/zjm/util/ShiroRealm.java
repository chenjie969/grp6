package com.zjm.util;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;

import com.zjm.common.db.model.Const;
import com.zjm.common.db.model.User;
import com.zjm.common.login.service.LoginService;
import com.zjm.sys.departs.service.DepartsService;



/**
 * mashuo add 20170417
 */
public class ShiroRealm extends AuthorizingRealm {

	@Resource
	private LoginService loginService;
	
	@Resource
	private DepartsService departsService;
	
	/*
	 * 登录信息和用户验证信息验证(non-Javadoc)
	 * @see org.apache.shiro.realm.AuthenticatingRealm#doGetAuthenticationInfo(org.apache.shiro.authc.AuthenticationToken)
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		 UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		 AuthenticationInfo authenticationInfo = null;
		 String userid=new String(token.getUsername());//用户名
		 String password=new String(token.getPassword());//密码
		 User login=new User();
		 login.setUser_id(userid);
		 login.setUserpassword(password);
		 User a = loginService.selectOneUserByLoginName(login);//通过登录名 寻找用户
		
	     if (a != null && a.getUser_id().equals(userid)) {
	    	 if(a.getUserpassword().equals(password)){
	    		 if (a.getIsactive()!=null && a.getIsactive()==1) {
		    		 authenticationInfo = new SimpleAuthenticationInfo(a, password, getName());
		    		 a.setIpaddress(Tool.getIpAddr(Tool.getRequest()));
		    		 this.setSession(Const.SESSION_USER, a);
		    		 boolean isHoldingGroupDepart = departsService.isHoldingGroupFlowDEpart( a.getUser_uid());
		    		 this.setSession(Const.SESSION_IS_HOLDING_GROUP, isHoldingGroupDepart);
		    		 return authenticationInfo;
	    		 }else{
	    			 throw new LockedAccountException(); /*当前账号已冻结，禁止登录！*/
	    		 }
	    	 }else{
	    		 throw new IncorrectCredentialsException(); /*密码错误*/
	    	 }    	
	     } else {
	    	 throw new UnknownAccountException(); /*账号错误*/
	     }
	     
	}
	
	/*
	 * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用,负责在应用程序中决定用户的访问控制的方法(non-Javadoc)
	 * @see org.apache.shiro.realm.AuthorizingRealm#doGetAuthorizationInfo(org.apache.shiro.subject.PrincipalCollection)
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection pc) {	
		System.out.println("进入权限认证！");
		  // 因为非正常退出，即没有显式调用 SecurityUtils.getSubject().logout()
        // (可能是关闭浏览器，或超时)，但此时缓存依旧存在(principals)，所以会自己跑到授权方法里。
        if (!SecurityUtils.getSubject().isAuthenticated()) {
            doClearCache(pc);
            SecurityUtils.getSubject().logout();
            return null;
        }
        System.out.println("权限认证！");
        
        
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
       /* List<String> permissionList=new ArrayList<String>();
        permissionList.add("user:useradd");
        permissionList.add("useredit");
        permissionList.add("userdel");
        permissionList.add("userview");
        
        permissionList.add("user/personSet/edit");
        info.addStringPermissions(permissionList);
        System.out.println(info.getStringPermissions());
        System.out.println(JSON.toJSONString(info.getStringPermissions()));
        Set<String> roleList=new HashSet<>();
        roleList.add("admin");
        info.setRoles(roleList);
        */
        
        return info;
	}

	
	@Override
	public String getName() {
		return "shiroRealm";
	}
	
    @Override
    public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
        super.clearCachedAuthorizationInfo(principals);
    }

    @Override
    public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
        super.clearCachedAuthenticationInfo(principals);
    }

    @Override
    public void clearCache(PrincipalCollection principals) {
        super.clearCache(principals);
    }

    public void clearAllCachedAuthorizationInfo() {
        getAuthorizationCache().clear();
    }

    public void clearAllCachedAuthenticationInfo() {
        getAuthenticationCache().clear();
    }

    public void clearAllCache() {
        clearAllCachedAuthenticationInfo();
        clearAllCachedAuthorizationInfo();
    }
   /**
     * 将一些数据放到ShiroSession中,以便于其它地方使用
     */
    private void setSession(Object key, Object value) {
        Subject currentUser = SecurityUtils.getSubject();
        if (null != currentUser) {
            Session session = currentUser.getSession();
            if (null != session) {
                session.setAttribute(key, value);
            }
        }
    }
	
}
