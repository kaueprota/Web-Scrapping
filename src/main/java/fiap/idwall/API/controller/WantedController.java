package fiap.idwall.API.controller;

import fiap.idwall.API.model.Wanted;
import fiap.idwall.API.model.repository.WantedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wanted")
public class WantedController {

    @Autowired
    private WantedRepository wantedRepository;

    @GetMapping
    public ResponseEntity<List<Wanted>> getAllWanted() {
        try {
            // Recupera uma lista de todos os wanteds do repositório
            List<Wanted> wantedList = wantedRepository.findAll();
            return ResponseEntity.ok(wantedList);
        } catch (Exception e) {
            // Retorna uma resposta de erro 500 (Internal Server Error) se ocorrer uma exceção
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/search/{param}")
    public ResponseEntity<?> getWantedByParam(@PathVariable String param) {
        try {
            // Verifica se o parâmetro é numérico (ID) ou alfanumérico (nome)
            if (param.matches("\\d+")) {
                Long id = Long.parseLong(param);
                // Busca o wanted pelo ID no repositório
                Wanted wanted = wantedRepository.findById(id).orElse(null);
                if (wanted != null) {
                    // Retorna uma resposta de sucesso 200 (OK) com o wanted encontrado
                    return ResponseEntity.ok(wanted);
                } else {
                    // Retorna uma resposta de erro 404 (Not Found) se o wanted não for encontrado
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Wanted não encontrado");
                }
            } else {
                // Busca uma lista de wanteds pelo nome no repositório
                List<Wanted> wantedList = wantedRepository.findByName(param);

                if (!wantedList.isEmpty()) {
                    // Retorna uma resposta de sucesso 200 (OK) com a lista de wanteds encontrados
                    return ResponseEntity.ok(wantedList);
                } else {
                    // Retorna uma resposta de erro 404 (Not Found) se nenhum wanted for encontrado com o nome fornecido
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum Wanted encontrado com esse nome");
                }
            }
        } catch (NumberFormatException e) {
            // Retorna uma resposta de erro 400 (Bad Request) se ocorrer um erro de formato no ID
            return ResponseEntity.badRequest().body("ID inválido");
        } catch (Exception e) {
            // Retorna uma resposta de erro 500 (Internal Server Error) se ocorrer uma exceção
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao buscar o Wanted: " + e.getMessage());
        }
    }

    @PostMapping("/create")
    public ResponseEntity<String> createWanted(@RequestBody Wanted wanted) {
        try {
            // Cria um novo wanted no repositório
            Wanted createdWanted = wantedRepository.save(wanted);
            // Retorna uma resposta de sucesso 200 (OK) com uma mensagem de sucesso e o ID do wanted criado
            return ResponseEntity.ok("Wanted criado com sucesso! ID: " + createdWanted.getId());
        } catch (Exception e) {
            // Retorna uma resposta de erro 500 (Internal Server Error) se ocorrer uma exceção ao criar o wanted
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao criar o Wanted: " + e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
        public ResponseEntity<String> deleteWantedById(@PathVariable Long id) {
            try {
                // Verifica se o wanted com o ID fornecido existe no repositório
                if (wantedRepository.existsById(id)) {
                    // Deleta o wanted pelo ID no repositório
                    wantedRepository.deleteById(id);
                    // Retorna uma resposta de sucesso 200 (OK) com uma mensagem de sucesso
                    return ResponseEntity.ok("Wanted deletado com sucesso!");
                } else {
                    // Retorna uma resposta de erro 404 (Not Found) se o wanted não for encontrado
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Wanted não encontrado");
                }
            } catch (Exception e) {
                // Retorna uma resposta de erro 500 (Internal Server Error) se ocorrer uma exceção ao deletar o wanted
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao deletar o Wanted: " + e.getMessage());
            }
    }

}
