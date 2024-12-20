package pe.edu.cibertec.Proyecto_BonaVenture_Bazar.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.Proyecto_BonaVenture_Bazar.dto.ArticuloDetailDto;
import pe.edu.cibertec.Proyecto_BonaVenture_Bazar.dto.ArticuloDto;
import pe.edu.cibertec.Proyecto_BonaVenture_Bazar.model.Articulos;
import pe.edu.cibertec.Proyecto_BonaVenture_Bazar.repository.ArticuloRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ManageServiceImpl implements pe.edu.cibertec.Proyecto_BonaVenture_Bazar.service.ManageService{

    @Autowired
    ArticuloRepository articuloRepository;

    @Override
    public List<ArticuloDto> getAllArticulos() throws Exception {
        List<ArticuloDto> articulos = new ArrayList<>();
        Iterable<Articulos> iterable = articuloRepository.findAll();
        iterable.forEach(articulo -> {
            articulos.add(new ArticuloDto(
                    articulo.getIdArticulo(),
                    articulo.getNomArt(),
                    articulo.getDescrpArt(),
                    articulo.getMarca(),
                    articulo.getModelo(),
                    articulo.getColor(),
                    articulo.getPrecio(),
                    articulo.getCategoria(),  // Esto debe ser el objeto Categoria completo
                    articulo.getProveedor()));
        });

        return articulos;
    }

    @Override
    public Optional<ArticuloDetailDto> getArticuloById(int id) throws Exception {
        Optional<Articulos> optional = articuloRepository.findById(id);
        return optional.map(articulo -> new ArticuloDetailDto(articulo.getIdArticulo(),
                articulo.getNomArt(),
                articulo.getDescrpArt(),
                articulo.getMarca(),
                articulo.getModelo(),
                articulo.getColor(),
                articulo.getPrecio(),
                articulo.getCategoria(),
                articulo.getProveedor()));
    }

    @Override
    public boolean updateArticulo(ArticuloDto articuloDto) throws Exception {
        Optional<Articulos> optional = articuloRepository.findById(articuloDto.id());
        return optional.map(articulo -> {
            articulo.setNomArt(articuloDto.nomArt());
            articulo.setMarca(articuloDto.marca());
            articulo.setModelo(articuloDto.modelo());
            articulo.setColor(articuloDto.color());
            articulo.setPrecio(articuloDto.precio());
            articulo.setCategoria(articuloDto.idCatgr());
            articulo.setProveedor(articuloDto.idProv());
            articuloRepository.save(articulo);
            return true;
        }).orElse(false);
    }

    @Override
    public boolean deleteArticuloById(int id) throws Exception {
        Optional<Articulos> optional = articuloRepository.findById(id);
        return optional.map(articulo -> {
            articuloRepository.delete(articulo);
            return true;
        }).orElse(false);
    }

    @Override
    public boolean addArticulo(ArticuloDetailDto articuloDetailDto) throws Exception {

        Optional<Articulos> optional = articuloRepository.findById(articuloDetailDto.id()); // Corregido
        if (optional.isEmpty()) {
            Articulos articulo = new Articulos();
            articulo.setNomArt(articuloDetailDto.nomArt());
            articulo.setMarca(articuloDetailDto.marca());
            articulo.setModelo(articuloDetailDto.modelo());
            articulo.setColor(articuloDetailDto.color());
            articulo.setPrecio(articuloDetailDto.precio());
            articulo.setCategoria(articuloDetailDto.idCatgr());
            articulo.setProveedor(articuloDetailDto.idProv());
            articuloRepository.save(articulo);
            return true;
        }
        return false;
    }
}
