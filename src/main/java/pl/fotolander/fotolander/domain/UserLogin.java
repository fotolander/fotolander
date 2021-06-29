package pl.fotolander.fotolander.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserLogin {
    private String gmail;
    private String password;
}
