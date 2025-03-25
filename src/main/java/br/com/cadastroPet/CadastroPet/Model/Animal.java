package br.com.cadastroPet.CadastroPet.Model;

import br.com.cadastroPet.CadastroPet.DTOS.AtualizarInfoDTO;
import br.com.cadastroPet.CadastroPet.DTOS.CadastroDTO;
import br.com.cadastroPet.CadastroPet.Services.ValidadorInfo;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Objects;
@Entity
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private TIPO type;
    private String firstName;
    private String lastName;
    @Enumerated(EnumType.STRING)
    private SEXO sex;
    @Embedded
    private Adress adress;
    private Double age;
    private Double weight;
    private String breed;
    private LocalDate date;

    public LocalDate getDate() {
        return date;
    }

    public Long getId() {
        return id;
    }

    public TIPO getType() {
        return type;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public SEXO getSex() {
        return sex;
    }

    public Adress getAdress() {
        return adress;
    }

    public Double getAge() {
        return age;
    }

    public Double getWeight() {
        return weight;
    }

    public String getBreed() {
        return breed;
    }
    public String getAgeConfigurado(){
        String age = (this.getAge()<1)? this.getAge().toString()+"meses":this.getAge().toString()+"anos";
        return age;
    }

    public void setAge(Double age) {
        this.age = age;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "tipo=" + type +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", sex=" + sex +
                ", adress=" + adress +
                ", age=" + age +
                ", peso=" + weight +
                ", breed='" + breed + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(id, animal.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public Animal(){}

    public Animal(CadastroDTO cadastroDTO){
        this.firstName = ValidadorInfo.validarFirstName(cadastroDTO.name());
        this.lastName = ValidadorInfo.validarLastName(cadastroDTO.lastName());
        this.type = ValidadorInfo.validarType(cadastroDTO.type());
        this.weight = ValidadorInfo.validarWeight(cadastroDTO.weight());
        this.age = ValidadorInfo.validarAge(cadastroDTO.age());
        this.breed = ValidadorInfo.validarBreed(cadastroDTO.breed());
        this.sex = ValidadorInfo.validarSexo(cadastroDTO.sexo());
        this.adress = new Adress(cadastroDTO.adress());
        this.date = LocalDate.now();

    }

    public void atualizar(AtualizarInfoDTO atualizarInfoDTO){
        this.setAge(ValidadorInfo.validarAge(atualizarInfoDTO.age()));
        this.setWeight(ValidadorInfo.validarWeight(atualizarInfoDTO.weight()));
    }
}
