package ma.enset.mappers;

import ma.enset.dto.BankAccountRequestDTO;
import ma.enset.entities.BankAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;


@Component
public class AccountMapper {
    public BankAccountRequestDTO fromBankAccount(BankAccount bankAccount){
        BankAccountRequestDTO bankAccountRequestDTO=new BankAccountRequestDTO();
        BeanUtils.copyProperties(bankAccount ,bankAccountRequestDTO)
        return bankAccountRequestDTO;
    }
}
