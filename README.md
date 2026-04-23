<div align="center">

# 🚗✨ BrilloCar API

**Sistema de gestión de lavado y detailing automotriz**

![Java](https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.0.6-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-16-316192?style=for-the-badge&logo=postgresql&logoColor=white)
![Gradle](https://img.shields.io/badge/Gradle-8-02303A?style=for-the-badge&logo=gradle&logoColor=white)
![Lombok](https://img.shields.io/badge/Lombok-%E2%9D%A4-red?style=for-the-badge)

</div>

---

## 📖 ¿Qué es BrilloCar?

BrilloCar es una **REST API** construida con Spring Boot para gestionar las operaciones de un negocio de lavado y detailing de vehículos. Permite registrar clientes, vehículos, servicios, órdenes de trabajo y pagos, con validaciones de negocio en cada paso del flujo.

---

## 🏗️ Arquitectura

El proyecto sigue una arquitectura en capas limpia, respetando los principios **SOLID**, **KISS** y **DRY**:

```
BrilloCar/
├── controller/        → Endpoints REST (ClienteController, OrdenController, ...)
├── service/           → Lógica de negocio (interfaces + implementaciones)
├── repository/        → Acceso a datos (Spring Data JPA)
├── model/
│   ├── entity/        → Entidades JPA (Cliente, Vehiculo, OrdenServicio, ...)
│   └── enums/         → Estados y tipos del dominio
├── config/            → Configuración de OpenAPI/Swagger
└── exception/         → Manejo global de excepciones
```

---

## 🧩 Entidades del dominio

| Entidad | Descripción |
|---|---|
| `Cliente` | Propietario del vehículo |
| `Vehiculo` | Vehículo asociado a un cliente |
| `Servicio` | Servicio ofrecido (fijo o precio variable por tipo de vehículo) |
| `OrdenServicio` | Orden de trabajo que agrupa servicios aplicados a un vehículo |
| `ItemServicio` | Línea de detalle dentro de una orden |
| `Pago` | Pago registrado contra una orden finalizada |

### 📊 Enums del sistema

| Enum | Valores |
|---|---|
| `EstadoOrden` | `REGISTRADA` → `EN_PROCESO` → `FINALIZADA` → `ENTREGADA` |
| `EstadoPago` | `PENDIENTE`, `COMPLETADO`, `RECHAZADO` |
| `MetodoPago` | `EFECTIVO`, `TARJETA`, `TRANSFERENCIA` |
| `TipoVehiculo` | `MOTO`, `SEDAN`, `SUV`, `CAMIONETA`, `BUS` |
| `TipoServicio` | Define la categoría del servicio |

---

## 🔄 Flujo de negocio

```
1. Registrar Cliente
       ↓
2. Registrar Vehículo (asociado al cliente)
       ↓
3. Crear Orden de Servicio (vehiculo + cliente)
       ↓
4. Agregar Servicios a la Orden
       ↓
5. Cambiar estado → FINALIZADA
       ↓
6. Registrar Pago (monto debe coincidir con el total)
```

> ⚠️ Solo se puede pagar una orden que esté en estado **FINALIZADA** y sin pago previo.

---

## 🚀 Cómo correr el proyecto

### Prerrequisitos

- Java 21+
- PostgreSQL corriendo en `localhost:5432`
- Base de datos `BrilloCar` creada

### Crear la base de datos

```sql
CREATE DATABASE "BrilloCar";
```

### Correr la app

```bash
./gradlew bootRun
```

La API estará disponible en: **`http://localhost:8080`**

---

## 📚 Documentación interactiva

Una vez levantada la app, podés explorar todos los endpoints en:

🔗 **Swagger UI**: [`http://localhost:8080/swagger-ui.html`](http://localhost:8080/swagger-ui.html)

---

## 🛠️ Stack tecnológico

| Tecnología | Uso |
|---|---|
| Spring Boot 4.0.6 | Framework principal |
| Spring Data JPA | Persistencia |
| Hibernate | ORM |
| PostgreSQL | Base de datos |
| Lombok | Reducción de boilerplate |
| SpringDoc OpenAPI | Documentación Swagger |
| Spring DevTools | Hot reload en desarrollo |
| Gradle | Build tool |

---

## 👨‍💻 Desarrollado por

**Dirkin Yohan** — Proyecto académico · Programación Orientada a Objetos · 6° Semestre

---

<div align="center">
  <sub>Hecho con ☕ y mucho <code>git merge</code> 🤝</sub>
</div>
