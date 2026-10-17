package ma.enset.service;

import jakarta.transaction.Transactional;
import ma.enset.dto.BankAccountRequestDTO;
import ma.enset.dto.BankAccountResponseDTO;
import ma.enset.entities.BankAccount;
import ma.enset.mappers.AccountMapper;
import ma.enset.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
@Transactional
public class AcountServiceImpl implements AccountService {
    @Autowired
    private BankAccountRepository bankAccountRepository;
    private AccountMapper accountMapper;
    @Override
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO) {
        BankAccount bankAccount=BankAccount.builder()
                .id(UUID.randomUUID().toString())
                .createdAt(new Date())
                .balance(bankAccountDTO.getBalance())
                .type(bankAccountDTO.getType())
                .currency(bankAccountDTO.getCurrency())
                .build();
        BankAccount saveBankAccount = bankAccountRepository.save(bankAccount);
        BankAccountRequestDTO bankAccountResponseDTO = accountMapper.fromBankAccount(saveBankAccount);
        return bankAccountResponseDTO;
    }
}
