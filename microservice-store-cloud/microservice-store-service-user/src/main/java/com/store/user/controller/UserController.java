package com.store.user.controller;

import cn.hutool.core.io.FileUtil;
import com.baomidou.mybatisplus.plugins.Page;
import com.store.constants.CommonConstants;
import com.store.model.SysUser;
import com.store.model.SysUserRole;
import com.store.user.dto.UserDTO;
import com.store.user.dto.UserInfo;
import com.store.user.service.ISysUserService;
import com.store.utils.Query;
import com.store.utils.R;
import com.store.vo.UserVO;
import com.store.web.BaseController;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

//@Api(value = "API - UserServiceImpl", description = "内容操作")
@RestController
public class UserController extends BaseController {

    private static final PasswordEncoder ENCODER = new BCryptPasswordEncoder();

//    @Autowired
//    private FastFileStorageClient fastFileStorageClient;

    @Autowired
    private ISysUserService userService;

//    @Autowired
//    private FdfsPropertiesConfig fdfsPropertiesConfig;


    /**
     * 获取当前用户信息（角色、权限）
     * 并且异步初始化用户部门信息
     *
     * @param userVo 当前用户信息
     * @return 用户名
     */
    @GetMapping("/info")
    public R<UserInfo> user(UserVO userVo) {
        String username = getUserName();
        userVo.setUsername(username);
//        UserInfo userInfo = userService.findUserInfo(userVo);
        UserInfo userInfo = userService.findUserInfo(userService.findUserByUsername(username));
        return new R<>(userInfo);
    }

    /**
     * 通过ID查询当前用户信息
     *
     * @param id ID
     * @return 用户信息
     */
    @GetMapping("/{id}")
    public UserVO user(@PathVariable Integer id) {
        return userService.selectUserVoById(id);
    }

    /**
     * 删除用户信息
     *
     * @param id ID
     * @return R
     */
//    @ApiOperation(value = "删除用户", notes = "根据ID删除用户")
//    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer", paramType = "path")
    @DeleteMapping("/{id}")
    public R<Boolean> userDel(@PathVariable Integer id) {
        SysUser sysUser = userService.selectById(id);
        return new R<>(userService.deleteUserById(sysUser));
    }

    /**
     * 添加用户
     *
     * @param userDto 用户信息
     * @return success/false
     */
    @PostMapping("/add")
    public R<Boolean> user(@RequestBody UserDTO userDto) {
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(userDto, sysUser);
        sysUser.setDelFlag(CommonConstants.STATUS_NORMAL);
        sysUser.setPassword(ENCODER.encode(userDto.getPassword()));
        userService.insert(sysUser);
        SysUserRole userRole = new SysUserRole();
        userRole.setUserId(sysUser.getId());
        userRole.setRoleId(userDto.getRole());
        return new R<>(userRole.insert());
    }

    /**
     * 更新用户信息
     *
     * @param userDto 用户信息
     * @return R
     */
    @PutMapping
    public R<Boolean> userUpdate(@RequestBody UserDTO userDto) {
        SysUser user = userService.selectById(userDto.getId());
        return new R<>(userService.updateUser(userDto, user.getUsername()));
    }

    /**
     * 通过用户名查询用户及其角色信息
     *
     * @param username 用户名
     * @return UseVo 对象
     */
    @GetMapping("/findUserByUsername/{username}")
    public UserVO findUserByUsername(@PathVariable String username) {
        return userService.findUserByUsername(username);
    }

    /**
     * 通过手机号查询用户及其角色信息
     *
     * @param mobile 手机号
     * @return UseVo 对象
     */
    @GetMapping("/findUserByMobile/{mobile}")
    public UserVO findUserByMobile(@PathVariable String mobile) {
        return userService.findUserByMobile(mobile);
    }

    /**
     * 通过OpenId查询
     *
     * @param openId openid
     * @return 对象
     */
    @GetMapping("/findUserByOpenId/{openId}")
    public UserVO findUserByOpenId(@PathVariable String openId) {
        return userService.findUserByOpenId(openId);
    }

    /**
     * 分页查询用户
     *
     * @param params 参数集
     * @return 用户集合
     */
    @RequestMapping("/userPage")
    public Page userPage(@RequestParam Map<String, Object> params) {
        return userService.selectWithRolePage(new Query(params));
    }

    /**
     * 上传用户头像
     * (多机部署有问题，建议使用独立的文件服务器)
     *
     * @param file 资源
     * @return filename map
     */
    @PostMapping("/upload")
    public Map<String, String> upload(@RequestParam("file") MultipartFile file) {
        String fileExt = FileUtil.extName(file.getOriginalFilename());
        Map<String, String> resultMap = new HashMap<>(1);
//        try {
//            StorePath storePath = fastFileStorageClient.uploadFile(file.getBytes(), fileExt);
//            resultMap.put("filename", fdfsPropertiesConfig.getFileHost() + storePath.getFullPath());
//        } catch (IOException e) {
//            logger.error("文件上传异常", e);
//            throw new RuntimeException(e);
//        }
        return resultMap;
    }

    /**
     * 修改个人信息
     *
     * @param userDto userDto
     * @param userVo  登录用户信息
     * @return success/false
     */
    @PutMapping("/editInfo")
    public R<Boolean> editInfo(@RequestBody UserDTO userDto, UserVO userVo) {
        return new R<>(userService.updateUserInfo(userDto, userVo.getUsername()));
    }
}
