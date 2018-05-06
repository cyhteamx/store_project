package com.store.auth.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Msg implements Serializable {

    private static final long serialVersionUID = 7514826298158585250L;

    public static final int SUCCESS=200;

    public static final int FAILED=201;

    private Integer code;

    private String msg;

}
