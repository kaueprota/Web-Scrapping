package fiap.idwall.API.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
@Entity
@Table(name = "WANTED")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Wanted {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "IMG")
    private String img;

    @Column(nullable = false, name = "NAME")
    private String name;

    @Column(length = 10, name = "HAIR")
    private String hair;

    @Column(length = 10, name = "EYES")
    private String eyes;

    @Column(length = 5, name = "HEIGHT")
    private String height;

    @Column(name = "DATE_OF_BIRTH")
    private Date dateOfBirth;

    @Column(length = 6, name = "SEX")
    private String sex;

    @Column(name = "CITIZENSHIP")
    private String citizenship;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "WANTED_FOR")
    private WantedFor wantedFor;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "CATEGORY")
    private Category category;

    @Column(name = "REWARD")
    private double reward;
}
