package fiap.idwall.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DataInsertionConfig {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Bean
    public CommandLineRunner insertData() {
        return args -> {

            // Quando a aplicação for iniciada primeiro a tabela é limpa para não ter problemas com a PK id
            jdbcTemplate.execute("truncate table WANTED");

            // Nesse comando será inserido todos os dados na tabela
            // Será necessário alterar todos os dados para esse padrão
            // O ID não pode ser repetido
            jdbcTemplate.execute("INSERT INTO WANTED (ID, AGE, CATEGORY, CITIZENSHIP, DATE_OF_BIRTH, EYES, HAIR, HEIGHT, IMG, NAME, REWARD, SEX, WANTED_FOR)\n" +
                    "VALUES " +
                    "(1, 30, 'TERRORISM', 'Brazilian', '1993-05-20', 'Brown', 'Black', '180', 'procurado1.jpg', 'John Doe', 10000, 'M', 'FBI'), " +
                    "(2, 70, 'TERRORISM', 'Brazilian', '1993-05-20', 'Brown', 'Black', '180', 'procurado1.jpg', 'John Doe', 10000, 'M', 'FBI'), " +
                    "(3, 34, 'TERRORISM', 'Brazilian', '1993-05-20', 'Brown', 'Black', '180', 'procurado1.jpg', 'John Doe', 10000, 'M', 'FBI'), " +
                    "(4, 28, 'TERRORISM', 'Brazilian', '1993-05-20', 'Brown', 'Black', '180', 'procurado1.jpg', 'John Doe', 10000, 'M', 'FBI');");
        };
    }

}
