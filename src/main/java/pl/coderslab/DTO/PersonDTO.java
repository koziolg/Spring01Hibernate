package pl.coderslab.DTO;

import org.springframework.stereotype.Component;
import pl.coderslab.model.Gender;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDTO {
    public String[] getCountries(){
        return new String[] {"Polska", "Szwecja", "Czechy"};
    }


    public List<Gender> getGenders(){

        List<Gender> list = new ArrayList<>();
        list.add(new Gender("M", "Male"));
        list.add(new Gender("F", "Female"));
        list.add(new Gender("FTW", "cos"));
        return list;
    }
}
