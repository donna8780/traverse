package com.traverse.www.vo;

import com.google.protobuf.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerVO {

	private int board_idx, accounts_idx;
	private String title, content,nick;
	private Timestamp create_at;
	
}
