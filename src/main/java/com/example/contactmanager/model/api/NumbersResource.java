package com.example.contactmanager.model.api;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;


@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@ApiModel(description = "numbers for Contact model")
public class NumbersResource {

    @ApiModelProperty(notes = "unique number ID")
    private int n_id;

    @ApiModelProperty(notes = "home phone number ")
    private String homeNumber;

    @ApiModelProperty(notes = "mobile phone number")
    private String mobileNumber;
}
