package com.example.vo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Data
@Entity
@Table(name="probTable")
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BojVo {
	@Id
	@NonNull
	private String id;
	private String level;
	private String name;
	private String url;

}
