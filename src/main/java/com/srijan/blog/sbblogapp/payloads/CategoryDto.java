package com.srijan.blog.sbblogapp.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {

    private Integer categoryId;

    @NotEmpty
    @Size(min = 3, message = "Min size of category title is 3")
    private String categoryTitle;

    @NotEmpty
    @Size(min = 10, message = "Min size of category description is 10")
    private String categoryDescription;
}
