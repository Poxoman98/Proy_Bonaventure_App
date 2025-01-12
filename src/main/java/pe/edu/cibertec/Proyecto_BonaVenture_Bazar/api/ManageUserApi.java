package pe.edu.cibertec.Proyecto_BonaVenture_Bazar.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.Proyecto_BonaVenture_Bazar.dto.ArticuloDetailDto;
import pe.edu.cibertec.Proyecto_BonaVenture_Bazar.dto.ArticuloDto;
import pe.edu.cibertec.Proyecto_BonaVenture_Bazar.response.*;
import pe.edu.cibertec.Proyecto_BonaVenture_Bazar.service.ManageService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/manage-articulo")
public class ManageUserApi {

    @Autowired
    ManageService manageService;

    @GetMapping("/all")
    public FindArticulosResponse findArticulos(){

        try {
            List<ArticuloDto> cars = manageService.getAllArticulos();
            if (!cars.isEmpty())
                return new FindArticulosResponse("01", null, cars);
            else
                return new FindArticulosResponse("02", "Cars not found", null);

        } catch (Exception e) {
            e.printStackTrace();
            return new FindArticulosResponse("99", "An Error Ocurred try again", null);
        }
    }

    @GetMapping("/detail")
    public FindArticuloResponse findCar(@RequestParam(value = "id", defaultValue = "0") String id) {

        try {
            Optional<ArticuloDetailDto> optional = manageService.getArticuloById(Integer.parseInt(id));
            return optional.map(articulo ->
                    new FindArticuloResponse("01", null, articulo)
            ).orElse(
                    new FindArticuloResponse("02", "Car not Found", null)
            );
        } catch (Exception e) {
            e.printStackTrace();
            return new FindArticuloResponse("99", "An error ocurred, please try again", null);
        }

    }

    @PutMapping("/update")
    public UpdateArticuloResponse updateArticulo(@RequestBody ArticuloDto articuloDto) {

        try {
            if (manageService.updateArticulo(articuloDto))
                return new UpdateArticuloResponse("01", null);
            else
                return new UpdateArticuloResponse("02", "Car not Found");

        } catch (Exception e) {
            e.printStackTrace();
            return new UpdateArticuloResponse("99", "An error ocurred, please try again");
        }
    }

    @DeleteMapping("/delete/{id}")
    public DeleteArticuloResponse deleteArticulo(@PathVariable String id) {

        try {
            if (manageService.deleteArticuloById(Integer.parseInt(id)))
                return new DeleteArticuloResponse("01", null);
            else
                return new DeleteArticuloResponse("02", "Car not Found");
        } catch (Exception e) {
            e.printStackTrace();
            return new DeleteArticuloResponse("99", "An error ocurred, please try again");
        }

    }

    @PostMapping("/create")
    public CreateArticuloResponse createArticulo(@RequestBody ArticuloDetailDto articuloDetailDto) {

        try {
            if (manageService.addArticulo(articuloDetailDto))
                return new CreateArticuloResponse("01", null);
            else
                return new CreateArticuloResponse("02", "Car already exists");
        } catch (Exception e) {
            e.printStackTrace();
            return new CreateArticuloResponse("99", "An error ocurred, please try again");

        }
    }
}
