# ADS Assignment 4 - Graphs

## Overview
This Java project implements two fundamental graph traversal algorithms: Breadth-First Search (BFS) and Dijkstra's Algorithm, on an edge-weighted graph using Vertex objects instead of a separate Edge class. Each Vertex stores its adjacent vertices and the corresponding weights directly. 

## Project Structure
src/Main.java – Contains example usage and testing

src/Vertex.java – Represents a graph node that stores its own adjacency list and edge weights

src/WeightedGraph.java – Represents the edge-weighted graph; allows adding vertices, edges, and retrieving neighbors

src/Search.java – Abstract base class for graph search algorithms (BFS, Dijkstra)

src/BreadthFirstSearch.java – Implements BFS using a queue-based approach

src/DijkstraSearch.java – Implements Dijkstra's shortest path algorithm for weighted graphs

## Project's Work

### Classes
#### Main
Demonstrates example usage of the graph and both search algorithms. You can modify this file to test with different inputs or graph structures.

#### Vertex
Represents a graph node with generic data. Stores adjacent vertices in a Map<Vertex, Double> to represent edge weights. Provides methods for adding and retrieving neighbors.

#### WeightedGraph
Implements an undirected (or optionally directed) weighted graph using a Map<T, Vertex<T>> structure. Supports:

Adding vertices and edges

Checking adjacency

Listing neighbors

#### Search
An abstract class that holds common logic for search algorithms. Maintains marked (visited nodes) and edgeTo (paths).

#### BreadthFirstSearch
Extends Search to perform BFS traversal from a given source vertex. Uses a queue to explore nodes level by level.

#### DijkstraSearch
Extends Search to perform Dijkstra’s algorithm from a source vertex. Calculates shortest paths using a distance map and a priority-like selection of the minimum distance node.

## Setup & Run

### Prerequisites
Java JDK 17 or higher

### Compile the Program
Navigate to the src folder and compile:
javac Main.java

### Run the Program

java Main
