package com.wkprojects;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.wkprojects.domain.Address;
import com.wkprojects.domain.Category;
import com.wkprojects.domain.City;
import com.wkprojects.domain.Client;
import com.wkprojects.domain.Demand;
import com.wkprojects.domain.DemandItem;
import com.wkprojects.domain.Payment;
import com.wkprojects.domain.PaymentWithTicket;
import com.wkprojects.domain.PaymentoWithCard;
import com.wkprojects.domain.Product;
import com.wkprojects.domain.State;
import com.wkprojects.domain.enums.ClientType;
import com.wkprojects.domain.enums.PaymentStatus;
import com.wkprojects.repositories.AddressRepository;
import com.wkprojects.repositories.CategoryRepository;
import com.wkprojects.repositories.CityRepository;
import com.wkprojects.repositories.ClientRepository;
import com.wkprojects.repositories.DemandItemRepository;
import com.wkprojects.repositories.DemandRepository;
import com.wkprojects.repositories.PaymentRepository;
import com.wkprojects.repositories.ProductRepository;
import com.wkprojects.repositories.StateRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private StateRepository stateRepository;

	@Autowired
	private CityRepository cityRepository;

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private DemandRepository demandRepository;
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private DemandItemRepository demandItemRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Category cat1 = new Category(null, "Informática");
		Category cat2 = new Category(null, "Escritório");
		Category cat3 = new Category(null, "Cama, mesa e Banho");
		Category cat4 = new Category(null, "Eletrônicos");
		Category cat5 = new Category(null, "Jardinagem");
		Category cat6 = new Category(null, "Decoração");
		Category cat7 = new Category(null, "Perfumaria");

		Product p1 = new Product(null, "Computador", 2000.00);
		Product p2 = new Product(null, "Impressora", 800.00);
		Product p3 = new Product(null, "Mouse", 80.00);

		cat1.getProducts().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProducts().addAll(Arrays.asList(p2));

		p1.getCategories().addAll(Arrays.asList(cat1));
		p2.getCategories().addAll(Arrays.asList(cat1, cat2));
		p3.getCategories().addAll(Arrays.asList(cat1));

		State st1 = new State(null, "Minas Gerais");
		State st2 = new State(null, "São Paulo");

		City c1 = new City(null, "Uberlândia", st1);
		City c2 = new City(null, "São Paulo", st2);
		City c3 = new City(null, "Campinas", st2);

		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7));
		productRepository.saveAll(Arrays.asList(p1, p2, p3));

		st1.getCities().addAll(Arrays.asList(c1));
		st2.getCities().addAll(Arrays.asList(c2, c3));

		stateRepository.saveAll(Arrays.asList(st1, st2));
		cityRepository.saveAll(Arrays.asList(c1, c2, c3));

		Client cli1 = new Client(null, "Maria Silva", "maria@gmail.com", "36378912377", ClientType.PHYSICALPERSON);

		cli1.getTelephone().addAll(Arrays.asList("27363323", "93838393"));

		Address a1 = new Address(null, "Rua Flores", "300", "Apto 303", "Jardim", "38220834", cli1, c1);
		Address a2 = new Address(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cli1, c2);

		cli1.getAddresses().addAll(Arrays.asList(a1, a2));

		clientRepository.saveAll(Arrays.asList(cli1));
		addressRepository.saveAll(Arrays.asList(a1, a2));

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		Demand dem1 = new Demand(null, sdf.parse("30/09/2017 10:32"), cli1, a1);
		Demand dem2 = new Demand(null, sdf.parse("10/10/2017 19:35"), cli1, a2);

		Payment pay1 = new PaymentoWithCard(null, PaymentStatus.SETTLED, dem1, 6);
		dem1.setPayment(pay1);

		Payment pay2 = new PaymentWithTicket(null, PaymentStatus.PENDING, dem2, sdf.parse("20/10/2017 00:00"),
				null);
		dem2.setPayment(pay2);

		cli1.getDemands().addAll(Arrays.asList(dem1, dem2));

		demandRepository.saveAll(Arrays.asList(dem1, dem2));
		paymentRepository.saveAll(Arrays.asList(pay1, pay2));
		
		DemandItem ip1 = new DemandItem(dem1, p1,1, 2000.00, 0.00);
		DemandItem ip2 = new DemandItem(dem1, p3, 2, 80.00, 0.00);
		DemandItem ip3 = new DemandItem(dem2, p2,1, 800.00, 100.00);
		
		dem1.getItems().addAll(Arrays.asList(ip1, ip2));
		dem2.getItems().addAll(Arrays.asList(ip3));
		
		p1.getItems().addAll(Arrays.asList(ip1));
		p2.getItems().addAll(Arrays.asList(ip3));
		p3.getItems().addAll(Arrays.asList(ip2));
		
		demandItemRepository.saveAll(Arrays.asList(ip1, ip2, ip3));

	}

}
