package ma.enset.entities;

import ma.enset.enums.AccountType;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = BankAccount.class)
public interface AccountProjection {
    public String getId();
    public AccountType gettype();
    public Double getBalance();
}
