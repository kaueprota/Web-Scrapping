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

//    @Column(nullable = false, name = "IMG")
//    private String img;
//
//    @Column(nullable = false, name = "NAME")
//    private String name;

    @Column(length = 100, name = "HAIR")
    private String hair;

    @Column(length = 100, name = "EYES")
    private String eyes;

//    @Column(length = 5, name = "HEIGHT")
//    private String height;
//
//    @Column(name = "DATE_OF_BIRTH")
//    private Date dateOfBirth;
//
//    @Column(length = 6, name = "SEX")
//    private String sex;
//
//    @Column(name = "CITIZENSHIP")
//    private String citizenship;
//
//    @Enumerated(EnumType.STRING)
//    @Column(nullable = false, name = "WANTED_FOR")
//    private WantedFor wantedFor;
//
//    @Enumerated(EnumType.STRING)
//    @Column(nullable = false, name = "CATEGORY")
//    private Category category;

    @Column(name = "REWARD")
    private double reward;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public String getImg() {
//        return img;
//    }
//
//    public void setImg(String img) {
//        this.img = img;
//    }

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }

    public String getHair() {
        return hair;
    }

    public void setHair(String hair) {
        this.hair = hair;
    }

    public String getEyes() {
        return eyes;
    }

    public void setEyes(String eyes) {
        this.eyes = eyes;
    }
//
//    public String getHeight() {
//        return height;
//    }
//
//    public void setHeight(String height) {
//        this.height = height;
//    }
//
//    public Date getDateOfBirth() {
//        return dateOfBirth;
//    }
//
//    public void setDateOfBirth(Date dateOfBirth) {
//        this.dateOfBirth = dateOfBirth;
//    }
//
//    public String getSex() {
//        return sex;
//    }
//
//    public void setSex(String sex) {
//        this.sex = sex;
//    }
//
//    public String getCitizenship() {
//        return citizenship;
//    }
//
//    public void setCitizenship(String citizenship) {
//        this.citizenship = citizenship;
//    }
//
//    public WantedFor getWantedFor() {
//        return wantedFor;
//    }
//
//    public void setWantedFor(WantedFor wantedFor) {
//        this.wantedFor = wantedFor;
//    }
//
//    public Category getCategory() {
//        return category;
//    }
//
//    public void setCategory(Category category) {
//        this.category = category;
//    }

    public double getReward() {
        return reward;
    }

    public void setReward(double reward) {
        this.reward = reward;
    }
}
