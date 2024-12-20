package pe.edu.cibertec.Proyecto_BonaVenture_Bazar.service;

import pe.edu.cibertec.Proyecto_BonaVenture_Bazar.dto.ArticuloDetailDto;
import pe.edu.cibertec.Proyecto_BonaVenture_Bazar.dto.ArticuloDto;

import java.util.List;
import java.util.Optional;

public interface ManageService {

    List<ArticuloDto> getAllArticulos() throws Exception;

    Optional<ArticuloDetailDto> getArticuloById(int id) throws Exception;

    boolean updateArticulo(ArticuloDto carDto) throws Exception;

    boolean deleteArticuloById(int id) throws Exception;

    boolean addArticulo(ArticuloDetailDto articuloDetailDto) throws Exception;
}
