package com.springcloud.mvc.app.form;

import lombok.Data;

//import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.NotNull;

@Data
public class UserLoginForm {


    private String username;

    private String password;

}
