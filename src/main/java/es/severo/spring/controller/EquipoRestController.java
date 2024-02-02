package es.severo.spring.controller;

import es.severo.spring.entity.Coche;
import es.severo.spring.entity.Equipo;
import es.severo.spring.service.EquipoService;
import es.severo.spring.util.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "TEAM TABLE")
@RestController
@RequestMapping("/api")
public class EquipoRestController {

    private final EquipoService equipoService;

    public EquipoRestController(EquipoService equipoService) {
        this.equipoService = equipoService;
    }

    @GetMapping("/teams")
    public List<Equipo> findAll(){
        return equipoService.findAll();
    }

    @GetMapping("/teamspaged")
    public List<Equipo> getPagedTeams(@RequestParam(defaultValue = "1") Integer pageNo, @RequestParam(defaultValue ="3") Integer pageSize,
                                       @RequestParam(required = false) CamposEquipo camposEquipo,
                                       @RequestParam(defaultValue = "ASC") Sort.Direction sortDirection){
        return equipoService.findAllSplited(pageNo,pageSize,camposEquipo,sortDirection);
    }

    @GetMapping("/teams/competition/{comp}")
    public List<Equipo> getTeamsThatParticipatieInACertainCompetition(@PathVariable("comp") Competicion comp){
        return equipoService.findByCompeticion(comp.getStr());
    }

    @GetMapping("/teams/tires/{tires}")
    public List<Equipo> getTeamsThatUseACertainTypeOfTires(@PathVariable("tires") Neumaticos tires){
        return equipoService.findByTiresUsed(tires.getStr());
    }


}
