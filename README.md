# Untitled Dungeon Crawler

A text-based dungeon crawler game created by Josh Sorensen & Bowen Berthelson as a final project for SLCC's CSIS 1400 - Fundementals of Programming class.

Full Playthrough: https://youtu.be/ZFVFGvDmwlA?si=wclCrbmBIwF2b4Ha

## Game Elements

### Dungeon Structure
- 4 uniquely themed rooms: Webbed Entrance, Goblin's Hideout, Ancient Burial Chamber, and Dragon's Lair
- Each room contains both an enemy and a treasure chest
- Progressive difficulty as you advance deeper into the dungeon

### Combat System

![2025-04-28 12 29 03](https://github.com/user-attachments/assets/0ea452cd-5dad-444b-bdad-4c6cd3e807bf)

- Turn-based combat against various enemies
- Attack and defense mechanics with damage calculations
- Health points (HP) system for both player and enemies

### Characters
- **Player**: Customizable name with inventory management
- **Enemies**: 
  - Spider: A weak but annoying first enemy
  - Goblin: Stronger than the spider with a rusty dagger
  - Skeleton: Ancient undead warrior with considerable health
  - Dragon: Final boss with powerful fire breath attack

### Items & Inventory System

![2025-04-28 12 34 08](https://github.com/user-attachments/assets/6bdc8409-a167-4596-a943-1535c323ad40)


- **Weapons**:
  - Wooden Sword: Basic starter weapon
  - Steel Sword: Improved damage output
  - Battle Axe: Heavy weapon with serious cleaving power
  - Excalibur: Legendary weapon with maximum damage
  
- **Consumables**:
  - Food items (Bread, Apple): Small health recovery
  - Medical items (Bandages): Medium health recovery
  - Potions (Healing Potion, Health Elixir): Large health recovery

### Treasure System & Looting

![2025-04-28 12 36 31](https://github.com/user-attachments/assets/a2338f06-3319-4762-a648-575be63128b3)


- Three chest types (Wooden, Silver, and Golden) with increasing value of loot
- Random loot generation based on chest type
- Opportunity to collect items after defeating room enemies

### Visual Elements
- Detailed ASCII art for enemies, items, and scenery
- Custom UI frames and boxes for game interactions
- Color-coded messages for different types of information

## How to Play

1. Compile and run the `PlayGame.java` file
2. Follow the on-screen prompts to name your character
3. Navigate through the dungeon rooms by defeating enemies
4. Manage your inventory to equip better weapons and use healing items
5. Defeat the dragon in the final room to complete the game

## Controls

Input the number corresponding to your desired action:
- Fight enemies to progress
- Navigate between rooms
- Loot chests after defeating enemies
- Manage inventory, equip weapons, and use consumable items
