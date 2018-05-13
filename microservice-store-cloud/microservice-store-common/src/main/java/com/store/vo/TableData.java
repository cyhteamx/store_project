package com.store.vo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TableData<T> {

    private long total;

    private List<T> rows;

    public TableData() {

    }

    public TableData(long total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }
}
