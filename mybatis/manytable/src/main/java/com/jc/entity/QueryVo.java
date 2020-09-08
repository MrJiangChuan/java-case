package com.jc.entity;

import java.util.List;

public class QueryVo {
    private List<Integer> ids;

    public QueryVo() {
    }

    public QueryVo(List<Integer> ids) {
        this.ids = ids;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    @Override
    public String toString() {
        return "QueryVo{" +
                "ids=" + ids +
                '}';
    }
}
