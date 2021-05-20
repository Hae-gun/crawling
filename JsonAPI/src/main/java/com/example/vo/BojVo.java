package com.example.vo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NonNull;
import lombok.ToString;

@Data
@Entity
@Table(name="probTable")
@ToString
public class BojVo {
	@Id
	@NonNull
	private Long id;
	private String porbName;
	private String url;
	private String category;
}
