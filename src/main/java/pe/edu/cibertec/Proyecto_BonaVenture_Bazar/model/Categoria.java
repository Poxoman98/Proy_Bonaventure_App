package pe.edu.cibertec.Proyecto_BonaVenture_Bazar.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCatgr;

    @Column(unique = true, nullable = false)
    private String nomCtgr;
}