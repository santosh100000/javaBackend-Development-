package io.bootify.vsit_managment_system.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


public class UserDTO {

    private Long id;

    @Size(max = 255)
    private String name;

    @Size(max = 255)
    private String email;

    @NotNull
    @Size(max = 255)
    private String phone;

    @Size(max = 255)
    private String role;

    @NotNull
    private UserStatus status;

    private Long flat;

    private Long address;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(final String phone) {
        this.phone = phone;
    }

    public String getRole() {
        return role;
    }

    public void setRole(final String role) {
        this.role = role;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(final UserStatus status) {
        this.status = status;
    }

    public Long getFlat() {
        return flat;
    }

    public void setFlat(final Long flat) {
        this.flat = flat;
    }

    public Long getAddress() {
        return address;
    }

    public void setAddress(final Long address) {
        this.address = address;
    }

}
