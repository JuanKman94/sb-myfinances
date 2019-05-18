package mx.geckox.myfin.services;

import mx.geckox.myfin.api.AccountDto;
import mx.geckox.myfin.entities.Account;
import mx.geckox.myfin.exceptions.ModelNotFoundException;
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

  public Account find(Long id) throws ModelNotFoundException {
    return this.accountsRepository
        .findById(id)
        .orElseThrow(ModelNotFoundException::new);
  }

  public Iterable<Account> all() {
    return accountsRepository.findAll();
  }

  public Account create(AccountDto input) {
    log.info("creating account {}", input);
    Account account = new Account(input.getName(), input.getBalance(), input.getColor());
    log.info("saving account {}", account);

    return this.accountsRepository.save(account);
  }

  public Account update(Long id, AccountDto input) {
    Account account = this.accountsRepository.findById(id).orElseThrow(ModelNotFoundException::new);

    account.setName(input.getName());
    account.setColor(input.getColor());
    account.setBalance(input.getBalance());

    return this.accountsRepository.save(account);
  }

  public void delete(Long id) {
    Account account = this.accountsRepository.findById(id).orElseThrow(ModelNotFoundException::new);
    this.accountsRepository.delete(account);
  }
}
