package com.example.contactmanager.model.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel(description = "Contact details")
public class ContactResource {

    @ApiModelProperty(notes = "unique contact ID")
    private int id;

    @ApiModelProperty(notes = "name of contact")
    private String name;

    @ApiModelProperty(notes = "number of contact")
    private String surname;

    @ApiModelProperty(notes = "age of contact")
    private int age;

    @ApiModelProperty(notes = "phone numbers of contact (mobile + home)")
    private NumbersResource numbers;

}