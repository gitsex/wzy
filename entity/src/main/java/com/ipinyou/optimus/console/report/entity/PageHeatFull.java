package com.ipinyou.optimus.console.report.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.ToString;

import org.hibernate.annotations.Index;
import org.springframework.format.annotation.DateTimeFormat;

import com.ipinyou.base.constant.DateFormat;

/**
 * 页面热度分析-带参数
 * 
 * @author guodong.zhang
 * @author yaohl
 */
@Entity
@Table(name = "rpt_page_heat_full")
@Data
@ToString(callSuper = true)
public class PageHeatFull implements com.ipinyou.base.entity.Entity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 559946274625433330L;
	/**
	 * 主键
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	/**
	 * 广告主公司ID
	 */
	@NotNull
	@Index(name="companyId")
	private long companyId;
	
	/**
	 * 日期
	 */
	@NotNull
	@DateTimeFormat(pattern = DateFormat.DATE)
	@Index(name="day")
	private Date day;
	
	/**
	 * 页面url
	 */
	@NotNull
	@Column(length = 2083)
	private String url;

	/**
	 * 访问次数
	 */
	@NotNull
	private long pv;

	/**
	 * 访问人数
	 */
	@NotNull
	private long uv;
}
