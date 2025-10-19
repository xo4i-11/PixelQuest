# 🎮 PixelQuest

**PixelQuest** is a 2D pixel-based action-adventure game that blends exploration, combat, and intelligent enemy behavior through real-time pathfinding.  
Designed with a focus on **AI-driven gameplay** and **player experience**, it challenges players to think strategically as they battle enemies, manage resources, and progress through increasingly difficult levels.

---

## 🌟 About the Project

I built **PixelQuest** as both a creative outlet and a technical challenge.  
The main goal was to **combine game design with computer science principles** — especially in areas like **pathfinding algorithms**, **entity interaction**, and **state management**.

What started as a small 2D demo evolved into a complete mini-game framework featuring level transitions, multiple weapon types, and a modular combat system.  
Through this project, I explored how algorithms and system design can directly enhance gameplay realism and player engagement.

---

## ⚔️ Gameplay Overview

In **PixelQuest**, you play as a lone adventurer trapped in a mysterious pixel world.  
Each level introduces new challenges, enemies, and environmental hazards.  
To survive, players must balance offense and defense — mastering different weapons, managing health, and anticipating enemy movements.

### 🎯 Core Mechanics
- **Multi-Level Progression:**  
  Each stage has unique layouts, obstacles, and enemy behaviors. Advancing requires defeating all enemies or finding key items.

- **Dynamic Enemy AI (Pathfinding):**  
  Enemies actively track the player using the **Breadth-First Search (BFS)** algorithm, allowing them to navigate around walls and obstacles intelligently.

- **Combat System:**  
  Switch between different weapons, use shooting mechanics, and utilize items strategically.

- **Health & Status Effects:**  
  - Healing restores lost health instantly or over time.  
  - Poison introduces gradual damage, requiring tactical use of healing items.  

- **Item Interaction:**  
  Collect health potions, weapon upgrades, and hidden power-ups across maps.

---

## 🧠 Key Features

| Feature | Description |
|----------|-------------|
| 🗺️ **Level System** | Multiple handcrafted levels with distinct difficulty and visual themes |
| ⚔️ **Weapon Variety** | Switchable weapons with different attack mechanics and damage values |
| 🤖 **Enemy AI** | Pathfinding-based enemy behavior (BFS algorithm) |
| ❤️ **Health & Status Effects** | Healing, poisoning, and regeneration mechanics |
| 🎨 **Pixel Art Graphics** | Handcrafted 2D sprite-based visuals |
| 🎵 **Sound Effects & Music** | Immersive sound design using simple event-based triggers |

---

## 🧩 Motivation & Learning Goals

PixelQuest was built as part of my journey to explore **game development fundamentals** and **AI behavior in games**.  
Specifically, I wanted to:
- Understand **how pathfinding algorithms (BFS, DFS, A\*) work in practice** within a game grid.  
- Design a **modular game architecture** for entities, levels, and combat systems.  
- Experiment with **state machines**, **collision detection**, and **event-based logic**.  
- Polish user experience through pixel art, animations, and responsive controls.

---

## 🧰 Tech Stack

| Category | Technology |
|-----------|-------------|
| **Language** | Java |
| **Build Tool** | Maven |
| **Testing Framework** | JUnit |
| **Paradigm** | Object-Oriented Programming (OOP) |
| **Algorithms** | BFS Pathfinding for Enemy AI |
| **Game Architecture** | Modular OOP-based design |
| **Tools** | Git, GitHub |

---

## 🕹️ Controls

| Action | Key |
|--------|-----|
| Move | Mouse / Pointer |
| Attack / Shoot | Space |
| Switch Weapon | Tab |
| Inventory Items | 1 / 2 / 3 / 4 / 5 |
| Pause | ESC |

---

## 🧱 Installation & Setup

```bash
# Clone the repository
git clone https://github.com/<your-username>/PixelQuest.git

# Enter the project directory
cd PixelQuest

# Build and run using Maven
mvn clean compile exec:java
