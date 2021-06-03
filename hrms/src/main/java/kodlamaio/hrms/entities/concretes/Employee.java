package kodlamaio.hrms.entities.concretes;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@AllArgsConstructor
@NoArgsConstructor 
@PrimaryKeyJoinColumn(name="id",referencedColumnName = "id")
@Table(name="employee_users")
public class Employee extends User{
	@Column(name="first_name")
	private String first_name;
	
	@Column(name="last_name")
	private String last_name;
	


}
