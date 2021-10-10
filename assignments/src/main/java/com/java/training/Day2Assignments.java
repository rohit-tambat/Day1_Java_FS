package com.java.training;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Day2Assignments {
	static List<Product> productList= null;
	static List<Order> orderList = null;
	
	public static void main(String...args) {
		
		//Obtain a list of products belongs to category “Books” with price > 100
		System.out.println("------1.Obtain a list of products belongs to category “Books” with price > 100---");
		productList.stream().filter(x->x.getCategory().equalsIgnoreCase("Book")).filter(x->x.getPrice() > 100).forEach(System.out::println);
		
		//Obtain a list of order with products belong to category “Baby”
		System.out.println("------2.Obtain a list of order with products belong to category “Baby”---");
		orderList.stream().filter(x->x.getProducts().stream().anyMatch(p->p.getCategory().equalsIgnoreCase("Baby"))).forEach(System.out::println);
		
		//Obtain a list of product with category = “Toys” and then apply 10% discount
		System.out.println("------3.Obtain a list of product with category = “Toys” and then apply 10% discount---");
		System.out.println("Discounted Toys price="+productList.stream().filter(x->x.getCategory().equalsIgnoreCase("Toys")).mapToDouble(Product::getPrice).sum()*0.10);
		
		//Get the cheapest products of “Books” category
		System.out.println("------4.Get the cheapest products of “Books” categoryt---");
		System.out.println("Cheapest Book Product="+productList.stream().collect(Collectors.minBy(Comparator.comparing(Product::getPrice))).get());
		
		//Get the 3 most recent placed order
		System.out.println("------5.Get the 3 most recent placed order---");
		orderList.stream().sorted(Comparator.comparing(Order::getOrderDate)).limit(2).collect(Collectors.toList()).forEach(System.out::println);
		
		//Obtain a collection of statistic figures (i.e. sum, average, max, min, count) for all products of category “Books”
		System.out.println("------6.Obtain a collection of statistic figures (i.e. sum, average, max, min, count) for all products of category “Books”---");
		System.out.println("Sum Price="+productList.stream().filter(x->x.getCategory().equalsIgnoreCase("Book")).mapToDouble(Product::getPrice).sum());
		System.out.println("Average Price="+productList.stream().filter(x->x.getCategory().equalsIgnoreCase("Book")).mapToDouble(Product::getPrice).average().getAsDouble());
		System.out.println("Max Price="+productList.stream().filter(x->x.getCategory().equalsIgnoreCase("Book")).mapToDouble(Product::getPrice).max().getAsDouble());
		System.out.println("Min Price="+productList.stream().filter(x->x.getCategory().equalsIgnoreCase("Book")).mapToDouble(Product::getPrice).min().getAsDouble());
		System.out.println("Count Price="+productList.stream().filter(x->x.getCategory().equalsIgnoreCase("Book")).mapToDouble(Product::getPrice).count());
	}
	
	//Use static initializer to create ProductList, OrderList and CustomerList which contains sample Product, Order and Customer
	static {
		//Product(Long id, String name, String category, Double price)
		Product p1 = new Product(123L,"Product1","Book",120.0);
		Product p2 = new Product(456L,"Product2","Book",110.0);
		Product p3 = new Product(789L,"Product3","Book",12.5);
		Product p4 = new Product(156L,"Product4","Baby",32.5);
		Product p5 = new Product(856L,"Product5","Baby",02.5);
		Product p6 = new Product(154L,"Product6","Toys",100.0);
		Product p7 = new Product(859L,"Product7","Toys",200.0);
		productList = Arrays.asList(p1,p2,p3,p4,p5,p6,p7);
		//Customer(Long id, String name, Integer tier)
		Customer c1 =  new Customer(1L, "Customer1", 1);
		Customer c2 = new Customer(2L, "Customer2", 2);	
		Customer c3 = new Customer(3L, "Customer3", 3);	
		//Order(Long id, String status, LocalDate orderDate, LocalDate deliveryDate, List<Product> products,Customer customer) 
		Order o1 = new Order(1L,"Active",LocalDate.of(2021, 7, 1),LocalDate.of(2021, 7, 4),Arrays.asList(p1,p2),c1);
		Order o2 = new Order(2L,"Delivered",LocalDate.of(2021, 7, 2),LocalDate.of(2021, 7, 3),Arrays.asList(p1,p2,p3,p4),c2);
		Order o3 = new Order(3L,"Delivered",LocalDate.of(2021, 7, 3),LocalDate.of(2021, 7, 3),Arrays.asList(p1,p2,p5,p4),c2);
		
		orderList = Arrays.asList(o1,o2,o3);		
		 
	}

}

class Product{
	
	private Long id;
	private String name;
	private String category;
	private Double price;
	
	public Product(Long id, String name, String category, Double price) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.price = price;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", category=" + category + ", price=" + price + "]";
	}

}

class Order{

	private Long id;
	private String status;
	private LocalDate orderDate;
	private LocalDate deliveryDate;
	List<Product> products;
	Customer customer;
	
	public Order(Long id, String status, LocalDate orderDate, LocalDate deliveryDate, List<Product> products,
			Customer customer) {
		super();
		this.id = id;
		this.status = status;
		this.orderDate = orderDate;
		this.deliveryDate = deliveryDate;
		this.products = products;
		this.customer = customer;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(LocalDate deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", status=" + status + ", orderDate=" + orderDate + ", deliveryDate=" + deliveryDate
				+ ", products=" + products + ", customer=" + customer + "]";
	}

}

class Customer{
	
	private Long id;
	private String name;
	private Integer tier;
	
	public Customer(Long id, String name, Integer tier) {
		super();
		this.id = id;
		this.name = name;
		this.tier = tier;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getTier() {
		return tier;
	}
	public void setTier(Integer tier) {
		this.tier = tier;
	}
}