package com.staging.entity;

import com.baomidou.mybatisplus.enums.IdType;
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
@TableName("t_integral_task")
public class IntegralTask extends Model<IntegralTask> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 任务属性
     */
    @TableField("task_property")
    private Integer taskProperty;
    /**
     * 英文名称
     */
    @TableField("task_english_name")
    private String taskEnglishName;
    /**
     * 任务名称
     */
    @TableField("task_name")
    private String taskName;
    /**
     * 任务积分
     */
    @TableField("task_integral")
    private Integer taskIntegral;
    /**
     * 任务经验值
     */
    @TableField("task_empirical")
    private Integer taskEmpirical;
    /**
     * 任务说明
     */
    @TableField("task_explain")
    private String taskExplain;
    /**
     * 任务完成状态
     */
    @TableField("task_completion_status")
    private Integer taskCompletionStatus;
    /**
     * 链接
     */
    @TableField("task_link")
    private String taskLink;
    /**
     * 1-直属，0-非直属
     */
    @TableField("task_status")
    private Integer taskStatus;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTaskProperty() {
        return taskProperty;
    }

    public void setTaskProperty(Integer taskProperty) {
        this.taskProperty = taskProperty;
    }

    public String getTaskEnglishName() {
        return taskEnglishName;
    }

    public void setTaskEnglishName(String taskEnglishName) {
        this.taskEnglishName = taskEnglishName;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Integer getTaskIntegral() {
        return taskIntegral;
    }

    public void setTaskIntegral(Integer taskIntegral) {
        this.taskIntegral = taskIntegral;
    }

    public Integer getTaskEmpirical() {
        return taskEmpirical;
    }

    public void setTaskEmpirical(Integer taskEmpirical) {
        this.taskEmpirical = taskEmpirical;
    }

    public String getTaskExplain() {
        return taskExplain;
    }

    public void setTaskExplain(String taskExplain) {
        this.taskExplain = taskExplain;
    }

    public Integer getTaskCompletionStatus() {
        return taskCompletionStatus;
    }

    public void setTaskCompletionStatus(Integer taskCompletionStatus) {
        this.taskCompletionStatus = taskCompletionStatus;
    }

    public String getTaskLink() {
        return taskLink;
    }

    public void setTaskLink(String taskLink) {
        this.taskLink = taskLink;
    }

    public Integer getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(Integer taskStatus) {
        this.taskStatus = taskStatus;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "IntegralTask{" +
        "id=" + id +
        ", taskProperty=" + taskProperty +
        ", taskEnglishName=" + taskEnglishName +
        ", taskName=" + taskName +
        ", taskIntegral=" + taskIntegral +
        ", taskEmpirical=" + taskEmpirical +
        ", taskExplain=" + taskExplain +
        ", taskCompletionStatus=" + taskCompletionStatus +
        ", taskLink=" + taskLink +
        ", taskStatus=" + taskStatus +
        "}";
    }
}
