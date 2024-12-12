package com.example.config;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.security.enterprise.authentication.mechanism.http.FormAuthenticationMechanismDefinition;
import jakarta.security.enterprise.authentication.mechanism.http.LoginToContinue;
import jakarta.security.enterprise.credential.UsernamePasswordCredential;
import jakarta.security.enterprise.identitystore.CredentialValidationResult;
import jakarta.security.enterprise.identitystore.IdentityStore;

import java.util.HashMap;

import java.util.Set;

@FormAuthenticationMechanismDefinition(
  loginToContinue = @LoginToContinue(
    loginPage = "/login.html",
    errorPage = "/login-error.html")
)
@ApplicationScoped
public class SecurityConfig implements IdentityStore {
  private static final HashMap<String, String> users = new HashMap<>();
  private static final HashMap<String, Set<String>> roles = new HashMap<>();

  static {
    users.put("admin", "1234");
    users.put("user", "1234");

    roles.put("admin", Set.of("ADMIN"));
    roles.put("user", Set.of("USER"));
  }

  public CredentialValidationResult validate(UsernamePasswordCredential credential) {
    String caller = credential.getCaller();
    String password = users.get(caller);

    if (password != null && password.equals(credential.getPasswordAsString())) {
      return new CredentialValidationResult(caller, roles.get(caller));
    }

    return CredentialValidationResult.INVALID_RESULT;
  }

  @PostConstruct
  public void testValidation() {
    UsernamePasswordCredential credential = new UsernamePasswordCredential("user", "1234");
    CredentialValidationResult result = validate(credential);
    if (result.getStatus() == CredentialValidationResult.Status.VALID) {
      System.out.println("Validation successful: " + result.getCallerPrincipal().getName());
    } else {
      System.out.println("Validation failed");
    }
  }
}
