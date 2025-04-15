# Java Collections

## ✅ 1. Foundations: Interfaces vs Classes
### Understand the difference:

- Interface — defines what methods a class must implement.
- Class — provides the implementation.

### Key base interface: Collection (super interface for List, Set, Queue)

### Separate from Collection: Map, Iterator

## 📁 2. Collection Hierarchy
### A. List Interface
Common Feature: Ordered, allows duplicates, indexed access

Implementations:

- ArrayList: Backed by a dynamic array (fast reads, slow inserts in middle)
- LinkedList: Doubly-linked list (fast insertions/deletions)
- Stack: LIFO structure (extends Vector)
- Vector: Legacy, synchronized version of ArrayList

### B. Set Interface
Common Feature: No duplicates

Implementations:

- HashSet: Unordered, backed by a HashMap
- LinkedHashSet: Maintains insertion order
- TreeSet: Sorted set (uses Red-Black Tree)
- EnumSet: For enum types (memory-efficient, fast) — special use case

### C. Queue Interface
Common Feature: FIFO structure

Implementations:

- ArrayDeque: Double-ended queue (faster than Stack)
- LinkedList: Also implements Queue (but slower than ArrayDeque)
- PriorityQueue: Orders by natural order or Comparator

## 🗺️ 3. Map Interface
Common Feature: Key-Value pairs, no duplicate keys

Implementations:

- HashMap: Unordered, allows null keys
- LinkedHashMap: Maintains insertion order
- TreeMap: Sorted map (by keys)
- WeakHashMap: Keys can be garbage collected
- EnumMap: Efficient mapping for enum keys

## 🔁 4. Iterator Interface
Used to iterate over any Collection type.

Types:

- Iterator — supports hasNext(), next(), remove()
- ListIterator — only for Lists, supports bidirectional traversal
