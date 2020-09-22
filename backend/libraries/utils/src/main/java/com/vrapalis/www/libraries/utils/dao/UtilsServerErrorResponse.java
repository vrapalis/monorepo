package com.vrapalis.www.libraries.utils.dao;

import lombok.Getter;

@Getter
public class UtilsServerErrorResponse extends UtilsServerResponse {
    private final String errorMsg;

    public UtilsServerErrorResponse(String msg, String errorMsg, String path) {
        super(msg, path);
        this.errorMsg = errorMsg;
    }
}
