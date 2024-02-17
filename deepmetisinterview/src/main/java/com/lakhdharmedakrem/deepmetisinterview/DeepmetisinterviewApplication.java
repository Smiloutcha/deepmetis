package com.lakhdharmedakrem.deepmetisinterview;

import com.lakhdharmedakrem.deepmetisinterview.dto.ClientOrderRequestDto;
import com.lakhdharmedakrem.deepmetisinterview.mapper.ClientOrderMapper;
import com.lakhdharmedakrem.deepmetisinterview.model.ClientOrder;
import com.lakhdharmedakrem.deepmetisinterview.model.Ingredient;
import com.lakhdharmedakrem.deepmetisinterview.model.Sandwich;
import com.lakhdharmedakrem.deepmetisinterview.model.SandwichOrder;
import com.lakhdharmedakrem.deepmetisinterview.repository.ClientOrderRepository;
import com.lakhdharmedakrem.deepmetisinterview.repository.SandwichOrderRepository;
import com.lakhdharmedakrem.deepmetisinterview.repository.SandwichRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class DeepmetisinterviewApplication {



	public static void main(String[] args) {
		SpringApplication.run(DeepmetisinterviewApplication.class, args);
	}



}
