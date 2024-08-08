package com.traverse.www.vo;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnnouncementVO {
	private int announcement_idx, a_idx, v_count;
	private String title, contents;
	private Date w_date;
}
