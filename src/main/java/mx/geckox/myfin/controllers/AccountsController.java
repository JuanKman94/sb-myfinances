package mx.geckox.myfin.controllers;

import mx.geckox.myfin.api.AccountRequest;
import mx.geckox.myfin.entities.Account;
import mx.geckox.myfin.exceptions.ModelNotFoundException;
import mx.geckox.myfin.repositories.AccountsRepository;
import mx.geckox.myfin.services.AccountsService;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/accounts")
public class AccountsController {
  @Autowired
  private AccountsService accountsService;

  private static final Logger log = LogManager.getLogger(AccountsController.class);

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public Iterable<Account> all() {
    return this.accountsService.all();
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public ResponseEntity get(@PathVariable Long id) throws ModelNotFoundException {
    return new ResponseEntity<>(this.accountsService.find(id), HttpStatus.OK);
  }

  @RequestMapping(value = "/", method = RequestMethod.POST)
  public ResponseEntity<?> create(@RequestBody AccountRequest payload) {
    log.info("Creating account with {}", payload);
    return new ResponseEntity<>(this.accountsService.create(payload), HttpStatus.OK);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public ResponseEntity<?> update(
      @PathVariable Long id,
      @RequestBody AccountRequest payload
  ) throws ModelNotFoundException {
    return new ResponseEntity<>(this.accountsService.update(id, payload), HttpStatus.OK);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public ResponseEntity delete(@PathVariable Long id) {
    this.accountsService.delete(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
