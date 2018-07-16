package com.staging.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Animo123
 * @since 2018-07-06
 */
@TableName("t_attach_case")
public class AttachCase extends Model<AttachCase> {

    private static final long serialVersionUID = 1L;

    private Integer id;
    /**
     * 附件名称
     */
    private String name;
    /**
     * 文件格式
     */
    private Integer pattern;
    /**
     * 文件大小
     */
    private Integer size;
    /**
     * 课件id
     */
    private Integer caseId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPattern() {
        return pattern;
    }

    public void setPattern(Integer pattern) {
        this.pattern = pattern;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getCaseId() {
        return caseId;
    }

    public void setCaseId(Integer caseId) {
        this.caseId = caseId;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "AttachCase{" +
        "id=" + id +
        ", name=" + name +
        ", pattern=" + pattern +
        ", size=" + size +
        ", caseId=" + caseId +
        "}";
    }
}
