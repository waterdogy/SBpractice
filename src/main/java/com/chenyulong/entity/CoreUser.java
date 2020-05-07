package com.chenyulong.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.Date;
import java.util.Objects;

public class CoreUser implements java.io.Serializable{
    @NotNull(message = "ID不能为空")
    protected Long id;
    // 删除标识
    @JsonIgnore
    protected Integer delFlag= 0;
    // 创建时间

    protected Date createTime;


    // 登录名，编号
    @NotBlank(message = "用户编号不能为空")
    @Null(message = "用户编号不能为空")
    private String code;

    // 用户姓名
    @NotBlank(message = "用户名不能为空")
    private String name;

    // 组织机构id

    private Long orgId;

    // 密码
    @JsonIgnore
    private String password;

    private String state;

    //扩展例子
    private String jobType0;

    private String jobType1;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getJobType0() {
        return jobType0;
    }

    public void setJobType0(String jobType0) {
        this.jobType0 = jobType0;
    }

    public String getJobType1() {
        return jobType1;
    }

    public void setJobType1(String jobType1) {
        this.jobType1 = jobType1;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoreUser coreUser = (CoreUser) o;
        return getCode().equals(coreUser.getCode()) &&
                getName().equals(coreUser.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCode(), getName());
    }
}
