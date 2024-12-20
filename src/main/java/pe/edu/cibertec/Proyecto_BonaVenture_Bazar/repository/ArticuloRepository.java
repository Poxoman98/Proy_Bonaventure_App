package pe.edu.cibertec.Proyecto_BonaVenture_Bazar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.cibertec.Proyecto_BonaVenture_Bazar.model.Articulos;

public interface ArticuloRepository extends JpaRepository<Articulos, Integer> {
}