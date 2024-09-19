# Blockchain Académico: Plataforma Descentralizada de Gestión de Credenciales Educativas

## Descripción
Blockchain Académico es una plataforma web descentralizada diseñada para emitir, gestionar y verificar credenciales académicas utilizando tecnología blockchain. Su propósito es ofrecer una solución segura y eficiente para instituciones académicas y usuarios, eliminando la necesidad de intermediarios y garantizando la autenticidad de las credenciales.

## Funcionalidades Principales

- **Emisión de Credenciales Digitales**: Las instituciones académicas pueden emitir certificados digitales para los estudiantes.
- **Gestión de Credenciales**: Los usuarios pueden visualizar, gestionar y compartir sus credenciales de manera segura.
- **Verificación de Credenciales**: Empleadores e instituciones pueden verificar la autenticidad de las credenciales.
- **Almacenamiento en Blockchain**: Las credenciales se almacenan en una blockchain para garantizar su integridad.
- **Enlaces Temporales**: Los usuarios pueden compartir credenciales mediante enlaces temporales.

## Tecnologías Utilizadas

- **Backend**: Java con Spring Boot (Spring Data, Spring Security)
- **Frontend**: React.js
- **Base de Datos**: PostgreSQL
- **Blockchain**: Ethereum o Hyperledger
- **Seguridad**: Cifrado de datos sensibles, autenticación y autorización con Spring Security.

## Requisitos de Instalación

### Prerrequisitos:
- **Java 11** o superior
- **Node.js** (para el frontend)
- **PostgreSQL** o **MongoDB** (según preferencia)
- **Docker** (opcional para despliegue)
- **Maven**

### Instalación:
1. Clonar el repositorio:
    ```bash
    git clone https://github.com/tuusuario/blockchain-academico.git
    ```

2. Backend:
    ```bash
    cd blockchain-academico/backend
    mvn clean install
    mvn spring-boot:run
    ```

3. Frontend:
    ```bash
    cd blockchain-academico/frontend
    npm install
    npm start
    ```

4. Configurar la base de datos y variables de entorno.

## Uso
- **Registrar institución académica**: Para comenzar, una institución académica debe registrarse y configurar su sistema para la emisión de credenciales.
- **Emitir credenciales**: Los administradores de las instituciones pueden emitir credenciales para los estudiantes.
- **Verificar credenciales**: Los empleadores pueden verificar la autenticidad de las credenciales a través de la plataforma.

## Autores
- **Diego A. Berrio Gómez** - Desarrollador Full Stack

## Licencia
Este proyecto está bajo la Licencia MIT.

