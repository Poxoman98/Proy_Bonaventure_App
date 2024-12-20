package pe.edu.cibertec.Proyecto_BonaVenture_Bazar.dto;

import pe.edu.cibertec.Proyecto_BonaVenture_Bazar.model.Categoria;
import pe.edu.cibertec.Proyecto_BonaVenture_Bazar.model.Proveedor;

public record ArticuloDetailDto(Integer id,
                                String nomArt,
                                String descrpArt,
                                String marca,
                                String modelo,
                                String color,
                                Double precio,
                                Categoria idCatgr,
                                Proveedor idProv) {
}
