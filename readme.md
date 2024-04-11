**Flujo funcional**

1. **Definición de Requisitos**:
   1. Identificar los requisitos del sistema relacionados con la gestión de comprobantes de ventas.
   1. Requerimientos como la capacidad de calcular totales de ventas, almacenar información de clientes y artículos son fundamentales.
1. **Diseño de Clases**:
   1. Definir las clases principales del sistema, como Articulo, Cliente, ComprobanteVentasCabezal, ComprobanteVentasDetalle y PedidoVentasCabezal.
   1. Establecer las relaciones entre estas clases, como la relación entre ComprobanteVentasCabezal y ComprobanteVentasDetalle, y entre PedidoVentasCabezal y PedidoVentasDetalle.
1. **Implementación de la Interfaz *CalcularTotal***:
   1. Crear la interfaz CalcularTotal con el método calcularTotal().
   1. Esta interfaz permite que las clases que necesiten calcular totales implementen este método de manera uniforme.
1. **Desarrollo de las Clases de Modelo**:
   1. Implementar las clases del modelo, como Articulo, Cliente, ComprobanteVentasCabezal, ComprobanteVentasDetalle, PedidoVentaCabezal y PedidoVentasDetalle.
   1. Cada clase debe tener sus propiedades y métodos necesarios para representar y operar con los datos relacionados con los comprobantes de ventas.
1. **Manejo de Excepciones**:
   1. Implementar el manejo de excepciones, como PrecioNegativoException y CantidadNegativaException, para manejar casos en los que los precios o cantidades no sean válidos.
1. **Pruebas Unitarias**:
   1. Desarrollar pruebas unitarias para cada clase y método.
   1. Las pruebas deben verificar que los cálculos y operaciones en las clases se comporten como se espera y manejen los casos de error de manera adecuada.







**Descripcion Funcional:**

El presente es un desarrollo que proporciona un modelo básico para gestionar comprobantes de ventas, implementando pedidos. Descripcion funcional de cada clase:

1) **Articulo**: Representa un artículo que puede ser vendido. Contiene un código, una descripción y un precio. Se valida que el precio no sea negativo al crear una instancia de esta clase.
1) **Cliente**: Representa un cliente que realiza la compra. Contiene un código y una descripción.
1) **ComprobanteVentasCabezal**: Es una clase abstracta que sirve como base para los encabezados de los comprobantes de ventas. Contiene la fecha del comprobante, un número de pedido generado automáticamente y la información del cliente.
1) **ComprobanteVentasDetalle**: También es una clase abstracta que representa los detalles de los comprobantes de ventas. Contiene una lista de artículos y la cantidad de cada artículo en el detalle.
1) **PedidoVentasCabezal**: Una implementación concreta de ComprobanteVentasCabezal que representa un pedido de ventas específico. Además de heredar los campos de ComprobanteVentasCabezal, tiene una lista de detalles de pedido.
1) **PedidoVentasDetalle**: Una implementación concreta de ComprobanteVentasDetalle para los detalles de un pedido de ventas. Además de heredar los campos de ComprobanteVentasDetalle, tiene un método para calcular el subtotal del pedido basado en los artículos y sus precios.

Por su parte la interfaz **CalcularTotal** en este contexto es una abstracción que define un método para calcular el total de un comprobante de ventas. Esta interfaz permite que las clases que la implementen proporcionen una implementación específica de cómo calcular el total según las reglas de negocio del sistema. 

Aquí hay algunos puntos importantes sobre dicha interfaz:

1. **Abstracción**: Proporciona una abstracción para el cálculo del total de un comprobante de ventas, lo que significa que no especifica cómo debe realizarse el cálculo, sino que simplemente define que debe existir un método para ello.
1. **Reutilización de código**: Al definir una interfaz común para calcular el total, se facilita la reutilización del código en diferentes clases que necesiten realizar esta operación.
1. **Flexibilidad**: Permite que las clases concretas que implementen la interfaz proporcionen su propia lógica de cálculo de total, lo que las hace flexibles y adaptables a diferentes requerimientos.
1. **Desacoplamiento**: Ayuda a desacoplar el código al proporcionar una capa de abstracción entre las clases que necesitan calcular el total y la implementación concreta de cómo se realiza ese cálculo.

El polimorfismo se ve en varias partes:

- Interfaz **CalcularTotal**: La interfaz define un método calcularTotal(), el cual es implementado de forma diferente por cada clase que la implementa. Esto permite que diferentes objetos que implementan la interfaz CalcularTotal puedan ser tratados de manera uniforme a través de una referencia de la interfaz, pero cada uno puede tener su propia implementación del método calcularTotal().
- Método **calcularTotal**() en las clases concretas: Cada clase concreta que implementa la interfaz CalcularTotal (como PedidoVentasCabezal) proporciona su propia implementación del método calcularTotal(). A pesar de que estos métodos tienen la misma firma en la interfaz, cada uno puede ejecutar un comportamiento diferente, dependiendo de la lógica específica de la clase. Esto demuestra polimorfismo, ya que objetos de diferentes clases pueden responder al mismo mensaje (calcularTotal()) de manera diferente.

- Método **calcularSubtotal**() en la clase PedidoVentasDetalle: Este método también muestra polimorfismo, ya que es una implementación específica de la clase PedidoVentasDetalle. Aunque podría haber otras clases que implementen un método con el mismo nombre y firma, cada una podría tener su propia lógica de cálculo, permitiendo que el mismo método sea invocado en diferentes contextos pero con resultados específicos para cada clase.

La diferencia es que calcularSubtotal() calcula el costo de una parte específica del pedido (es decir, un detalle de pedido), mientras que calcularTotal() calcula el costo total de todo el pedido sumando los subtotales de cada detalle.



