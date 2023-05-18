package fiap.idwall.API.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Wanted {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String img;
    private String name;
    private int age;
    private String Hair;
    private String Eyes;
    private String Height;
    private Date date_of_birth;
    private String sex;
    private String citizenship;
    @Enumerated(EnumType.STRING)
    private WantedFor wantedFor;
    @Enumerated(EnumType.STRING)
    private Category category;
    private double reward;
}
