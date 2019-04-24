package mx.geckox.myfin.repositories;

import mx.geckox.myfin.entities.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountsRepository extends CrudRepository<Account, Long> {
  Account findByName(String name);
}
