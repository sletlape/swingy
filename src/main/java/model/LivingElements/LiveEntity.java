package model.LivingElements;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.awt.*;

@Getter @Setter

public abstract class LiveEntity {

 //   @NotBlank(message = "Username cannot be null")
    @Size(min = 3, max = 10, message = "Username should be between 3 and 10 characters long!")
    protected String name;

    protected int hp;
    protected int xp;
    protected int level;
    protected Point point;

    public LiveEntity(String name, int hp, int xp, int level) {
        this.name = name;
        this.hp = hp;
        this.xp = xp;
        this.level = level;
        this.point = new Point();
    }
}
