package fiap.idwall.API.controller;

import fiap.idwall.API.model.Wanted;
import fiap.idwall.API.model.repository.WantedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wanted")
public class WantedController {

    @Autowired
    private WantedRepository wantedRepository;

    @PostMapping
    public ResponseEntity<String> createWanted(@RequestBody Wanted wanted) {
        try {
            Wanted createdWanted = wantedRepository.save(wanted);
            return ResponseEntity.ok("Wanted criado com sucesso! ID: " + createdWanted.getId());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao criar o Wanted: " + e.getMessage());
        }
    }

}
