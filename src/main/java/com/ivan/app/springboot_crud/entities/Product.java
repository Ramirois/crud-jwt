package com.ivan.app.springboot_crud.entities;

import com.ivan.app.springboot_crud.validation.IsExistsDb;
import com.ivan.app.springboot_crud.validation.IsRequired;

// import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
// import jakarta.validation.constraints.Min;
// import jakarta.validation.constraints.NotBlank;
// import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
// import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "products")
public class Product{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @IsExistsDb
    private String sku;

    @IsRequired(message = "{IsRequired.product.name}")
    @Size(min = 3, max = 20)
    private String name;

    @NotNull(message = "{NotNull.product.price}")
    private Integer price;

    @IsRequired(message = "{IsRequired.product.description}")
    private String description;

}
