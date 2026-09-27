package be.technofutur.springexorecap.entities;


import be.technofutur.springexorecap.enums.pkmType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Embeddable
public class PkmSpecy {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private int id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String imageURL;

    @Getter @Setter
    @Column(nullable = false, length = 20)
    @Enumerated(EnumType.STRING)
    private pkmType type1;

    @Getter @Setter
    @Column(length = 20)
    @Enumerated(EnumType.STRING)
    private pkmType type2;

}
