package cn.edu.hyit.seppms.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CustomRealm extends AuthorizingRealm {

    Map<String, String> userMap = new HashMap<String, String>(16);

    {
        // 不加密
//        userMap.put("Mark", "123");
        // MD5加密
//        userMap.put("Mark", "202cb962ac59075b964b07152d234b70");
        // md5盐加密
        userMap.put("1151401107", "a81082604404c078e80f8bf501133abe");

        // 设置realm的name
        super.setName("customRealm");
    }

    /**
     * 用来做授权
     * @param principalCollection
     * @return
     */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String userName = (String) principalCollection.getPrimaryPrincipal();
        // 从数据库或者缓存中获取角色数据
        Set<String> roles = getRolesByUserName(userName);
        Set<String> permissions = getPermissionsByUserName(userName);

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setRoles(roles);
        simpleAuthorizationInfo.setStringPermissions(permissions);
        return simpleAuthorizationInfo;
    }

    private Set<String> getPermissionsByUserName(String userName) {
        Set<String> permissions = new HashSet<String>();
        permissions.add("user:select");
        permissions.add("user:delete");
        return permissions;
    }

    private Set<String> getRolesByUserName(String userName) {

        Set<String> roles = new HashSet<String>();
        roles.add("admin");
        roles.add("user");
        return roles;
    }

    /**
     * 用来做认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // 1.从主体传过来的认证信息中，获得用户名
        String userName = (String) authenticationToken.getPrincipal();

        // 2.通过用户名到数据库中获取凭证
        String password = getPasswordByUserName(userName);
        if (password == null){
            return null;
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(userName, password, "customRealm");
        // 使用salt加密时要讲salt设置进authenticationInfo
        authenticationInfo.setCredentialsSalt(ByteSource.Util.bytes("1151401107"));
        return authenticationInfo;
    }

    /**
     * 模拟数据库查询凭证
     * @param userName
     * @return
     */
    private String getPasswordByUserName(String userName) {

        return (String) userMap.get(userName);
    }

    public static void main(String[] args) {
        // 普通md5加密
//        Md5Hash md5Hash = new Md5Hash("123");
        // md5盐加密
        Md5Hash md5Hash = new Md5Hash("123", "1151401107");//b38ac18016d255ee4e9a364fb6490ebf
        System.out.println(md5Hash.toString());

    }
}
