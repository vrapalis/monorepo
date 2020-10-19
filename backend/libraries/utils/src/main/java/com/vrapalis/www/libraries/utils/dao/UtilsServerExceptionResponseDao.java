package com.vrapalis.www.libraries.utils.dao;

import lombok.Getter;

@Getter
public class UtilsServerExceptionResponseDao extends UtilsServerResponseDao {
    private final String errorMsg;

    public UtilsServerExceptionResponseDao(String msg, String errorMsg, String path) {
        super(msg, path);
        this.errorMsg = errorMsg;
    }
}
