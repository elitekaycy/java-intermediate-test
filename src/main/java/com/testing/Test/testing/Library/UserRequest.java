package com.testing.Test.testing.Library;

public class UserRequest {

  private String username;
  private String password;

  public UserRequest() {
    // Default constructor required by Jackson for JSON serialization
  }

  public UserRequest(String username, String password) {
    this.username = username;
    this.password = password;
  }

  // Getters and setters

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
}
