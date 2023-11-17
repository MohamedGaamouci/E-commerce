package com.gmc_team.e_commerse_platform.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

@OpenAPIDefinition(
        info = @Info(
                version = "V1",
                description = "E-commerce Documentation Api 'RestFull Api'",
                contact = @Contact(
                        name = "Gaamouci Mohamed Monsif",
                        email = "gaamoucimohamed@gmail.com"
                ),title = "E_commerce Platform Documentation"
        )
)
@SecurityScheme(
        name = "jwt",
        type = SecuritySchemeType.HTTP,
        scheme = "bearer",
        bearerFormat = "JWT" ,
        in = SecuritySchemeIn.HEADER
)
public class swaggerconfig {


}
