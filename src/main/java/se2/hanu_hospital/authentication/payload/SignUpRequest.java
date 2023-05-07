package se2.hanu_hospital.authentication.payload;

import se2.hanu_hospital.account.model.Role;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SignUpRequest {
    @NotBlank
    @Size(min = 2, max = 40)
    private String name;

    @NotBlank
    @Size(min = 3, max = 15)
    private String username;

    @NotBlank
    @Size(min = 10, max = 10)
    private String phoneNumber;

    @Size(max = 255)
    private String address;

    @NotBlank
    @Size(min = 6, max = 20)
    private String password;

    @NotNull
    private Role role;

    public SignUpRequest(String name, String username, String phoneNumber, String address, String password, Role role) {
        this.name = name;
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.password = password;
        this.role = role;
    }

    public SignUpRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
