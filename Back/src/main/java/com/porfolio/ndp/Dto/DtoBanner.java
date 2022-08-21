
package com.porfolio.ndp.Dto;

import javax.validation.constraints.NotBlank;


public class DtoBanner {
    @NotBlank
    private String img;
    
      //constructores

    public DtoBanner() {
    }

    public DtoBanner(String img) {
        this.img = img;
    }
     // Getters Setters

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    
}
