# 🏠 Real Estate API

API imobiliária para imóveis à venda e aluguel com filtros avançados.

## 📋 Sobre o Projeto

Backend para plataforma imobiliária. Gerencia imóveis para venda e aluguel com todas as características relevantes (quartos, banheiros, área, localização). Suporta filtros avançados para buscas personalizadas.

## ✨ Funcionalidades

- ✅ Cadastrar imóveis (apartamento, casa, comercial, terreno)
- ✅ Tipo de anúncio: SALE (venda) ou RENT (aluguel)
- ✅ Filtrar por cidade
- ✅ Filtrar por faixa de preço
- ✅ Filtrar por número mínimo de quartos
- ✅ Filtrar por tipo de imóvel
- ✅ Busca por CEP/bairro
- ✅ Ativar/desativar anúncio

## 🔗 Endpoints

| Método | Rota | Descrição |
|--------|------|-----------|
| GET/POST | `/api/properties` | Listar / Cadastrar imóvel |
| GET | `/api/properties?city=SP&minRooms=2` | Busca com filtros |
| GET | `/api/properties?type=RENT` | Filtrar por tipo |
| GET | `/api/properties?minPrice=300000` | Filtrar por preço |
| GET/PUT/DELETE | `/api/properties/{id}` | Gerenciar imóvel |

## 🛠️ Tecnologias

- Java 17 · Spring Boot 3.2 · MySQL · Maven · Lombok
