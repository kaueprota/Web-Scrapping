//package fiap.idwall.API;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.core.JdbcTemplate;
//
//@Configuration
//public class DataInsertionConfig {
//
//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//
//    @Bean
//
//    public CommandLineRunner insertData() {
//        return args -> {
//
//            // Nesse comando será inserido todos os dados na tabela
//            // Será necessário alterar todos os dados para esse padrão
//            // O ID não pode ser repetido
//            jdbcTemplate.execute("INSERT INTO WANTED (IMG, NAME, HAIR, EYES, HEIGHT, DATE_OF_BIRTH, SEX, CITIZENSHIP, WANTED_FOR, CATEGORY, REWARD)\n" +
//                    "VALUES " +
//
//            "('https://ws-public.interpol.int/notices/v1/red/images/2023-27985', 'EDGARDO MARTÍNEZ RODRÍGUEZ',  'Black', 'Brown', '1,70m', '1990-03-29', 'Male', 'El Salvador', 'INTERPOL', 'TERRORISM', 5000)," +
//
//            "('https://ws-public.interpol.int/notices/v1/red/images/2023-20396', 'MOVSAR ZOUBAIROVITCH MAGOMADOV', 'Brown', 'Blue', '1,81m', '1991-06-22', 'Male', 'Russia', 'INTERPOL', 'TERRORISM', 5000)," +
//
//            "('https://ws-public.interpol.int/notices/v1/red/images/2023-24847', 'PEDRO OSMAR PERLA RUBIO', 'Black', 'Brown', '1,69m', '1986-03-04', 'Male', 'El Salvador', 'INTERPOL', 'TERRORISM', 3000)," +
//
//            "('https://ws-public.interpol.int/notices/v1/red/images/2023-27683', 'JOSE EDUARDO MACZ GUERRA', 'Black', 'Brown', '1,73m', '1990-09-28', 'Male', 'Guatemala', 'INTERPOL', 'MONEYLAUNDERING', 6000)," +
//
//            "('https://ws-public.interpol.int/notices/v1/red/images/2023-27384', 'NOEL ANTONIO ROSTRAN AMADOR', 'Black', 'Brown', '1,70m', '1992-04-02', 'Male', 'Nicarágua', 'INTERPOL', 'OTHERS', 4000)," +
//
//            "('https://ws-public.interpol.int/notices/v1/red/images/2023-26387', 'JOSE ROGELIO MISAEL RUBIO PERLA', 'Black', 'Brown', '1,69m', '1980-10-16', 'Male', 'El Salvador', 'INTERPOL', 'TERRORISM', 10000)," +
//
//            "('https://ws-public.interpol.int/notices/v1/red/images/2023-26393', 'JORGE LUIS HERNÁNDEZ CENTENO', 'Black', 'Brown', '1,79m', '1998-08-24', 'Male', 'El Salvdor', 'INTERPOL', 'MONEYLAUNDERING', 6000)," +
//
//            "('https://ws-public.interpol.int/notices/v1/red/images/2022-85031', 'FLORENCIO MAMANI ALFONZO', 'Black', 'Brown', '1.73m', '1998-01-15', 'Male', 'Bolivia', 'INTERPOL', 'MONEYLAUNDERING', 4000)," +
//
//            "('https://ws-public.interpol.int/notices/v1/red/images/2023-27694', 'MAXIMO ALANOCA CONDORI', 'Brown', 'Brown', '1,75m', '1974-11-02', 'Male', 'Italy', 'INTERPOL', 'OTHERS', 6000)," +
//
//            "('https://ws-public.interpol.int/notices/v1/red/images/2023-10742', 'ADAM YANDIEV', 'Black', 'Brown', '1,80m', '1985-01-28', 'Male', 'Russia', 'INTERPOL', 'MONEYLAUNDERING', 10000)," +
//
//            "('https://www.fbi.gov/wanted/counterintelligence/boris-yakovlevich-livshits/@@images/image', 'BORIS YAKOVLEVICH LIVSHITS', 'Black', 'Brown', '1,90m', '1978-10-15', 'Male', 'Russia', 'FBI', 'MONEYLAUNDERING', 15000)," +
//
//            "('https://www.fbi.gov/wanted/vicap/missing-persons/jesus-de-la-cruz---lynn-massachusetts/@@images/image', 'JESUS DE LA CRUZ', 'Brown', 'Brown', '1,89m', '1985-05-03', 'Male', 'Colombia', 'FBI', 'TERRORISM', 10000)," +
//
//            "('https://www.fbi.gov/wanted/seeking-info/mary-aleta-molly-sparks/@@images/image', 'MARY ALETA MOLLY SPARKS', 'Blonde', 'Blue', '1,73m', '1990-07-12', 'Female', 'United States', 'FBI', 'MONEYLAUNDERING', 12000)," +
//
//            "('https://www.fbi.gov/wanted/kidnap/susan-gail-carter/@@images/image', 'SUSAN GAIL CARTER', 'Red', 'Green', '1,61m', '1982-11-21', 'Female', 'England', 'FBI', 'OTHERS', 15000)," +
//
//            "('https://www.fbi.gov/wanted/additional/aaron-paul-victory/@@images/image', 'AARON PAUL VICTORY', 'Brown', 'Brown', '1,60m', '1979-01-28', 'Male', 'United States', 'FBI', 'TERRORISM', 13000)," +
//
//            "('https://www.fbi.gov/wanted/vicap/missing-persons/bryan-matthew-mcgehrin---taneytown-maryland/@@images/image', 'BRYAN MATTHEW MCGEHRIN', 'Brown', 'Brown', '1,73m', '1992-12-05', 'Male', 'England', 'FBI', 'TERRORISM', 12000)," +
//
//            "('https://www.fbi.gov/wanted/cei/tiara-thomas/@@images/image', 'TIARA THOMAS', 'Black', 'Brown', '1,81m', '2000-02-04', 'Female', 'Canada', 'FBI', 'MONEYLAUNDERING', 14000)," +
//
//            "('https://www.fbi.gov/wanted/seeking-info/nathaniel-mesiah-roby-townsend-1/@@images/image', 'NATHANIEL MESIAH ROBY-TOWNSEND', 'Black', 'Brown', '1,71m', '1985-01-25', 'Male', 'United States', 'FBI', 'TERRORISM', 1000)," +
//
//            "('https://www.fbi.gov/wanted/additional/murray-gordon-waller/@@images/image', 'MURRAY GORDON WALLER', 'Blond', 'Green', '1,81m', '1947-02-25', 'Male', 'United States', 'FBI', 'MONEYLAUNDERING', 15000)," +
//
//            "('https://www.fbi.gov/wanted/vicap/missing-persons/mitchell-todd-hein/@@images/image', 'MITCHELL TODD HEIN', 'Brown', 'Brown', '1,78m', '1996-06-30', 'Male', 'Brazil', 'FBI','TERRORISM', 20000);");
//        };
//    }
//
//}
