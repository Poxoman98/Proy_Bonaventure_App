package pe.edu.cibertec.Proyecto_BonaVenture_Bazar.response;

import pe.edu.cibertec.Proyecto_BonaVenture_Bazar.dto.ArticuloDto;

public record FindArticulosResponse (String code,
                                     String error,
                                     Iterable<ArticuloDto> cars){
}
