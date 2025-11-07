package com.wvl.negocio.controlador;

import com.wvl.negocio.entidades.Producto;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProductoControlador {
  private ArrayList<Producto> productos;

  public ProductoControlador() {
    productos = new ArrayList<>(List.of(
    new Producto(
    "P001",
    "Tablet Samsung Galaxy Tab S6",
    1299.90,
    "Pantalla AMOLED de 10.5 pulgadas, 128GB de almacenamiento.",
    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSscAFFlSeTKD7HudDqEeCxJaQSWVg-Uu3qpw&s",
    15,
    LocalDate.now().plusMonths(12),
    "Tablets"
    ),
    new Producto(
    "P002",
    "Laptop Lenovo IdeaPad 3",
    2499.50,
    "Procesador Ryzen 5, 8GB RAM, SSD 512GB.",
    "https://p1-ofp.static.pub/fes/cms/2021/12/17/ephit8bi4waypyhk5ayf20s55uhtf3918030.png",
    8,
    LocalDate.now().plusYears(1),
    "Laptops"
    ),
    new Producto(
    "P003",
    "Mouse Logitech M170",
    79.99,
    "Mouse inalámbrico con diseño ergonómico y batería de larga duración.",
    "https://production-tailoy-repo-magento-statics.s3.amazonaws.com/imagenes/872x872/productos/i/m/o/mouse-logitech-m170-wireless-rojo-26369002-default-1.jpg",
    40,
    LocalDate.now().plusYears(2),
    "Periféricos"
    ),
    new Producto(
    "P004",
    "Monitor LG Ultragear 27''",
    1290.00,
    "Monitor gaming 144Hz, resolución Full HD, panel IPS.",
    "https://informaticadataplus.pe/wp-content/uploads/2025/04/Monitor-Gaming-LG-UltraGear-27GS65F-B-27-IPS-FHD-180Hz-1ms-G-Sync.jpg",
    10,
    LocalDate.now().plusMonths(6),
    "Monitores"
    ),
    new Producto(
    "P005",
    "Teclado Mecánico Redragon Kumara",
    189.00,
    "Switches rojos, retroiluminación RGB, diseño compacto.",
    "https://media.falabella.com/falabellaPE/116470435_01/w=800,h=800,fit=pad",
    25,
    LocalDate.now().plusMonths(18),
    "Periféricos"
    ),
    new Producto(
    "P006",
    "Smartphone Xiaomi Redmi Note 13",
    899.90,
    "Pantalla AMOLED, cámara de 108MP, batería de 5000mAh.",
    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRgZrqgaTfOdtLbqtdaLRadgxaOGWGPgSjIig&s",
    30,
    LocalDate.now().plusYears(2),
    "Smartphones"
    ),
    new Producto(
    "P007",
    "Auriculares Sony WH-CH520",
    349.00,
    "Bluetooth, 50 horas de autonomía, sonido estéreo nítido.",
    "https://tecnomad.pro/wp-content/uploads/2023/03/Sony-WH-CH520-Auriculares-Inalambricos-tecnomad.jpg",
    20,
    LocalDate.now().plusMonths(10),
    "Audio"
    ),
    new Producto(
    "P008",
    "Impresora HP DeskJet 2320",
    299.00,
    "Multifuncional: imprime, escanea y copia.",
    "https://cdn.salla.sa/AzvQAP/1c66414c-c696-4e8c-8354-2ed37b206e2f-1000x1000-CasAdzU1zuPUyPI6xXLzI6ZkSdtmEDbSjB5NRwa4.jpg",
    7,
    LocalDate.now().plusYears(3),
    "Impresoras"
    ),
    new Producto(
    "P009",
    "Disco Duro Externo Seagate 2TB",
    379.90,
    "USB 3.0, diseño compacto y resistente.",
    "https://oechsle.vteximg.com.br/arquivos/ids/8127358-1000-1000/image-2fe7dd8f53b84466a812d021cacdccb0.jpg?v=637849626447400000",
    50,
    LocalDate.now().plusYears(4),
    "Almacenamiento"
    ),
    new Producto(
    "P010",
    "Cámara Canon EOS Rebel T7",
    2499.00,
    "Sensor de 24.1 MP, grabación Full HD, Wi-Fi integrado.",
    "https://hiraoka.com.pe/media/catalog/product/0/8/08_k432_frontslantdown_ef-s18-55_is_ii.jpg?quality=80&bg-color=255,255,255&fit=bounds&height=560&width=700&canvas=700:560",
    5,
    LocalDate.now().plusYears(1),
    "Cámaras"
    )
    ));
  }

  public ArrayList<Producto> getProductos() {
    return productos;
  }

  // 🔹 CREATE
  public boolean agregarProducto(Producto nuevo) {
    if (buscarProductoPorId(nuevo.getCodigo()) != null) {
      return false; // ya existe
    }
    productos.add(nuevo);
    return true;
  }

  // 🔹 READ
  public Producto buscarProductoPorId(String id) {
    for (Producto p : productos) {
      if (p.getCodigo().equalsIgnoreCase(id)) {
        return p;
      }
    }
    return null;
  }

  public ArrayList<Producto> listarProductos() {
    return productos;
  }

  // 🔹 UPDATE
  public boolean actualizarProducto(String id, Producto actualizado) {
    for (int i = 0; i < productos.size(); i++) {
      if (productos.get(i).getCodigo().equalsIgnoreCase(id)) {
        productos.set(i, actualizado);
        return true;
      }
    }
    return false;
  }

  // 🔹 DELETE
  public boolean eliminarProducto(String id) {
    return productos.removeIf(p -> p.getCodigo().equalsIgnoreCase(id));
  }
}
