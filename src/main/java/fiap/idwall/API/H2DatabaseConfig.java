package fiap.idwall.API;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.InputStreamReader;

@Configuration
public class H2DatabaseConfig {
//    @Autowired
//    private DataSource dataSource;
//
//    @Bean
//    public CommandLineRunner initDatabase() {
//        return args -> {
//            Resource resource = new ClassPathResource("src/main/resources/Insert_Sql.sql");
//            ScriptUtils.executeSqlScript(dataSource.getConnection("sa","" ), resource);
//        };
//    }
}
