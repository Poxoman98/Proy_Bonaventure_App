package pe.edu.cibertec.Proyecto_BonaVenture_Bazar.response;

import pe.edu.cibertec.Proyecto_BonaVenture_Bazar.dto.ArticuloDetailDto;

public record FindArticuloResponse (String code,
                                    String error,
                                    ArticuloDetailDto car){
}
