package com.Doctor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
 
import javax.persistence.Id;


import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
public class DoctorSG 
{
	@Id
	@GeneratedValue(generator = "Id_generator")
	@GenericGenerator(name = "Id_generator",strategy ="org.hibernate.id.enhanced.SequenceStyleGenerator",
						parameters = {@Parameter(name="sequence_name", value="user_sequence"),
								      @Parameter(name ="initial_value",value="100"),
									  @Parameter(name="increment_size",value = "1")})
	private int id;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
