package pe.edu.cibertec.Proyecto_BonaVenture_Bazar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.cibertec.Proyecto_BonaVenture_Bazar.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
}
