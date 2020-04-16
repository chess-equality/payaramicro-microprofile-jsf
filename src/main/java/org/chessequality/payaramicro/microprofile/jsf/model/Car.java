package org.chessequality.payaramicro.microprofile.jsf.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car implements Serializable {

    private static final long serialVersionUID = -6632613576873133822L;

    public String id;
    public String brand;
    public int year;
    public String color;
    public int price;
    public boolean sold;
}
