package mx.geckox.myfin.controllers;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.google.gson.Gson;
import mx.geckox.myfin.api.AccountDto;
import mx.geckox.myfin.entities.Account;
import mx.geckox.myfin.repositories.AccountsRepository;
import mx.geckox.myfin.services.AccountsService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@WebMvcTest
public class AccountsControllerTest {
  @MockBean
  private AccountsService accountsService;

  @Autowired
  private MockMvc mockMvc;

  private Gson gson = new Gson();

  @Test
  public void canCreateAccounts() throws Exception {
    Double balance = 1020.21;
    String color = "#665544";
    String name = "BBVA";

    AccountDto payload = new AccountDto(name, balance, color);
    Account account = new Account(name, balance, color);
    account.setId(123L);

    when(accountsService.create(isA(AccountDto.class))).thenReturn(account);

    mockMvc.perform(
        post("/accounts/")
          .contentType(MediaType.APPLICATION_JSON)
          .content(gson.toJson(payload)))
      .andExpect(status().isOk())
      .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
      .andExpect(jsonPath("$.name", is(account.getName())))
      .andExpect(jsonPath("$.id", is(account.getId().intValue())));

    verify(accountsService, atLeastOnce()).create(isA(AccountDto.class));
  }
}
