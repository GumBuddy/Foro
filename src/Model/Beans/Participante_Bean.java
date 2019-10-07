package Model.Beans;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "participante", schema = "foro", catalog = "")
public class Participante_Bean {
    private Integer idParticipante;
    private String usuario;
    private String twit;

    public Participante_Bean(Integer idParticipante, String usuario, String twit) {
        this.idParticipante = idParticipante;
        this.usuario = usuario;
        this.twit = twit;
    }

    public Participante_Bean() {

    }

    @Id
    @Column(name = "id_participante", nullable = false)
    public Integer getIdParticipante() {
        return idParticipante;
    }

    public void setIdParticipante(Integer idParticipante) {
        this.idParticipante = idParticipante;
    }

    @Basic
    @Column(name = "usuario", nullable = false, length = 15)
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Basic
    @Column(name = "twit", nullable = false, length = 250)
    public String getTwit() {
        return twit;
    }

    public void setTwit(String twit) {
        this.twit = twit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participante_Bean that = (Participante_Bean) o;
        return Objects.equals(idParticipante, that.idParticipante) &&
                Objects.equals(usuario, that.usuario) &&
                Objects.equals(twit, that.twit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idParticipante, usuario, twit);
    }
}
