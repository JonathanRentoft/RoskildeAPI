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

## 🛠️ Tech Stack

Dette API er bygget med fokus på hastighed og enkelhed.

* **Sprog:** [F.eks. Python / Node.js]
* **Framework:** [F.eks. Flask / Express / FastAPI]
* **Database:** [F.eks. MongoDB / JSON-fil / SQLite]
* **Scraping:** [F.eks. BeautifulSoup / Cheerio]

## 🚀 Installation

Følg disse trin for at køre projektet lokalt på din maskine.

### Forudsætninger
* [Node.js / Python installeret]
* Git

### Trin-for-trin

1.  **Klon repositoryet**
    ```bash
    git clone [https://github.com/dit-brugernavn/roskildeAPI.git](https://github.com/dit-brugernavn/roskildeAPI.git)
    cd roskildeAPI
    ```

2.  **Installer afhængigheder**
    ```bash
    # Hvis det er Node.js
    npm install

    # Hvis det er Python
    pip install -r requirements.txt
    ```

3.  **Start serveren**
    ```bash
    # Kommando for at starte
    npm start / python app.py
    ```

Serveren kører nu på `http://localhost:3000` (eller din port).

## 📡 API Endpoints

Her er en oversigt over de vigtigste endpoints, du kan kalde.

| Metode | Endpoint | Beskrivelse | Eksempel |
| :--- | :--- | :--- | :--- |
| `GET` | `/api/artists` | Henter alle kunstnere | `[{"name": "Kendrick Lamar", ...}]` |
| `GET` | `/api/schedule` | Henter fuld tidsplan | `{"Wednesday": [...]}` |
| `GET` | `/api/stages` | Liste over scener | `["Orange", "Arena", ...]` |
| `GET` | `/api/artist/:id` | Detaljer om én kunstner | `{"id": 42, "bio": "..."}` |

### Eksempel på response (JSON)

```json
{
  "artist": "Blur",
  "stage": "Orange Scene",
  "time": "23:00",
  "day": "Friday",
  "tags": ["Britpop", "Rock"]
}
