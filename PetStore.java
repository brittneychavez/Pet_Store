package pet.store.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class PetStore {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long petStoreId;
private String petStoreName;
private String petStoreLocation;

@OneToMany(mappedBy = "petStore", cascade = CascadeType.ALL, orphanRemoval = true)
@EqualsAndHashCode.Exclude
@ToString.Exclude
private Set<Employee> employees = new HashSet<Employee>();

@ManyToMany(cascade = CascadeType.PERSIST)
@JoinTable(name = "pet_store_customer",
        joinColumns = @JoinColumn(name = "pet_store_id"),
        inverseJoinColumns = @JoinColumn(name = "customer_id")
    )
@EqualsAndHashCode.Exclude
@ToString.Exclude
private Set<Customer> customers = new HashSet<Customer>();

}
