package com.wvl.stage4.models;

public class Product {
  private int id;
  private String sku;
  private String name;
  private Double price;
  private String brand;
  private ProductCategory category;

  public Product() {}

  public Product(int id, String sku, String name, Double price, String brand, ProductCategory category) {
    this.id = id;
    this.sku = sku;
    this.name = name;
    this.price = price;
    this.brand = brand;
    this.category = category;
  }

  public int getId() {
    return id;
  }

  public String getSku() {
    return sku;
  }

  public String getName() {
    return name;
  }

  public Double getPrice() {
    return price;
  }

  public String getBrand() {
    return brand;
  }

  public ProductCategory getCategory() {
    return category;
  }

  public Product(int id, String sku, String name, Double price, String brand) {
    this.id = id;
    this.sku = sku;
    this.name = name;
    this.price = price;
    this.brand = brand;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setSku(String sku) {
    this.sku = sku;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public void setCategory(ProductCategory category) {
    this.category = category;
  }

  static Product create(String sku, String name, Double price, String brand) {
    Product product = new Product();
    product.setSku(sku);
    product.setName(name);
    product.setPrice(price);
    product.setBrand(brand);
    return product;
  }
}
