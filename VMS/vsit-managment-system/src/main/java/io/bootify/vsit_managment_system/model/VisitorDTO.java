package io.bootify.vsit_managment_system.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


public class VisitorDTO {

    private Long id;

    @NotNull
    @Size(max = 255)
    private String email;

    @NotNull
    @Size(max = 255)
    private String name;

    @NotNull
    @Size(max = 255)
    private String phone;

    @NotNull
    private Long idNumber;

    private Long address;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(final String phone) {
        this.phone = phone;
    }

    public Long getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(final Long idNumber) {
        this.idNumber = idNumber;
    }

    public Long getAddress() {
        return address;
    }

    public void setAddress(final Long address) {
        this.address = address;
    }

}
