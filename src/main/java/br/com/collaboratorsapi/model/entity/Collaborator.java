package br.com.collaboratorsapi.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Collaborator {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer code;

    @NotNull(message = "response.error.empty.name")
    @Length(min = 3, max = 20, message = "response.error.length.name")
    private String name;

    @NotNull(message = "response.error.empty.login")
    @Length(min = 5, max = 20, message = "response.error.length.login")
    private String login;

    //TODO adicionar validação para enum
    private CollaboratorProfileEnum profile;

    //TODO adicionar validação e analisar conflito com anotação @JSonIgnore
    @JsonIgnore
    //@NotEmpty
    private String password;

    public Collaborator() {
    }

    public Collaborator(String name, String login, CollaboratorProfileEnum profile, String password) {
        this(null, name, login, profile, password);
    }

    public Collaborator(Integer code, String name, String login, CollaboratorProfileEnum profile) {
        this(code, name, login, profile, null);
    }

    public Collaborator(Integer code, String name, String login, CollaboratorProfileEnum profile, String password) {
        this.code = code;
        this.name = name;
        this.login = login;
        this.profile = profile;
        this.password = password;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public CollaboratorProfileEnum getProfile() {
        return profile;
    }

    public void setProfile(CollaboratorProfileEnum profile) {
        this.profile = profile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
