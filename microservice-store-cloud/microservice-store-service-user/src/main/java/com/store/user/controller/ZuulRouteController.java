package com.store.user.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.store.constants.CommonConstants;
import com.store.model.SysZuulRoute;
import com.store.user.service.ISysZuulRouteService;
import com.store.utils.Query;
import com.store.utils.R;
import com.store.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;

/**
 * <p>
 * 动态路由配置表 前端控制器
 * </p>
 *
 * @author lengleng
 * @since 2018-05-15
 */
@RestController
@RequestMapping("/route")
public class ZuulRouteController extends BaseController {

    @Autowired
    private ISysZuulRouteService sysZuulRouteService;
    /**
     * 通过ID查询
     *
     * @param id ID
     * @return SysZuulRoute
     */
    @GetMapping("/{id}")
    public SysZuulRoute get(@PathVariable Integer id) {
        return sysZuulRouteService.selectById(id);
    }

    /**
     * 分页查询信息
     *
     * @param params 分页对象
     * @return 分页对象
     */
    @RequestMapping("/page")
    public Page page(@RequestParam Map<String, Object> params) {
        params.put(CommonConstants.DEL_FLAG, CommonConstants.STATUS_NORMAL);
        return sysZuulRouteService.selectPage(new Query<>(params), new EntityWrapper<>());
    }

    /**
     * 添加
     *
     * @param sysZuulRoute 实体
     * @return success/false
     */
    @PostMapping
    public R<Boolean> add(@RequestBody SysZuulRoute sysZuulRoute) {
        return new R<>(sysZuulRouteService.insert(sysZuulRoute));
    }

    /**
     * 删除
     *
     * @param id ID
     * @return success/false
     */
    @DeleteMapping("/{id}")
    public R<Boolean> delete(@PathVariable Integer id) {
        SysZuulRoute sysZuulRoute = new SysZuulRoute();
        sysZuulRoute.setId(id);
        sysZuulRoute.setUpdateTime(new Date());
        sysZuulRoute.setDelFlag(CommonConstants.STATUS_DEL);
        return new R<>(sysZuulRouteService.updateById(sysZuulRoute));
    }

    /**
     * 编辑
     *
     * @param sysZuulRoute 实体
     * @return success/false
     */
    @PutMapping
    public R<Boolean> edit(@RequestBody SysZuulRoute sysZuulRoute) {
        sysZuulRoute.setUpdateTime(new Date());
        return new R<>(sysZuulRouteService.updateById(sysZuulRoute));
    }

    /**
     * 刷新配置
     *
     * @return success/fasle
     */
    @GetMapping("/apply")
    public R<Boolean> apply() {
        return new R<>(sysZuulRouteService.applyZuulRoute());
    }
}
