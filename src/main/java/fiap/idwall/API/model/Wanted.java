package fiap.idwall.API.model;

import jakarta.persistence.*;
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

    @Column(nullable = false)
    private String img;

    @Column(nullable = false)
    private String name;

    @Column
    private int age;

    @Size(max = 10)
    private String hair;

    @Column(length = 10)
    private String eyes;

    @Size(max = 4)
    private String height;

    @Column()
    private Date date_of_birth;

    @Size(max = 2)
    private String sex;

    @Column
    private String citizenship;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private WantedFor wantedFor;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Category category;

    @Column
    private double reward;
}
