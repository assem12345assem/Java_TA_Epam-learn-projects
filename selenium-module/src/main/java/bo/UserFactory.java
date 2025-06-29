package bo;

import util.DataLoader;

public class UserFactory {
  public static User validUser() {
    return new User(
        DataLoader.loadProperty("email"),
        DataLoader.loadProperty("password"));
  }
}
