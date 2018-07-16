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
@TableName("t_case_comment_reply")
public class CaseCommentReply extends Model<CaseCommentReply> {

    private static final long serialVersionUID = 1L;

    /**
     * 课件二级评论id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 父id
     */
    private Integer pid;
    /**
     * 关联case_comment表的id
     */
    @TableField("case_comment_id")
    private Integer caseCommentId;
    /**
     * 用户id
     */
    @TableField("case_user_two_id")
    private Integer caseUserTwoId;
    /**
     * 评论
     */
    @TableField("case_content_two")
    private String caseContentTwo;
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

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getCaseCommentId() {
        return caseCommentId;
    }

    public void setCaseCommentId(Integer caseCommentId) {
        this.caseCommentId = caseCommentId;
    }

    public Integer getCaseUserTwoId() {
        return caseUserTwoId;
    }

    public void setCaseUserTwoId(Integer caseUserTwoId) {
        this.caseUserTwoId = caseUserTwoId;
    }

    public String getCaseContentTwo() {
        return caseContentTwo;
    }

    public void setCaseContentTwo(String caseContentTwo) {
        this.caseContentTwo = caseContentTwo;
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
        return "CaseCommentReply{" +
        "id=" + id +
        ", pid=" + pid +
        ", caseCommentId=" + caseCommentId +
        ", caseUserTwoId=" + caseUserTwoId +
        ", caseContentTwo=" + caseContentTwo +
        ", creatTime=" + creatTime +
        "}";
    }
}
