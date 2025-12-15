<div align="center">

  # 🍊 RoskildeAPI
  
  **Din uofficielle gateway til Roskilde Festival data**

  [![Build Status](https://img.shields.io/badge/build-passing-brightgreen.svg)]()
  [![License: MIT](https://img.shields.io/badge/License-MIT-orange.svg)](https://opensource.org/licenses/MIT)
  [![Version](https://img.shields.io/badge/version-1.0.0-blue.svg)]()
  [![Roskilde Vibes](https://img.shields.io/badge/Festival-Ready-orange)](https://roskilde-festival.dk)

  

  <p>
    <a href="#om-projektet">Om Projektet</a> •
    <a href="#features">Features</a> •
    <a href="#installation">Installation</a> •
    <a href="#api-endpoints">Endpoints</a> •
    <a href="#tech-stack">Teknologi</a>
  </p>
</div>

---

## ⛺ Om Projektet

**RoskildeAPI** er et wrapper-API, vi byggede for at gøre det nemmere at tilgå data omkring Roskilde Festival. Formålet var at strukturere data omkring kunstnere, spilleplaner og scener i et letlæseligt JSON-format, som kan bruges til apps, dataanalyse eller bare for sjov.

> **Bemærk:** Dette er et hobbyprojekt og er ikke officielt tilknyttet Roskilde Festival.

## ✨ Features

* 🎸 **Hent Kunstnere:** Få en komplet liste over alle annoncerede navne.
* 📅 **Spilleplan:** Se hvem der spiller hvornår (sorteret på dage).
* 📍 **Scene-info:** Filtrer koncerter baseret på specifikke scener (Orange, Arena, Avalon, etc.).
* 🔍 **Metadata:** Hent beskrivelser, genrer og billed-links for hver kunstner.

## 🚀 Installation

Følg disse trin for at køre projektet lokalt på din maskine.

### Trin-for-trin

1.  **Klon repositoryet**
    ```bash
    git clone [https://github.com/JonathanRentoft/roskildeAPI.git](https://github.com/JonathanRentoft/roskildeAPI.git)
    cd roskildeAPI
    ```

2.  **Installer afhængigheder**
    ```bash
    npm install
    ```

3.  **Start serveren**
    ```bash
    # Kommando for at starte
    npm start dev
    ```

Serveren kører nu på `http://localhost:3000` (eller din port).

## 📡 API Endpoints

Her er den komplette liste over tilgængelige routes, opdelt efter funktionalitet og adgangskrav.

### 🔐 Autentificering
| Metode | Endpoint | Beskrivelse | Adgang |
| :--- | :--- | :--- | :--- |
| `POST` | `/auth/login` | Log ind og modtag token/session | Alle |
| `POST` | `/auth/register` | Opret ny brugerprofil | Alle |

### 🎸 Kunstnere (Artists)
| Metode | Endpoint | Beskrivelse | Adgang |
| :--- | :--- | :--- | :--- |
| `GET` | `/artists/` | Hent liste over alle kunstnere | Alle |
| `POST` | `/artists/` | Opret en ny kunstner | **Admin** |
| `PUT` | `/artists/{id}/` | Opdater data for en kunstner | **Admin** |
| `DELETE` | `/artists/{id}/` | Slet en kunstner fra programmet | **Admin** |

### ⭐ Favoritter (User)
| Metode | Endpoint | Beskrivelse | Adgang |
| :--- | :--- | :--- | :--- |
| `GET` | `/favorites/` | Se dine egne favoritter | User |
| `POST` | `/favorites/{id}/` | Tilføj kunstner (via ID) til favoritter | User |
| `DELETE` | `/favorites/{id}/` | Fjern kunstner fra favoritter | User |

### ℹ️ System
| Metode | Endpoint | Beskrivelse | Adgang |
| :--- | :--- | :--- | :--- |
| `GET` | `/routes` | Oversigt over alle aktive routes (Javalin) | - |
### Eksempel på response (JSON)

```json
{
    "id": 1,
    "name": "Kendrick Lamar",
    "stage": "Orange Scene",
    "day": "Onsdag",
    "time": "22:00",
    "genre": "Hip Hop",
    "description": "Kongen af moderne rap vender tilbage."
  }
