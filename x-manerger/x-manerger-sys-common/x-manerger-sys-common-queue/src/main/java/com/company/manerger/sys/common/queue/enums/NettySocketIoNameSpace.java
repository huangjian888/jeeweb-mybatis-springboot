package com.company.manerger.sys.common.queue.enums;

public enum NettySocketIoNameSpace {
    NAMESPACE_QUEUE("NameSpaceQueue");

    private String value;
    private NettySocketIoNameSpace(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
    @Override
    public String toString() {
        return value;
    }
}
