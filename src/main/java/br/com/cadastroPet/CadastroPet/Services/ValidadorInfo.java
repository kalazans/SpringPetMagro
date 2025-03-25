package br.com.cadastroPet.CadastroPet.Services;

import br.com.cadastroPet.CadastroPet.Infra.Exceptions.IdadeInvalidaException;
import br.com.cadastroPet.CadastroPet.Infra.Exceptions.PesoInvalidoException;
import br.com.cadastroPet.CadastroPet.Infra.Exceptions.ValidarException;
import br.com.cadastroPet.CadastroPet.Model.Adress;
import br.com.cadastroPet.CadastroPet.Model.SEXO;
import br.com.cadastroPet.CadastroPet.Model.TIPO;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidadorInfo {

    public static String validarFirstName(String firstName){
        String regex = "([a-zA-Z])+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(firstName);
        if(matcher.matches()==false|| firstName.matches("null|NULL|\\s")){
            throw new ValidarException("somente letras, voce digitou -> "+firstName);
        }
        else{
            return firstName;
        }
    }
    public static String validarLastName(String lastName){
        String regex = "([a-zA-Z])+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(lastName);
        if(matcher.matches()==false){
            throw new ValidarException("somente letras, voce digitou -> "+lastName);
        }
        else{
            return lastName.trim();
        }
    }

    public static SEXO validarSexo(String sexo){
        String regex = "(MACHO|FEMEA)?";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(sexo.toUpperCase());
        if(matcher.matches() == false){
            throw new ValidarException("sexo invalido! SOMENTE MACHO OU FEMEA ! vode difitou -> "+sexo);
        } else{
            return SEXO.valueOf(sexo.toUpperCase());
        }
    }

    public static Double validarAge(String age){
        Double ageD = Double.parseDouble(age);
        String regex = "([0-9])+([.,])?([0-9])+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(ageD.toString());
        if(matcher.matches() == false) throw new ValidarException("somente numero!! recebido -> "+age);
        if(Double.parseDouble(age.replace(",","."))>20){
            throw  new IdadeInvalidaException("idade nao pode ser maior que 20! recebido -> "+age);
        } else {
            return Double.parseDouble(age.replace(",","."));
        }
    }
    public static Double validarWeight(String weight){
        Double weightD = Double.parseDouble(weight);
        String regex = "([0-9])+([.,])?([0-9])+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(weightD.toString());
        if(matcher.matches() == false) throw new ValidarException("somente numero!! voce digitou -> "+weight);

        if(Double.parseDouble(weight.replace(",","."))>60 ||Double.parseDouble(weight.replace(",","."))<0.5){
            throw new PesoInvalidoException("nao pode peso acima de 60 ou menor que 0.5!! recebido -> "+weight);
        } else{
            return Double.parseDouble(weight.replace(",","."));
        }


    }
    public static String validarBreed(String breed){
        String regex = "([a-zA-z\\s])+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(breed);
        if(matcher.matches() == false){
            throw new ValidarException("somente letras!! voce digitou ->"+breed);
        }
        else{
            return breed;
        }
    }

    public static TIPO validarType(String type){
        String regex = "(GATO|CACHORRO|PASSARO)?";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(type.toUpperCase());
        String foundType="";
        if(matcher.find() == false){
            throw new ValidarException("animal nao aceito!! somente gato,cachorro, passaro!! voce digitou -> "+type);
        }
        return TIPO.valueOf(matcher.group());


    }

    public static boolean validarTypeParameter(String typeParameter){
        String regex = "(GATO|CACHORRO|PASSARO)?";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(typeParameter.toUpperCase());
        String foundType="";
        if(matcher.find() == false){
            throw new ValidarException("animal nao aceito!! somente gato,cachorro, passaro!! voce digitou -> "+typeParameter);
        }
        else{
            return true;
        }

    }
    public static boolean validarNomeParamter(String nomeParameter){
        String regex = "([a-zA-z\\s])+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(nomeParameter);
        if(matcher.matches() == false){
            throw new ValidarException("somente letras!! voce digitou ->"+nomeParameter);
        }
        else{
            return true;
        }
    }
    public static boolean validarBreedParameter(String breedParameter){
        String regex = "([a-zA-z\\s])+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(breedParameter);
        if(matcher.matches() == false){
            throw new ValidarException("somente letras!! voce digitou ->"+breedParameter);
        }
        else{
            return true;
        }
    }


    public static String validarRua(String rua){
        String regex = "([a-zA-z\\s])+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(rua);
        if(matcher.matches() == false){
            throw new ValidarException("somente letras! voce digitou -> "+rua);
        } else{
            return rua;
        }

    }
    public static String validarCidade(String cidade){
        String regex = "([a-zA-z\\s])+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(cidade);
        if(matcher.matches() == false){
            throw new ValidarException("somente letras! voce digitou -> "+cidade);
        } else{
            return cidade;
        }

    }

    public static String validarNumero(String numero){
        String regex = "([0-9])+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(numero);
        if(matcher.matches() == false){
            throw new ValidarException("somente numeros! voce digitou -> "+numero);
        } else{
            return numero;
        }
    }
    public static String validarNotNullorBlank(String key){
        if(key.equals("")||key.equalsIgnoreCase("null")){
            throw new ValidarException("campo nao poder ser vazio ou null");
        } else{
            return key;
        }
    }


}
