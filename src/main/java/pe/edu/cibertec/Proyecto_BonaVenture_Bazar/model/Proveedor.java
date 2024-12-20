package pe.edu.cibertec.Proyecto_BonaVenture_Bazar.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProv;

    private String nomProv;
    private String telProv;
    private String emailProv;
    private String dirProv;
}