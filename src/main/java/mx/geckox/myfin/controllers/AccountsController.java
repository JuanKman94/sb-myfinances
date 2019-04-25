package mx.geckox.myfin.controllers;

import mx.geckox.myfin.api.AccountDto;
import mx.geckox.myfin.entities.Account;
import mx.geckox.myfin.repositories.AccountsRepository;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/accounts")
public class AccountsController {
  @Autowired
  private AccountsRepository accountsRepository;

  private static final Logger log = LogManager.getLogger(AccountsController.class);

  @RequestMapping("/")
  public Iterable<Account> all() {
    return accountsRepository.findAll();
  }

  @RequestMapping(value = "/", method = RequestMethod.POST)
  public ResponseEntity<?> create(@RequestBody AccountDto input) {
    Account account = new Account(input.getName(), input.getBalance(), input.getColor());
    log.info("Creating account with {}", account);
    return new ResponseEntity<Account>(this.accountsRepository.save(account), HttpStatus.OK);
  }
}
