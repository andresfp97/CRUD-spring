package Clase3;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persona")
public class PersonaController {
    private final PersonaService personaService;

    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }
    @GetMapping
    public List<Persona>findAll(){
        return personaService.findAll();
    }
    @GetMapping("/{id}")
    public Optional<Persona> finById(@PathVariable Long id){
        return personaService.findById(id);
    }
    @PostMapping
    public Persona save(@Validated @RequestBody Persona persona){
        return personaService.save(persona);
    }
    @DeleteMapping("/{id}")
    public void deleteById( Long id){
        personaService.deleteById(id);
    }


}
