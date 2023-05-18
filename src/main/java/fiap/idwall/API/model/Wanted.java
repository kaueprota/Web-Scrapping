package fiap.idwall.API.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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

    @NotBlank
    private String name;
    private int age;
    @Size(max = 10)
    private String Hair;
    @Size(max = 20)
    private String Eyes;
    @Size(max = 4)
    private String Height;
    private Date date_of_birth;
    @Size(max = 2)
    private String sex;
    private String citizenship;

    @Enumerated(EnumType.STRING)
    @NotBlank
    private WantedFor wantedFor;

    @Enumerated(EnumType.STRING)
    @NotBlank
    private Category category;

    private double reward;
}
