package com.store.vo;

import com.store.model.SysLog;
import lombok.Data;

import java.io.Serializable;

/**
 * @author lengleng
 * @date 2017/11/20
 */
@Data
public class LogVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private SysLog sysLog;
    private String username;
}
