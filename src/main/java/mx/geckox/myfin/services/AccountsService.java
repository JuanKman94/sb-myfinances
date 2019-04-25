package mx.geckox.myfin.services;

import mx.geckox.myfin.api.AccountDto;
import mx.geckox.myfin.entities.Account;
import mx.geckox.myfin.repositories.AccountsRepository;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountsService {
  @Autowired
  private AccountsRepository accountsRepository;

  private static final Logger log = LogManager.getLogger(AccountsService.class);

  public Account create(AccountDto input) {
    log.info("creating account {}", input);
    Account account = new Account(input.getName(), input.getBalance(), input.getColor());
    log.info("saving account {}", account);
    
    return this.accountsRepository.save(account);
  }

  public Iterable<Account> all() {
    return accountsRepository.findAll();
  }
}
