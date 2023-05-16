package dev.alexander.swapi.error;

import java.util.UUID;
import lombok.Getter;

@Getter
public class BaseExcception extends RuntimeException {
   
    private final UUID errorId;

    public BaseException(String message){
       
        super(message);
        this.errorId = UUID.randomUUID();
    }
}
