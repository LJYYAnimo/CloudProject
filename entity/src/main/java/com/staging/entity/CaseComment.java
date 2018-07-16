package com.staging.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
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
@TableName("t_case_comment")
public class CaseComment extends Model<CaseComment> {

    private static final long serialVersionUID = 1L;

    /**
     * 课件评论一级回复id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 课件id
     */
    @TableField("case_id")
    private Integer caseId;
    /**
     * 用户id
     */
    @TableField("case_user_id")
    private Integer caseUserId;
    /**
     * 课件评论
     */
    @TableField("case_content")
    private String caseContent;
    /**
     * 创建时间
     */
    private Date creatTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCaseId() {
        return caseId;
    }

    public void setCaseId(Integer caseId) {
        this.caseId = caseId;
    }

    public Integer getCaseUserId() {
        return caseUserId;
    }

    public void setCaseUserId(Integer caseUserId) {
        this.caseUserId = caseUserId;
    }

    public String getCaseContent() {
        return caseContent;
    }

    public void setCaseContent(String caseContent) {
        this.caseContent = caseContent;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "CaseComment{" +
        "id=" + id +
        ", caseId=" + caseId +
        ", caseUserId=" + caseUserId +
        ", caseContent=" + caseContent +
        ", creatTime=" + creatTime +
        "}";
    }
}
