package com.zqx.hospitalmanage.pojo;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

/**
 * @version 1.0
 * @program: hospitalmanage.Page
 * @description: page 用于分页
 * @author: wangshu
 * @create: 2019-03-19 17:23:43
 **/
@Component
public class Page<T> implements Serializable {

    private int first = 1;//第一页
    private int last;//最后一页
    private int now;//当前页
    private int total;//总页数 ==>sql==>select count(*)/pageNum from tableName;
    private int num;//数据总量 ==>sql==>select count(*) from tableName;
    private int size = 10;//每一页的数量,默认等于10

    private List<T> data;//数据

    public int getFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public int getLast() {
        return last;
    }

    public void setLast(int last) {
        this.last = last;
    }

    public int getNow() {
        return now;
    }

    public void setNow(int now) {
        this.now = now;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Page{" +
                "first=" + first +
                ", last=" + last +
                ", now=" + now +
                ", total=" + total +
                ", num=" + num +
                ", size=" + size +
                ", data=" + data +
                '}';
    }
}
