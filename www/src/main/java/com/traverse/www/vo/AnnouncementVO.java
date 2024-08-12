package com.traverse.www.vo;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnnouncementVO {
	private int accounts_idx, announcement_idx, a_idx, v_count;
	private String title, contents, nick;
	private Date w_date;
}
