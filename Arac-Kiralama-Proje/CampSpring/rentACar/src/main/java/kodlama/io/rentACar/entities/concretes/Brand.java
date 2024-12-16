package kodlama.io.rentACar.entities.concretes;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Table(name = "brands")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "manufacturing_year")
    private int manufacturing_year;

    @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Model> models;
}


