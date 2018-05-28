package cn.edu.hyit.seppms.realm;

import cn.edu.hyit.seppms.dao.impl.UserDaoImpl;
import cn.edu.hyit.seppms.domain.User;
import cn.edu.hyit.seppms.service.RoleService;
import cn.edu.hyit.seppms.service.UserService;
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

import javax.annotation.Resource;
import java.util.*;

public class CustomRealm extends AuthorizingRealm {

    @Resource(name = "userService")
    private UserService us;

    @Resource(name = "roleService")
    private RoleService rs;
    /**
     * 用来做授权
     * @param principalCollection
     * @return
     */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String number = (String) principalCollection.getPrimaryPrincipal();
        // 从数据库或者缓存中获取角色数据
        // TODO
        Set<String> roles = getRolesByNumber(number);
        Set<String> permissions = getPermissionsByUserName(number);

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

    private Set<String> getRolesByNumber(String number) {

        // TODO
        List<String> list = rs.getRolesByNumber(number);
        Set<String> sets = new HashSet<String>(list);
        return sets;
    }

    /**
     * 用来做认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // 1.从主体传过来的认证信息中，获得用户名
        String number = (String) authenticationToken.getPrincipal();

        // 2.通过用户名到数据库中获取凭证
        String password = getPasswordByNumber(number);
        if (password == null){
            return null;
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(number, password, "customRealm");
        // 使用salt加密时要讲salt设置进authenticationInfo
        authenticationInfo.setCredentialsSalt(ByteSource.Util.bytes(number));
        return authenticationInfo;
    }

    /**
     * 数据库查询凭证
     * @param number
     * @return
     */
    private String getPasswordByNumber(String number) {
        User user = us.getUserByNumber(number);
        if (user != null){
            return user.getPassword();
        }
        return null;
    }

    public static void main(String[] args) {
        // 普通md5加密
//        Md5Hash md5Hash = new Md5Hash("123");
        // md5盐加密
        Md5Hash md5Hash = new Md5Hash("123", "1151401108");//a81082604404c078e80f8bf501133abe
        System.out.println(md5Hash.toString());

    }
}
