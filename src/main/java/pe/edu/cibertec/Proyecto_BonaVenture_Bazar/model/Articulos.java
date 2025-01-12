package pe.edu.cibertec.Proyecto_BonaVenture_Bazar.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Articulos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idArticulo;

    private String nomArt;
    private String descrpArt;
    private String marca;
    private String modelo;
    private String color;

    @Column(nullable = false)
    private Double precio;

    @ManyToOne
    @JoinColumn(name = "idCatgr", nullable = false)
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "idProv", nullable = false)
    private Proveedor proveedor;
}