package be.technofutur.springexorecap.entities;


import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class CarteLineEntity {

    @EmbeddedId
    private carteLineEntityID id

    @Embeddable
    public static class carteLineEntityID
    {



    }

}
