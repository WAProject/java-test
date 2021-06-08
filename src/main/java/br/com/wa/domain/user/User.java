package br.com.wa.domain.user;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

import kotlin.jvm.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document(collection = "user")
@NoArgsConstructor
@AllArgsConstructor
public class User {
	
	public User(String name) {
		this.name = name;
	}
	
	@Transient
	@JsonIgnore
	public static final String SEQUENCE_NAME = "user_seq";
	
	@Id
	private int id;
	
	private String name;
	private String email;
	private int age;
	private Address address;

}