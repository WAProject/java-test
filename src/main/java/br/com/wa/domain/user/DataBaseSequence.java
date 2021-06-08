package br.com.wa.domain.user;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document(collection = "db_sequences")
@NoArgsConstructor
@AllArgsConstructor
public class DataBaseSequence {
	
	@Id
	private String id;
	private int sequenceValue;

}
