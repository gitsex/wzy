/**
 * 
 */
package com.ipinyou.optimus.console.report.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import org.hibernate.annotations.Index;

/**
 * @author lijt
 *
 */
@Entity
@Table(name = "rpt_uv_order_conversion")
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class UvOrderConversion extends BaseUvConversion {
	
	private static final long serialVersionUID = 4584055446565630447L;
	
	/**
	 * 订单id
	 */
	@Index(name="orderId")
	private long orderId;
	
}
