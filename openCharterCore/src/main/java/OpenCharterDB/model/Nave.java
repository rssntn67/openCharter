package OpenCharterDB.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Nave {

     @Id
     @GeneratedValue()
     private Long id;
    private String name, tipo, nazione, portorif, armatore, proprietario;
    private float lung;
    private float larg;

    private float alt;

    Nave() {
    }

    public Nave(String name, String tipo, String nazione, String portorif, String armatore, String proprietario, float lung, float larg, float alt) {
        this.name = name;
        this.tipo = tipo;
        this.nazione = nazione;
        this.portorif = portorif;
        this.armatore = armatore;
        this.proprietario = proprietario;
        this.lung = lung;
        this.larg = larg;
        this.alt = alt;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNazione() {
        return nazione;
    }

    public void setNazione(String nazione) {
        this.nazione = nazione;
    }

    public String getPortorif() {
        return portorif;
    }

    public void setPortorif(String portorif) {
        this.portorif = portorif;
    }

    public String getArmatore() {
        return armatore;
    }

    public void setArmatore(String armatore) {
        this.armatore = armatore;
    }

    public String getProprietario() {
        return proprietario;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    public float getLung() {
        return lung;
    }

    public void setLung(float lung) {
        this.lung = lung;
    }

    public float getLarg() {
        return larg;
    }

    public void setLarg(float larg) {
        this.larg = larg;
    }

    public float getAlt() {
        return alt;
    }

    public void setAlt(float alt) {
        this.alt = alt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Nave nave)) return false;
        return Float.compare(nave.lung, lung) == 0 && Float.compare(nave.larg, larg) == 0 && Float.compare(nave.alt, alt) == 0 && id.equals(nave.id) && name.equals(nave.name) && tipo.equals(nave.tipo) && nazione.equals(nave.nazione) && portorif.equals(nave.portorif) && armatore.equals(nave.armatore) && proprietario.equals(nave.proprietario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, tipo, nazione, portorif, armatore, proprietario, lung, larg, alt);
    }

    @Override
    public String toString() {
        return "Nave{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tipo='" + tipo + '\'' +
                ", nazione='" + nazione + '\'' +
                ", portorif='" + portorif + '\'' +
                ", armatore='" + armatore + '\'' +
                ", proprietario='" + proprietario + '\'' +
                ", lung=" + lung +
                ", larg=" + larg +
                ", alt=" + alt +
                '}';
    }
}
