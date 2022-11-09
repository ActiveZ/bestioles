package fr.diginamic.bestioles.dto;

import lombok.Data;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserDTO {
    private String userName;
    private String pwd;
    private List<String> roles = new ArrayList<>();
}
