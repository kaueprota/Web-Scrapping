package fiap.idwall.API.controller;

import fiap.idwall.API.model.Wanted;
import fiap.idwall.API.model.repository.WantedRepository;
import fiap.idwall.API.service.WantedService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping("/wanted")
public class WantedController {

    @Autowired
    private WantedRepository wantedRepository;

    @Autowired
    private WantedService wantedService;

    private static final Logger log = LoggerFactory.getLogger(WantedController.class);

    @Operation(summary = "Retorna todos os procurados existentes em nosso banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição mal formatada"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor") })
    @GetMapping
    public ResponseEntity<List<Wanted>> getAllWanted() {
        try {
            // Recupera uma lista de todos os wanteds do repositório
            List<Wanted> wantedList = wantedRepository.findAll();
            return ResponseEntity.ok(wantedList);
        } catch (Exception e) {
            // Retorna uma resposta de erro 500 (Internal Server Error) se ocorrer uma exceção
            log.error("Erro ao recuperar Wanted", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @Operation(summary = "Retorna todos os dados da API externa e salva no banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição mal formatada"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor") })
    @GetMapping("/save")
    public ResponseEntity<List<Wanted>> getByApiAndSave() {
        try {
            return ResponseEntity.ok(List.of(wantedService.getByApiAndSave()));
        } catch (Exception e) {
            log.error("Erro ao salvar os dados", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @Operation(summary = "Aqui, podemos realizar uma busca direcionada")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição mal formatada"),
            @ApiResponse(responseCode = "404", description = "Valor não encontrado",
                    content = @Content(schema = @Schema(implementation = String.class),
                    examples = @ExampleObject(value = "{\"message\": \"Wanted não encontrado\"}"))),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor") })
    @GetMapping("/search/{param}")
    public ResponseEntity<?> getWantedByParam(@Parameter(description = "Nome ou id do procurado", required = true) @PathVariable String param) {
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

    //Metodo para testes
    @Operation(summary = "Este método serve apenas para teste")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição mal formatada"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor") })
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
    @Operation(summary = "exclui um procurado do nosso banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso, recurso deletado",
                    content = @Content(schema = @Schema(implementation = String.class),
                            examples = @ExampleObject(value = "{\"message\": \"Recurso deletado com sucesso\"}"))),
            @ApiResponse(responseCode = "204", description = "Sucesso, sem conteúdo para retornar"),
            @ApiResponse(responseCode = "404", description = "Recurso não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
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
