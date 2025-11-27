package com.projetouninove.saldosmart.infrastructure.config;

import com.projetouninove.saldosmart.infrastructure.entity.Category;
import com.projetouninove.saldosmart.infrastructure.entity.Transaction;
import com.projetouninove.saldosmart.infrastructure.entity.TransactionType;
import com.projetouninove.saldosmart.infrastructure.repository.CategoryRepository;
import com.projetouninove.saldosmart.infrastructure.repository.TransactionRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

@Component
@Profile("dev")
public class DatabaseSeeder {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    private Random random = new Random();

    @PostConstruct
    public void seeder() {
        var categories = List.of(
            Category.builder().name("Educação").icon("Book").build(),
            Category.builder().name("Transporte").icon("Bus").build(),
            Category.builder().name("Lazer").icon("Dices").build()
        );

        categoryRepository.saveAll(categories);

        var descriptions = List.of(
            "Livro de Java da Faculdade", "Mensalidade da Faculdade", "Bilhere Único", "Taxa do Uber",
            "Cinema domingo", "Futebol com amigos", "Cerveja gelada", "Entretenimento"
        );

        for(int i = 0; i < 50; i++) {
            transactionRepository.saveAll(List.of(
                Transaction.builder()
                            .description(descriptions.get(random.nextInt(descriptions.size())))
                            .amount(BigDecimal.valueOf(random.nextDouble() * 500))
                            .date(LocalDate.now().minusDays(random.nextInt(7)))
                            .type(TransactionType.EXPENSE)
                            .category(categories.get(random.nextInt(categories.size())))
                            .build()
            ));
        }
    }
}
